package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import fileoper.OpenFile;
import fileoper.SaveFile;
import mygui.DrawShape;

public class BtnListrner implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if ("Exit" == e.getActionCommand()) {
			Tools.windoexit();
		} else if (e.getActionCommand().equals("Save")) {
			Tools.Save();
		} else if (e.getActionCommand().equals("Open")) {
			Tools.Open();
		} else if (e.getActionCommand().equals("New")) {
			Tools.New();
		}
	}

}
