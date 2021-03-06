package sorting;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
        
        System.out.println("Array of numbers generated");
        return arr;
    }
    
    public List<String> GenerateArrayOfStrings(int elemCount) throws FileNotFoundException, IOException {
        
        List<String> arr =  new ArrayList<>();        
        BufferedReader in = new BufferedReader(new FileReader("dict_medium.txt"));
        String str;
        int i = 0;
        
        while((str = in.readLine()) != null && i < elemCount) {
            arr.add(str);
            
            i++;
        }
        
        System.out.println("Array of strings loaded.");
        
        return arr;
    }
}
