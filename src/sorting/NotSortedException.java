package sorting;

/**
 * Exception to throw when the array is not sorted in the end
 * @author krystian
 */
public class NotSortedException extends Exception {
    public NotSortedException() {
        System.out.println("The array is not sorted!");
    }
}
