import java.io.*;

public class RockStar
{
	public static int getNumSongs(int ff, int fs, int sf, int ss)
	{	
		if(ff > 0 || fs > 0) /* ff > 0 or fs > 0 or both > 0 */
			return ff + (fs > 0 ? ss : 0) + Math.min(fs, sf + 1) + Math.min(sf, fs);
		else /* ff < 0 && fs < 0 */
			return ss + (sf > 0 ? 1 : 0);
	}

	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true)
		{
			int ff = 0, fs = 0, sf = 0, ss = 3;
			System.out.println(getNumSongs(ff, fs, sf, ss));
		}
	}
}