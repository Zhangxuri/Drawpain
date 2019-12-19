package fileoper;

import java.io.*;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

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
		FileFilter filenameFilter=new FileFilter() {
			@Override
			public boolean accept(File f) {
				if (f.isDirectory()) {
					return false;
				}
				if (f.getName().endsWith("txt")){
					return true;
				}
				else {
					return false;
				}
			}

			@Override
			public String getDescription() {
				return null;
			}
		};
		jFileChooser.setFileFilter(filenameFilter);
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
			//
			e.printStackTrace();
		}
	}

}
