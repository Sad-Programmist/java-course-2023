package edu.hw8.task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;

public class SingleThreadedPasswordCracker {

    protected SingleThreadedPasswordCracker() {

    }

    public static Map<String, String> crackPassword(List<String> dbStrings) {
        Map<String, String> result = new HashMap<>();
        if (dbStrings == null) {
            return result;
        }
        Map<String, String> hashNameMap = dbStringsToHashNameMap(dbStrings);
        PasswordGenerator passwordGenerator = new PasswordGenerator();

        while (true) {
            String password = passwordGenerator.next();
            String md5Hash = md5(password);
            if (hashNameMap.containsKey(md5Hash)) {
                result.put(hashNameMap.get(md5Hash), password);
                hashNameMap.remove(md5Hash);
                if (hashNameMap.isEmpty()) {
                    break;
                }
            }
        }

        return result;
    }

    protected static Map<String, String> dbStringsToHashNameMap(List<String> dbStrings) {
        Map<String, String> hashNameMap = new ConcurrentHashMap<>();

        for (String dbString : dbStrings) {
            String[] parts = dbString.split("\\s+");
            if (parts.length == 2) {
                String username = parts[0];
                String hash = parts[1];
                hashNameMap.put(hash, username);
            } else {
                LogManager.getLogger().error("Ошибка формата строки базы данных: " + dbString);
            }
        }

        return hashNameMap;
    }

    protected static String md5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
