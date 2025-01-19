package chapter06.F_reflecting_generic_types;
// ch07_6_1
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.lang.reflect.WildcardType;

class ReflectionDemo {
    public static String printSuperclass(Type sup) {
        if (!sup.equals(Object.class)) {
            return "extends " + printType(sup) + "\n";
        }
        return "";
    }
    public static String printInterfaces(Type[] impls) {
        if (impls.length > 0) {
            return "implements " + Arrays.stream(impls)
                    .map(ReflectionDemo::printType)
                    .collect(Collectors.joining(",")) + "\n";
        }
        return "";
    }
    public static String printTypeParameters(TypeVariable<?>[] vars) {
        if (vars.length > 0) {
            return  Arrays.stream(vars)
                    .map(b -> b.getName() + printBounds(b.getBounds()))
                    .collect(Collectors.joining(",","<",">\n"));
        }
        return "";
    }
    public static String printBounds(Type[] bounds) {
        if (bounds.length > 0 && ! Arrays.equals(bounds,new Type[]{ Object.class })) {
            return " extends " +
                    Arrays.stream(bounds)
                            .map(ReflectionDemo::printType)
                            .collect(Collectors.joining(" & "));
        }
        return "";
    }
    public static String printType(Type type) {
        return switch(type) {
            case Class<?> cls -> cls.getName();
            case ParameterizedType p -> printParameterizedType(p);
            case TypeVariable<?> tv -> tv.getName();
            case GenericArrayType gat -> gat.getGenericComponentType() + "[]";
            case WildcardType wt -> printWildcard(wt);
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
    private static String printParameterizedType(ParameterizedType p) {
        Class<?> c = (Class<?>)p.getRawType();
        Type o = p.getOwnerType();
        String ptString = o != null ? printType(o) + "." : "";
        ptString = ptString + c.getName();
        return ptString + Arrays.stream(p.getActualTypeArguments())
                .map(ReflectionDemo::printType)
                .collect(Collectors.joining(",","<",">"));
    }
    private static String printWildcard(WildcardType wt) {
        Type[] upper = wt.getUpperBounds();
        Type[] lower = wt.getLowerBounds();
        if (lower.length == 1) {
            return "? super " + printType(lower[0]);
        } else if (upper.length == 1 && ! upper[0].equals(Object.class)) {
            return "? extends" + printType(upper[0]);
        }
        return "";
    }
    public static String printClass(Class<?> c) {
        return "class " +
                printType(c) +
                printTypeParameters(c.getTypeParameters()) +
                printSuperclass(c.getGenericSuperclass()) +
                printInterfaces(c.getGenericInterfaces());
    }
    public static void main(String[] args) throws ClassNotFoundException {
        for (String name : args) {
            Class<?> c = Class.forName(name);
            System.out.println(printClass(c));
        }
    }

}