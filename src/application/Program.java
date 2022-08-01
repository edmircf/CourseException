package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Chek-in date (dd/mm/yyyy): ");
			Date chekIn = sdf.parse(sc.next());
			System.out.print("Chek-out date (dd/mm/yyyy): ");
			Date chekOut = sdf.parse(sc.next());
			
			Reservation reservation = new Reservation(number, chekIn, chekOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Chek-in date (dd/mm/yyyy): ");
			chekIn = sdf.parse(sc.next());
			System.out.print("Chek-out date (dd/mm/yyyy): ");
			chekOut = sdf.parse(sc.next());
			
			reservation.updatDates(chekIn, chekOut);
			
			System.out.println("Reservation: " + reservation);
		}catch (ParseException e){
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch (RuntimeException e){
			System.out.println("Unexpected Error");
			
		}finally {
			sc.close();
		}
	}

}
