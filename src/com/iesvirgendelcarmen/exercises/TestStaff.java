package com.iesvirgendelcarmen.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TestStaff {

	private static Staff staff;
	private static Scanner sc;
	private static boolean fileChanged;

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
			if (sOption.matches("[0-8]"))
				iOption = Integer.parseInt(sOption);
			else
				iOption = -1; //reseteamos la iOption válida
			//			if (option == 0)   cambiamos la condición y la llevamos al while
			//				break;
			switch (iOption) {
			case 0:
				if (fileChanged)
					exit();
				break;
			case 1:
				deletePerson();
				break;
			case 2:
				listByCountry();
				break;
			case 3:
				listByGender();
				break;
			case 4:
				deleteByEmail();
				break;
			case 5:
				getNumberOfPersonByAge();
				break;
			case 6:
				addPerson();
				break;
			case 7:
				updatePersonByEmail();
				break;
			case 8:
				getPersonByEmail();
				break;
			default:
				break;
			}
		} while (!(iOption == 0));
		sc.close();
		System.out.println("END APP");

	}

	private static void getPersonByEmail() {
		String email;
		do {
			System.out.println("Enter email");
			email = sc.next();
		} while (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));
		Person person = staff.getPersonByEmail(email);
		if (person != null)
			System.out.println(person);
		else
			System.out.println("Person not found");
		
	}

	private static void exit() {
		System.out.println("Enter filename:");
		String fileName = sc.next();
		try {
			Helper.writeCSV(staff, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void addPerson() {
		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter last name");
		String lastName = sc.next();
		
		String email;
		do {
			System.out.println("Enter email");
			email = sc.next();
		} while (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));
		
		String sGender;
		do {
			System.out.println("Enter gender:");
			sGender = sc.next();
			//regex
			// gender.toLowerCase().matches("(male|female)");
		} while(!(sGender.toLowerCase().equals("male") || 
				sGender.toLowerCase().equals("female")));
		Gender gender;
		if (sGender.toLowerCase().equals("male"))
			gender = Gender.Male;
		else
			gender =  Gender.Female;
		
		String sBirthday;
		LocalDate lBirthday;
		do {
			System.out.println("Enter birthday (yyyy/mm/dd)");
			sBirthday = sc.next();
			if (sBirthday.matches("\\d{4}/\\d{2}/\\d{2}")) {
				lBirthday = LocalDate.parse(sBirthday, Helper.formatter);
				break;
			}
		} while(true);
		
		System.out.println("Enter country:");
		String country = sc.next();
		
		Person person = new Person(firstName, lastName, email, gender, lBirthday, country);
		if (staff.addPerson(person)) {
			System.out.println("Add person");
			fileChanged = true;
		}
		else
			System.out.println("Problem to add person");
		
	}

	private static void updatePersonByEmail() {
		System.out.println("Enter first name");
		String firstName = sc.next();
		System.out.println("Enter last name");
		String lastName = sc.next();
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		String newEmail;
		do {
			System.out.println("Enter new email");
			newEmail = sc.next();
		} while (!newEmail.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));
		if (staff.updatePersonByEmail(person, newEmail)) {
			System.out.printf("Update email of %s, %s%n", lastName, firstName);
			fileChanged = true;
		}
		else
			System.out.println("No update email");
		
	}

	private static void getNumberOfPersonByAge() {
		int iAge;
		String sAge;
		do {
			System.out.println("Enter age:");
			sAge = sc.next();
			if (sAge.matches("[0-9]{1,2}")){
				iAge = Integer.parseInt(sAge);
				break;
			}
		} while(true);
		System.out.printf("Number of people older than %d are %d%n",
				iAge, staff.getNumberOfPeopleByAge(iAge));
	}

	private static void listByGender() {
		String gender;
		List<Person> listByGender;
		do {
			System.out.println("Enter gender:");
			gender = sc.next();
			//regex
			// gender.toLowerCase().matches("(male|female)");
		} while(!(gender.toLowerCase().equals("male") || 
				gender.toLowerCase().equals("female")));

		if (gender.toLowerCase().equals("male"))
			listByGender = staff.getListPeopleByGender(Gender.Male);
		else
			listByGender = staff.getListPeopleByGender(Gender.Female);

		listByGender.forEach( p -> System.out.println(p));
		if (listByGender.size() == 0)
			System.out.println("Empty list");
	}

	private static void deleteByEmail() {
		String email;
		do {
			System.out.println("Enter email");
			email = sc.next();
		} while (!email.matches("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$"));
		if (staff.removePerson(email)) {
			System.out.printf("Person wiht email %s has deleted%n", email);
			fileChanged = true;
		}
		else
			System.out.println("Email does not exist");

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
		if (staff.removePerson(person)) {
			System.out.printf("Delete person %s, %s%n",  lastName,firstName );
			fileChanged = true;
		}
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
		System.out.println("8- List by email");
		System.out.print("Choose option: ");
	}
}
