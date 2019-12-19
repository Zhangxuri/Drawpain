package mygui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.nio.channels.NetworkChannel;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;

import fileoper.SaveFile;
import listener.BtnListrner;
import listener.ColorHandler;
import listener.DragDrawPanel;
import listener.LineWidthPanel;
import listener.RadioListener;
import listener.Windowclose;
import shape.Shape;

public class DrawShape extends JFrame {

	JPanel pnlCommandArea = new JPanel(new FlowLayout());
	public static DragDrawPanel pnlDisplayArea = new DragDrawPanel();
	JPanel pnlShape = new JPanel(new GridLayout(2, 2));
	JPanel pnlFile = new JPanel(new GridLayout(2, 2));
	public static LineWidthPanel lineWidthPanel = new LineWidthPanel();
	public static ColorHandler colorHandler = new ColorHandler();
	Menu menu=new Menu();

	static JButton btnO = new JButton("Open");
	static JButton btnS = new JButton("Save");
	static JButton btnN = new JButton("New");
	static JButton btnE = new JButton("Exit");

	public static JRadioButton rdoC = new JRadioButton("Circle");
	public static JRadioButton rdoL = new JRadioButton("Line", true);
	public static JRadioButton rdoR = new JRadioButton("Rect");
	public static JRadioButton rdoO = new JRadioButton("Other");
	public static Vector<shape.Shape> shapes = new Vector<shape.Shape>();

	ButtonGroup grpShape = new ButtonGroup();
	ButtonGroup grpDraw = new ButtonGroup();
	Container contentPane;

	public final static int LINE = 0;
	public final static int CIRCLE = 1;
	public final static int RECT = 2;
	public final static int OTHER = 3;
	public static int type = LINE;

	public DrawShape() {
		setTitle("��ͼ����");
		setSize(850, 680);
		setLayout(new FlowLayout());
		pnlCommandArea.setBorder(new TitledBorder("Commend"));
		Dimension d = new Dimension(200, 600);
		pnlCommandArea.setPreferredSize(d);
		pnlCommandArea.setLayout(new GridLayout(4, 1));
		shapes = pnlDisplayArea.getshapes();

		setJMenuBar(menu);
		add(pnlCommandArea);
		add(pnlDisplayArea);

		pnlShape.setPreferredSize(new Dimension(190, 140));
		pnlFile.setPreferredSize(new Dimension(190, 140));

		pnlShape.setBackground(Color.red);
		pnlFile.setBackground(Color.green);

		pnlShape.setBorder(new TitledBorder("Shape"));
		pnlFile.setBorder(new TitledBorder("File"));

		pnlCommandArea.add(pnlShape);
		pnlCommandArea.add(lineWidthPanel);
		pnlCommandArea.add(colorHandler);
		pnlCommandArea.add(pnlFile);


		pnlShape.add(rdoL, 0);
		pnlShape.add(rdoR, 1);
		pnlShape.add(rdoC, 2);
		pnlShape.add(rdoO, 3);

		grpShape.add(rdoC);
		grpShape.add(rdoO);
		grpShape.add(rdoL);
		grpShape.add(rdoR);

		// ���ѡ��ļ�������
		RadioListener radioListener = new RadioListener();
		rdoL.addItemListener(radioListener);
		rdoR.addItemListener(radioListener);
		rdoC.addItemListener(radioListener);
		rdoO.addItemListener(radioListener);

		btnO.setMnemonic(KeyEvent.VK_O);
		btnS.setMnemonic(KeyEvent.VK_S);
		btnN.setMnemonic(KeyEvent.VK_N);
		btnE.setMnemonic(KeyEvent.VK_E);

		BtnListrner btnListrner = new BtnListrner();
		btnO.addActionListener(btnListrner);
		btnS.addActionListener(btnListrner);
		btnN.addActionListener(btnListrner);
		btnE.addActionListener(btnListrner);

		pnlFile.add(btnO, 0);
		pnlFile.add(btnS, 1);
		pnlFile.add(btnN, 2);
		pnlFile.add(btnE, 3);

		Windowclose windowclose = new Windowclose();
		addWindowListener(windowclose);
		setVisible(true);

	}



}
