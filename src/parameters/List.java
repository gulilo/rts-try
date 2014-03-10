package parameters;

public class List<T>
{
	private Node<T> head;

	public List()
	{
		head = null;
	}

	public Node<T> add(T t)
	{
		if(head == null)
		{
			head = new Node<T>(t);
			return head;
		}
		else
		{
			Node<T> current = head;
			for(; current.getNext() != null; current = current.getNext())
			{}
			Node<T> next = new Node<T>(t);
			current.setNext(next);
			return next;
		}
	}

	public Node<T> getHead()
	{
		return head;
	}
}
