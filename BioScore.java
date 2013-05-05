import java.util.Arrays;
public class BioScore {

	public static double score(int[] f, int[] s, int n) {

		int sum = 0;

		for(int i = 0; i < f.length; i++) {
			sum += f[i] * s[i];
		}

		return (double)(sum/(n*(n-1)/2));
	}

	public static double maxAvg(String[] knownSet) {

		int[] f = new int [10];
		int[] s = new int [10];
		int n = knownSet.length;

		for(int i = 0; i < n - 1; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				for(int k = 0; k < knownSet[0].length(); k++)
				{
					String temp = knownSet[i].charAt(k) + "" +  knownSet[j].charAt(k);

					if(temp.equals("AA")) ++f[0];
					else if(temp.equals("CC")) ++f[1];
					else if(temp.equals("GG")) ++f[2];
					else if(temp.equals("TT")) ++f[3];
					else if(temp.equals("AC") || temp.equals("CA")) ++f[4];
					else if(temp.equals("AG") || temp.equals("GA")) ++f[5];
					else if(temp.equals("AT") || temp.equals("TA")) ++f[6];
					else if(temp.equals("CG") || temp.equals("GC")) ++f[7];
					else if(temp.equals("CT") || temp.equals("TC")) ++f[8];
					else if(temp.equals("GT") || temp.equals("TG")) ++f[9];
				}
			}
		}

		int[] temp = new int [6];

		for(int i = 0; i < temp.length; i++){
			temp [i] = f[i + 4];
		}

		Arrays.sort(temp);

		for(int i = temp.length-1 , k = 4; i >= 0; --i, ++k){
			f[k] = temp[i];
		}

		for(int i = 0; i < f.length; i++)
			System.out.println(f[i]);

		/* Algorithm */

		double best = Integer.MIN_VALUE;

		for(s[0] = 1; s[0] <= 10; s[0]++)
		{
			for(s[1] = 1; s[1] <= 10; s[1]++)
			{
				for(s[2] = 1; s[2] <= 10; s[2]++)
				{
					for(s[3] = 1; s[3] <= 10; s[3]++)
					{
						if((s[0] + s[1] + s[2] + s[3]) % 2 == 0)
						{
							s[4] = s[5] = 10;
							s[6] = 10 - ((s[0] + s[1] + s[2] + s[3])) / 2;
							s[7] = s[8] = s[9] = -10;

							best = Math.max(best , score (f, s, n));
						}				
					}
				}
			}
		}
		return best;
	}

	public static void main(String[] args) {

		String [] a = {"ACTAGAGAC","AAAAAAAAA","TAGTCATAC","GCAGCATTC"};
		System.out.println(maxAvg(a));
	}
}