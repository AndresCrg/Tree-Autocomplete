package models.entity;

//172.16.0.72 8080

public class TreeaAutoComplete {
	
	private Node root;
	
	public TreeaAutoComplete() {
		root = new  Node("Root");
	}
	
	public void addChild(String word, Node nodeFather){
		Node nodeActual = new Node(word);
		if (word != null && word.length() > 0) {
			nodeActual.setWord(String.valueOf(word.charAt(0)));
			System.out.println("hijo" + " " + nodeActual.getWord() + " "+ "padre"+ " " + nodeFather.getWord());
			if (nodeActual.isChild(nodeFather)) {
				nodeFather = nodeActual;
				addChild(word.substring(1, word.length()), nodeActual);
			}else {
				nodeActual.addChild(new Node(word.substring(1)));
				addChild(word.substring(1, word.length()), nodeFather);
			}
		}
	}
	
	public int getWeight() {
		return (root != null) ? root.getWeight():0;
	}
	
	public Node getRoot() {
		return root;
	}
	
	public static void main(String[] args) {
		TreeaAutoComplete t = new TreeaAutoComplete();
		t.addChild("HOLA", t.getRoot());
	}
}