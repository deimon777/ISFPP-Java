package com.deimon.isfpp.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException {

		// System.out.print("Enter the file name with extension : ");

		// Scanner input = new Scanner(System.in);

		// File file = new File(input.nextLine());

		// input = new Scanner(file);

		String ruta_absoluta = new File("").getAbsolutePath();
		String ruta_ralativa = "/src/com/deimon/isfpp/test/";
		String archivo = ruta_absoluta+ruta_ralativa+"datos.txt";
				
		Scanner read = new Scanner(new File(archivo));
		read.useDelimiter(";");
		String title, category, runningTime;
		int year;
		double price;

		while (read.hasNext()) {
			title = read.next();
			category = read.next();
			runningTime = read.next();
			year = read.nextInt();
			price = read.nextDouble();
			System.out.println(title + " " + category + " " + runningTime + " "
					+ year + " " + price + "\n"); // just for debugging
			
		}
		read.close();

	}
}
