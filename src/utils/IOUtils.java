package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import core.Point;
import core.QuadTree;
import list.List;

public class IOUtils {
	public static void storeQuadTreeDetails(String fileQt, String fileList, QuadTree qt, List<Point> list)
			throws FileNotFoundException, IOException {
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileQt));
				ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream(fileList))) {
			out.writeObject(qt);
			out2.writeObject(list);
		}
	}

	
	@SuppressWarnings("unchecked")
	public static List<Point> restoreQuadTreeDetailsList(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f1=new File(file);
		if(f1.isFile()&& f1.canRead()) {
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1))
					){
				
				  return (List<Point>) in.readObject();
				
				
			}
		}
		return null;
	}
	
	public static QuadTree restoreQuadTreeDetailsTree(String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		File f1=new File(file);
		if(f1.isFile()&& f1.canRead()) {
			try(ObjectInputStream in=new ObjectInputStream(new FileInputStream(f1))
					){
				return (QuadTree) in.readObject();		
			}
		}
		return null;
	}
}
