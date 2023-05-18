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

        if(key == root.key){
            comparisons++;
            root.count++;
            return root;
        }

        if(key < root.key){
            comparisons++;
            root.left = insertRec(root.left, key);
        }else{
            comparisons++;
            root.right = insertRec(root.right, key);
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

    void delete(int key){
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key){
        if(root == null){
            System.out.println("false");
            return root;
        }

        

        if(key < root.key){
            comparisons++;
            root.left = deleteRec(root.left, key);
        }else if(key > root.key){
            comparisons++;
            root.right = deleteRec(root.right, key);
        }else{
            if(root.count > 1){
                root.count--;
                System.out.println("true");
                return root;
            }

            if(root.left == null){
                Node temp = root.right;
                System.out.println("true");
                return temp;
            }else if(root.right == null){
                Node temp = root.left;
                System.out.println("true");
                return temp;
            }

            Node temp = minValueNode(root.right);
            root.key = temp.key;
            root.count = temp.count;
            root.right = deleteRec(root.right, temp.key);
        }

        return root;
    }

    Node minValueNode(Node root){
        Node current = root;

        while(current.left != null){
            current = current.left;
        }

        return current;
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