package sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * Class responsible for interacting with the program
 * @author krystian
 */
public class View {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Utils utils = new Utils();
        Sorting sorting = Sorting.getInstance();
        
        List<Integer> smallArrayOfNumbers = utils.GenerateArrayOfRandoms(100, 1, 1000000);
//        List<Integer> normalArrayOfNumbers = utils.GenerateArrayOfRandoms(10000, 1, 1000000);
//        List<Integer> bigArrayOfNumbers = utils.GenerateArrayOfRandoms(10000000, 1, 1000000);

        // Sorting of numbers
        System.out.println(smallArrayOfNumbers);
        System.out.println(sorting.BubbleSort(smallArrayOfNumbers));
        
        
    }
}
