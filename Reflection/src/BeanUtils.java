import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


class BeanUtils {

    static void transform(Object to, Object from) {

        Class To = to.getClass();
        Class From = from.getClass();

        Method[] toMethods = To.getMethods();
        Method[] fromMethods = From.getMethods();

        for (Method fromMethod : fromMethods) {
            for (Method toMethod : toMethods) {
                if (isSetter(toMethod) && isGetter(fromMethod) && isSame(fromMethod.getName().substring(3), toMethod.getName().substring(3)) && isCompatible(toMethod, fromMethod)) {
                    try {
                        toMethod.invoke(to, fromMethod.invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static boolean isCompatible(Method setter, Method getter) {

        return getter.getReturnType() == setter.getParameterTypes()[0] && getter.getParameterCount() == 0;
    }

    private static boolean isSetter(Method method) {
        return method.getName().startsWith("set");
    }

    private static boolean isGetter(Method method) {
        return method.getName().startsWith("get");
    }

    private static boolean isSame(String to, String from) {
        return from.replaceAll("get", "").equals(to.replaceAll("set", ""));
    }
}
