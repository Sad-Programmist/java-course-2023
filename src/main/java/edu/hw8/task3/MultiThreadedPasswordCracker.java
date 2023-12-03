package edu.hw8.task3;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.logging.log4j.LogManager;

public class MultiThreadedPasswordCracker extends SingleThreadedPasswordCracker {

    private MultiThreadedPasswordCracker() {
    }

    public static Map<String, String> crackPassword(List<String> dbStrings, int threadNumber) {
        Map<String, String> result = new ConcurrentHashMap<>();
        if (dbStrings == null) {
            return result;
        }
        Map<String, String> hashNameMap = dbStringsToHashNameMap(dbStrings);

        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
        ExecutorCompletionService<Void> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < threadNumber; i++) {
            completionService.submit(() -> {
                PasswordGenerator passwordGenerator = new PasswordGenerator();

                while (!Thread.interrupted()) {
                    String password = passwordGenerator.next();
                    String md5Hash = md5(password);

                    if (hashNameMap.containsKey(md5Hash)) {
                        result.put(hashNameMap.get(md5Hash), password);
                        hashNameMap.remove(md5Hash);
                        if (hashNameMap.isEmpty()) {
                            executorService.shutdownNow();
                            break;
                        }
                    }
                }
                return null;
            });
        }

        try {
            for (int i = 0; i < threadNumber; i++) {
                completionService.take().get();
            }
        } catch (InterruptedException | ExecutionException e) {
            LogManager.getLogger().error(e.getMessage());
        }

        executorService.shutdown();

        return result;
    }
}
