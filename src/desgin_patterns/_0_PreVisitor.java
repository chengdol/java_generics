package desgin_patterns;

// 这是一种用case analysis and recursion定义一种结构的方法
// 见下一个visitor pattern对它的改进
public class _0_PreVisitor
{
	public static void main(String[] args)
	{
		MyTree<Integer> t = MyTree.branch(MyTree.branch(MyTree.leaf(1), MyTree.leaf(2))
				, MyTree.leaf(3));
		System.out.println(t.toString());
	}
}

// abstract class
abstract class MyTree<E>
{
	@Override
	abstract public String toString();
	abstract public Double sum();
	
	// here should be final
	public static <E> MyTree<E> leaf(final E e)
	{
		// anonymous class
		return new MyTree<E>() {

			@Override
			public String toString()
			{
				return e.toString();
			}

			@Override
			public Double sum()
			{
				return ((Number)e).doubleValue();
			}
			
		};
	}
	
	// here should be final
	public static <E> MyTree<E> branch(final MyTree<E> left, final MyTree<E> right)
	{
		// anonymous
		return new MyTree<E>() {

			@Override
			public String toString()
			{
				return "(" + left.toString() + "^" + right.toString() + ")";
			}

			@Override
			public Double sum()
			{
				return left.sum() + right.sum();
			}
			
		};
	}
	
	
}
