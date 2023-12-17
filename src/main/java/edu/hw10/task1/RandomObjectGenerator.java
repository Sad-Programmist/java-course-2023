package edu.hw10.task1;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;

public class RandomObjectGenerator {

    public <T> T nextObject(Class<T> clazz, String factoryMethodName) throws Exception {
        if (clazz.isRecord()) {
            return generateRecord(clazz);
        } else {
            return generatePojo(clazz, factoryMethodName);
        }
    }

    public <T> T nextObject(Class<T> clazz) throws Exception {
        if (clazz.isRecord()) {
            return generateRecord(clazz);
        } else {
            return generatePojo(clazz);
        }
    }

    private <T> T generateRecord(Class<T> clazz) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        List<Object> values = new ArrayList<>();

        for (Field field : fields) {
            values.add(generateValueForField(field));
        }

        Constructor<T> constructor =
            clazz.getDeclaredConstructor(Arrays.stream(fields).map(Field::getType).toArray(Class[]::new));
        return constructor.newInstance(values.toArray());
    }

    private <T> T generatePojo(Class<T> clazz, String factoryMethodName) throws Exception {
        Method factoryMethod = findFactoryMethod(clazz, factoryMethodName);

        if (factoryMethod != null) {
            Class<?>[] parameterTypes = factoryMethod.getParameterTypes();
            Object[] args = Arrays.stream(parameterTypes).map(paramType -> {
                try {
                    return generateValueForField(paramType.getDeclaredField(paramType.getName()));
                } catch (NoSuchFieldException | IllegalAccessException | InstantiationException
                         | InvocationTargetException e) {
                    LogManager.getLogger().error(e.getMessage());
                    return null;
                }
            }).toArray();
            return (T) factoryMethod.invoke(null, args);
        } else {
            return generatePoWithoutFabricMethod(clazz);
        }
    }

    private <T> T generatePojo(Class<T> clazz) throws Exception {
        return generatePoWithoutFabricMethod(clazz);

    }

    private <T> T generatePoWithoutFabricMethod(Class<T> clazz) throws Exception {
        Constructor<T> constructor = clazz.getDeclaredConstructor();
        T instance = constructor.newInstance();

        for (Field field : clazz.getDeclaredFields()) {
            Method setterMethod = findSetterMethod(clazz, field.getName());

            if (setterMethod != null) {
                Object value = generateValueForField(field);
                setterMethod.invoke(instance, value);
            }
        }

        return instance;
    }

    private Method findSetterMethod(Class<?> clazz, String fieldName) {
        String setterMethodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(setterMethodName) && method.getParameterCount() == 1) {
                return method;
            }
        }

        return null;
    }

    private Object generateValueForField(Field field)
        throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> fieldType = field.getType();
        Object value = null;

        Min minAnnotation = field.getAnnotation(Min.class);
        Max maxAnnotation = field.getAnnotation(Max.class);
        NotNull notNullAnnotation = field.getAnnotation(NotNull.class);

        if (notNullAnnotation != null) {
            value = generateNotNullValue(fieldType, minAnnotation, maxAnnotation);
        } else {
            value = generateDefaultValue(fieldType, minAnnotation, maxAnnotation);
        }

        return value;
    }

    private Object generateNotNullValue(Class<?> type, Min minAnnotation, Max maxAnnotation)
        throws IllegalAccessException, InstantiationException,
        InvocationTargetException {
        Object value = null;

        if (type.isPrimitive() || type == String.class) {
            value = generateDefaultValue(type, minAnnotation, maxAnnotation);
        } else {
            Constructor<?>[] constructors = type.getDeclaredConstructors();
            if (constructors.length > 0) {
                Constructor<?> constructor = constructors[0];
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                Object[] args = Arrays.stream(parameterTypes)
                    .map(paramType -> generateDefaultValue(paramType, minAnnotation, maxAnnotation)).toArray();
                value = constructor.newInstance(args);
            }
        }

        return value;
    }

    @SuppressWarnings("ReturnCount")
    private Object generateDefaultValue(Class<?> type, Min minAnnotation, Max maxAnnotation) {
        if (type == int.class || type == Integer.class) {
            int minValue = minAnnotation != null ? minAnnotation.value() : 0;
            int maxValue = maxAnnotation != null ? maxAnnotation.value() : Integer.MAX_VALUE - 1;
            return Math.max(new Random().nextInt(maxValue - minValue + 1) + minValue, minValue);
        } else if (type == double.class || type == Double.class) {
            double minValue = minAnnotation != null ? minAnnotation.value() : 0;
            double maxValue = maxAnnotation != null ? maxAnnotation.value() : Double.MAX_VALUE;
            return Math.max(new Random().nextDouble() * (maxValue - minValue) + minValue, minValue);
        } else if (type == boolean.class || type == Boolean.class) {
            return new Random().nextBoolean();
        } else if (type == String.class) {
            return UUID.randomUUID().toString();
        } else {
            return null;
        }
    }

    private Method findFactoryMethod(Class<?> clazz, String factoryMethodName) {
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().equals(factoryMethodName)) {
                return method;
            }
        }
        return null;
    }
}
