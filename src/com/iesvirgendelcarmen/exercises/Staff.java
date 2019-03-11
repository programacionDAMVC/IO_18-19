package com.iesvirgendelcarmen.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Staff {

	private List<Person> listOfPerson;

	public Staff(List<Person> listOfPerson) {
		this.listOfPerson = listOfPerson;
	}

	public boolean addPerson(Person person) {
		return listOfPerson.add(person);
	}

	public boolean removePerson(Person person) {
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
		return null;
	}

	//método que borre un objeto Persona dado como arguemento el email de la misma.
	public boolean removePerson (String email) {
		for (Person person : listOfPerson) {
			if (person.getEmail().equals(email)) 
				return listOfPerson.remove(person);
		}
		return false;

	}

	//método que actualice el correo electrónico, dado un objeto Persona
	public boolean updateEmailOfPerson(Person person, String newEmail) {
		return false;
	}



}
