package generics_class;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

// it has a static nested class
public class LinkedCollection2<E> extends AbstractCollection<E>
{
	private static class Node<T>
	{
		private T value;
		private Node<T> next = null;
		private Node(T val) { value = val; }
	}
	
	private int size = 0;
	private Node<E> first = new Node<>(null);
	private Node<E> last = first;
	
	public LinkedCollection2() {}
	public LinkedCollection2(Collection<? extends E> col) { addAll(col); }
	
	@Override
	public boolean add(E e)
	{
		last.next = new Node<E>(e);
		last = last.next;
		size++;
		return true;
	}
	
	@Override
	public Iterator<E> iterator()
	{
		// because Node is static, 
		return new Iterator<E>() {
			private Node<E> current = first;
			
			@Override
			public boolean hasNext()
			{
				return current.next != null;
			}

			@Override
			public E next()
			{
				if (hasNext())
				{
					current = current.next;
					return current.value;
				}
				else
				{
					throw new NoSuchElementException();
				}
			}
		};
	}

	@Override
	public int size()
	{
		return size;
	}

}
