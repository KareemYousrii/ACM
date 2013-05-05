public class SchoolAssembly
{
	public static int getBeans(int kids, int quantity)
	{
		return (kids * quantity + 4 * (quantity - 1) + 19) / 20;
	}

	public static int getBeans2(int kids, int quantity)
	{
		int [] buckets = new int [5];
		int len = 5;
		int q = quantity - 1;

		/* Initially fill all buckets with quantity - 1 */
		for(int i = 0; i < len; i++)
		{
				buckets[i] += q;
		}

		int beans = len * q;
		int sets = 0;
		boolean flag = false;

		while(sets < kids)
		{
			for(int i = 0; i < len; i++)
			{
				/* If the number of beans in the buckets aren't yet quantity - 1 */
				if(buckets[i] + 1 % quantity != 0)
				{
					buckets[i]++;
					flag = true;
					break;
				}				
			}
			
			if(!flag)
			{
				buckets[Math.random() * 4] = 0;
				sets++;
			}

			/* Reset the flag and increment the number of beans */
			beans++;
			flag = false;
		}
	}

	public static void main(String[]args)
	{
		int kids = 5;
		int quantity = 5;

		System.out.println(getBeans(5, 5));
	}
}