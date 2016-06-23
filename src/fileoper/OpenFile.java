package fileoper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.omg.PortableInterceptor.IORInterceptor;

import mygui.DrawShape;
import shape.Circle;
import shape.Dot;
import shape.Line;
import shape.Rectangle;

public class OpenFile {
	FileReader fileReader;
	JFileChooser jFileChooser;

	public OpenFile() {
		// TODO Auto-generated constructor stub
		jFileChooser = new JFileChooser();
		jFileChooser.setCurrentDirectory(new File("C:\\Users\\ZXR\\Desktop"));
		FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("txt", "txt");
		jFileChooser.setFileFilter(fileNameExtensionFilter);
		jFileChooser.showOpenDialog(null);
		DrawShape.shapes.clear();
		try {
			fileReader = new FileReader(jFileChooser.getSelectedFile());
			while (fileReader.ready()) {
				switch (fileReader.read()) {
				case 'C':
					DrawShape.shapes.add(new Circle(fileReader));
					break;
				case 'L':
					DrawShape.shapes.add(new Line(fileReader));
					break;
				case 'R':
					DrawShape.shapes.add(new Rectangle(fileReader));
					break;
				case 'D':
					Dot dot = new Dot(fileReader);
					int a = 'G';
					fileReader.read();
					fileReader.read();
					while (a == fileReader.read()) {
						dot.readmore(fileReader);
						fileReader.read();
						fileReader.read();
					}
					DrawShape.shapes.add(dot);
				}
			}
			fileReader.close();
			JOptionPane.showMessageDialog(null, "Open Success", "Message", 1);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
