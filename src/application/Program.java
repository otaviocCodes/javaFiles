package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter file path: ");
		String strPath = sc.nextLine();
		
		File path = new File(strPath);
		String strFolder = path.getParent();
		
		boolean success = new File(strFolder + "\\out").mkdirs();
		
		System.out.println(success);
		
		String strFile = strFolder + "\\out\\summary.csv";
		
		try(BufferedReader br = new BufferedReader(new FileReader(strPath))){
			
			String itemCsv = br.readLine();
			while(itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				list.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
				
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(strFile))){
				
				for(Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.valorTotal()));
					bw.newLine();
				}	
					System.out.println(strFile + " CREATED");
				
			}
			catch(IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		}
		catch(IOException e) {
			System.out.println("Error writing file: " + e.getMessage());
		}
		
		sc.close();

	}

}
