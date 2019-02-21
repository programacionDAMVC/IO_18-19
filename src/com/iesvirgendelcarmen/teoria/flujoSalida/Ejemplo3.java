package com.iesvirgendelcarmen.teoria.flujoSalida;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Ejemplo3 {

	public static void main(String[] args) {
		List<Double> listaNumeros = new ArrayList<>();
		File inFile = new File("datos/numeros_originales.txt");
		File outFile = new File("datos/numeros_procesados.txt");
		try (Scanner sc = new Scanner(inFile);){
			while (sc.hasNextDouble())
				//System.out.println(sc.nextDouble());
				listaNumeros.add(sc.nextDouble());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(listaNumeros);
		Collections.sort(listaNumeros);  //ordena la colección orden natural (menor a mayor)
		System.out.println(listaNumeros);
		Collections.sort(listaNumeros, new Comparator<Double>() {

			@Override
			public int compare(Double arg0, Double arg1) {
				// TODO Auto-generated method stub
				return - (int) (arg0 * 100 - arg1 * 100);
			}
		});
		
		System.out.println(listaNumeros);
		double suma = 0.0;
		for (Double double1 : listaNumeros) {
			suma += double1;
		}
		double media = suma / listaNumeros.size();
		try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(outFile)));){
			for (Double double1 : listaNumeros) {
				out.writeChars(double1 + System.lineSeparator());
				
			}
			out.writeChars(String.format("Valor de la media: %.2f%n", media));
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Terminado");
		


	}

}
