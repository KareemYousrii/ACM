public class GroceryBagger
{
	public static int minimumBags(int strength, String[] itemType)
	{
		int[] items = new int [itemType.length];

		int index = 0;
		for(int i = 0; i < itemType.length; i++)
		{
			if(itemType[i] == null) /* Has been considered before */
				continue;

			items[index]++;

			for(int j = i + 1; j < itemType.length; j++)
			{
				if(itemType[i].equalsIgnoreCase(itemType[j]))
				{
					items[index]++;
					itemType[j] = null;
				}
			}
			index++;
		}

		/* Print the list of occurrences */
		// for(int i = 0; i < items.length; i++)
		// 	System.out.println(items[i]);

		/* Algorithm */
		int bags = 0;

		for(int i = 0; i < itemType.length; i++)
		{
			while(items[i] > 0)
			{
				items[i] -= strength;
				bags++;
			}
		}
		return bags;
	}

	public static void main(String[]args)
	{
		int n = 2;
		String[] itemType = {"DAIRY",
 "DAIRY",
 "PRODUCE",
 "PRODUCE",
 "PRODUCE",
 "MEAT"};

		System.out.println(minimumBags(n, itemType));
	}
}