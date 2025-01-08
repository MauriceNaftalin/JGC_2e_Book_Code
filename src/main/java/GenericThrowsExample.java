public class GenericThrowsExample {

    // Generic method with a type variable T that extends Exception
    public static <T extends Exception> void performAction(boolean condition, Class<T> exClass) throws T {
        if (condition) {
            T result;
            try {
                result = exClass.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Failed to create exception instance", e);
            }
            throw result; // Throwing a generic exception
        }
        System.out.println("Action performed successfully.");
    }

    // Helper method to create an instance of the exception
    private static <T extends Exception> T createExceptionInstance(Class<T> exceptionClass) {
        try {
            return exceptionClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create exception instance", e);
        }
    }

    public static void main(String[] args) {
        try {
            // Call the method with a specific exception type
            GenericThrowsExample.<RuntimeException>performAction(true, RuntimeException.class); // Replace `true` with a condition to test
        } catch (RuntimeException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}