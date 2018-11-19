package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Merge File Example
 *
 * @author Krishna
 *
 */
public class Merge {
    
    
	private static String FILE_NAME = "TextFile.txt";
	public static void main(String[] args) {
		File ofile = new File(FILE_NAME);
		FileOutputStream fos;
		FileInputStream fis;
		byte[] fileBytes;
		int bytesRead = 0;
		List<File> list = new ArrayList<File>();
		list.add(new File(FILE_NAME+".part0"));
		list.add(new File(FILE_NAME+".part1"));
		list.add(new File(FILE_NAME+".part2"));
		list.add(new File(FILE_NAME+".part3"));
		list.add(new File(FILE_NAME+".part4"));
		list.add(new File(FILE_NAME+".part5"));
		list.add(new File(FILE_NAME+".part6"));
		list.add(new File(FILE_NAME+".part7"));
		try {
		    fos = new FileOutputStream(ofile,true);
		    for (File file : list) {
		        fis = new FileInputStream(file);
		        fileBytes = new byte[(int) file.length()];
		        bytesRead = fis.read(fileBytes, 0,(int)  file.length());
		        assert(bytesRead == fileBytes.length);
		        assert(bytesRead == (int) file.length());
		        fos.write(fileBytes);
		        fos.flush();
		        fileBytes = null;
		        fis.close();
		        fis = null;
		    }
		    fos.close();
		    fos = null;
		}catch (Exception exception){
			exception.printStackTrace();
		}
	}
}

