public class Box
{
	public static int maxCredit(int[] a, int[] b, int[] c, int[] d, int[] e)
	{
		final int count = 5;
		int[][] m = new int [count][];
		int[] pos = new int [count];
		int[] judges = new int [count];
		int result = 0;

		for(int i = 0; i < count; i++)
		{
			pos[i] = 0;
			judges[i] = -1;
		}

		m [0] = a; m[1] = b; m[2] = c; m[3] = d; m[4] = e;

		for(int i = 0; i <= 180000; i++)
		{
			for(int j = 0; j < count; j++)
			{
				if(pos[j] >= m[j].length)
					continue;

				if(m[j][pos[j]] <= i)
				{
					judges[j] = m[j][pos[j]];
					pos[j]++;
				}
			}

			int num = 0;
			for(int j = 0; j < count; j++)
			{
                if(judges[j] == -1)
                    continue;

				if(i - judges[j] <= 1000) //We choose judges[j] based on the condition: 'm[j][pos[j]] <= i'
					num++;
			}

			if(num >= 3)
			{
				result++;
				for(int j = 0; j < count; j++)
					judges[j] = -1;
			}
		}
		return result;
	}

	public static void main(String[]args)
	{
		int[] a = {180000};
		int[] b = {1, 2, 3, 4, 5, 6, 179000, 179500, 179800};
		int[] c = {5, 10, 1000, 10000};
		int[] d = {5, 10, 1000, 10000};
		int[] e = {6, 9000};

		System.out.println(maxCredit(a, b, c, d, e));
	}
}