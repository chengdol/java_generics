package generics_method;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

// wildcard ?
// extends and super
public class WildcardDemo
{
	
	public static <T> void copy(Collection<? super T> dst, Collection<? extends T> src)
	{
		for (T t : src)
		{
			dst.add(t);
		}
	}
	
	public static void main(String[] args)
	{
		List<Integer> ints = new ArrayList<>();
		List<? extends Number> nums = ints;
		// wrong
		// nums.add(100);
		
		List<Object> objs = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		doubles.add(1.23);
		doubles.add(3.4);
		doubles.add(-6.55);
		List<String> strs = new ArrayList<>();
		strs.add("hello");
		strs.add("PHP");
		strs.add("green");
		// copy
		copy(objs, doubles);
		copy(objs, strs);
		
		System.out.println(objs.toString());
	}
}
