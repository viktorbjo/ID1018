
/**
 * Write a description of class EnTriangelOchDessCirklar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class EnTriangelOchDessCirklar
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("skriv in dina sidor");
        
        double sida1 = in.nextDouble();
        double sida2 = in.nextDouble();
        double sida3 = in.nextDouble();
        
        //visa in cirkeln
        double radieInC = Triangel.radieC(sida1, sida2, sida3);
        System.out.printf("cirkelns raide är inne är: " + radieInC);
        System.out.println("");
        
        //visa in cirkeln
        double radieUtC = Triangel.radieCC(sida1, sida2, sida3);
        System.out.printf("cirkelns raide utanför är: " + radieUtC);
        
    }
}
