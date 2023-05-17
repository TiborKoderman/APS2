/**
 * Node¸
 */
class Node {
    int key;
    int count; 
    Node left, right;
    
    public Node(int item){
        key = item;
        count = 1;
        left = right = null;
    }
}

//binary search tree
public class bst{
    
    Node root;
    int comparisons=0;

    bst(){
        root = null;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key){
        if(root == null){
            root = new Node(key);
            return root;
        }

        if(key < root.key){
            comparisons++;
            root.left = insertRec(root.left, key);
        }else if(key > root.key){
            comparisons++;
            root.right = insertRec(root.right, key);
        }else{
            comparisons++;
            root.count++;
        }

        return root;
    } 

    void printPreOrder(){
        printPreOrderRec(root);
        System.out.println();
    }

    void printPreOrderRec(Node root){
        if(root != null){
            System.out.printf("%d/%d | ", root.key, root.count);
            printPreOrderRec(root.left);
            printPreOrderRec(root.right);
        }
    }

    void printInOrder(){
        printInOrderRec(root);
        System.out.println();
    }

    void printInOrderRec(Node root){
        if(root != null){
            printInOrderRec(root.left);
            System.out.printf("%d/%d | ", root.key, root.count);
            printInOrderRec(root.right);
        }
    }

    void printPostOrder(){
        printPostOrderRec(root);
        System.out.println();
    }

    void printPostOrderRec(Node root){
        if(root != null){
            printPostOrderRec(root.left);
            printPostOrderRec(root.right);
            System.out.printf("%d/%d | ", root.key, root.count);
        }
    }

    void printComparisons(){
        System.out.printf("COMPARISONS: %d\n", comparisons);
    }

    boolean find(int key){
        return findRec(root, key);
    }

    boolean findRec(Node root, int key){
        if(root == null){
            System.out.println("false");
            return false;
        }

        if(root.key == key){
            comparisons++;
            System.out.println("true");
            return true;
        }

        comparisons++;
        if(key < root.key){
            return findRec(root.left, key);
        }else{
            return findRec(root.right, key);
        }
    }

    

}