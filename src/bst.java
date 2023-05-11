// //binary search tree

// public class bst {

//         Node root;

//         bst(){
//                 root = null;
//         }
        
//         void insert(int key){
//                 if(root == null){
//                         root = new Node(key);
//                         return;
//                 }

//                 Node current = root;

//                 while(true){
//                         if(key < current.key){
//                                 if(current.left == null){
//                                         current.left = new Node(key);
//                                         return;
//                                 }
//                                 current = current.left;
//                         }else{
//                                 if(current.right == null){
//                                         current.right = new Node(key);
//                                         return;
//                                 }
//                                 current = current.right;
//                         }
//                 }

//         }

//         void delete(int key){
//                 root = deleteRec(root, key);
//         }

//         Node deleteRec(Node node, int key){
//                 if(node == null){
//                         return node;
//                 }

//                 if(key < node.key){
//                         node.left = deleteRec(node.left, key);
//                 }else if(key > node.key){
//                         node.right = deleteRec(node.right, key);
//                 }else{
//                         if(node.left == null){
//                                 return node.right;
//                         }else if(node.right == null){
//                                 return node.left;
//                         }

//                         node.key = minValue(node.right);

//                         node.right = deleteRec(node.right, node.key);
//                 }

//                 return node;
//         }

//         int minValue(Node node){
//                 int minv = node.key;
//                 while(node.left != null){
//                         minv = node.left.key;
//                         node = node.left;
//                 }
//                 return minv;
//         }

//         void printPreOrder(){
//                 printPreOrderRec(root);
//         }

//         printPreOrderRec(Node node){
//                 if(node == null){
//                         return;
//                 }

//                 System.out.println(node.key);
//                 printPreOrderRec(node.left);
//                 printPreOrderRec(node.right);
//         }
        
// }


// class Node{
//         int key;
//         Node left, right;
        
//         public Node(int item){
//                 key = item;
//                 left = right = null;
//         }


// }
