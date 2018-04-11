package reifiable;

import java.util.Arrays;
import java.util.List;

// how to cast list as the whole
public class ListCast
{
	public static void main(String[] args)
	{
		List<Object> objs = Arrays.asList("hello", "tomcat", "123.445");
		
		// unchecked cast
		for (String str : (List<String>)(List<?>)objs)
		{
			System.out.println("length: " + str.length());
		}
	}
}
