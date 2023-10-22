package edu.hw2.task4;

public class CallingInfoUtil {

    private CallingInfoUtil() {
    }

    /**
     * This method retrieves information about the calling method and its class.
     * It uses the stack trace to determine the caller's class and method.
     *
     * @return A CallingInfo object containing the class name and method name of the calling method.
     */
    public static CallingInfo callingInfo() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();

        String className = stackTrace[1].getClassName();
        String methodName = stackTrace[1].getMethodName();
        return new CallingInfo(className, methodName);
    }
}
