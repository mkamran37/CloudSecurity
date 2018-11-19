package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Split File Example
 *
 * @author Krishna
 *
 */
public class Split {
	private static String FILE_NAME = "TextFile.txt";
	private static byte PART_SIZE = 5;
	public static void main(String[] args) {
		File inputFile = new File(FILE_NAME);
		FileInputStream inputStream;
		String newFileName;
		FileOutputStream filePart;
		int fileSize = (int) inputFile.length();
		int nChunks = 0, read = 0, readLength = PART_SIZE;
		byte[] byteChunkPart;
		try {
			inputStream = new FileInputStream(inputFile);
			while (fileSize > 0) {
				if (fileSize <= 5) {
					readLength = fileSize;
				}
				byteChunkPart = new byte[readLength];
				read = inputStream.read(byteChunkPart, 0, readLength);
				fileSize -= read;
				assert (read == byteChunkPart.length);
				nChunks++;
				newFileName = FILE_NAME + ".part"
						+ Integer.toString(nChunks - 1);
				filePart = new FileOutputStream(new File(newFileName));
				filePart.write(byteChunkPart);
				filePart.flush();
				filePart.close();
				byteChunkPart = null;
				filePart = null;
			}
			inputStream.close();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}