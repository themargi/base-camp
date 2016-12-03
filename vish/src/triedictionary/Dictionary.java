package triedictionary;

import java.util.Scanner;

public class Dictionary 
{
	public static void main(String[] args)
	{
		int a=1;int b =1;
		Scanner in = new Scanner(System.in);
		CharacterNode root = new CharacterNode('*');
		DictionaryUtils util = new DictionaryUtils(root);
		while(a==b)
		{
			System.out.println("1.Add Word 2.Search Word 3.Remove Word 4.Exit");
			
			switch(in.nextInt())
			{
				case 1:
					util.addWord(in.next());
					break;
				case 2:
					util.searchWord(in.next());
					break;
				case 3:
					util.removeWord(in.next());
					break;
				case 4:
					a=2;
					break;
				default:
					System.out.println("Input a valid Choice");
			}
		}
		in.close();
	}
}
