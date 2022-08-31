package utilities;

import java.awt.GridBagConstraints;
import javax.swing.JButton;
import controller.Action;
import controller.Controller;

public class UtilEdit {
		
	public static void editGridbag(GridBagConstraints c, int fila, double height, int colIni, int ancho){
		c.gridy = fila; 
		c.weighty = height; 
		c.gridx = colIni; 
		c.gridwidth = ancho; 
	}
	
	public static void addActionButton(JButton button, Controller controller, Action action){
		button.addActionListener( controller);
		button.setActionCommand(action.toString());
	}
}
