import static java.lang.System.out;

import java.util.Arrays;

public class Sortera
{

	public static void main(String[] args)
	{

		double[] ArrayAttSortera = new double[] { 4, 0, 2, -3, 13, 44,4, 54 };

		out.println(Arrays.toString(ArrayAttSortera));

		ArrayAttSortera = sort(ArrayAttSortera);

		out.println(Arrays.toString(ArrayAttSortera));
	}

	public static double[] sort(double[] set)
	{
    	for(int i = 0; i < set.length; i++)
	{
        	for(int j = i + 1; j < set.length; j++)
		{
        	if (set[j] < set[i])
            {
				double b = set[j]; 	// Spara i en buffer
		        	set[j] = set[i];	// Byt ut xj mot xi
		        	set[i] = b;			// och xi mot xj
		        }
			}
		}
		return set;
	}
}