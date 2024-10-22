package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriter_BufferedWriter4 {

	public static void main(String[] args) {

		String[] lines = new String[] { "good morning", "good afternoon", "good evening" };

		String path = "c:\\OneDriveTemp\\out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {

			for (String line : lines) {
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
