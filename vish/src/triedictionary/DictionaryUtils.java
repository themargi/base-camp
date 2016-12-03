package triedictionary;

import java.util.ArrayList;

public class DictionaryUtils
{
	private CharacterNode root;
	
	DictionaryUtils(CharacterNode in)
	{
		root=in;
	}
	
	public void addWord(String s)
	{
		CharacterNode curr = root;
		boolean endMark = false;
		for(int i=0;i<s.length();i++)
		{
			if(i==s.length()-1) endMark = true;
			
			char now =s.charAt(i);
						
			if(null != curr.getChildren())
			{
				ArrayList<CharacterNode> children = curr.getChildren();
				boolean found = false;
				for(int j=0;j<children.size();j++)
				{
					CharacterNode nowNode = children.get(j);
					if(nowNode.getChar()==now) 
					{
						if(endMark)
						{
							if( nowNode.getEndMark() ) System.out.println("Word already exists");
							else nowNode.addEndMark();
						}
						found = true;
					}
					if(found) break;
				}
				curr.addChild(now, endMark);
			}
			else
			{
				curr.addChild(now, endMark);
			}
			
			curr=curr.getChild(now);
		}
	}
	
	public void searchWord(String s)
	{
		CharacterNode curr = root;
		for(int i=0;i<s.length();i++)
		{	
			char now =s.charAt(i);
			boolean found = false;
			if(null != curr.getChildren())
			{
				ArrayList<CharacterNode> children = curr.getChildren();
				for(int j=0;j<children.size();j++)
				{
				    if(children.get(j).getChar()==now)
				    {
				    	curr = children.get(j);
				    	found=true;
				    }
					if(found) break;				    
				}
			}
			if(!found)
			{
				System.out.println("Search String not found");
				return;
			}
		}	
		printStrings(curr,s);
	}
	
	private void printStrings(CharacterNode node, String s) 
	{
		ArrayList<CharacterNode> children = node.getChildren();
		if(node.getEndMark())
		{
			System.out.println(s);
		}
		if(null!=children)
		{
			for(int j=0;j<children.size();j++)
			{
				String newS = s+children.get(j).getChar();
				printStrings(children.get(j), newS);	
			}
		}
	}

	public void removeWord(String s)
	{
		CharacterNode curr = root;
		CharacterNode prev = root;
		for(int i=0;i<s.length();i++)
		{
			char now =s.charAt(i);
			boolean found = false;
			if(null != curr.getChildren())
			{
				ArrayList<CharacterNode> children = curr.getChildren();
				for(int j=0;j<children.size();j++)
				{
				    if(children.get(j).getChar()==now)
				    {
				    	curr = children.get(j);
				    	if( curr.getEndMark() && i!=(s.length()-1) ) prev=curr;
				    	found=true;
				    }
					if(found) break;				    
				}
			}
			if(!found)
			{
				System.out.println("Search String not found");
				return;
			}
		}
		if(!curr.getEndMark())
		{
			System.out.println("Search String not found");
			return;
		}
		curr.removeEndMark();
		//FIX ME: the actual entry has not been purged.
		System.out.println(s + " has been removed");
	}
}
