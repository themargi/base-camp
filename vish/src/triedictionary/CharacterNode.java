package triedictionary;

import java.util.ArrayList;

public class CharacterNode 
{
	private char myChar;
	private boolean endMark = false;
	
	private ArrayList<CharacterNode> children = null;
	
	CharacterNode(char in)
	{
		myChar = in;
	}
	
	public char getChar()
	{
		return myChar;
	}
	
	public boolean getEndMark()
	{
		return endMark;
	}
	
	public void addEndMark()
	{
		endMark = true;
	}
	public void removeEndMark()
	{
		endMark = false;
	}
	
	public ArrayList<CharacterNode> getChildren()
	{
		return(children);
	}
	
	public void addChild(char in, boolean endMark)
	{
		CharacterNode c = new CharacterNode(in);
		if(endMark)
		{
			c.addEndMark();
		}
		
		if(null==this.children)
		{
			this.children = new ArrayList<CharacterNode>();					
		}
		this.children.add(c);	
	}

	public CharacterNode getChild(char now) 
	{
		ArrayList<CharacterNode> children = this.getChildren();
		for(int i=0;i<children.size();i++)
		{
			if(children.get(i).getChar()==now) return(children.get(i));
		}
		return null;
	}
	
	public String toString()
	{
		return String.valueOf(myChar);		
	}
}
