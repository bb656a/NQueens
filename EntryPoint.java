import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
public class EntryPoint {

	public static void main(String[] args) 
	{
		
		Solver solver = new Solver(8);
		
		try
		{
			solver.solve();
		} 
		catch( Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		

	}

}
