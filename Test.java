import java.util.ArrayList;
public class Test
{
	public Test()
	{
		
	}
	
	ArrayList<ArrayList<Coordinates>> list2 = new ArrayList<>();
	
	public void Super_test(ArrayList<ArrayList<Coordinates>> list2)
	{
		ArrayList<Coordinates> temp = new ArrayList<>();
		for(int i = 0; i < 10; i++)
		{
			temp.add(new Coordinates(i, i*2));
		}
		
		list2.add(temp);
		
		boolean solved = false;
		
		while(!solved)
		{
			
		}
	}
}
