package com.iesvirgendelcarmen.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Helper {
	
	public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	
	public static int getYearsOfPeriod(LocalDate lDate) {
		Period period = Period.between(lDate, LocalDate.now());
		return period.getYears();
	}

	

	//método que dado el path del csv, lea el csv y devuelva
	//List<Person>
	public static List<Person> readCSV(Path pathCSV) throws IOException{
		//crear la lista de Person vacía
		List<Person> listOfPerson = new ArrayList<>();
		//leer la líneas del path con readAllLines de la clase Files
		List<String> listOfLines = Files.readAllLines(pathCSV);
		//eliminamos la cabecera first_name, last_name, email .....
		if (listOfLines.size() != 0)
			listOfLines.remove(0);
		//recorremos la lista de líneas leídas anteriormente
		Person person;
		String[] lineSplit;
		for (String line : listOfLines) {
			//cada línea se divide (split) por la ,
			//Annabelle,Trimme,atrimmer7@biblegateway.com,Female,1992/10/06,China
			//firstName, lastName, email, gender, birthday, country  (el split devuelve String[])
			lineSplit = line.split(",");
			if (lineSplit[3].equals("Male"))
				person = new Person(lineSplit[0], lineSplit[1],lineSplit[2],
						Gender.Male,LocalDate.parse(lineSplit[4], formatter),lineSplit[5]);
			else
				person = new Person(lineSplit[0], lineSplit[1],lineSplit[2],
						Gender.Female,LocalDate.parse(lineSplit[4], formatter),lineSplit[5]);
			//añadimos cada objeto Person a lista
			listOfPerson.add(person);
		}
		//devolvemos la lista
		return listOfPerson;
	}
	
	public static void writeCSV (Staff staff, String fileName) {
		//Creamos un nuevo Path con fileName + fecha (LocalDateTime.now().toString())
		//obtener List<Person> del atributo staff, mediante getter
		//recorremos la lista y añadimos person + \n a u StringBuilder
		//quitar el último salto de línea
		//usar bufferedwriter que proporciona el método newBufferedWriter de la clase Files
		//usando el método print(String) lo volcamos al fichero
	}
	
	public static void main(String[] args) throws IOException {
//		System.out.println(getYearsOfPeriod(LocalDate.of(2000, 3, 13)));
//		LocalDate localDate = LocalDate.parse("2000/03/13", formatter);
//		System.out.println(localDate);
		Path path = Paths.get("datos", "personal.csv");
		System.out.println(readCSV(path));
	}
}
