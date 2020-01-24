
public class GTNode<T> {
	T data;
	GTNode next;
	LinkedList<GTNode<T>> ch;
	public GTNode(T data) {
		this.data = data ;
		next = null;
		ch = new LinkedList();
	}
}