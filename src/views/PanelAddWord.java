package views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import controller.Action;
import controller.Controller;
import utilities.UtilEdit;

public class PanelAddWord extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextArea txWord;
	private JButton btnAddWord;
	private JList<String> possibleWordsList;
	private DefaultListModel<String> model;
	
	public PanelAddWord(Controller controller) {
		setLayout(new GridBagLayout());
		initComponents(controller);
	}

	private void initComponents(Controller controller) {
		setBorder(BorderFactory.createTitledBorder(UIConstant.ADD_WORD_TEXT_TITLE));
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		c.weightx = 1; //Tamaño por celda
		c.gridheight = 1; //Alto 100%
		for (int i = 0; i < 12; i++) {
			c.gridx = i;
			add(new JLabel(""), c);
		}
		
		txWord = new JTextArea();
		txWord.setBorder(BorderFactory.createTitledBorder(UIConstant.INPUT_WORD_TEXT));
		UtilEdit.editGridbag(c, 1, 1, 2, 5);
		add(txWord, c);
		
		btnAddWord = new JButton(UIConstant.ADD_WORD_TEXT, createImageIcon(UIConstant.ADD_WORD_ICON));
		UtilEdit.addActionButton(btnAddWord, controller, Action.ADD_WORD);
		UtilEdit.editGridbag(c, 2, 1, 2, 1);
		add(btnAddWord, c);
		
		model = new DefaultListModel<>();
		possibleWordsList = new JList<>(model);
		possibleWordsList.setBorder(BorderFactory.createTitledBorder(UIConstant.POSSIBLE_WORD_TITLE));
		UtilEdit.editGridbag(c, 3, 1, 1, 5);
		add(possibleWordsList, c);
	}
	
	public String createWord(){
		return txWord.getText();
	}
	
	public void cleanForm(){
		txWord.setText("");
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