package generics_method;

import java.util.ArrayList;
import java.util.List;

// convert array to list
// using generics method and varargs
public class Lists
{
	// varargs always receive an unchecked warning
	@SafeVarargs
	public static <T> List<T> toList(T... arr)
	{
		List<T> tmp = new ArrayList<>();
		for (T n : arr) { tmp.add(n); }
		
		return tmp;
	}
	
	public static void main(String[] args)
	{
		System.out.println(toList(new Double[]{3.23, 45.4, -34.4}));
		// varargs will create array from inputs
		System.out.println(Lists.toList("1", "2", "3"));
		// explicitly give the type
		// sometimes this is necessary
		System.out.println(Lists.<Number>toList(1, 2.45, -34.9));
		
	}
}
