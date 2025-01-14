package chapter03.F_multiple_bounds;
// ch03_6_1
import java.io.IOException;

public interface IoeThrowingSupplier<S> {
    S get() throws IOException;

}