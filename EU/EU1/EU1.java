import java.util.*;

public class EU1 {
        public static void main(String[] args) {

    
        int[] sekvens = {5,4,6,8,5,4,3,8,9,10,17,43,22,67,34,23,2,4,67};
        //System.out.println (Arrays.toString (sekvens));
        System.out.println();
  
        int m = min(sekvens);
        System.out.println("Det minsta elementet är " + m);
        System.out.println();
    }
    // min returnerar det minsta elementet i en sekventiellsamling.
    // Om samlingen är tom, kastas ett undantagav typen IllegalArgumentException.
    public static int min(int[] element) throws IllegalArgumentException {
        if (element.length == 0)
            throw new IllegalArgumentException ("tom samling");

            
        // hör ihop med spårutskriften 2:
        //int antalVarv = 1;
        
        int[] sekvens = element;
        int antaletPar = sekvens.length / 2;
        int antaletOparadeElement = sekvens.length % 2;
        int antaletTankbaraElement = antaletPar + antaletOparadeElement;
        int[] delsekvens = new int[antaletTankbaraElement];  
        
        int i = 0;
        int j = 0;
        
        while(antaletPar > 0) {
            
            // skilj ur en delsekvens med de tänkbara elementen
            i = 0;
            j = 0;

    
            //jämför talen parvis och behåller det minsta utav talen.
            //innan nästa iteration börjar
            while(j < antaletPar) {
                delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1];
                i += 2;
            }

            //kollar oparade element om dom finns
            if(antaletOparadeElement == 1)
                delsekvens[j] = sekvens[antaletPar*2];
            
            // utgå nu ifrån delsekvensen
            sekvens = delsekvens;
            antaletPar = antaletTankbaraElement /2;
            antaletOparadeElement = antaletTankbaraElement % 2;
            antaletTankbaraElement = antaletPar + antaletOparadeElement;
            
            // spårutskrift 1 –för att följasekvensen
            System.out.println (java.util.Arrays.toString (sekvens));
          

            // spårutskrift 2 -för att avsluta loopen i förväg
            // (för att kunna se vad som händer i början)
            // if (antalVarv++ == 10)
            // System.exit (0);
        }
            
        // sekvens[0] är det enda återstående tänkbara elementet
        //-det är det minsta elementet return sekvens[0];

        return sekvens[0];
    }  
    

}