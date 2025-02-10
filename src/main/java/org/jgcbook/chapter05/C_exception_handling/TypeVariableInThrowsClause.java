package org.jgcbook.chapter05.C_exception_handling;
// ch06_3_3
import java.util.List;
import java.util.NoSuchElementException;

public class TypeVariableInThrowsClause {
    @FunctionalInterface
    interface Testable<X extends Throwable> {
        void run() throws X;
    }
    static <X extends Throwable> void checkThrows(Testable<X> test, Class<X> clazz) {
        try {
            test.run();
        } catch (Throwable t) {
            if (clazz.isInstance(t)) {
                return;                 // ok
            } else {
                throw new AssertionError(t);
            }
        }
        throw new AssertionError("no exception was thrown");
    }
    public static void main(String[] args) {
        checkThrows(() -> List.of().iterator().next(), NoSuchElementException.class);
        checkThrows(() -> { throw new Exception(); }, Exception.class);
    }

}