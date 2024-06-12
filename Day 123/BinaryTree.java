import java.util.*;

public class BinaryTree1 {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void inorder(Node root){
            if(root == null){
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }

        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal
        public static void levelOrder(Node root) {
            if(root == null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            int count = 0;
            while (!q.isEmpty()) {
                Node curr = q.remove();
                if(curr == null){
                    System.out.println();
                    count++;
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if(curr.left != null){
                        q.add(curr.left);
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                    }
                }
            }
            System.out.println("Height of tree is " + count);
        }

        public static int height(Node root){
            if(root == null){
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh, rh) + 1;
        }

        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int leftD = diameter(root.left);
            int leftHt = height(root.left);
            int rightD = diameter(root.right);
            int rightHt = height(root.right);
            int selfDiameter = leftHt + rightHt + 1;
            return Math.max(selfDiameter, Math.max(rightD, leftD));
        }

        public static void kLevel(Node root, int level, int K){
            if(root == null){
                return;
            }
            if(level == K){
                System.out.print(root.data + " ");
                return;
            }
            kLevel(root.left, level + 1, K);
            kLevel(root.right, level + 1, K);
        }

        public static boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);
            if (root.data == n) {
                return true;
            }
            boolean foundLeft = getPath(root.left, n, path);
            boolean foundRight = getPath(root.right, n, path);

            if (foundLeft || foundRight) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }

        public static Node lowestCommonAncestor(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            if (!getPath(root, n1, path1) || !getPath(root, n2, path2)) {
                return null; // If either n1 or n2 is not present, return null
            }

            int i = 0;
            for (i = 0; i < path1.size() && i < path2.size(); i++) {
                if (!path1.get(i).equals(path2.get(i))) {
                    break;
                }
            }
            return path1.get(i - 1);
        }
    }

    public static void main(String[] args) {
        // Building a sample tree: 1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        // Tree Traversals
        // System.out.println("Preorder Traversal:");
        // tree.preorder(root);
        // System.out.println("\nInorder Traversal:");
        // tree.inorder(root);
        // System.out.println("\nPostorder Traversal:");
        // tree.postOrder(root);
        // System.out.println("\nLevel Order Traversal:");
        // tree.levelOrder(root);

        // // Diameter of the tree
        // System.out.println("Diameter of the tree: " + tree.diameter(root));

        // // Print nodes at K level
        // int K = 2;
        // System.out.println("Nodes at level " + K + ":");
        // tree.kLevel(root, 1, K);

        // Find Lowest Common Ancestor (LCA)
        Node lca = tree.lowestCommonAncestor(root, 4, 5);
        if (lca != null) {
            System.out.println("LCA(4, 5) = " + lca.data);
        } else {
            System.out.println("Keys are not present");
        }

        lca = tree.lowestCommonAncestor(root, 4, 10);
        if (lca != null) {
            System.out.println("LCA(4, 10) = " + lca.data);
        } else {
            System.out.println("Keys are not present");
        }
    }
}
