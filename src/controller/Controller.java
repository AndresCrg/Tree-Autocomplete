package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.entity.TreeaAutoComplete;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private TreeaAutoComplete treeaAutoComplete;
	private MainWindow mainWindow;
	
	public Controller() {
		treeaAutoComplete = new TreeaAutoComplete();
		mainWindow = new MainWindow(treeaAutoComplete.getRoot(),this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Action.valueOf(e.getActionCommand())) {
		case ADD_WORD:
			addWord();
			break;
		}
	}
	
	private void addWord() {
		treeaAutoComplete.addChild(mainWindow.createNode(), treeaAutoComplete.getRoot());
		mainWindow.paintTree(treeaAutoComplete.getRoot());
	}
}