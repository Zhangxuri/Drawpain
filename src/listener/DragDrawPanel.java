package listener;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import fileoper.SaveFile;
import mygui.DrawShape;
import shape.Dot;
import shape.MyPoint;

public class DragDrawPanel extends JPanel implements MouseMotionListener, MouseListener {

	/** 矩形的起点 左上角* */
	private Point Start = null;
	/** 矩形的终点 右下角* */
	private Point Stop = null;
	/** 是否绘制虚线矩形* */
	private boolean dottedTag = true;
	private Color color;
	public static int width = 1;
	public static int w = 0;
	public static int h = 0;
	Dot dot;

	public DragDrawPanel() {

		setPreferredSize(new Dimension(600, 600));
		Border border = new LineBorder(Color.black);
		setBorder(border);
		setBackground(Color.white);
		Start = new MyPoint(0, 0);
		Stop = new MyPoint(0, 0);
		dot = new Dot();
		addMouseListener(this);
		addMouseMotionListener(this);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		color = ColorHandler.color;
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(color);
		/** 矩形的宽度* */
		w = Math.abs(Stop.x - Start.x);
		/** 矩形的高度* */
		h = Math.abs(Stop.y - Start.y);
		/** 起点终点的最小值作为起点* */
		Point min = new Point(0, 0);
		min.x = Math.min(Stop.x, Start.x);
		min.y = Math.min(Stop.y, Start.y);
		/** 如果是绘制虚线矩形* */
		for (shape.Shape shape : DrawShape.shapes) {
			g2.setStroke(new BasicStroke());
			shape.DrawShape(g2);
		}
		if (dottedTag) {
			Stroke dash = new BasicStroke(width, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 0.5f,
					new float[] { 5, 5, }, 0f);
			g2.setStroke(dash);
			if (DrawShape.type == DrawShape.RECT) {
				g2.drawRect(min.x, min.y, w, h);
			} else if (DrawShape.type == DrawShape.LINE) {
				g2.drawLine(Start.x, Start.y, Stop.x, Stop.y);
			} else if (DrawShape.type == DrawShape.CIRCLE) {
				g2.drawOval(min.x, min.y, w, h);
			}
			dot.DrawShape(g2);
		}
	}

	public void mouseDragged(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		Stop = mouseEvent.getPoint();
		if (DrawShape.type == DrawShape.OTHER) {
			dot.addpoint(Start.x, Start.y, Stop.x, Stop.y);
			Start = Stop;
		} else if (Tools.type == 1) {

			if (Stop.x > Start.x) {
				Stop.x = Start.x + Math.min(Math.abs(Stop.x - Start.x), Math.abs(Stop.y - Start.y));
			} else {
				Stop.x = Start.x - Math.min(Math.abs(Stop.x - Start.x), Math.abs(Stop.y - Start.y));

			}
			if (Stop.y < Start.y) {
				Stop.y = Start.y - Math.min(Math.abs(Stop.x - Start.x), Math.abs(Stop.y - Start.y));
			} else {
				Stop.y = Start.y + Math.min(Math.abs(Stop.x - Start.x), Math.abs(Stop.y - Start.y));
			}
		}
		repaint();

	}

	public void mousePressed(MouseEvent mouseEvent) {
		/** 设置可以进行绘制* */
		dottedTag = true;
		/** 记录起始点* */
		Start = mouseEvent.getPoint();
		/** 记录起终点* */
		Stop = Start;
		if (DrawShape.type == DrawShape.OTHER) {
			dot = new Dot();
			color = ColorHandler.color;
			dot.setcolorwidth(color, width);
		}

	}

	public void mouseReleased(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub
		dottedTag = false;
		if (DrawShape.type == DrawShape.RECT) {
			DrawShape.shapes.add(new shape.Rectangle(color, width, Start.x, Start.y, Stop.x, Stop.y));
		} else if (DrawShape.type == DrawShape.LINE) {
			DrawShape.shapes.add(new shape.Line(color, width, Start.x, Start.y, Stop.x, Stop.y));
		} else if (DrawShape.type == DrawShape.CIRCLE) {
			DrawShape.shapes.add(new shape.Circle(color, width, Start.x, Start.y, Stop.x, Stop.y));
		} else if (DrawShape.type == DrawShape.OTHER) {
			DrawShape.shapes.add(dot);
		}
		SaveFile.hassave = false;
		repaint();
	}

	public void mouseMoved(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseClicked(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseEntered(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent mouseEvent) {
		// TODO Auto-generated method stub

	}

	public Vector<shape.Shape> getshapes() {
		return DrawShape.shapes;

	}

}
