package cn.edu.nbu.structorpattern;

import java.util.Enumeration;
import java.util.Vector;

public class TestComposite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree("A");
		TreeNode node1 = new TreeNode("B");
		TreeNode node2 = new TreeNode("C");
		
		node1.add(node2);
		tree.root.add(node1);
		System.out.println("build the tree successfully");
	}
}


class TreeNode{
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	
	public TreeNode(String name){
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	
	public void add(TreeNode node){
		children.add(node);
	}
	
	public void remove(TreeNode node){
		children.remove(node);
	}
	
	public Enumeration<TreeNode> getChildren(){
		return children.elements();
	}
}

class Tree{
	TreeNode root = null;
	public Tree(String name){
		root = new TreeNode(name);
	}
}