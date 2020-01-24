
public class test {

	public static void main(String[] args) {
	
		GT<String> gt = new LinkedGT<String>();
		gt.insert("a");
		gt.insert("b");
		gt.findRoot();
		gt.insert("c");
		gt.findRoot();
		gt.insert("d");
		gt.findRoot();
		gt.findChild(1);
		gt.insert("l");
		gt.insert("m");
		gt.insert("n");
		gt.findRoot();
		gt.findChild(1);
		gt.findChild(0);
		gt.findChild(0);
		gt.insert("o");
		gt.findRoot();
		gt.findChild(2);
		gt.insert("e");
		gt.findParent();
		gt.insert("f");
		gt.findRoot();
		display(gt);
		System.out.println("-------------------------");

		gt.findRoot();
		gt.findChild(0);
		gt.remove();
		
		gt.findRoot();
		System.out.println(gt.retrieve());
		gt.findChild(0);
		System.out.println(gt.retrieve());
		gt.remove();
		
		gt.findRoot();
		display(gt);
		/*LinkedGT<PGElem> pg = new LinkedGT<PGElem>();

pg.insert(new PGElem(1,ElemType.Generator,1));
                    pg.insert(new PGElem(2,ElemType.Generator,1));
                    pg.findRoot();
                    pg.insert(new PGElem(3,ElemType.Generator,1));
                    pg.findRoot();
                    pg.insert(new PGElem(4,ElemType.Generator,1));
                    pg.insert(new PGElem(5,ElemType.Generator,1));
                    System.out.println(pg.findParent());
                    System.out.println(pg.retrieve().getId());
                    System.out.println(pg.findParent());
                    System.out.println(pg.retrieve().getId());
                    pg.findRoot();
                    pg.insert(new PGElem(6,ElemType.Generator,1));
                    pg.findRoot();




                    Queue<Integer> ids = PowerGridUtils.collectPreorder(pg);

                    for(int i = 0;i<ids.length();i++) {
                              Integer x = ids.serve();
                              ids.enqueue(x);
                              System.out.println(x);
                    }

	/*	pg.insert(new PGElem(1,ElemType.Generator,1));
		pg.insert(new PGElem(2,ElemType.Generator,1));
		pg.findRoot();
		pg.insert(new PGElem(3,ElemType.Generator,1));
		pg.findRoot();
		pg.insert(new PGElem(4,ElemType.Generator,1));
		pg.insert(new PGElem(5,ElemType.Generator,1));
		System.out.println(pg.findParent());
		System.out.println(pg.retrieve().getId());
		System.out.println(pg.findParent());
		System.out.println(pg.retrieve().getId());
		pg.findRoot();
		pg.insert(new PGElem(6,ElemType.Generator,1));
		pg.findRoot();*/

		//System.out.println(pg.nbChildren()+"kk");
		/*pg.insert(new PGElem(1,ElemType.Generator,1));
		pg.insert(new PGElem(2,ElemType.Generator,1));
		pg.insert(new PGElem(8,ElemType.Generator,1));
		pg.insert(new PGElem(9,ElemType.Generator,1));
		pg.insert(new PGElem(11,ElemType.Generator,1));
		//System.out.println(pg.retrieve());
		System.out.println(pg.findParent());
		//System.out.println(pg.retrieve());
		//System.out.println("-------------------------");
		pg.insert(new PGElem(10,ElemType.Generator,1));
		//System.out.println(pg.retrieve());
		System.out.println(pg.findParent());
		//System.out.println(pg.retrieve());
		pg.insert(new PGElem(12,ElemType.Generator,1));
		pg.findRoot();
		pg.insert(new PGElem(3,ElemType.Generator,1));
		pg.insert(new PGElem(4,ElemType.Generator,1));
		pg.findRoot();
		pg.insert(new PGElem(5,ElemType.Generator,1));
		pg.insert(new PGElem(6,ElemType.Generator,1));
		
		
		
				
		System.out.println("-------------------------");

		Queue<Integer> ids = PowerGridUtils.collectPreorder(pg);

		for(int i = 0;i<ids.length();i++) {
			Integer x = ids.serve();
			ids.enqueue(x);
			System.out.println(x);
		}
		
	 System.out.println(PowerGridUtils.find(pg,5)+"v");
	System.out.println(pg.retrieve().getId()+"  www");
		
	 System.out.println(PowerGridUtils.find(pg,20)+"v");
		System.out.println(pg.retrieve().getId()+"  www");
		
		
		
	}
		//System.out.println(pg.retrieve());
	//	System.out.println(pg.findParent());
		//System.out.println(pg.retrieve());
		/*pg.remove();
		System.out.println(pg.retrieve());
		pg.current.ch.findFirst();
		while(true) {
			System.out.println(pg.current.ch.current.data.data);
			pg.current.ch.findNext();
			if(pg.current.ch.last())
				break;
		}
	/*	GT<PGElem> tree = new LinkedGT<PGElem>();
		
		PGElem gen = new PGElem(66, ElemType.Generator, 50);
		PGElem a = new PGElem(1, ElemType.Generator, 50);
		PGElem b = new PGElem(2, ElemType.Transmitter, 20);
		PGElem c = new PGElem(3, ElemType.Transmitter, 20);
		PGElem d = new PGElem(4, ElemType.Consumer, 5);
		PGElem e = new PGElem(5, ElemType.Consumer, 3);
		PGElem f = new PGElem(6, ElemType.Transmitter, 5);
		PGElem g = new PGElem(7, ElemType.Consumer, 11);
		PGElem h = new PGElem(8, ElemType.Consumer, 10);
		PGElem i = new PGElem(9, ElemType.Consumer, 7);
		
		System.out.println("-----------------");
		if (PowerGridUtils.addGenerator(tree, a) )
			System.out.println ("generator added");
		else
			System.out.println ("mistake");
		
		System.out.println("-----------------");
		
		if (PowerGridUtils.addGenerator(tree, gen) )
			System.out.println ("generator added");
		else
			System.out.println ("another generator .. mistake");
		
		System.out.println("-----------------");
		
		if (PowerGridUtils.addGenerator(tree, b) )
			System.out.println ("generator added");
		else
			System.out.println ("adding a transmitter .. mistake");
		System.out.println("-----------------");
		
		PowerGridUtils.attach(tree, b , 1);
		PowerGridUtils.attach(tree, c , 1);
		PowerGridUtils.attach(tree, d , 2);
		PowerGridUtils.attach(tree, e , 2);
		PowerGridUtils.attach(tree, f , 2);
		PowerGridUtils.attach(tree, g , 3);
		PowerGridUtils.attach(tree, h , 3);
		PowerGridUtils.attach(tree, i , 6);
		
		
		Queue<Integer> q = PowerGridUtils.collectPreorder(tree);
		System.out.println("-----------------");
		
		System.out.println(q.length()); // 9 
		for (int k = 0 ; k <q.length() ; k++) {
			int x = q.serve();
			System.out.println(x);
			q.enqueue(x);
		} // 1 2 4 5 6 9 3 7 8 
		
		
		System.out.println("-----------------");
		
		boolean find = PowerGridUtils.find(tree,5);
		System.out.println (find);
		System.out.println (tree.retrieve().getId());
		
		find = PowerGridUtils.find(tree,99);
		System.out.println (find);
		System.out.println (tree.retrieve().getId());
		
		System.out.println("-----------------");
		
		System.out.println ( PowerGridUtils.totalPower(tree, 2) ); //15
		
		System.out.println ( PowerGridUtils.totalPower(tree, 3) ); //21
		System.out.println ( PowerGridUtils.totalPower(tree, 11) ); //-1
		
		System.out.println("-----------------");
		
		
		System.out.println ( PowerGridUtils.findOverload(tree) ); //6 .. 6 and 3 both overloaded but 6 comes before in preorder
	    
		System.out.println("-----------------");
		
		if (PowerGridUtils.remove(tree, 3))
			System.out.println ( "done" );
		else
			System.out.println("mistakee");
		
		q = PowerGridUtils.collectPreorder(tree);
		
		System.out.println("-----------------");
		
		System.out.println(q.length());
		for (int k = 0 ; k <q.length() ; k++) {
			int x = q.serve();
			System.out.println(x);
			q.enqueue(x);
		}

		
	*/
		
		
	}
	public static void display(GT<String>p) {
		System.out.println(p.retrieve());
		if(p.nbChildren()==0)
			return;
		for(int i=0;i<p.nbChildren();i++) {
			p.findChild(i);
			display(p);
			p.findParent();
		}
}

	
	}