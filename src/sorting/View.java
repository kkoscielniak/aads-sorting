package sorting;

import java.util.List;
import org.apache.commons.lang3.time.StopWatch;

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
        StopWatch watch = new StopWatch();
        
//        List<Integer> smallArrayOfNumbers = utils.GenerateArrayOfRandoms(100, 1, 1000000);
        List<Integer> mediumArrayOfNumbers = utils.GenerateArrayOfRandoms(10000, 1, 1000000);
//        List<Integer> bigArrayOfNumbers = utils.GenerateArrayOfRandoms(1000000, 1, 1000000);

        // Sorting of numbers
        try {
            
            /* Bubble Sorting */
//            watch.start();
//            sorting.BubbleSort(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Bubble sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
            
            watch.start();
            sorting.BubbleSort(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Bubble sort of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
//            watch.start();
//            sorting.BubbleSortV2(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Improved bubble sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
            
            watch.start();
            sorting.BubbleSortV2(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Improved bubble sort of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
//            watch.start();
//            sorting.BubbleSortV3(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Improved by reduction bubble sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
//            
//            watch.start();
//            sorting.BubbleSortV3(mediumArrayOfNumbers);
//            watch.stop();
//            System.out.println("Improved by reduction bubble sort of medium array took " + watch.getTime() + "ms");
//            watch.reset();
//            
//            watch.start();
//            sorting.SelectionSort(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Selection sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
            
            watch.start();
            sorting.SelectionSort(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Selection sort of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
//            watch.start();
//            sorting.InsertionSort(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Insertion sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
            
            watch.start();
            sorting.InsertionSort(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Insertion sort of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
//            watch.start();
//            sorting.ShellSort(smallArrayOfNumbers);
//            watch.stop();
//            System.out.println("Shell sort of small array took " + watch.getTime() + "ms");
//            watch.reset();
            
            watch.start();
            sorting.ShellSort(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Shell sort with h=arr.size()/2 of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
            watch.start();
            sorting.ShellSortV2(mediumArrayOfNumbers);
            watch.stop();
            System.out.println("Shell sort with h=1 of medium array took " + watch.getTime() + "ms");
            watch.reset();
            
            

            
            
            
            
            
            
            
            
            
        } catch (NotSortedException e) {
            System.out.println(e);
        }
    }
}
