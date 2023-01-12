import java.util.*;    // Scanner 
import static java.lang.System.out; 

public class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar {

    public static void main (String[] args) {

        out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n"); 

        // mata in två naturliga heltal
        Scanner    in = new Scanner (System.in);
        out.println ("två naturliga heltal:");
        String    tal1 = in.next ();
        String    tal2 = in.next ();
        out.println ();

        // addera heltalen och visa resultatet 
        String summa = addera (tal1, tal2);
        visa(tal1, tal2, summa, '+');

        // subtrahera heltalen och visa resultatet
        //koden här
        String differens = subtrahera(tal1, tal2);
        visa(tal1, tal2, differens, '-');
    }

    // addera tar emot två naturliga heltal givna somteckensträngar, och returnerar deras
    // summa somen teckensträng.
    public static String addera (String tal1, String tal2) {

        // koden ska skrivas här
        int max = Math.max(tal1.length(), tal2.length());
        int talVektor1[] = new int[max];
        int talVektor2[] = new int[max];

        for (int i = 0; i < tal1.length(); i++) {
            talVektor1[i] = Character.getNumericValue(tal1.charAt(tal1.length() - 1 - i));
        }
        for (int i = 0; i < tal2.length(); i++) {
            talVektor2[i] = Character.getNumericValue(tal2.charAt(tal2.length() - 1 - i));
        }

        int minnessiffra = 0;
        int sum[] = new int[max + 1];

        for (int j = 0; j < max; j++) {
            sum[j] = (talVektor1[j] + talVektor2[j] + minnessiffra) % 10;
            if ((talVektor1[j] + talVektor2[j] + minnessiffra) >= 10) {
                minnessiffra = 1;
            } 
            else {
                minnessiffra = 0;
            }
        }

        sum[max] = minnessiffra;
        StringBuilder sb = new StringBuilder();
        if (sum[max] > 0) {
            sb.append(String.valueOf(sum[max]));
        }
        for (int i = max-1; i >= 0; i--) {
           sb.append(String.valueOf(sum[i]));
        }  
        return sb.toString();
    }

    // subtrahera tar emot två naturliga heltal givna som tecken strängar, och returnerar
    // deras differens som en teckensträng.
    // Det första heltalet är inte mindre än det andra heltalet.
    public static String subtrahera (String tal1, String tal2) {

        int max = Math.max(tal1.length(), tal2.length());
        int talVektor1[] = new int[max];
        int talVektor2[] = new int[max];

        for (int i = 0; i < tal1.length(); i++) {
            talVektor1[i] = Character.getNumericValue(tal1.charAt(tal1.length() - 1 - i));
        }
        for (int i = 0; i < tal2.length(); i++) {
            talVektor2[i] = Character.getNumericValue(tal2.charAt(tal2.length() - 1 - i));
        }

        int diff[] = new int[max];
        int minnessiffra = 0;
        
        for(int i = 0; i < max; i++) {
            int diff1 = talVektor1[i] - talVektor2[i] - minnessiffra;
            if(diff1 < 0) {
                diff1 = diff1 + 10;
                minnessiffra = 1;
            }
            else {
                minnessiffra = 0;
            }
            diff[i] = diff1;
            
            //System.out.println ("diff: " + java.util.Arrays.toString (diff));
        }
        
        boolean startnummer = false;
        StringBuilder sb = new StringBuilder();
        for (int i = max - 1; i >= 0; i--) {
            if(startnummer || diff[i] > 0) {
                startnummer = true;
                sb.append(String.valueOf(diff[i]));
                //System.out.println ("String SB(for): " + sb);
            }
        }  
        return sb.toString();   
    }

        // visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
        // utförd i samband med hetalen
    public static void visa (String tal1, String tal2,String resultat, char operator) {

        // sätt en lämplig längd på heltalen och resultatet   
        int len1 = tal1.length ();
        int    len2 = tal2.length ();
        int    len  = resultat.length ();
        int    maxLen = Math.max (Math.max (len1, len2), len);
        tal1 = sattLen (tal1, maxLen -len1);
        tal2 = sattLen (tal2, maxLen -len2);
        resultat = sattLen (resultat, maxLen -len);

        // visa heltalen och resultatet
        out.println ("  " + tal1);
        out.println ("" + operator + " " + tal2);
        for (int i = 0; i < maxLen + 2; i++)
            out.print ("-");
        out.println ();
        out.println ("  " + resultat + "\n");
    }

    // sattLen lägger till ett angivet antal mellan slag i början av en given sträng
    public static String sattLen (String s, int antal) {

        StringBuilder    sb = new StringBuilder (s);
        for (int i = 0; i < antal; i++)
            sb.insert (0, " ");

        return sb.toString ();
    }

}