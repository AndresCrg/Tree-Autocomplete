package views;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import controller.Controller;
import models.entity.Node;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private PanelAddWord panelAddWord;
	private PanelPreviewTree panelPreviewTree;
	
	public MainWindow(Node node, Controller controller) {
		setTitle(UIConstant.TITLE_APP);
		setIconImage(createImageIcon(UIConstant.ICON_APP).getImage());
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 2));
		initComponents(node, controller);
		setVisible(true);
	}
	
	private void initComponents(Node node, Controller controller) {
		panelAddWord = new PanelAddWord(controller);
		add(panelAddWord);
		
		panelPreviewTree = new PanelPreviewTree(node, controller);
		add(panelPreviewTree);
	}
	
	public String createNode(){
		return panelAddWord.createWord();
	}
	
	public void paintTree(Node node){
		panelPreviewTree.paintTree(node);
	}

	protected ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}
}