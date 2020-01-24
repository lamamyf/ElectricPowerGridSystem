
public class Node<T> {
    T data;
    Node<T> next;
    
	public Node(T val) {
		data = val;
		next = null;
	}

	
	/*private boolean findParent(GTNode<T> n) {
		if(current == root || n == null) {
			return false;

		}
			
		if(isItMyChild(n,current)) {
			current = n;
			return true;
		}
		
		
		if(n.ch.empty()) 
		return false;
		
		n.ch.findFirst();
		boolean flag = false;
		for(int i = 0 ; i<nCh(n); i++){
	  		flag = findParent(n.ch.retrieve());
	  		if(flag)
	  			break;
	  		n.ch.findNext();
		}
		return flag ;
	}*/
	
	/*		if(current == root || n == null) {
			return ;

		}
			
		if(isItMyChild(n,current)) {
			current = n;
			return;
		}
		
		
		if(n.ch.empty()) 
		return;
		
		n.ch.findFirst();
		boolean flag = false;
		for(int i = 0 ; i<nCh(n); i++){
	  		findParent((GTNode<T>)n.ch.current);
	  		//if(flag)
	  			//break;
	  		n.ch.findNext();
		}
		*/
}



