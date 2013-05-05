import java.util.*;

public class TCSocks
{
	public static void earnMoney(int[] money, String[] cost, String[] time, String[] competitors)
	{
		int[][] c = parse(cost);
		int[][] t = parse(time);
		int[][] comp = retProfit(money, competitors);

		// for(int i = 0; i < comp.length; i++)
		// 	for(int j = 0; j < comp.length; j++)
		// 		System.out.println(comp[i][j]); 
	}

	/* Parses any array of string into a 2d array of ints */
	public static int[][] parse(String[] a)
	{	
		int len = a.length;
		int[][] result = new int[len][];

		for(int i = 0; i < len; i++)
		{
			StringTokenizer st = new StringTokenizer(a[i]);
			result[i] = new int [st.countTokens()];

			for(int j = 0; st.hasMoreTokens(); j++) 
			{
				result[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		return result;
	}

	/* Returns the maximum profit for each city at each time */
	public static int[][] retProfit(int[] money, String[] competitors)
	{
		int len = money.length;
		int [][] comp = new int [competitors.length][];

		/* row -> city to visit, col -> time */
		int[][] result = new int [len - 1][len];

		for(int i = 0; i < len; i++)
		{
			result[0][i] = money[i];
		}

		for(int i = 0; i < competitors.length; i++)
		{
			StringTokenizer st = new StringTokenizer(competitors[i]);
			comp[i] = new int [st.countTokens()];

			for(int j = 0; j < comp[i].length; j++)
			{
				comp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/* Keeps track of time */
		for(int i = 0; i < len - 1; i++)
		{
			int prev = i - 1;

			if(prev == -1)
				prev = 0;

			for(int j = 0; j < len; j++)
				result[i][j] = result[prev][j];

			/* Keeps track of the competitor */
			for(int j = 0; j < comp.length; j++)
			{
				if(comp[j].length > i)
				{
					int ind = comp[j][i];
					result[i][ind] =  result [prev][ind] / 2;
				}
			}
		}

		/* For debugging purposes */
		for(int i = 0; i < result.length; i++)
		{
			for(int j = 0; j < result[i].length; j++)
				System.out.print(result[i][j] + " ");

			System.out.println();
		}

		return result;
	}

	public static void main(String[] args)
	{
		int[] money = {0, 100, 100, 100};
		String[] cost = {"0 50 50 200", "0 0 50 200", "0 10 0 200", "0 0 0 0"};
		String[] time = {"0 1 1 1", "1 0 1 1", "1 1 0 1", "1 1 1 0"};
		String[] competitors = {"3", "2 3 1", "2 1"};

		earnMoney(money, cost, time, competitors);
	}
}