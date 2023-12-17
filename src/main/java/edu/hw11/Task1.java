package edu.hw11;

import java.lang.reflect.InvocationTargetException;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;
import net.bytebuddy.implementation.FixedValue;
import org.apache.logging.log4j.LogManager;
import static net.bytebuddy.matcher.ElementMatchers.named;

public class Task1 {

    private Task1() {
    }

    private static String byteBuddyToString() {
        try {
            Class<?> dynamicType = new ByteBuddy()
                .subclass(Object.class)
                .method(named("toString")).intercept(FixedValue.value("Hello, ByteBuddy!"))
                .make()
                .load(Task1.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION)
                .getLoaded();

            Object dynamicInstance = dynamicType.getDeclaredConstructor().newInstance();

            String result = dynamicInstance.toString();

            return result;
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                 | InvocationTargetException e) {
            LogManager.getLogger().error(e.getMessage());
        }
        return null;
    }

    public static String runTask1() {
        return byteBuddyToString();
    }
}
