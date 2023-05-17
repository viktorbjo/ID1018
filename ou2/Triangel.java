
/**
 * Write a description of class Triangel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangel
{
    // räkna omkrets med sidor
    public static double omkrets (double sida1, double sida2, double sida3) 
    {
        return sida1 + sida2 + sida3;
    }
    
    //räkna area med bas och höjd
    public static double area (double bas, double hojd)
    {
        return (bas * hojd) / 2;
    }
    
    //räkna area med sidor
    public static double areaSidor (double sida1, double sida2, double sida3)
    {
        double p = (sida1 + sida2 + sida3) / 2;
        return Math.sqrt(p*(p-sida1)*(p-sida2)*(p-sida3));
    }
    
    //räkna bisektris
    public static double bisektris (double b, double c, double alfa)
    {
        double p = 2* b * c * Math.cos (alfa / 2);
        double bis = p / (b + c);
        
        return bis;
    }
    
    //räkna radien av cirkeln i triangeln per sidor
    public static double radieC (double sida1, double sida2, double sida3)
    {
        double area1 = areaSidor(sida1, sida2, sida3);
        double omkrets1 = omkrets(sida1, sida2, sida3);
        
        return (2 * area1) / omkrets1;
    }
    
    //räkna radien på cirkeln runt triangeln
    public static double radieCC (double sida1, double sida2, double sida3)
    {
        double area1 = areaSidor(sida1, sida2, sida3);
        
        return (sida1 * sida2 * sida3)/(4 * area1);
    }
}
