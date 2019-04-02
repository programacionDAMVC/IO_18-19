package com.iesvirgendelcarmen.exercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StaffDAO {

	Connection connection;

	public StaffDAO () {
		try {
			connection = ConnectionDB.getConnection();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean addPerson(Person person) {
		int rows = 0;
		String sqlInsert = "INSERT INTO person VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlInsert);){
			psStatement.setString(1, person.getFirstName());
			psStatement.setString(2, person.getLastName());
			psStatement.setString(3, person.getEmail());
			if (person.getGender() != null)
				psStatement.setString(4, person.getGender().toString());
			else
				psStatement.setString(4, "");
			if (person.getBirthday() != null)
				psStatement.setString(5, person.getBirthday().format(Helper.formatter));
			else
				psStatement.setString(5, person.getBirthday()+"");
			psStatement.setString(6, person.getCountry());
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Fail! Email exists, or not firstName or not lastName");
		}
		return rows != 0;
	}
	
	public boolean removePerson(Person person) {
		int rows = 0;
		//DELETE FROM person WHERE firstName = 'luis' AND lastName = 'garcía';
		String sqlDelete = "DELETE FROM person WHERE firstName = ? AND lastName = ?;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlDelete);){
			psStatement.setString(1, person.getFirstName());
			psStatement.setString(2, person.getLastName());
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}
	
	public List<Person> getListPeopleByCountry(String country){
		List<Person> listPersonByEmail = new ArrayList<>();
		String sqlSelect = "SELECT * FROM person WHERE country = ?;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlSelect);){
			psStatement.setString(1, country);
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next()) {
				Gender gGender;
				String firstName = rsSet.getString("firstName");
				String lastName = rsSet.getString("lastName");
				String email = rsSet.getString("email");
				String countryBD = rsSet.getString("country");
				String sGender = rsSet.getString("gender");
				if (sGender.equals("Male")) {
					gGender = Gender.Male;
				}
				else {
					gGender = Gender.Female;
				}
				String sBirthday = rsSet.getString("birthday");
				LocalDate lBirthday = LocalDate.parse(sBirthday, Helper.formatter);
				listPersonByEmail.add(new Person(firstName, lastName, email, 
						gGender, lBirthday, countryBD));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPersonByEmail;
	}
//    ///////
	public static void main(String[] args) {
//		Person p1 = new Person("firstname", "lastName", "email", 
//				Gender.Female, LocalDate.now(), "country");
//		StaffDAO sDao = new StaffDAO();
//		System.out.println(sDao.addPerson(new Person()));
//		//System.out.println(null+"");
		String sFecha = "2000/10/10";
		LocalDate lFecha = LocalDate.parse(sFecha, Helper.formatter);
		System.out.println(sFecha);
		System.out.println(lFecha);
	}

	public List<Person> getListPeopleByGender(Gender gender) {
		List<Person> listPersonByGender = new ArrayList<>();
		String sqlSelect = "SELECT * FROM person WHERE gender = ?;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlSelect);){
			psStatement.setString(1, gender.toString());
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next()) {
				Gender gGender;
				String firstName = rsSet.getString("firstName");
				String lastName = rsSet.getString("lastName");
				String email = rsSet.getString("email");
				String countryBD = rsSet.getString("country");
				String sGender = rsSet.getString("gender");
				if (sGender.equals("Male")) {
					gGender = Gender.Male;
				}
				else {
					gGender = Gender.Female;
				}
				String sBirthday = rsSet.getString("birthday");
				LocalDate lBirthday = LocalDate.parse(sBirthday, Helper.formatter);
				listPersonByGender.add(new Person(firstName, lastName, email, 
						gGender, lBirthday, countryBD));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listPersonByGender;
	}

	public boolean removePerson(String email) {
		int rows = 0;
		String sqlDelete = "DELETE FROM person WHERE email = ? ;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlDelete);){
			psStatement.setString(1, email);
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}

	public boolean updatePersonByEmail(Person person, String newEmail) {
		// UPDATE  person SET email = "emai" WHERE firstName = "Orland" and lastName = "Nevinson";
		int rows = 0;
		String sqlUpdate = "UPDATE  person SET email = ? WHERE firstName = ? and lastName = ?;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlUpdate);){
			psStatement.setString(1, newEmail);
			psStatement.setString(2, person.getFirstName());
			psStatement.setString(3, person.getLastName());
			rows = psStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows != 0;
	}

	public Person getPersonByEmail(String email) {
		Person person = null;
		String sqlSelect = "SELECT * FROM person WHERE email = ?;";
		try (PreparedStatement psStatement = connection.prepareStatement(sqlSelect);){
			psStatement.setString(1, email);
			ResultSet rsSet = psStatement.executeQuery();
			while (rsSet.next()) {
				Gender gGender;
				String firstName = rsSet.getString("firstName");
				String lastName = rsSet.getString("lastName");
				String emailBD = rsSet.getString("email");
				String countryBD = rsSet.getString("country");
				String sGender = rsSet.getString("gender");
				if (sGender.equals("Male")) {
					gGender = Gender.Male;
				}
				else {
					gGender = Gender.Female;
				}
				String sBirthday = rsSet.getString("birthday");
				LocalDate lBirthday = LocalDate.parse(sBirthday, Helper.formatter);
				person = new Person(firstName, lastName, email, 
						gGender, lBirthday, countryBD);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}

}
