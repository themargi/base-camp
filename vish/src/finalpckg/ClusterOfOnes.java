package finalpckg;

import java.util.ArrayList;
import java.util.Scanner;

class Move
{
	int moveRow;
	int moveCol;
	
	Move(int i, int j)
	{
		moveRow = i;
		moveCol = j;
	}
	
	public int getMoveRow()
	{
		return moveRow;
	}
	
	public int getMoveCol()
	{
		return moveCol;
	}
	
}

public class ClusterOfOnes 
{
	public static int N;
	public static int M;
	public static int[][] arr;
	public static ArrayList<Move> moves = new ArrayList<Move>();
		
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		N = in.nextInt();
		M = in.nextInt();
		arr = new int[N][M];
		
		moves.add(new Move(0,1));
		moves.add(new Move(1,1));
		moves.add(new Move(1,0));
		moves.add(new Move(1,-1));
		moves.add(new Move(0,-1));
		moves.add(new Move(-1,-1));
		moves.add(new Move(-1,0));
		moves.add(new Move(-1,1));
		
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<M;j++)
			{
				arr[i][j]=in.nextInt();
			}
		}
		int maxCount = 0;
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				int count = checkCount(i,j);
				if(count>maxCount) maxCount = count;
			}
		System.out.println(maxCount);
		in.close();
	}

	private static int checkCount(int i, int j)
	{
		int count = 0;
		
		if(arr[i][j] == 0)
		{
			return 0;
		}
		else
		{
			count=1;
			arr[i][j] = 0;
			
			for(int k=0;k<8;k++)
			{
				int newRow = i + moves.get(k).getMoveRow();
				int newCol = j + moves.get(k).getMoveCol();
				if( (newRow < N) && (newRow > -1) && (newCol < M)  && (newCol > -1 ) )
				{
					count+=checkCount(newRow,newCol);
				}
			}
			return(count);
		}	
	}
}
