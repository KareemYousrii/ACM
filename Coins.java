public class Coins
{
	public static int returnMinCoins(int [] values, int sum)
	{
		int [] min = new int [sum + 1];
		min[0] = 0;

		for(int i = 1; i < min.length; i++)
			min[i] = 9999;

		for(int i = 1; i < min.length; i++)
		{
			for(int j = 0; j < values.length; j++)
			{
				if(values[j] <= i && min[i - values[j]] + 1 < min[i])
				{
					min[i] = min[i - values[j]] + 1;
				}
			}
		}
		return min[sum];
	}
	public static void main(String[]args)
	{
		int [] values = {1, 3, 5};
		int sum = 11;

		System.out.println(returnMinCoins(values, sum));
	}
}