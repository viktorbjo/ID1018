
/**
 * Write a description of class Temperaturer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;     // Scanner, Locale 
 
class Temperaturer 
{ 
    public static void main (String[] args) 
    { 
        System.out.println ("TEMPERATURER\n"); 
     
        // inmatningsverktyg 
        Scanner    in = new Scanner (System.in); 
        in.useLocale (Locale.US); 
 
        // mata in uppgifter om antalet veckor och antalet mätningar 
        System.out.print ("antalet veckor: "); 
        int    antalVeckor = in.nextInt (); 
        System.out.print ("antalet mätningar per vecka: "); 
        int    antalMatningarPerVecka = in.nextInt (); 
 
        // plats att lagra temperaturer 
        double[][]    t = new double[antalVeckor + 1][antalMatningarPerVecka + 1]; 
         
        // mata in temperaturerna 
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
            System.out.println ("temperaturer - vecka " + vecka + ":"); 
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) 
                t[vecka][matning] = in.nextDouble (); 
        } 
        System.out.println (); 
 
        // visa temperaturerna 
        System.out.println ("temperaturerna:"); 
        for (int vecka = 1; vecka <= antalVeckor; vecka++) 
        { 
            for (int matning = 1; matning <= antalMatningarPerVecka; matning++) 
                System.out.print (t[vecka][matning] + " "); 
            System.out.println (); 
        } 
        System.out.println (); 
 
        // den minsta, den största och medeltemperaturen – veckovis 
        double[]    minT = new double[antalVeckor + 1]; 
        double[]    maxT = new double[antalVeckor + 1]; 
        double[]    sumT = new double[antalVeckor + 1]; 
        double[]    medelT = new double[antalVeckor + 1]; 
        // koden ska skrivas här 
        
        //räkna minsta
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            minT[vecka] = t[vecka][1];
            for (int mata = 2; mata <= antalMatningarPerVecka; mata++)
            {
                if(t[vecka][mata] < minT[vecka]) 
                {
                    minT[vecka] = t[vecka][mata];
                }
            }
        }
        
        //räkna största
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            maxT[vecka] = t[vecka][1];
            for (int mata = 2; mata <= antalMatningarPerVecka; mata++)
            {
                if(t[vecka][mata] > maxT[vecka])
                {
                    maxT[vecka] = t[vecka][mata];
                }
            }
        }
        
        
        //räkna summan
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            sumT[vecka] = t[vecka][1];
            for (int mata = 2; mata <= antalMatningarPerVecka; mata++)
            {
                sumT[vecka] += t[vecka][mata];
            }
        }
        
        //räkna medel
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            medelT[vecka] = sumT[vecka] / antalMatningarPerVecka;
        }
        
        // visa den minsta, den största och medeltemperaturen för varje vecka 
        // koden ska skrivas här 
        
        // visa det minsta
        System.out.println("Den lägasta temperaturen per vecka är: ");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.print(minT[vecka] + " \n");
        }
        
        //visa det största
        System.out.println("Den högsta temperaturen per vecka är: ");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.print(maxT[vecka] + " \n");
        }
        
        //visa medel
        System.out.println("Medeltemperaturen per vecka är: ");
        for (int vecka = 1; vecka <= antalVeckor; vecka++)
        {
            System.out.printf("%.1f \n", medelT[vecka]);
        }
        
        // den minsta, den största och medeltemperaturen - hela mätperioden 
        double    minTemp = minT[1]; 
        double    maxTemp = maxT[1]; 
        double    sumTemp = sumT[1]; 
        double    medelTemp = 0; 
        // koden ska skrivas här 
        
        //minsta värde hela mätperoiden
        for (int vecka = 2; vecka <= antalVeckor; vecka++)
        {
            if (minT[vecka] < minTemp) 
            {
                minTemp = minT[vecka];
            }
        }
        
        //största värde hela mätperoiden
        for (int vecka = 2; vecka <= antalVeckor; vecka++)
        {
            if (maxT[vecka] > maxTemp)
            {
                maxTemp = maxT[vecka];
            }
        }
        
        //summa hela mätperioden
        for (int vecka = 2; vecka <= antalVeckor; vecka++)
        {
            sumTemp += sumT[vecka];
        }
        
        //medelvärde för hela mätperioden
        medelTemp = sumTemp / (antalVeckor * antalMatningarPerVecka);
        
        // visa den minsta, den största och medeltemperaturen i hela mätperioden 
        // koden ska skrivas här 
        
        //visa minsta temperatur för hela mätperoiden
        System.out.println("Den lägsta temperaturen för hela mätperoiden "
        + "är: " + minTemp + "\n");
        
        //visa högsta temperaturen för hela mätperioden
        System.out.println("Den hösta temperaturen för hela mätperioden "
        + "är: " + maxTemp + "\n");
        
        //visa medeltemperaturen för hela mätperoden
        System.out.printf("Medeltemperaturen för hela mätperoiden" + 
        "är: %.1f", medelTemp);
    }
}
