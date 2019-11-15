
public class Coordinates
{
	int x = 0;
	int y = 0;
	
	public Coordinates(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	//@Override
	public String toString()
	{
		String str = "(" + this.x + "," + this.y + ")";
				
		return str;
	}
}
