import java.util.*;     // Scanner, Locale

public class DenKortasteVagen //klassens namn
{
  public static int[] mellanstationer (double[] distance1, double[][] distance2, double[] distance3)
 {
  int[] shortestStations = {0,0};
  double currentShortDistance = 999;
  for (int i=0; i<distance1.length; i++)
  {
    for (int j=0; j<distance3.length; j++)
    {
      if (currentShortDistance > distance1[i] + distance2[i][j] + distance3[j])
      {
        currentShortDistance = distance1[i] + distance2[i][j] + distance3[j];
        shortestStations[0] = i;
        shortestStations[1] = j;
      }
    }
  }
  return shortestStations;
  }
  // langd returnerar längden av den kortaste vägen.
  public static double langd (double[] distance1, double[][] distance2, double[] distance3)
  {
    int[] shortestStations = {0,0};
    double currentShortDistance = 999;
    for (int i=0; i<distance1.length; i++)
    {
      for (int j=0; j<distance3.length; j++)
      {
        if (currentShortDistance > distance1[i] + distance2[i][j] + distance3[j])
        {
          currentShortDistance = distance1[i] + distance2[i][j] + distance3[j];
          shortestStations[0] = i;
          shortestStations[1] = j;
        }
      }
    }
    return currentShortDistance;
  }
}