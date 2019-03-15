package com.iesvirgendelcarmen.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestStaff {
	
	private static Staff staff;
	private static Scanner sc;
	
	public static void main(String[] args) {
		Path pathCSV;
		sc = new Scanner(System.in);
		//mensaje solicitando el fichero
		
		do {
			System.out.println("Enter filename:");
			String fileName = sc.next();
			pathCSV = Paths.get("datos", fileName);
//			if (Files.exists(pathCSV))
//				break;
		} while (!Files.exists(pathCSV));
		//llamar al método de la clase Helper, pasando como argumento un Path
		//se debe obtener List<Person> 

		try {
			List<Person> listOfPerson = Helper.readCSV(pathCSV);
			staff = new Staff(listOfPerson);
			//System.out.println(listOfPerson);
		} catch (IOException e) {
			System.out.println("Error I/O");
			//	e.printStackTrace();
		} 
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
				deletePerson();
				break;
			case 2:
				listByCountry();
				break;
			default:
				break;
			}
		} while (!(iOption == 0));
		sc.close();
		System.out.println("Fin de la aplicación");

	}

	private static void deletePerson() {
		// Sukey,Zoellner,szoellnerrp@free.fr,Female,2015/04/18,Russia
		//Veriee,Butner,vbutnerrq@feedburner.com,Female,1997/07/10,Peru
		//Orland,Nevinson,onevinsonrr@irs.gov,Male,1995/09/24,Botswana
		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter last name");
		String lastName = sc.next();
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		if (staff.removePerson(person))
			System.out.printf("Delete person %s, %s%n",  lastName,firstName );
		else
			System.out.println("Person does not exist");
		
	}

	private static void listByCountry() {
		System.out.println("Enter country name:");
		String countryName = sc.next();
		List<Person> listOfPersonByCountry = staff.getListPeopleByCountry(countryName);
		for (Person person : listOfPersonByCountry) {
			System.out.println(person);
		}
		if (listOfPersonByCountry.size() == 0)
			System.out.println("Empty list");
		
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
