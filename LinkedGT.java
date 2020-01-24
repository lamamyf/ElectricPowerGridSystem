
public class LinkedGT<T> implements GT<T> {
	GTNode<T> root;
	GTNode<T> current;
	public LinkedGT() {
		root = current = null ;
	}

	@Override
	public boolean empty() {
		return root == null;
	}

	@Override
	public boolean full() {
		return false;
	}

	@Override
	public T retrieve() {
		return current.data;
	}

	@Override
	public void update(T e) {
		current.data = e ;
	}

	@Override
	public boolean insert(T e) {
		GTNode<T> newNode = new GTNode<T>(e);
		if(empty()) {
			root = newNode;
			current = newNode;
			return true;
		}
		
		if(!current.ch.empty()){
			while(!current.ch.last())
				current.ch.findNext();
		}
		current.ch.insert(newNode);
		current = newNode;
		return true;
	}

	@Override
	public int nbChildren(){
		if(empty())
		return 0;
		if(current.ch.empty())
			return 0;
		int n = 1;
		current.ch.findFirst();
		while(!current.ch.last()) {
			n++;
			current.ch.findNext();
		}
		
		return n;
	}
	private int nCh(GTNode<T>n) {
		if(n == null)
			return 0;
		if(n.ch.empty())
			return 0;
		
		int c= 1;
		n.ch.findFirst();
		while(!n.ch.last()) {
			c++;
			n.ch.findNext();
		}
		
		return c;
	}
	@Override
	public boolean findChild(int i) {
		if(empty())
			return false;
		
		int numOfChild = nbChildren();
		
		if(i >=numOfChild || i<0)
		return false;
		
		LinkedList<GTNode<T>> list = current.ch;
		list.findFirst();
		for(int j = 0 ; j< numOfChild ; j++) {
			if(j==i) {
		current = list.retrieve();
		break;
			}
			current.ch.findNext();
		}
		return true;
		
	}

	@Override
	public boolean findParent() {
		if(current == root)
			return false;
		findParent(root);
		return true;
	
	}
	
	
	
	private void findParent(GTNode<T>parent) {
		if(nCh(parent)==0)
			return;
		parent.ch.findFirst();
		
		while(true) {
			
			if(parent.ch.retrieve()==current) {
				current = parent;
				return;
			}
			
			if(parent.ch.last())
				break;
			parent.ch.findNext();
		}
		parent.ch.findFirst();

		while(!parent.ch.last()) {
			findParent(parent.ch.retrieve());
			parent.ch.findNext();;

		}
		
		findParent(parent.ch.retrieve());
	}
	
	/*private boolean isItMyChild(GTNode<T> parent,GTNode<T> n) {
		
		if(parent.ch.empty())
			return false;
		
		parent.ch.findFirst();
		while(!parent.ch.last()){
		
			if(parent.ch.retrieve()==n)
				return true;
			parent.ch.findNext();
		}
		
		if(parent.ch.retrieve() ==n) 
			return true;
		
		return false;
	}*/

	@Override
	public void findRoot(){
		if(!empty())
		current = root;
	}

	@Override
	public void remove() {
		if(empty())
			return;
		GTNode<T> temp = current;
		
		if(current == root) {//current == root
			current = root = null;
			return;
		}
		
		if(!findParent())
			return;
		
		if(current.ch.empty())
			return;
		
		LinkedList<GTNode<T>> x= current.ch;
			x.findFirst();
			
		while(!x.last()){
			if(x.retrieve() == temp) {
				x.remove();
				return;
			}
			x.findNext();
		}
		
		if(x.retrieve() == temp)
				x.remove();
	}

}
