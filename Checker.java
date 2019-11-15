import java.util.ArrayList;
public class Checker 
{
	public static boolean check(ArrayList<Coordinates> list)
	{
		
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = 0; j < list.size(); j++)
			{
				if(i == j)
				{
					break;
				}
				//Checks if queens are on same horizontal
				else if(list.get(i).getX() == list.get(j).getX())
				{
					return false;
				}
				//Checks if queens are on same vertical
				else if(list.get(i).getY() == list.get(j).getY())
				{
					return false;
				}
				//Checks if queens are on same positive slope diagonal
				else if(list.get(i).getX() + list.get(i).getY() == 
						list.get(j).getX() + list.get(j).getY())
				{
					return false;
				}
				//Checks if queens are on the same negative slop diagonal
				else if(list.get(i).getX() - list.get(i).getY() ==
						list.get(j).getX() - list.get(j).getY())
				{
					return false;
				}
				
			}
		}
		
		return true;
	}
}
