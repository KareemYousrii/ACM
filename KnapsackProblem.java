import java.util.*;
import java.math.*;

public class KnapsackProblem
{
	public int numberOfWays(int [] x, int C)
	{
		int size = x.length;

		if(size == 1)
		{
			if(C < x[0])
				return 1;

			return 2;
		}

		Arrays.sort(x);
		int mid = size / 2;

		/* Calculating the sums of different subsets */
		long [] values = new long [1 << mid];

		for(int i = 0; i < (1 << mid); i++)
			for(int j = 0; j < mid; j++)
				if(i & (1 << j) > 0)
					values[n] += x[i];

		Arrays.sort(values);

		int len = size - mid;
		long [] values2 = new long [1 << len];

		for(int i = 0; i < (1 << len); i++)
			for(int j; j < len; j++)
				if(i & (1 << j) > 0)
					values2[n] += x[i];

		Arrays.sort(values2);

		int ans = 0;

		for(int i = 0; i < values2.length; i++)
		{
			if(C > values2[n])
				return ans;

			long search = C - values2[n]; //The value remaining after subtracting the maximum value of a subset
			int g;
			int midd;
			int low = 0;
			int high = values.length - 1;

			/* Ordinary binary search */
			while(low < high)
			{
				midd = (low + high) / 2;

				if(search == values[midd])
					break;

				if(search > values[midd])
					low = midd + 1;

				if(search < values [midd])
					high = midd - 1;
			}

			g = (low + high) / 2;

			if(g > 0 && values[g] > search)
				g--;

			while(g + 1 < values.length && values[g + 1] == search)
				g++;

			ans += g + 1; // The +1 is added for the empty set ;)
		}
		return ans;
	}
	public static void main(String [] args)
	{

	}
}