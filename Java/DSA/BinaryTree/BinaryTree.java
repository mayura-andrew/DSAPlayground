package BinaryTree;

import java.util.LinkedList;
import java.util.Stack;
import java.util.*;


public class BinaryTree {

    private  TreeNode root;

    private class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data; // genetic type

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createBinaryTree() {
        TreeNode first = new TreeNode(12);
        TreeNode second = new TreeNode(7);
        TreeNode third = new TreeNode(15);
        TreeNode fourth = new TreeNode(3);
        TreeNode fifth = new TreeNode(9);
        TreeNode sixth = new TreeNode(14);
        TreeNode seventh = new TreeNode(20);
        TreeNode eight = new TreeNode(1);
        TreeNode nineth = new TreeNode(10);

        root = first; // root ---> first
        first.left = second;
        first.right = third;  // second <---- first ----> third
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        fourth.left = null;
        fourth.right = null;
        fifth.left = eight;
        fifth.right = null;
        sixth.left = null;
        sixth.right = nineth;
        nineth.left = null;
        nineth.right = null;
        eight.left = null;
        eight.right = null;
        seventh.left = null;
        seventh.right = null; 
    }


    // Recursive PreOrder traversal of a Binary Tree
   public void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
   }

    // Iterative Preorder traversal of a Binary Tree

    public void preOrder() {
        if(root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode temp = stack.pop();
            System.out.print(temp.data + " ");
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null) {
                stack.push(temp.left);
            } 
        }
    }

    // Recursive inorder traveral of Ba=inary tree

    public void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    // // Iterative Inorder traversal of a Binary Tree
    // public void inOrder(TreeNode root) {
    //     if(root == null) {
    //         return;
    //     }
    //     Stack<TreeNode> stack = new Stack<>();
    //     TreeNode temp = root;

    //     while(!stack.isEmpty() || temp != null) {
    //         if(temp != null) {
    //             stack.push(temp);
    //             temp = temp.left;
    //         } else {
    //             temp = stack.pop();
    //             System.out.print(temp.data + " ");
    //             temp = temp.right;
    //         }
    //     }
    // }

    // Post Order Recursive Traversal
    public void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Iterative Postorder Traversal of a Binary Tree
    public void postOrder() {
        TreeNode current = root;
        Stack<TreeNode> stack = new Stack<>();

        while(current != null || !stack.isEmpty()){
            if(current != null) {
                stack.push(current);
                current = current.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null) {
                    temp = stack.pop();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        System.out.print(temp.data + " "); 
                    } 
                } else {
                        current = temp;
                }
            }
        }
    }

    // Level order traversal of a BT 
    public void levelOrder() {
        if(root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.data + " ");
            if(temp.left != null) {
                queue.offer(temp.left);
            } if (temp.right != null) {
                queue.offer(temp.right);
            }
        }
    }

    // Finding the Maximum value in a BT
    public int findMax(TreeNode root) {
        if(root == null) { // Base case
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int left = findMax(root.left);
        int right = findMax(root.right);
        if(left > result) {
            result = left;
        }
        if (right > result) {
            result = right;
        }
        return result;
    }
    

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //   bt.preOrder();
        //   bt.inOrder(bt.root);
        //   bt.postOrder(bt.root);
        // bt.postOrder();
        // bt.levelOrder();
        // int max = bt.findMax(bt.root);
        bt.postOrder(bt.root);
         System.out.println();
        bt.inOrder(bt.root);
         System.out.println();
        bt.preOrder();
        // System.out.println(max);
    }
}
