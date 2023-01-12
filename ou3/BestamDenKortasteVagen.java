import java.util.*;
/**
 * Write a description of class BestamDenKortasteVagen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;     // Scanner, Locale

public class BestamDenKortasteVagen //klassens namn
{


  public static void main(String[] args)
  {
   java.util.Scanner    in = new java.util.Scanner (System.in);

   double[] distance1 = new double[3];
   double[][] distance2 = new double[3][4];
   double[] distance3 = new double[4];



   for (int i=0; i<distance1.length; i++)
   {
     System.out.println("Ange distans mellan Zon1 och u" + (i + 1));
     distance1[i] = in.nextDouble();
   }

   for (int i=0; i<distance1.length; i++)
   {
     for (int j=0; j<distance3.length; j++)
     {
       System.out.println("Ange distans mellan station u" + (i + 1) + " och station v" + (j+1));
       distance2[i][j] = in.nextDouble();
     }
   }

   for (int i=0; i<distance3.length; i++)
   {
     System.out.println("Ange distans mellan v" + (i + 1) + " och Zon 4");
     distance3[i] = in.nextDouble();
   }
   int[] stations = DenKortasteVagen.mellanstationer(distance1,distance2,distance3);
   System.out.println("Första stationen är U: " + (stations[0] + 1) + " Och andra stationen är V: " + (stations[1] + 1));


   double shortestDistance = DenKortasteVagen.langd(distance1,distance2,distance3);
   System.out.println("Kortaste distansen är " + shortestDistance);
  }
}
