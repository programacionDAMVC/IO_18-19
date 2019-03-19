package com.iesvirgendelcarmen.exercises;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Staff {

	private List<Person> listOfPerson;

	public Staff(List<Person> listOfPerson) {
		this.listOfPerson = listOfPerson;
	}

	
	
	public List<Person> getListOfPerson() {
		return listOfPerson;
	}



	public boolean addPerson(Person person) {
		return listOfPerson.add(person);
	}

	public boolean removePerson(Person person) {  //método sobrecardo
		return listOfPerson.remove(person);
	}

	public List<Person> getListPeopleByCountry(String country){
		List<Person> listPersonCountry = new ArrayList<>();
		for (Person person : listOfPerson) {
			if (person.getCountry().equals(country))
				listPersonCountry.add(person);
		}
		return listPersonCountry;
		//usando los stream de java 8
		//		return listOfPerson.stream()
		//				.filter( p -> p.getCountry().equals(country))
		//				.collect(Collectors.toList());

	}
	//método que devuelva otra lista de objetos Persona dado como argumento el género.

	public List<Person> getListPeopleByGender(Gender gender){
		List<Person> listPersonGender = new ArrayList<>();
		for (Person person : listOfPerson) {
			if (person.getGender().equals(gender))
				listPersonGender.add(person);
		}
		return listPersonGender;
	}

	//método que borre un objeto Persona dado como arguemento el email de la misma.
	public boolean removePerson (String email) { //método sobrecargado
		for (Person person : listOfPerson) {
			if (person.getEmail().equals(email)) 
				return listOfPerson.remove(person);
		}
		return false;

	}

	//método que actualice el correo electrónico, dado un objeto Persona
	public boolean updatePersonByEmail(Person person, String newEmail) {
		for (Person personOfList : listOfPerson) {
			if (personOfList.equals(person)) {
				personOfList.setEmail(newEmail);
				return true;
			}
		}
		return false;
	}

	//método que nos devuelva el número de objetos Persona que tenga
	// una edad superior a una edad dada
	public int getNumberOfPeopleByAge(int age) {
		int count = 0;
		for (Person person : listOfPerson) {
			if (Helper.getYearsOfPeriod(person.getBirthday()) > age)
				count++;
		}
		return count;
		
	}
	
	//método que devuelva un objeto Person dado  un email (se supone único)
	public Person getPersonByEmail(String email) {
		for (Person person : listOfPerson) {
			if (person.getEmail().equals(email))
				return person;
		}
		return null;
	}
	
	public static void main(String[] args) {
		Person p1 = new Person("manuel", "garcia", "garcia@email", 
				Gender.Male, LocalDate.of(2000, 03, 13), "españa");
		Person p2 = new Person("francisca", "garcia", "Fgarcia@email", 
				Gender.Female, LocalDate.of(1990, 03, 13), "francia");
		Person p3 = new Person("luisa", "garcia", "Lgarcia@email", 
				Gender.Female, LocalDate.of(2010, 03, 13), "españa");
		Person p4 = new Person("luis", "garcia", "Lugarcia@email", 
				Gender.Male, LocalDate.of(1985, 03, 13), "inglaterra");
		List<Person> list = new ArrayList<>();
		list.add(p1); list.add(p4); list.add(p3); list.add(p2);
		System.out.println(list.toString());
		Staff staff = new Staff(list);
		System.out.println(staff.toString());
		System.out.println(staff.addPerson(new Person("gabriel", "garciez", "Ggarcia@email", 
				Gender.Male, LocalDate.of(1985, 03, 13), "india")));
//		System.out.println(staff.removePerson(new Person("firstname", "lastName", null,
//				null, null, null)));
//		System.out.println(staff.removePerson(new Person("manuel", "garcia", null,
//				null, null, null)));
//		System.out.println(staff.removePerson("email"));
//		System.out.println(staff.removePerson("Fgarcia@email"));
//		System.out.println(staff.removePerson("garcia@email"));
		System.out.println(staff.updatePersonByEmail(new Person("luisa", "garci",null, null, null, null), 
						"correo@correo.es"));
		System.out.println(staff.getListPeopleByCountry("españa"));
		System.out.println(staff.getListPeopleByCountry("india"));
		System.out.println(staff.getListPeopleByCountry("alemania"));
		System.out.println(staff.getListPeopleByGender(Gender.Male));
		System.out.println(staff.getNumberOfPeopleByAge(80));




	}

}
