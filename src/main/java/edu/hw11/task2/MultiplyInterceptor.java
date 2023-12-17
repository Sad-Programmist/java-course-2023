package edu.hw11.task2;

import java.lang.reflect.Method;
import net.bytebuddy.implementation.bind.annotation.AllArguments;
import net.bytebuddy.implementation.bind.annotation.Origin;
import net.bytebuddy.implementation.bind.annotation.RuntimeType;

public class MultiplyInterceptor {

    private MultiplyInterceptor() {
    }

    @RuntimeType
    public static int multiply(@AllArguments Object[] args, @Origin Method method) {
        int a = (int) args[0];
        int b = (int) args[1];
        return a * b;
    }
}
