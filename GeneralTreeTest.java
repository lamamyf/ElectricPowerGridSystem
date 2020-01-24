import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GeneralTreeTest {

    private static <T> String treeToString(GT<T> gt) {
	gt.findRoot();
	return (toStringSubTree(gt, new String[] { "|", "*", "'" }, 0));

    }

    private static <T> String toStringSubTree(GT<T> gt, String[] strings, int j) {

	if (gt.nbChildren() == 0)
	    return gt.retrieve() + "";

	String s = gt.retrieve() + "\n";

	int n = gt.nbChildren();
	for (int i = 0; i < n; i++) {
	    gt.findChild(i);
	    s += toStringSubTree(gt, strings, (j + 1) % strings.length);
	    if (i < n - 1)
		s += "\n";
	    gt.findParent();
	}
	return s.replace("\n", "\n" + strings[j] + "\t");
    }

    private GT<String> generateTree() {
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
	return gt;
    }

    @Test
    void print() {
	System.out.println(treeToString(generateTree()));
    }

    @Test
    void testInsertUpdate() {
	GT<String> tree = new LinkedGT<String>();
	assertTrue(tree.empty());
	assertTrue(tree.insert("a"));
	assertEquals("a", tree.retrieve());
	
	assertTrue(tree.insert("b"));
	assertEquals("b", tree.retrieve());
	
	tree.findRoot();
	assertTrue(tree.insert("c"));
	assertEquals("c", tree.retrieve());
	
	tree.findRoot();
	assertTrue(tree.insert("hello"));
	assertEquals("hello", tree.retrieve());
	
	tree.update("d");
	assertEquals("d", tree.retrieve());
	
	tree.findRoot();
	tree.findChild(1);
	
	assertTrue(tree.insert("l"));
	assertEquals("l", tree.retrieve());
	
	assertTrue(tree.insert("m"));
	assertEquals("m", tree.retrieve());
	
	assertTrue(tree.insert("n"));
	assertEquals("n", tree.retrieve());


    }

    @Test
    void testFindChild() {
	GT<String> tree = generateTree();
	tree.findRoot();
	assertTrue(tree.findChild(0));
	assertEquals("b", tree.retrieve());
	tree.findRoot();
	assertTrue(tree.findChild(1));
	assertEquals("c", tree.retrieve());
	tree.findRoot();
	assertTrue(tree.findChild(2));
	assertEquals("d", tree.retrieve());

	assertTrue(tree.findChild(0));
	assertEquals("e", tree.retrieve());

	assertFalse(tree.findChild(0));

	tree.findRoot();
	assertFalse(tree.findChild(3));
	assertTrue(tree.findChild(2));
    }

    @Test
    void testFindParent() {

	GT<String> tree = generateTree();
	tree.findRoot();
	tree.findChild(0);
	assertTrue(tree.findParent());
	assertEquals("a", tree.retrieve());

	tree.findChild(1);
	tree.findChild(0);
	tree.findChild(0);
	tree.findChild(1);

	assertTrue(tree.findParent());
	assertEquals("m", tree.retrieve());
	assertTrue(tree.findParent());
	assertTrue(tree.findParent());
	assertTrue(tree.findParent());
	assertFalse(tree.findParent());
    }

    @Test
    void testNBChildren() {
	GT<String> tree = generateTree();
	tree.findRoot();
	assertEquals(3, tree.nbChildren());

	tree.findChild(0);
	assertEquals(0, tree.nbChildren());

	tree.findParent();
	tree.findChild(1);
	assertEquals(1, tree.nbChildren());

	tree.findParent();
	tree.findChild(2);
	assertEquals(2, tree.nbChildren());

    }

    @Test
    void testDelete() {
	GT<String> tree = generateTree();
	tree.findRoot();
	tree.findChild(0);
	tree.remove();
	assertEquals("a", tree.retrieve());
	assertEquals(2, tree.nbChildren());

	tree.findRoot();
	tree.findChild(0);
	assertEquals("c", tree.retrieve());
	tree.remove();
	assertEquals("a", tree.retrieve());
	assertEquals(1, tree.nbChildren());
	tree.findChild(0);
	assertEquals("d", tree.retrieve());

	tree = generateTree();
	tree.findRoot();
	tree.remove();
	assertTrue(tree.empty());
    }

}
