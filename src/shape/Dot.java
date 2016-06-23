package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import listener.ColorHandler;
import listener.LineWidthPanel;

public class Dot extends Shape {
	private int num;
	public Dot() {
		// TODO Auto-generated constructor stub
	}
	public Dot(Color color, int width, int x1, int y1, int x2, int y2) {
		super(color, width, x1, y1, x2, y2);
	}

	public Dot(FileReader fileReader) throws IOException {
		super(fileReader);
		
	}
	public void readmore(FileReader fileReader) throws IOException {
		char[] c = new char[10];
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
	}

	public String toString() {
		return "Dot:" + super.toString();
	}

	public void output(PrintWriter printWriter) {
		printWriter.printf("D");
		printWriter.printf("%010d%010d%010d%010d%010d%010d\r\n", color.getRGB(), lineWidth, points.elementAt(0).x,
				points.elementAt(0).y, points.elementAt(1).x, points.elementAt(1).y);
		int i=2,j=3;
		while(points.size()>i)
		{
			printWriter.printf("G");
			printWriter.printf("%010d%010d%010d%010d\r\n",  points.elementAt(i).x,
					points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
			i=i+2;
			j=j+2;
		}
		printWriter.printf("F\r\n");
	}

	public void DrawShape(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(lineWidth));
		int i=0,j=1;
		while(points.size()>i)
		{
		g.drawLine(points.elementAt(i).x, points.elementAt(i).y, points.elementAt(j).x, points.elementAt(j).y);
			i=i+2;
			j=j+2;
		}
		
		g.setColor(ColorHandler.color);
		g.setStroke(new BasicStroke(LineWidthPanel.width));

	}
	public void addpoint(int x1,int y1,int x2,int y2) {
		// TODO Auto-generated method stub
		points.add(new MyPoint(x1, y1));
		points.add(new MyPoint(x2, y2));		
	}
	public void setcolorwidth(Color color1,int width) {
		lineWidth=width;
		color=color1;
	}
}
