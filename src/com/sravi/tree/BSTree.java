package com.sravi.tree;

/**
 * Created with IntelliJ IDEA.
 * User: sravi
 * Date: 10/13/13
 * Time: 12:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class BSTree{

    TreeNode root;

    public BSTree(){
        root = null;
    }

    private boolean findRNode(int val, TreeNode node){
        if(node == null) return false;
        if(node.val == val){
            return true;
        }else{
            if(node.val < val)
                return findRNode(val, node.right);
            else
                return findRNode(val, node.left);
        }
    }

    private boolean findNode(int val){
        TreeNode current = root;
        while(true){
            //return false once reach leaf
            if(current == null) return false;
            if(current.val == val){
                return true;
            }else{
                if(val < current.val){
                    current = current.left;
                }else{
                    current = current.right;
                }
            }
        }
    }

    private void printPreOrderTree(TreeNode node){
        if(node != null){
            System.out.print(node.val + " ");
            printPreOrderTree(node.left);
            printPreOrderTree(node.right);
        }
    }

    private void printInOrderTree(TreeNode node){
        if(node != null){
            printInOrderTree(node.left);
            System.out.print(node.val + " ");
            printInOrderTree(node.right);
        }
    }

    private boolean isBinarySearchTree(TreeNode node, int min, int max){
        if(node == null) return true;
        return((node.val < max && node.val > min)
                && isBinarySearchTree(node.left, Integer.MIN_VALUE, node.val)
                && isBinarySearchTree(node.right, node.val, Integer.MAX_VALUE));
    }

    /**
     * Is mirror tree's?
     */
    private boolean isMirrorTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if((node1 != null && node2 == null) || (node1 == null && node2 != null)) return false;
        return((node1.getVal() == node2.getVal()) &&
                isMirrorTree(node1.left, node2.right) &&
                isMirrorTree(node1.right, node2.left));
    }

    public void addNode(int val){
        TreeNode newNode = new TreeNode(val);
        if(this.root == null){
            System.out.println("Empty Tree. Trying to insert: " + newNode.val);
            this.root = newNode;
        }else{
            System.out.println("Tree not Empty. Trying to insert: " + newNode.val);
            TreeNode current = this.root;
            while(true){
                if(newNode.val < current.val){
                    if(current.left == null){
                        current.left = newNode;
                        return;
                    }
                    current = current.left;
                }else{
                    if(current.right == null){
                        current.right = newNode;
                        return;
                    }
                    current = current.right;
                }
            }
        }
    }

    public boolean find(int val){
        //return findRNode(val, this.root);
        return findNode(val);
    }

    public void inOrder(){
        printInOrderTree(this.root);
    }

    public void preOrder(){
        printPreOrderTree(this.root);
    }

    public TreeNode getRoot(){
        return this.root;
    }

    public void setRoot(TreeNode node){
        this.root = node;
    }

    public boolean isBST(){
        return isBinarySearchTree(this.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean isMirror(){
        return isMirrorTree(this.root.left, this.root.right);
    }

}