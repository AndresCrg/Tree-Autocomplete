package models.entity;

import java.util.ArrayList;

public class Node {
	
	 private String word;
	 private int weight;
	 private Node father;
	 private ArrayList<Node> childNodeList;
	 
	public Node(String word, int weight) {
		this.word = word;
		this.weight = weight;
		childNodeList = new ArrayList<>();
	}
	
	public Node(String word) {
		this.word = word;
		childNodeList = new ArrayList<>();
	}
	
	public void addChild(Node child){
		childNodeList.add(child);
	}
	
	public boolean isChild(Node newNode) {
		for (Node node : childNodeList) {
			if (!newNode.getWord().equalsIgnoreCase(node.getWord())) {
				return false;
			}
		}
		return true;
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public Node getFather() {
		return father;
	}

	public void setFather(Node father) {
		this.father = father;
	}

	public ArrayList<Node> getChildList() {
		return childNodeList;
	}

	@Override
	public String toString() {
		return word;
	}
}