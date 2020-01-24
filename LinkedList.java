
public class LinkedList<T>{
    private GTNode<T>head;
    GTNode<T> current;
    
    
	public LinkedList() {
		head = null;
		current= null;
	}
	
	
    public boolean empty() {
		return head == null;
	}
	public boolean full() {
		return false;
	}
	public void findFirst() {
		current = head;
	}
	public void findNext() {
		current = current.next;
	}
	public boolean last() {
		
		return current.next == null;
	}
	public T retrieve() {
		return current.data;
	}
	public void update(T e) {
		current.data = e;
	}
	
	public void insert(T e) {
		GTNode<T> n = new GTNode<T>(e);
		
		if(empty())
			head = current = n;
		else {
			n.next = current.next;
			current.next = n;
			current = current.next;
		}
		
			
	}
	public void remove () {
		if (current == head) {
			head = head.next;
		}else {
			GTNode<T> tmp = head;

			while (tmp.next != current)
				tmp = tmp.next;

			tmp.next = current.next;
		}

		if (current.next == null)
			current = head;
		else
			current = current.next;
	}

	
	public void remove(T e) {
		GTNode<T> t = head ;
		GTNode<T> p = head ;
		while(t != null) {
			if(head.data.equals(e)) {
				head = head.next;
				t    = t.next;
			}
			else if(t.data.equals(e)) {
				p.next = t.next;
				t = t.next;
			}
			else {
			p = t ; 
			t = t.next;
			}
		}
	}
	
	
	

}
