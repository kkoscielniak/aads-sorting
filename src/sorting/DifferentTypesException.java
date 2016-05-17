package sorting;

/**
 * Exception to throw when the comparised types are incompatible
 * @author krystian
 */
public class DifferentTypesException extends Exception {
    public DifferentTypesException() {
        System.out.println("Types are incompatible!");
    }
}
