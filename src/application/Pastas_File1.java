package application;

import java.io.File;
import java.util.Scanner;

public class Pastas_File1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a folder path: ");
		String strPath = sc.next();
		
		File path = new File(strPath);
		//caminho dos arquivos
		System.out.println(path.getName());
		System.out.println(path.getParent());
		System.out.println(path.getPath());
		
		File[] folders = path.listFiles(File::isDirectory);
		System.out.println("\nFOLDERS:");
		for(File folder : folders) {
			System.out.println(folder);
		}
		
		File[] files = path.listFiles(File::isFile);
		System.out.println("\nFILES:");
		for(File file : files) {
			System.out.println(file);
		}
		boolean success = new File(strPath + "\\subdir").mkdir();
		System.out.println("Directory create successfully: " + success);
		
		sc.close();
	}

}
