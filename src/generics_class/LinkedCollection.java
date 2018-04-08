package generics_class;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

// it has a non-static nested class
public class LinkedCollection<E> extends AbstractCollection<E> 
{
	// can refer to E in outer class
	private class Node
	{
		private E value;
		private Node next = null;
		// private inner class, here need modifier private!
		private Node(E val) { value = val; }
	}
	
	private int size = 0;
	private Node first = new Node(null);
	private Node last = first;
	
	
	public LinkedCollection() {}
	// addAll is in AbstractCollection class, use add() method
	public LinkedCollection(Collection<? extends E> col) { addAll(col); }
	
	@Override
	public boolean add(E e)
	{
		last.next = new Node(e);
		last = last.next;
		size++;
		return true;
	}
	
	@Override
	public Iterator<E> iterator()
	{
		// can also use E in anonymous class
		return new Iterator<E>() {
			
			private Node current = first;
			
			@Override
			public boolean hasNext()
			{
				return current.next != null;
			}

			@Override
			public E next()
			{
				if (current.next != null)
				{
					current = current.next;
					return current.value;
				}
				else
				{
					throw new NoSuchElementException();
				}
				
			}};
	}

	@Override
	public int size()
	{
		return size;
	}
	
}
