package com.iesvirgendelcarmen.teoria.flujoES;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejemplo1 {

	public static void main(String[] args) {

		File file = new File("datos/fichero1.dat");
		try (RandomAccessFile inOut = new RandomAccessFile(file, "rwd");){
			for (int i = 0; i < 100; i++) {
				System.out.printf("Escribiendo el nº %d en la posición %d%n",
						i, inOut.getFilePointer());
				inOut.writeInt(i);
			}
			System.out.println("Posición final del puntero: " + inOut.getFilePointer());
		//	System.out.println("Leyendo un valor entero: " + inOut.readInt());
			int posicion = 1;
			inOut.seek(posicion);
			System.out.printf("Valor de la posición %d: %d%n", posicion, inOut.readLong() );
			inOut.seek(396);
			inOut.writeInt(500);
			inOut.seek(396);

			System.out.printf("Valor de la posición %d: %d%n", 396, inOut.readInt() );
			System.out.printf("Valor de la posición %d: %d%n", 400, inOut.readInt() );

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   //modo lectura y escritura
		System.out.printf("Tamaño del fichero %s: %d bytes%n",
				file.getName(), file.length());
	}

}
