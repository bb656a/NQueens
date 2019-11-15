import java.util.ArrayList;
import java.util.Iterator;
/*
 *  this class contains the logic to solve the N-Queen's problem
 */
public class Solver
{
	int size;
	ArrayList<Board> boards;
	ArrayList<Board> solutions;
	Board solution = null;
	long counter = 0;
	
	
	Solver(int size)
	{
		boards = new ArrayList<Board>();
		solutions = new ArrayList<Board>();
		this.size = size;
	}
	
	public void solve()
	{
		boards.add(new Board(size, new ArrayList<Coordinates>()));
		Board newBoard;
		
		while(!boards.isEmpty())
		{
			Board temp = boards.remove(boards.size()-1);
			Iterator<Coordinates> it = temp.getPossible().iterator();
			while(it.hasNext())
			{
				ArrayList<Coordinates> list = (ArrayList<Coordinates>)temp.getQueens().clone();
				list.add((Coordinates) it.next());
				newBoard = new Board(this.size, list);
				
				if(newBoard.getQueens().size() == this.size)
				{
					solutions.add(newBoard);
//					solved = true;
//					System.out.println("Check: " + Checker.check(newBoard.getQueens()));
//					System.out.println("Solution Found: " + newBoard.toString());
				}
				else if(newBoard.getPossible().size() >= this.size - newBoard.getQueens().size()) 
				{
					boards.add(newBoard);
				}
			}
		}
		Iterator<Board> it = this.solutions.iterator();
		Board temp = null;
		System.out.println("Solutions are:\n");
		while(it.hasNext())
		{
			temp = it.next();
			System.out.println(temp.toString());
		}
	}
	
}
