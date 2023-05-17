public class App {
    public static void main(String[] args) throws Exception {
        bst b = new bst();

        b.insert(12);
        b.insert(22);
        b.insert(33);
        b.insert(4);
        b.insert(14);
        b.insert(6);
        b.insert(22);
        b.insert(33);
        b.insert(24);
        b.insert(17);
        b.printPreOrder();
        b.printInOrder();
        b.printPostOrder();
        b.printComparisons();
        b.find(99);
        b.find(17);
        b.printComparisons();
    }
}
