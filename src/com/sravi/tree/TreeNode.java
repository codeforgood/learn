package com.sravi.tree;

/**
 * User: sravi
 * Date: 10/13/13
 * Time: 12:19 AM
 */
public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public int getVal(){
        return this.val;
    }

    public void setVal(int val){
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
