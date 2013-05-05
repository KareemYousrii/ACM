import java.util.Arrays;

public class WorldPeace
{
	public static int[] sortReverse(int[] countries)
	{
		int n = countries.length;
		int[] result = new int [n];
		Arrays.sort(countries);

		/* Reverse the array */
		for(int i = 0; i < n; i++)
		{
			result[i] = countries[n-1-i];
		}

		return result;
	}
	public static long numGroups(int k, int[] countries)
	{
		long groups = 0;
		int min = 0;

		do {

			countries = sortReverse(countries);
			min = countries[k - 1];

			if(min > 0)
			{
				int allowance = (999 + min) / 1000;

				groups += allowance;

				for(int i = 0; i < k; i++)
					countries [i] -= allowance;
			}

		} while(min > 0);

		return groups; 
	}
	public static void main(String[] args)
	{
		int k = 10;
		int[] countries = { 638074479, 717901019, 910893151, 924124222, 991874870, 919392444, 729973192, 607898881, 
  838529741, 907090878, 632877562, 678638852, 749258866, 949661738, 784641190, 815740520, 
  689809286, 711327114, 658017649, 636727234, 871088534, 964608547, 867960437, 964911023, 
  642411618, 868318236, 793328473, 849540177, 960039699, 998262224, 775720601, 634685437, 
  743766982, 826321850, 846671921, 712570181, 676890302, 814283264, 958273130, 899003369, 
  909973864, 921987721, 978601888, 633027021, 896400011, 725078407, 662183572, 629843174, 
  617774786, 695823011 };

		long res = numGroups(k, countries);
		System.out.println(res);
	}
}