package chapter07.H_use_type_tokens_for_run_time_typing;
// ch08_8_1
import java.lang.reflect.Constructor;

public class Snippet_1 {
	public static <T> T createInstanceParameterized(Class<T> clazz) {
	   	try {
			Constructor<T> constructor = clazz.getDeclaredConstructor();
			constructor.setAccessible(true);
			return constructor.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
	public static Object createInstanceWildcard(Class<?> clazz) {
		try {
	   	    Constructor<?> constructor = clazz.getDeclaredConstructor();
		    constructor.setAccessible(true);
		    return constructor.newInstance();
		} catch (ReflectiveOperationException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args)  {
		class Foo {};
		Foo f1 = createInstanceParameterized(Foo.class);
		Foo f2 = (Foo) createInstanceWildcard(Foo.class);

	}
}