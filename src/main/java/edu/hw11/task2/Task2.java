package edu.hw11.task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;

public class Task2 {

    private Task2() {
    }

    public static int runTask2(int a, int b) throws IllegalAccessException, InstantiationException {
        Class<?> dynamicClass = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named("sum"))
            .intercept(MethodDelegation.to(MultiplyInterceptor.class))
            .make()
            .load(ArithmeticUtils.class.getClassLoader())
            .getLoaded();

        ArithmeticUtils arithmeticUtils = (ArithmeticUtils) dynamicClass.newInstance();
        return arithmeticUtils.sum(a, b);
    }
}
