package reflection;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by mtumilowicz on 2018-05-11.
 */
public class Invoker {
    public static Object invokeStatic(Object obj, String methodName) throws IllegalAccessException {
        try {
            return obj.getClass().getMethod(methodName).invoke(null);
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
