package bridges;

import java.lang.reflect.Method;

// use reflection to see bridge method added by compiler
// when using generics interface
public class Bridge
{
	public static void main(String[] args)
	{
		for (Method m : Integer.class.getMethods())
		{
			if (m.getName().equals("compareTo"))
			{
				// you can see there are 2 methods with different argus
				System.out.println(m.toGenericString());
			}
		}
	}
}
