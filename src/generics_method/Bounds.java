package generics_method;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// comparison and bonuds
public class Bounds
{
	// type variable T only bound with extends, never use super!
	// 这里用super也没有意义
	public static <T extends Comparable<T>> T maxElement(Collection<T> col)
	{
		Iterator<T> itor = col.iterator();
		T ret = itor.next();
		while (itor.hasNext())
		{
			T cur = itor.next();
			if (cur.compareTo(ret) > 0) { ret = cur; }
		}
		
		return ret;
	}
	
	// improved version
	
	// use wildcards if you can
	// why use super in comparable? since we put value in compareTo method
	public static <T extends Comparable<? super T>> T maxElement2(Collection<? extends T> col)
	{
		Iterator<? extends T> itor = col.iterator();
		T ret = itor.next();
		while (itor.hasNext())
		{
			T cur = itor.next();
			if (cur.compareTo(ret) > 0) { ret = cur; }
		}
		
		return ret;
	}
	
	public static void main(String[] args)
	{
		List<Integer> ints = Arrays.asList(new Integer[] {3,7,12,4,9,36,-2,4,-23});
		System.out.println(maxElement(ints));
		System.out.println(maxElement2(ints));
	}
}
