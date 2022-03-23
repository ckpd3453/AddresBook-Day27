package com.bridgeLabz;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MultipleServices13 {
	/**
	 * Java HashMap class implements the Map interface which allows us to store key
	 * and value pair, where keys should be unique.
	 */
	Map<String, Services13> Services13Map = new HashMap<>();

	/**
	 * created method addServices13() to add a new values in Services13
	 */
	public void addServices13() {
		System.out.println("Enter Name of new Address Book: ");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (Services13Map.containsKey(bookName)) {
			System.out.println("Address book with this name exists, Enter new name.");
			addServices13();
		} else {
			Services13 Services13 = new Services13();
			Services13Map.put(bookName, Services13);
			System.out.println("press 1 if you want to add another book or press any key to exit.");
			int newBook = scanner.nextInt();
			if (newBook == 1) {
				addServices13();
			}
		}
	}

	/**
	 * create method Services13Functions() to edit ,delete the contact in
	 * addresbook
	 */
	public void Services13Functions() {
		System.out.println("Enter the name of Address book to add, edit or delete the contact.");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.nextLine();
		if (Services13Map.containsKey(bookName)) {
			Services13Map.get(bookName);
			System.out.println("Enter book is present choose the options below to do certain function");
			while (true) {
				System.out.println("Enter\n 1. add Contact\n 2. edit contact\n 3. delete contact\n 4. previous menu");
				int choice = scanner.nextInt();
				switch (choice) {
				case 1:
					Services13Map.get(bookName).addContact();
					break;
				case 2:
					Services13Map.get(bookName).editContact();
					break;
				case 3:
					Services13Map.get(bookName).deleteContact();
					break;
				case 4:
					return;
				default:
					System.out.println("Entered choice is incorrect!.. please enter correct choice");
				}
			}
		}
	}

	/**
	 * create method deleteBook to delete the name of the Services13 to delete
	 */
	public void deleteBook() {
		System.out.println("Enter the name of Address book to delete.");
		Scanner scanner = new Scanner(System.in);
		String bookName = scanner.next();
		if (Services13Map.containsKey(bookName)) {
			Services13Map.remove(bookName);
		} else {
			System.out.println("No book found");
		}
	}

	/**
	 * create method printBook to see if Services13 is present in a program
	 */
	public void printBook() {
		System.out.println("These are Services13s in present program.");
		for (Map.Entry<String, Services13> entry : Services13Map.entrySet()) {
			System.out.println(entry.getKey() + "[]");
		}
	}

	/**
	 * create method printContactsInBook() that prints the contacts ina a book
	 */
	public void printContactsInBook() {
		for (Map.Entry<String, Services13> entry : Services13Map.entrySet()) {
			System.out.println("The contacts in the Book of < " + entry.getKey() + " > are!...");
			System.out.println(entry.getValue().contactDetailsList);
		}
	}
}
