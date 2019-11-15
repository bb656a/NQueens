import java.util.ArrayList;
import java.util.Iterator;
/*
 * 	This class represents a chess board with queens on it,
 * 	The queens are represented by coordinates, the board generates a list
 * 		of possible locations for the queens to be placed on.
 */
public class Board
{
	// adding to test git
	int size = 0;
	static long count = 0;
	long id = 0;
	Iterator<Coordinates> it;
	ArrayList<Coordinates> queens;
	ArrayList<Coordinates> possible;
	long parentId = 0;
	
	public Board(int size, ArrayList<Coordinates> queens, long parentId) throws Exception
	{
		id = count++;
		this.parentId = parentId;
		this.size = size;
		this.queens = queens;
		findPossible();
		System.out.println(this.toString());
	}
	
	public long getId()
	{
		return this.id;
	}
	
	public ArrayList<Coordinates> getQueens()
	{
		return this.queens;
	}
	
	public ArrayList<Coordinates> getPossible()
	{
		return this.possible;
	}
	
	private void findPossible() throws Exception
	{
		//Fills possible with every coordinate on the board
		this.possible = new ArrayList<Coordinates>();
		for(int i = 0; i < size; i++)
		{
			for(int j = 0; j < size; j++)
			{
				this.possible.add(new Coordinates(i,j));
			}
		}
		
		//Removes coordinates from possible that can be attacked by a queen in queen's
		for(int i = 0; i < queens.size(); i++)
		{
			
			//Removing possible's on queens horizontal axis
			it = this.possible.iterator();
			while(it.hasNext())
			{
				Coordinates temp = it.next();
				if(temp.getX() == queens.get(i).getX())
				{
					it.remove();
				}
			}
			//Removing possible's on queens vertical axis
			it = this.possible.iterator();
			while(it.hasNext())
			{
				Coordinates temp = it.next();
				if(temp.getY() == queens.get(i).getY())
				{
					it.remove();
				}
			}
			//Removing possible's on queens positive diagonal axis
			it = this.possible.iterator();
			while(it.hasNext())
			{
				Coordinates temp = it.next();
				if(temp.getX() + temp.getY() == 
						queens.get(i).getX() + queens.get(i).getY())
				{
					it.remove();
				}
			}
			//Removing possibles on queens negative diagonal axis
			it = this.possible.iterator();
			while(it.hasNext())
			{
				Coordinates temp = it.next();
				if(temp.getX() - temp.getY() == 
						queens.get(i).getX() - queens.get(i).getY())
				{
					it.remove();
				}
			}

		}
		if(!Checker.check(this.queens))
		{
			throw new Exception("\n\n\n Error id: " + this.id + "\n" + this.toString());
		}
		
	}
	
	public String toString()
	{
		
		String str = "\n" + "ID: " + this.id;
		str += "\n" + "Parent ID: " + this.parentId;
		boolean found = false;
		
		str += "\nPossible " + this.possible.size() + "\n";
		str += this.possible.toString();
		str += "\n queens: " + this.queens.size();
		str += "\n" + this.queens.toString() + "\n";
		
		for(int i = 0; i < this.size; i++)
		{
			for(int j = 0; j < this.size; j++)
			{
				for(int k = 0; k < this.queens.size(); k++)
				{
					if(this.queens.get(k).getX() == i &&
							this.queens.get(k).getY() == j)
					{
						str += "X";
						found = true;
					}
				}
				
				for(int k = 0; k < this.possible.size(); k++)
				{
					if(this.possible.get(k).getX() == i && 
							this.possible.get(k).getY() == j)
					{
						str += "P";
						found = true;
					}
				}
				if(!found)
				{
					str += "O";
				}
				found = false;
			}
			str += "\n";
		}
		return str;
	}
}
