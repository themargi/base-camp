package finalpckg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StockMaximizeProfit 
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		int[] arr = new int[count];
		ArrayList<Integer> tab = new ArrayList<Integer>();
		for(int i=0; i<count; i++)
		{
			int k = in.nextInt();
			arr[i] = k;
			tab.add(k);
		}
		Collections.sort(tab);
		int buyCost = 0;
		int shareCount = 0;
	    int sellCost = 0;
	    int currPeak = tab.get(count-1);
	    
	    for(int i=0;i<count;i++)
	    {
	    	if(arr[i]!=currPeak || shareCount == 0)
	    	{
	    		tab.remove(Integer.valueOf(arr[i]));
	    		if(shareCount==0 && tab.size()!=0) 
	    		{
	    			currPeak = tab.get(tab.size()-1);
	    		}
	    		System.out.println("Buying one quantity at: " + arr[i]);
	    		buyCost = buyCost + arr[i];
	    		shareCount++;
	    		
	    	}
	    	else
	    	{
	    		System.out.println("Selling " + shareCount + " quantity at: " + arr[i]);
	    		sellCost = sellCost + shareCount*arr[i];
	    		shareCount = 0;
	    		tab.remove(Integer.valueOf(arr[i]));
	    		if(tab.size()!=0)
	    			currPeak = tab.get(tab.size()-1);
	    	}
	    	System.out.println();
	    }
	    System.out.println();
	    int profit = sellCost-buyCost; 	
	    System.out.println("Profit = " + profit );
		in.close();
	}
}

