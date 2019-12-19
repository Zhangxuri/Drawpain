package fileoper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import mygui.DrawShape;
import shape.Shape;

public class SaveFile {
	FileWriter fileWriter;
	PrintWriter printWriter;
	JFileChooser jFileChooser;
	public static boolean hassave=true;
	public SaveFile() {
		// TODO Auto-generated constructor stub
		jFileChooser=new JFileChooser();
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
		jFileChooser.showSaveDialog(null);
		try {
			fileWriter =new FileWriter(jFileChooser.getSelectedFile());
			printWriter = new PrintWriter(fileWriter);
			for (Shape s : DrawShape.shapes)
				s.output(printWriter);
			printWriter.close();
			fileWriter.close();
			hassave=true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
