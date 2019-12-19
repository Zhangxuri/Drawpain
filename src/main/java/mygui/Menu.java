package mygui;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import listener.MenuListener;

public class Menu extends JMenuBar {
	
	JMenu jMenu_File;
	JMenu jMenu_Edit;
	JMenu jMenu_Help;
	
	JMenuItem jMenuItem_save;
	JMenuItem jMenuItem_open;
	JMenuItem jMenuItem_new;
	JMenuItem jMenuItem_re;
	JMenuItem jMenuItem_help;
	JMenuItem jMenuItem_about;
	JMenuItem jMenuItem_clear;
	JMenuItem jMenuItem_Zheng;
	public Menu() {
		// TODO Auto-generated constructor stub
		jMenu_File=new JMenu("File");
		jMenu_File.setMnemonic(KeyEvent.VK_F);
		jMenu_Edit=new JMenu("Edit");
		jMenu_Edit.setMnemonic(KeyEvent.VK_E);
		jMenu_Help=new JMenu("Help");
		jMenu_Help.setMnemonic(KeyEvent.VK_H);
		
		jMenuItem_new=new JMenuItem("New");
		jMenuItem_open=new JMenuItem("Open");
		jMenuItem_re=new JMenuItem("Revoke");
		jMenuItem_help=new JMenuItem("Help");
		jMenuItem_save=new JMenuItem("Save");
		jMenuItem_about=new JMenuItem("About");
		jMenuItem_clear=new JMenuItem("Clear");
		jMenuItem_Zheng=new JMenuItem("Zheng");
		
		add(jMenu_File);
		add(jMenu_Edit);
		add(jMenu_Help);
		
		jMenu_File.add(jMenuItem_new);
		jMenu_File.addSeparator();
		jMenu_File.add(jMenuItem_open);
		jMenu_File.add(jMenuItem_save);
		jMenu_Edit.add(jMenuItem_re);
		jMenu_Edit.add(jMenuItem_clear);
		jMenu_Edit.addSeparator();
		jMenu_Edit.add(jMenuItem_Zheng);
		jMenu_Help.add(jMenuItem_help);
		jMenu_Help.add(jMenuItem_about);
		
		jMenuItem_new.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
		jMenuItem_open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
		jMenuItem_save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
		jMenuItem_re.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
		jMenuItem_help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
		jMenuItem_about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
		jMenuItem_clear.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
		jMenuItem_Zheng.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));
		
		MenuListener menuListener=new MenuListener();
		jMenuItem_help.addActionListener(menuListener);
		jMenuItem_new.addActionListener(menuListener);
		jMenuItem_open.addActionListener(menuListener);
		jMenuItem_save.addActionListener(menuListener);
		jMenuItem_re.addActionListener(menuListener);
		jMenuItem_about.addActionListener(menuListener);
		jMenuItem_clear.addActionListener(menuListener);
		jMenuItem_Zheng.addActionListener(menuListener);
	}

}
