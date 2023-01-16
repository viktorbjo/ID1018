import java.util.*;

public class UppdateringsAlgoritm {

    public static void main(String[] args) {

    
        int[] sekvens = {5,4,6,8,5,4,3,8,9,10,17,43,22,67,34,23,2,4,67};
        System.out.println (Arrays.toString (sekvens));
        System.out.println();
  
        int m = min(sekvens);
        System.out.println("Det minsta elementet är " + m);
        System.out.println();
    }

    public static int min(int[] element) throws IllegalArgumentException {
        
        if (element.length == 0){
            throw new IllegalArgumentException ("tom samling");
        }

        //första minsta värdet
        int min = element[0]; 

        //går igenom resten av sekvensen och uppdatera när mindre värde kommer
        for(int i = 1; i < element.length; i++) {
            if(element[i] < min) {
               min = element[i];
            } 
        }
        return min;
    }
    
}