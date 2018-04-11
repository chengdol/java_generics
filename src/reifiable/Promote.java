package reifiable;

import java.util.Arrays;
import java.util.List;

public class Promote
{
	@SuppressWarnings("unchecked")
	public static List<String> promote(List<Object> objs)
	{
		for (Object o : objs)
		{
			if (!(o instanceof String))
			{
				throw new ClassCastException();
			}
		}
		
		return (List<String>)(List<?>)objs; // unchecked cast
	}
	
	public static void main(String[] args)
	{
		List<Object> obj1 = Arrays.asList("1", "2", "3");
		List<Object> obj2 = Arrays.asList(1, "2", "3");
		
		List<String> str1 = promote(obj1);
		System.out.println((List<?>)str1 == (List<?>)obj1);
		
		try
		{
			List<String> str2 = promote(obj2);
		}
		catch (ClassCastException e)
		{
			e.printStackTrace();
		}
		
		
	}
}
