package com.sravi.tree;

/**
 * Created with IntelliJ IDEA.
 * User: sravi
 * Date: 10/13/13
 * Time: 12:19 AM
 * To change this template use File | Settings | File Templates.
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
}
