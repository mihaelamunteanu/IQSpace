package com.codeprehend.iqspace.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import com.codeprehend.iqspace.IQSpaceGUI;
import com.codeprehend.iqspace.util.Constants;

public class CtrlAltDelAction extends AbstractAction {
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	private IQSpaceGUI mainWindow;

	public CtrlAltDelAction(IQSpaceGUI mainWindow) {
		this.mainWindow = mainWindow;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(Constants.CTRL_ALT_DEL);
		JOptionPane.showMessageDialog(mainWindow,
				"AL+CTRL+DEL pressed. Va rugam folositi aplicatia doar raspunzand la intrebari!");
	}
}