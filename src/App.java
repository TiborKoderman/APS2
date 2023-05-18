public class App {
    public static void main(String[] args) throws Exception {
// TEST 1
bst b = new bst();
b.insert(19);
b.insert(11);
b.insert(23);
b.insert(19);
b.insert(29);
b.printPreOrder();
b.printInOrder();
b.printPostOrder();

//TEST 2
b = new bst();
b.insert(19);
b.printComparisons();
b.insert(11);
b.insert(23);
b.insert(31);
b.insert(42);
b.insert(29);
System.out.println(b.find(29));
b.insert(23);
b.insert(29);
b.delete(31);
System.out.println(b.find(31));
System.out.println(b.find(23));
b.printInOrder();
b.printComparisons();

//TEST 3
b = new bst();
b.insert(19);
b.insert(19);
b.insert(19);
b.insert(11);
b.insert(9);
b.insert(11);
b.printInOrder();
b.delete(23);
b.insert(23);
b.insert(17);
b.insert(20);
b.insert(18);
b.insert(25);
b.printInOrder();
b.delete(19);
b.delete(19);
b.delete(11);
b.delete(11);
b.delete(23);
System.out.println(b.find(19));
b.printPreOrder();

//TEST 4
b = new bst();
b.insert(19);
b.insert(19);
System.out.println(b.find(19));
b.delete(19);
System.out.println(b.find(19));
b.delete(19);
System.out.println(b.find(19));
b.insert(19);
b.insert(9);
b.insert(23);
b.insert(11);
b.insert(21);
b.insert(31);
b.insert(11);
b.printPostOrder();
b.delete(19);
b.delete(11);
System.out.println(b.find(19));
System.out.println(b.find(11));
b.delete(11);
b.printPostOrder();

//TEST 5
b = new bst();
b.insert(29);
b.insert(15);
b.insert(43);
b.insert(7);
b.insert(23);
b.insert(35);
b.insert(51);
b.delete(29);
b.printPreOrder();
b.printComparisons();

b = new bst();
b.insert(29);
b.insert(15);
b.insert(43);
b.insert(5);
b.insert(23);
b.insert(35);
b.insert(51);
b.insert(3);
b.insert(7);
b.insert(19);
b.insert(27);
b.insert(31);
b.insert(37);
b.insert(47);
b.insert(59);
b.delete(15);
b.delete(43);
b.printPreOrder();
b.printPostOrder();
    }
}
