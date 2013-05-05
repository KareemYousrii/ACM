public class Unblur
{
	public static int[][] original(String[] blurred)
	{
		int h = blurred.length;
		int w = blurred[0].length();
		int[][] original = new int[h][w];
		int[][] b = new int[h][w];


		/* Parse the string into chars */
		for(int i = 0; i < h; i++)
			for(int j = 0; j < w; j++)
				b[i][j] = blurred[i].charAt(j) - '0';

		/* Algorithm: We Want to reach a point where the upper left pixel is the only one contributing to the current pixel */
		for(int i = 1; i < h-1; i++)
		{
			for(int j = 1; j < w-1; j++)
			{
				if(b[i-1][j-1] == 1)
				{
					original[i][j] = 1; // We would like to stay within the same row, only changing the columns.
					subtractMatrix(i, j, b);
				}
			}
		}

		return original;
	}

	public static void subtractMatrix(int y, int x, int[][] original)
	{
		int h = original.length;
		int w = original[0].length;
		int new_x;
		int new_y;

		//i is our y, while j is our x.
		int[] dx = {-1, 1, 0,  0, 0, -1, 1, -1, 1};
		int[] dy = { 0, 0, 1, -1, 0, -1, 1, 1, -1};

		for(int i = 0; i < dx.length; i++)
		{
			new_x = x + dx[i];
			new_y = y + dy[i];

			if(new_x < 0 || new_y < 0 || new_x >= w || new_y >= h) 
				continue;

			else
				original[new_y][new_x] -= 1;
		}
	}

	public static void main(String[]args)
	{
		String[] blurred = {"1233321000000000123332100000000000000000000",
  "1244422233222332334343323322232112332223321",
  "1255523344343443545343434434343233432334432",
  "0033303455465775633011445546454355753457753",
  "0033303333364543533011433336333364521346542",
  "0033303455464532445343545546454355753446542",
  "0022202344342200234343434434343233432323221",
  "0011101233221100123332223322232112332211111" };

		int[][] result = original(blurred);

		/* Print thte final result */
		for(int i = 0; i < result.length; i++)
		{
			for(int j = 0; j < result[i].length; j++)
			{
				if(result[i][j] == 0)
					System.out.print(".");
				else
					System.out.print("#");
			}
			System.out.println();
		}
	}
}