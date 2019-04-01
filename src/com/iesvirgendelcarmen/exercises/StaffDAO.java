package com.iesvirgendelcarmen.exercises;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

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

	public static void main(String[] args) {
		Person p1 = new Person("firstname", "lastName", "email", 
				Gender.Female, LocalDate.now(), "country");
		StaffDAO sDao = new StaffDAO();
		System.out.println(sDao.addPerson(new Person()));
		//System.out.println(null+"");
	}

}
