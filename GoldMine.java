import java.util.StringTokenizer;

public class GoldMine
{
	public static int [] getAllocation(String[] mines, int miners)
	{
		int n = mines.length; //The number of mines.
		int [][] pb = new int [n][7];
		int [][] v = new int [n][7];
		int [] rv = new int [7];

		//Parse the probabilities of the ores occuring in each mine.
		for(int i = 0; i < n; i++)
		{
			StringTokenizer st = new StringTokenizer(mines[i], ", ");
			for(int j = 0; j < 7; j++)
			{	
				pb[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		/* Print out the resultant array containing the probabilities */
		for(int i = 0; i < n; i++)
			for(int j = 0; j < 7; j++)
				System.out.println(pb[i][j]);

		/* Calculate the profit for all possibilities per mine */	
		for(int i = 0; i < n; i++) //Mine index
		{
			for(int j = 0; j < 7; j++) //Miners in an interval from 0 to 6 (inclusive).
			{
				for(int k = 0; k < 7; k++) //Number of ores.
				{	
					/* We have 3 cases to cover: */
					/* 1. Miners < number of ores */
					/* 2. Miners == number of ores */
					/* 3. Miners > Number of ores */

					if(j < k) {v[i][j] += pb[i][k] * j * 60;}
					else if (j == k) {v[i][j] += pb[i][k] * j * 50;}
					else /* Miners > ores */ {v[i][j] += pb[i][k] * (k * 50 + k - j * 20)}
				}
			}
		}

		/* Print the values for all possible number of miners / mine */
		for(int i = 0; i < n; i++)
			for(int j = 0; j < 7; j++)
				System.out.println(v[i][j]);

		/* We find out who deserves the worker */
		for(int i = 0; i < miners; i++)
		{	
			int bestIncrease = -999999;
			int bestMine = 0;
			for(int j = 0; j < n; j++)
			{
				if(rv == 6) continue;
				int increase = v[j][rv[j] + 1] - v[j][rv[j]];

				if(increase > bestIncrease) //Even if the increase is -ve !! That is because, all miners must be distributed among the mines.
				{
					bestIncrease = increase;
					bestMine = j;
				}
			}
			rv[bestMine]++;
		}
		return rv;
	}

	public static void main(String[] args)
	{
		String [] mines = { "000, 030, 030, 040, 000, 000, 000", "020, 020, 020, 010, 010, 010, 010" };
		int miners = 4;

		getAllocation(mines, miners);
	}
}