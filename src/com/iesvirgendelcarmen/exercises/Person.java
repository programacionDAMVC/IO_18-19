package com.iesvirgendelcarmen.exercises;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {

	private String firstName;
	private String lastName;
	private String email;
	private Gender gender;
	private LocalDate birthday;
	private String country;

	public Person(String firstName, String lastName, String email, Gender gender, LocalDate birthday, String country) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.birthday = birthday;
		this.country = country;
	}
	public Person() {}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		if (birthday != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			return String.format("%s,%s,%s,%s,%s,%s",
					firstName, lastName, email, gender, birthday.format(formatter), country);
		}
		return String.format("%s,%s,%s,%s,%s,%s",
				firstName, lastName, email, gender, birthday, country);

	}
	//	@Override
	//	public String toString() {
	//		return String.format("Person [firstName=%s, lastName=%s, email=%s, gender=%s, birthday=%s, country=%s]",
	//				firstName, lastName, email, gender, birthday, country);
	//	}
	//	@Override
	//	public String toString() {
	//		return String.format("%s,%s,%s,%s,%d/%d/%d,%s",
	//				firstName, lastName, email, gender, birthday.getYear(),
	//				birthday.getMonthValue(), birthday.getDayOfMonth(),country);
	//	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}


	public static void main(String[] args) {
		Person p1 = new Person("firstname", "lastName", "email", 
				Gender.Female, LocalDate.now(), "country");
		System.out.println(p1);
		Person p2 = new Person("firstname", "lastName1", "email", 
				Gender.Male, LocalDate.now(), "country");
		//System.out.println(p1.equals(p2));
		Person p3 = new Person();
		p3.setFirstName("firstname");
		p3.setLastName("lastName");
		System.out.println(p1.equals(p3));
		System.out.println(p2.equals(p3));
		System.out.println(p3);





	}



}
