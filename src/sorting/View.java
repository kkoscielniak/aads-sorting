/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author krystian
 */
public class View {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Utils utils = new Utils();
        
        System.out.print(utils.GenerateArrayOfRandoms(10, 99, 199));
    }
}
