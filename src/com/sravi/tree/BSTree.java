package com.sravi.tree;

/**
 * User: sravi
 * Date: 10/13/13
 * Time: 12:20 AM
 */
public class BSTree{

    TreeNode root;

    public BSTree(){
        root = null;
    }

    private TreeNode findRNode(int val, TreeNode node){
        if(node == null) return null;
        if(node.val == val){
            return node;
        }else{
            if(node.val < val)
                return findRNode(val, node.right);
            else
                return findRNode(val, node.left);
        }
    }

    private TreeNode findNode(int val){
        TreeNode current = root;
        while(true){
            //return null once reach leaf
            if(current == null) return null;
            if(current.val == val){
                return current;
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
        if(findNode(val) != null) return true;
        return false;
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

    private int getMaxTreeHeight(TreeNode node){
        if (node == null) return 0;
        return 1 + Math.max(getMaxTreeHeight(node.left), getMaxTreeHeight(node.right));
    }

    public int getHeight(){
        return getMaxTreeHeight(this.root);
    }

    /**
     * find the left most node for the give node
     * O(log(n))
     * @param node
     * @return
     */
    private TreeNode leftMost(TreeNode node){
        TreeNode current = node;
        while(current.getLeft() != null) current = current.getLeft(); // log(h)
        return current;
    }

    /**
     * find the next biggest node in the BST
     * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
     * @param node
     * @return
     */
    private TreeNode findNextNode(TreeNode node){
        if(node == null) return null;
        if(node.getRight() != null){
            return leftMost(node.getRight());  //log(h)
        }else{
            return findNextBigNodeFromRoot(node, this.root);
        }
    }

    /**
     * find the next big node for a given node from root
     * o(h)
     * @param node
     * @param root
     * @return
     */
    private TreeNode findNextBigNodeFromRoot(TreeNode node, TreeNode root) {
        TreeNode succ_node = null;
        TreeNode current = root;
        while(current != null){
            if(current.getVal() > node.getVal()){
                succ_node=current;
                current = current.getLeft();
            }else if(current.getVal() < node.getVal()){
                current = current.getRight();
            }else
                break;
        }
       return succ_node;
    }

    /**
     * 2log(h) -> log(h)
     * @param key
     * @return
     */
    public int findNext(int key){

        TreeNode node = findNode(key);  //log(h)
        if(node == null){
            throw new IllegalArgumentException("Node with given key not found");
        }
        TreeNode nextBigNode = findNextNode(node);   //log(h)
        return (nextBigNode != null)? nextBigNode.getVal():Integer.MAX_VALUE;
    }

}