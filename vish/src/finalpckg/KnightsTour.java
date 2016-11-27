package finalpckg;
import java.util.HashMap;

public class KnightsTour 
{
	static HashMap <Integer, int[] > moves = new HashMap<Integer,int[]>();
	static int a[][] = new int[5][5];
	
	public static void main (String[] args)
	{
		int a1[] = {2,1};
		moves.put(new Integer(1), a1);
		int b[] = {2,-1};
		moves.put(new Integer(2), b);
		int c[] = {1,2};
		moves.put(new Integer(3), c);
		int d[] = {1,-2};
		moves.put(new Integer(4), d);
		int e[] = {-2,1};
		moves.put(new Integer(5), e);
		int f[] = {-2,-1};
		moves.put(new Integer(6), f);
		int g[] = {-1,2};
		moves.put(new Integer(7), g);
		int h[] = {-1,-2};
		moves.put(new Integer(8), h);
		
		int value = 1;
	    int cursor1 = 0;
		int cursor2 = 0;
		
		a[0][0] = 1;	
		
		backtrackKnight(a, cursor1, cursor2 , value);
		
		for(int i =0; i<5; i++)
		{
			for(int j=0; j<5; j++)
			{
				System.out.print(a[i][j] + ".");		
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean backtrackKnight(int[][] a, int cursor1, int cursor2, int value) 
	{
		if(value==25) return(true);
		int p = 1;
		do 
		{
			int[] move = moves.get(new Integer(p));
			int pos1 = cursor1 + move[0];
			int pos2 = cursor2 + move[1];
			
			if( pos1 < 5 &&  pos2 < 5 && pos1 > -1 && pos2 > -1){
			if( a[pos1][pos2] == 0 )
			{
				value = value + 1;
				a[pos1][pos2] = value;
				System.out.println("Trying Value " + value + "at " + pos1 + " " + pos2); 
				int origcursor1=cursor1;
				int origcursor2=cursor2;
				cursor1 = pos1;
				cursor2 = pos2;
				boolean valid = backtrackKnight( a, cursor1, cursor2, value);
				if(valid == false){
									value=value-1; cursor1=origcursor1;cursor2=origcursor2;a[pos1][pos2]=0 ;
									System.out.println("Reverting to Value " + value + " at " + pos1 + " " + pos2);
								  }		  
				if(valid == true) return(true);
			}}			
			p++;
		} while (p < 9);	
		return(false);
	}

}
