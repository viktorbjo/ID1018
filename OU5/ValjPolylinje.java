import java.util.*;

public class ValjPolylinje {

    
    public static final Random rand = new Random ();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main (String[] args) {

        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            polylinjer[i] = slumpPolylinje ();
        }

        // visa polylinjerna
        System.out.println("Alla Polylinjer: ");
        System.out.println();
        for (int i = 0; i < ANTAL_POLYLINJER; i++) {
            System.out.println("Polylinje" + i + ": " + polylinjer[i] + ", Färg: " + polylinjer[i].getFarg());
            System.out.println();
        }
        System.out.println();

        // bestäm den kortaste av de polylinjer som är gula
        double kortaste = Double.MAX_VALUE;
        int index = 0;
        for(int i = 0; i < ANTAL_POLYLINJER; i++) {
            if(kortaste > polylinjer[i].langd() && polylinjer[i].getFarg().equalsIgnoreCase("gul")) {
                kortaste = polylinjer[i].langd();
                index = i;
            }
        }

        //visa den valda polylinjen
        if(kortaste == Double.MAX_VALUE) {
            System.out.println("Ingen gul vart genererad");
        }
        else {
        System.out.println("Den Kortaste gula Polylinjen är " + polylinjer[index] + " och är " + kortaste + " enheter lång");
        }
        System.out.println();
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn,som är en stor bokstav i
    // det engelska alfabetet, ochslumpmässiga koordinater.
    public static Punkt slumpPunkt () {
       
        String n = "" + (char) (65 + rand.nextInt (26));
        int    x = rand.nextInt (11);
        int    y = rand.nextInt (11);

        return new Punkt(n, x, y);
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, varsfärg är antingen blå, eller röd
    //eller gul. Namn på polylinjens hörn är stora bokstäver i det engelskaalfabetet. Två hörn
    //kan inte ha samma namn.
    public static Polylinje slumpPolylinje() {

        // skapa en tom polylinje, och lägg till hörn till den
        Polylinje polylinje = new Polylinje ();
        int antalHorn = 2 + rand.nextInt (7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];
        // ett och samma namn kan inte förekomma flera gånger
        Punkt valdPunkt= null;
        char valtChar = 0;
        while (antalValdaHorn < antalHorn) {

            valdPunkt = slumpPunkt();
            String pNamnString = valdPunkt.getNamn();
            char pNamn = pNamnString.charAt(0);
            
            while(valdaNamn[((int) pNamn)-65]) {
                valdPunkt = slumpPunkt();
                pNamnString = valdPunkt.getNamn();
                pNamn = pNamnString.charAt(0);
                
                
            }
            antalValdaHorn++;
            valdaNamn[(int) pNamn-65] = true;
            polylinje.laggTill(valdPunkt);
        
        }
        // sätt färg
        int farg = rand.nextInt(3);
        switch(farg) {
            case 0:
              polylinje.setFarg("blå");
              break;
            case 1:
                polylinje.setFarg("röd");
                break;
            case 2:
                polylinje.setFarg("gul");
                break;
        }
        
        return polylinje;
    }



}