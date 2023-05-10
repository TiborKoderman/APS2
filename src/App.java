public class App {
    public static void main(String[] args) throws Exception {
        HTB ht = new HTB(7, 11, 5, 13);

        ht.insert(12);
        ht.insert(10);
        ht.insert(22);
        System.out.println(ht.find(12));
        System.out.println("--");
        ht.delete(19);
        ht.delete(29);
        System.out.println(ht.find(19));
        System.out.println("--");

        ht.insert(17);
        ht.insert(2);
        ht.insert(33);

        ht.printKeys();
    }
}
