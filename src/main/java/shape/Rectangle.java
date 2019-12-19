package shape;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import listener.ColorHandler;
import listener.LineWidthPanel;

public class Rectangle extends Shape {

	public Rectangle(Color color, int width, int x1, int y1, int x2, int y2) {
		super(color, width, x1, y1, x2, y2);
	}

	public Rectangle(FileReader fileReader) throws IOException {
		super(fileReader);
	}

	public String toString() {
		return "Rectangle:" + super.toString();
	}

	public void output(PrintWriter printWriter) {
		printWriter.printf("R");
		super.output(printWriter);
	}

	public void DrawShape(Graphics2D g) {
		g.setColor(color);
		g.setStroke(new BasicStroke(lineWidth));
		g.drawRect(min.x, min.y, w, h);
		g.setColor(ColorHandler.color);
		g.setStroke(new BasicStroke(LineWidthPanel.width));

	}

}
