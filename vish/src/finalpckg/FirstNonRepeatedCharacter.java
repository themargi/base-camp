package finalpckg;

import java.util.ArrayList;

public class FirstNonRepeatedCharacter 
{
	public static void main(String[] args)
	{
		String s = "carrcy";
		ArrayList<Character> ctrl1 = new ArrayList<Character>();
		ArrayList<Character> ctrl2 = new ArrayList<Character>();
		
		for(int i=0;i<s.length();i++)
		{
			Character chk = s.charAt(i);
			if(ctrl2.contains(chk))
			{
				if(ctrl1.contains(chk))
				{
					ctrl1.remove(chk);
				}				
			}
			else
			{
				ctrl2.add(chk);
				ctrl1.add(chk);
			}
		}
		System.out.println(ctrl1.get(0));
	}	
}
