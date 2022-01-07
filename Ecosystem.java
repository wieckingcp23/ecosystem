/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projects;

/**
 *
 * @author Peyton Wiecking
 * @date 1/24/20
 * @helpRecieved: Textbook, class lecture
 * 
 * 
 */



public class Ecosystem {
    
public static void main(String[] args) {
    System.out.println("n = empty ");
    System.out.println("f = fish");
    System.out.println("b = bears");
    System.out.println();
    System.out.println("Starting Ecosystem"); 
    
    
    // creates an array for char elements
    char[] ecosystem = new char[30];
    
    // fills elements with n, b, or f 
    for (int i = 0; i < 30; i++){
        ecosystem[i] = bearOrFish();
        System.out.print(ecosystem[i] + " ");
    }
    System.out.println(" ");
    System.out.println();
    
    // runs the ecosystem 10 times and prints it 10 times
    for (int j = 0; j < 10; j++){
        shift(ecosystem);
        for (int i = 0; i < ecosystem.length; i++) {
            
            System.out.print(ecosystem[i] + " ");
        }
        System.out.print("Iteration " + (j + 1));
        System.out.println();
    }
    }


// method that assigns null to 0, fish to 1, and bear to 3
public static char bearOrFish(){
    int result = (int)(Math.random() * 3);
    if (result == 0){
        return 'n';
    }
    else if (result == 1){
        return 'f';
    }
    else {
        return 'b';
    }
}

// main logic behind element shift
public static void shift(char[] array){
        for (int i = 0; i < 30; i++) {
            // fills first element in array with a bear 
                if (i == 0) {
                    array[0] = 'b';
                }
                else {
                    // moves bears into null spots
                    if (array[i - 1] == 'b' && array[i] == 'b') {
                        for (int j = 0; j <= 29; j++) {
                            if (array[j] == 'n') {
                                array[j] = 'b';
                                
                            }
                        }
                    }
                    // moves fish into null spots
                    else if (array[i - 1] == 'f' && array[i] == 'f') {
                        for (int j = 0; j <= 29; j++) {
                            if (array[j] == 'n') {
                                array[j] = 'f';
                            }
                        }
                    }
                    
                     // shifts bears into null spots
                    else if (array[i - 1] == 'n' && array[i] == 'b' || array[i - 1] == 'b' && array[i] == 'n') {
                        array[i - 1] = 'b';
                        array[i] = 'n';
                    }
                    // shifts fish into null spots
                    else if (array[i - 1] == 'n' && array[i] == 'f' || array[i - 1] == 'f' && array[i] == 'n') {
                        array[i - 1] = 'f';
                        array[i] = 'n';
                    }
                    // shifts bears into fish
                    else if (array[i - 1] == 'b' && array[i] == 'f' || array[i - 1] == 'f' && array[i] == 'b'){
                        array[i] = 'n';
                        array[i - 1] = 'b';
                    }
                    else{
                        array[i] = 'n';
                    }
                }
        }
}
}