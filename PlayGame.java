import java.util.Arrays;

public class PlayGame
{
	public static int[] sortReverse(int[] arr)
	{
		int n = arr.length;
		int[] result = new int [n];
		Arrays.sort(arr);

		/* Reverse the array */
		for(int i = 0; i < n; i++)
		{
			result[i] = arr[n-1-i];
		}
		return result;
	}

	public static int saveCreatures(int[] you, int[] computer)
	{
		you = sortReverse(you);
		int n = you.length;
		int sum = 0;
		boolean [] state = new boolean [n];

		/* Algorithm: We want to minimize the difference. */
		for(int i = 0; i < n; i++)
		{
			int min = 999999;
			int diff = 0;
			int index = 0;

			for(int j = 0; j < n; j++)
			{
				if(state[j]) continue; /* Unit has been previously killed */

				diff = you[i] - computer[j];

				/* If a 'real' minimum is found, we prioritize it over x <= 0 */
				if(diff < min || (diff > min && min <= 0))
				{
                    if(min != 999999 && diff <= 0) continue;
					min = diff;
					index = j;
				}

			}
			/* Your piece won !! */
			if(min > 0)
			{
				sum += you[i];
				state[index] = true;
			}
		}
		return sum;
	}

	public static void main(String[] args)
	{
		int [] a = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
		int [] b = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

		System.out.println(saveCreatures(a, b));
	}
}