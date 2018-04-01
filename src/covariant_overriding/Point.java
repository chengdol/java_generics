package covariant_overriding;

import java.lang.reflect.Method;

public class Point
{
	int x;
	int y;
	
	public Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	// subclass can always widen the access modifer
	// protected to public
	// the return type is Point, covariant overriding
	@Override
	public Point clone() throws CloneNotSupportedException
	{
		return new Point(x, y);
	}
	
	public static void main(String[] args)
	{
		for (Method m : Point.class.getMethods())
		{
			if (m.getName().equals("clone"))
			{
				// there are 2 clone methods
				// using bridge implementation
				System.out.println(m.toGenericString());
			}
		}
		
	}
}
