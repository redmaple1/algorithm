package com.stackandqueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _103BinaryTreeZigzagLevelOrderTraversal {
	
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	private class LevelNode{
		TreeNode node;
		int level;
		
		LevelNode(TreeNode node,int level){
			this.node = node;
			this.level = level;
		}
	}
	
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root == null)
        	return list;
        
        LinkedList<LevelNode> queue = new LinkedList<LevelNode>();
        queue.addLast(new LevelNode(root,0));
        while(!queue.isEmpty()){
        	LevelNode front = queue.removeFirst();
        	TreeNode node = front.node;
        	int level = front.level;
        	
        	if(level == list.size())
        		list.add(new ArrayList<Integer>());
        	assert level < list.size();
        	
        	list.get(level).add(node.val);
        	if(node.left != null)
        		queue.addLast(new LevelNode(node.left,level + 1));
        	if(node.right != null)
        		queue.addLast(new LevelNode(node.right,level + 1));
        }
        
        for(int i = 0; i < list.size(); i++){
        	if(i % 2 != 0){
        		List<Integer> inner = new ArrayList<Integer>();
        		for(int j = list.get(i).size() - 1; j >= 0; j--){
        			inner.add(list.get(i).get(j));
        		}
        		list.set(i, inner);
        	}
        }
        return list;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
