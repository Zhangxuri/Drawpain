package listener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class LineWidthPanel extends JPanel {

	public static int width = 1;
	JSlider jSlider;
	JTextField jTextField;
	JPanel jPanel_data;

	public LineWidthPanel() {
		super(new GridLayout(2, 1));
		setBorder(new TitledBorder("LineWidth"));
		setPreferredSize(new Dimension(190, 140));
		setBackground(Color.getHSBColor(164, 194, 244));

		jSlider = new JSlider();
		jPanel_data = new JPanel();
		jTextField = new JTextField();

		jPanel_data.setLayout(new GridLayout(1, 2));

		jPanel_data.add(jSlider);
		jPanel_data.add(jTextField);

		add(jPanel_data);

		jSlider.setMaximum(100);
		jSlider.setMinimum(width);
		jSlider.setValue(width);
		jSlider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				width = jSlider.getValue() / 3;
				jTextField.setText("" + (width*3+1));
				repaint();
				DragDrawPanel.width = width;
			}
		});

		jTextField.setText("" + width);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		Graphics2D graphics2d = (Graphics2D) g;
		graphics2d.setStroke(new BasicStroke(width));
		graphics2d.setColor(ColorHandler.color);
		graphics2d.drawLine(20, 110, 170, 110);
		graphics2d.setStroke(new BasicStroke());
	}
}
