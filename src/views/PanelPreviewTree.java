package views;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controller.Controller;
import models.entity.Node;

public class PanelPreviewTree extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTree treeLetters;
	private DefaultMutableTreeNode defaultMutableTreeNode;
	private DefaultTreeModel model;
	
	public PanelPreviewTree(Node node, Controller controller) {
		setLayout(new BorderLayout());
		initComponents(node, controller);
	}

	private void initComponents(Node node, Controller controller) {
		setBorder(BorderFactory.createTitledBorder(UIConstant.PREVIEW_TREE_TEXT_TITLE));
		defaultMutableTreeNode = new DefaultMutableTreeNode(node);
		model = new DefaultTreeModel(defaultMutableTreeNode);
		treeLetters = new JTree(model);
		add(new JScrollPane(treeLetters));
	}
	
	public void paintTree(Node node) {
		paintTree(node, null, defaultMutableTreeNode);
		treeLetters.expandRow(0);
		revalidate();
		repaint();
	}
	
	private void paintTree(Node node, DefaultMutableTreeNode uiNode, DefaultMutableTreeNode uiRoot){
		if (node != null && uiNode != null) {
			model.insertNodeInto(uiNode, uiRoot, 0);
			if (node.getChildList() != null) {
				addChild(uiRoot, uiNode, node);
			}
		}else{
			model.insertNodeInto(new DefaultMutableTreeNode(node), defaultMutableTreeNode, 0);
		}
	}
	
	public void addChild(DefaultMutableTreeNode uiRoot, DefaultMutableTreeNode uiNode, Node node){
		System.out.println(node.getChildList().toString());
		int index = 0;
		for (Node nodeLetter : node.getChildList()) {
			DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(nodeLetter.getWord());
			model.insertNodeInto(newNode, uiRoot, index);
			index++;
		}
	}
}