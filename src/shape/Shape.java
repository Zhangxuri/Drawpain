package shape;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

public class Shape {
	protected Vector<MyPoint> points = new Vector<MyPoint>();
	protected Color color;
	protected int lineWidth;
	protected Point min;
	protected int w;
	protected int h;

	public Shape() {
		// TODO Auto-generated constructor stub
	}

	public Shape(Color color, int width, int x1, int y1, int x2, int y2) {
		min = new Point(Math.min(x1, x2), Math.min(y1, y2));
		this.color = color;
		this.lineWidth = width;
		points.add(new MyPoint(x1, y1));
		points.add(new MyPoint(x2, y2));
		w = Math.abs(x2 - x1);
		h = Math.abs(y2 - y1);

	}

	public Shape(FileReader fileReader) throws IOException {
		char[] c = new char[10];
		fileReader.read(c, 0, 10);
		color = new Color(Integer.parseInt(new String(c)));
		fileReader.read(c, 0, 10);
		lineWidth = Integer.parseInt(new String(c));
		fileReader.read(c, 0, 10);
		int x1 = Integer.parseInt(new String(c));
		fileReader.read(c, 0, 10);
		int y1 = Integer.parseInt(new String(c));
		points.add(new MyPoint(x1, y1));
		fileReader.read(c, 0, 10);
		int x2 = Integer.parseInt(new String(c));
		fileReader.read(c, 0, 10);
		int y2 = Integer.parseInt(new String(c));
		points.add(new MyPoint(x2, y2));
		w = Math.abs(x2 - x1);
		h = Math.abs(y2 - y1);
		min = new Point(Math.min(x1, x2), Math.min(y1, y2));
	}


	public void move(int dx, int dy) {
		for (MyPoint p : points)
			p.move(dx, dy);

	}

	public void rotate(int alpha) {
		for (MyPoint p : points)
			p.rotate(alpha);

	}

	public String toString() {
		String ps = "";
		int i = 0;
		for (MyPoint p : points) {
			ps += ("Point" + (++i) + ":" + p.toString() + " ");
		}
		return "Color=" + color + " Width=" + lineWidth + " " + ps;
	}

	public void output(PrintWriter printWriter) {
		printWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(), lineWidth, points.elementAt(0).x,
				points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);

	}

	public MyPoint getpointstart() {
		return points.firstElement();
	}

	public MyPoint getpointstop() {
		return points.lastElement();
	}

	public Point getminpoint() {
		return min;
	}

	public Color getcolor() {
		return color;
	}

	public int getw() {
		return w;
	}

	public int geth() {
		return h;
	}

	public void DrawShape(Graphics2D g) {

	}
}
