package utility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ProblemTest<T> {
    private final Method method;

    public ProblemTest(Method method) {
        this.method = method;
    }

    public ProblemTest(String className, String methodName) {
        try {
            this.method = Class.forName(className).getMethod(methodName);
        } catch (NoSuchMethodException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void showcase(List<T> testcases) {
        for (T testcase : testcases) {
            try {
                System.out.printf("function result: %s, arg: %s%n", method.invoke(testcase), testcase);
            } catch (IllegalAccessException e) {
                System.err.println("ERROR: Illegal Access");
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                System.err.println("ERROR: Target Invocation Error");
                throw new RuntimeException(e);
            }
        }
    }
}
