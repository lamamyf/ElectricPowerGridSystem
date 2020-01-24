public class PowerGridUtils {

	// Return the IDs of all elements in the power grid pg in pre-order.
	public static Queue<Integer> collectPreorder(GT<PGElem> pg){
		Queue<Integer> ids = new LinkedQueue();
		if(pg == null)
			return ids;
		pg.findRoot();
		 collect(pg , ids);
		 return ids;
	}
	
	private static void collect(GT<PGElem> pg, Queue<Integer>ids){
		if(pg == null || pg.empty())
		return;
		
		ids.enqueue(pg.retrieve().getId());
		
		if(pg.nbChildren()==0)  
			//pg.findParent();
			return;
		
		int c = pg.nbChildren();
		for(int i = 0 ; i<c ; i++){
				pg.findChild(i);
				collect( pg , ids );
				pg.findParent();
				
		}
	}

	// Searches the power grid pg for the element with ID id. If found, it is made current and true is returned, otherwise false is returned.
	public static boolean find(GT<PGElem> pg, int id) {
		if(pg == null || pg.empty())
			return false;
		
		int currid = pg.retrieve().getId();
		
		boolean found = false;
		Queue<Integer> ids = collectPreorder(pg);
		
		for(int i = 0 ; i<ids.length();i++) {
			Integer t = ids.serve();
			ids.enqueue(t);
			
			if(t == id ) 
			found = true;
	}
		if(!found) {
			find(pg , currid);
			return false;
		}
		
		
		pg.findRoot();
		return findrec(pg,id,-1);
		
	}
	
	public static boolean findrec(GT<PGElem> pg, int id,int i) {
		
		if(pg == null || pg.empty())
			return false;
		
		if(pg.retrieve().getId() == id) {
			if(i == -1 ) {
				pg.findRoot();
				return true;
			}
			pg.findParent();
			pg.findChild(i);
			return true;
		}
		
		for(int j =0 ;j<pg.nbChildren();j++) {
			pg.findChild(j);
			boolean found =findrec(pg,id,j);
			if(found)
				return true;			
			pg.findParent();
		}
		
		return false;
		
		
	}
	// Add the generator element gen to the power grid pg. This can only be done if the grid is empty. If successful, the method returns true. If there is already a generator, or gen is not of type Generator, false is returned.
	public static boolean addGenerator(GT<PGElem> pg, PGElem gen) {
		if(pg == null || gen == null)
			return false;
		if(pg.empty() && gen.getType() == ElemType.Generator) {
			pg.insert(gen);
			return true;
		}
		
		return false;
	}

	// Attaches pgn to the element id and returns true if successful. Note that a consumer can only be attached to a transmitter, and no element can be be attached to it. The tree must not contain more than one generator located at the root. If id does not exist, or there is already aelement with the same ID as pgn, pgn is not attached, and the method retrurns false.
	public static boolean attach(GT<PGElem> pg, PGElem pgn, int id) {
		if(pg == null || pgn == null)
			return false;
		
		if(!pg.empty() && pgn.getType() == ElemType.Generator)
			return false;//not sure
		
		int currid = pg.retrieve().getId();
		if(find(pg,pgn.getId())){ ///not a unique id,move curr back
			find(pg,currid);//not sure!!!
			return false;
		}
		
		if(!find(pg,id))//did not find the element that we suposed to attach the ele to it
		 return false;
		
		if(pg.retrieve().getType() == ElemType.Consumer)
			return false;
		if( pg.retrieve().getType() != ElemType.Transmitter && pgn.getType() == ElemType.Consumer)
				return false;
		pg.insert(pgn);
		return true;
		
		
		
	}
	// Removes element by ID, all corresponding subtree is removed. If removed, true is returned, false is returned otherwise.
	public static boolean remove(GT<PGElem> pg, int id) {
		if(pg == null || pg.empty())
			return false;
		if(!find(pg,id))
			return false;
		pg.remove();
		return true;
	}

	// Computes total power that consumed by a element (and all its subtree). If id is incorrect, -1 is returned.
	public static double totalPower(GT<PGElem> pg, int id) {	
		if(pg == null || pg.empty())
			return -1;
		
		if(!find(pg,id))
			return -1;
		
		if(pg.retrieve().getType() == ElemType.Consumer)
			return pg.retrieve().getPower();
		
		double power = 0;
		for(int i = 0 ; i<pg.nbChildren() ; i++) {
			pg.findChild(i);
			power += totalPower(pg, pg.retrieve().getId());
			pg.findParent();
		}
		
		return power;
	}
	

	// Checks if the power grid contains an overload. The method returns the ID of the first element preorder that has an overload and -1 if there is no overload.
	public static int findOverload(GT<PGElem> pg){
		if(pg == null || pg.empty())
			return -1;
		pg.findRoot();
		return findOverloadrec(pg);
	}

	private static int findOverloadrec(GT<PGElem> pg){
		if(pg == null || pg.empty())
			return -1;
		if(pg.retrieve().getType() == ElemType.Consumer)
			return -1;
		
		int currid = pg.retrieve().getId();
		double cap = pg.retrieve().getPower();
		//for(int i = 0 ; i<pg.nbChildren() ; i++ ) {
			//pg.findChild(i);
			//if(pg.retrieve().getType() == ElemType.Consumer)	
				//total += pg.retrieve().getPower();
			//pg.findParent();
		//}

		if(totalPower(pg,currid) > cap)
			return currid;
		
		find(pg,currid);
		for(int i = 0 ; i<pg.nbChildren() ; i++ ) {
			pg.findChild(i);
			int j = findOverloadrec(pg);
			if(j!=-1)
				return j;
			pg.findParent();
		}
		
		//find(pg , currid);
		return -1;
		
		
	}
	
}