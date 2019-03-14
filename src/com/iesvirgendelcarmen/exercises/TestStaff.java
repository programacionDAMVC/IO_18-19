package com.iesvirgendelcarmen.exercises;

import java.util.Scanner;

public class TestStaff {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		//mensaje solicitando el fichero
		//llamar al método de la clase Helper, pasando como argumento un Path
		//se debe obtener List<Person> 
		int iOption = -1;
		String sOption;
		do {
			showMenu();
			sOption = sc.next();
			if (sOption.matches("[0-7]"))
				iOption = Integer.parseInt(sOption);
			else
				iOption = -1; //reseteamos la iOption válida
//			if (option == 0)   cambiamos la condición y la llevamos al while
//				break;
			switch (iOption) {
			case 0:
			//	exit();
				break;
			case 1:
				System.out.println("opción uno");
				break;
			case 2:
				System.out.println("opción dos");
				break;
			default:
				break;
			}
		} while (!(iOption == 0));
		sc.close();
		System.out.println("Fin de la aplicación");

	}

	private static void showMenu() {
		System.out.println("\n\n0- Exit");
		System.out.println("1- Delete person");
		System.out.println("2- List by country");
		System.out.println("3- List by gender");
		System.out.println("4- Delete by email");
		System.out.println("5- Get number of person by age");
		System.out.println("6- Add person");
		System.out.println("7- Update email of person");
		System.out.print("Choose option: ");
	}
}
