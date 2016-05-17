package sorting;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Useful utilities for easing the further development
 * @author krystian
 */
public class Utils {
    
    public Utils() {
        // the constructor does nothing
    }
    
    public List<Integer> GenerateArrayOfRandoms(int n, int min, int max) {
        
        List<Integer> arr = new ArrayList<>();
        Random randomGenerator = new Random();
        
        for (int i = 0; i < n; i++) {
            arr.add(randomGenerator.nextInt((max - min) + 1) + min);
        }
        
        return arr;
    }
    
    public List<String> GenerateArrayOfStrings() {
        
        List<String> arr =  new ArrayList<>();
        arr.add("Jozek");
        arr.add("Bartek");
        arr.add("Michal");
        arr.add("Seba");
        arr.add("krykstos");
        arr.add("Helena");
               
        
        return arr;
    }
}
