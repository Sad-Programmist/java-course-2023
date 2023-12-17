package edu.hw10.task2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class CacheProxy implements InvocationHandler {
    private final Object target;
    private final Map<String, Object> cache;
    private final String cacheDirectory;
    private final static Logger LOGGER = LogManager.getLogger();


    private CacheProxy(Object target, String cacheDirectory) {
        this.target = target;
        this.cache = new ConcurrentHashMap<>();
        this.cacheDirectory = cacheDirectory;
    }

    public static <T> T create(Object target, Class<T> interfaceType, String cacheDirectory) {
        return (T) Proxy.newProxyInstance(
            interfaceType.getClassLoader(),
            new Class<?>[] {interfaceType},
            new CacheProxy(target, cacheDirectory)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class)) {
            Cache cacheAnnotation = method.getAnnotation(Cache.class);
            String key = generateCacheKey(method, args);

            if (cache.containsKey(key)) {
                return cache.get(key);
            } else {
                Object result = method.invoke(target, args);
                cache.put(key, result);

                if (cacheAnnotation.persist()) {
                    persistToDisk(key, result);
                }

                return result;
            }
        } else {
            return method.invoke(target, args);
        }
    }

    private String generateCacheKey(Method method, Object[] args) {
        return method.getName() + Arrays.toString(args);
    }

    private void persistToDisk(String key, Object result) {
        try {
            File directory = new File(cacheDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = cacheDirectory + File.separator + key + ".ser";
            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath))) {
                outputStream.writeObject(result);
            }
        } catch (IOException e) {
            LOGGER.error(e);
        }
    }
}
