package com.bridgelabz.AddressBookSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	ArrayList<Contact> contacts = new ArrayList<>();
	    private Scanner sc = new Scanner(System.in);

	    public void addContact(){
	    	System.out.println("Enter the First Name : ");
	    	String firstName = sc.next();
	    	System.out.println("Enter the Last Name : ");
	    	String lastName = sc.next();
	        System.out.println("Enter address : ");
	        String address = sc.next();
	        System.out.println("Enter city and state : ");
	        String city = sc.next();
	        String state = sc.next();
	        System.out.println("Enter zip code : ");
	        String zipCode = sc.next();
	        System.out.println("Enter contact number : ");
	        String mobileNo = sc.next();
	        System.out.println("Enter email id : ");
	        String email = sc.next();
	        
	        if (isDuplicate(firstName, lastName))
	            System.out.println(firstName+" "+ lastName+" already exists in contacts");
	        else
	        	  contacts.add(new Contact(firstName,lastName,address,city,state,zipCode,mobileNo,email));

	        
	    }

	    public void displayContact(){
	    	for(int i = 0; i < contacts.size(); i++) {
	    		Contact contact = contacts.get(i);
	    		System.out.println(contacts.toString());
	        }
	    }

	    public void editContact(){
	        System.out.println("Enter person name : ");
	        String name = sc.next();
	        for(Contact contact : contacts){
	            if(contact.getFirstName().equals(name) || contact.getLastName().equals(name)){
	                System.out.println("What you want to edit : \n" +
	                        "1.first name \t" +
	                        "2.last name \t" +
	                        "3.address \t" +
	                        "4.city \t" +
	                        "5.state \t" +
	                        "6.zipCode \t" +
	                        "7.mobile number \t" +
	                        "8.email");
	                int ch = sc.nextInt();
	                switch (ch){
	                    case 1:
	                        System.out.println("Enter first name :");
	                        contact.setFirstName(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 2:
	                        System.out.println("Enter last name :");
	                        contact.setLastName(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 3:
	                        System.out.println("Enter address :");
	                        contact.setAddress(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 4:
	                        System.out.println("Enter city :");
	                        contact.setCity(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 5:
	                        System.out.println("Enter state :");
	                        contact.setState(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 6:
	                        System.out.println("Enter zip code :");
	                        contact.setZipCode(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 7:
	                        System.out.println("Enter mobile number :");
	                        contact.setMobileNo(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    case 8:
	                        System.out.println("Enter email :");
	                        contact.setEmail(sc.next());
	                        System.out.println("Contact updated!");
	                        break;
	                    default:
	                        System.out.println("Invalid input.");
	                }
	                return;
	            }
	        }
	        System.out.println(name + " not found!");
	    }

	    public void deleteContact(){
	        System.out.println("Enter person name : ");
	        String name = sc.next();
	        for(Contact contact : contacts){
	            if(contact.getFirstName().equals(name) || contact.getLastName().equals(name)){
	                contacts.remove(contact);
	                System.out.println(contact.getFirstName() +" removed!");
	                return;
	            }
	        }
	        System.out.println(name + " not found!");
	    }
	    public List<Contact> getContactList(){
	        return contacts;
	    }
	    /*
		    * This method is used to check the duplicate entry
		    * if first and last name already exists in addressbook then it will not return true i.e. duplicate entry
		    * if duplicate return true else return false
		    * */
		    public boolean isDuplicate(String firstName, String lastName){
		        boolean result = contacts.stream().filter(contact -> contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)).count() > 0;
		        return result;
		    }
		    public void searchByCityOrState(String location){
		        contacts.stream().forEach(contact -> {
		            if (contact.getCity().equals(location) || contact.getState().equals(location)){
		                System.out.println(contact);
		            }
		        });
		    }

		}

