package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Chek-in date (dd/mm/yyyy): ");
		Date chekIn = sdf.parse(sc.next());
		System.out.print("Chek-out date (dd/mm/yyyy): ");
		Date chekOut = sdf.parse(sc.next());
		if (!chekOut.after(chekIn)) {
			System.out.println("Error in reservation: Chek-out date must be after chek-in date!");;
		}else {
			Reservation reservation = new Reservation(number, chekIn, chekOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Chek-in date (dd/mm/yyyy): ");
			chekIn = sdf.parse(sc.next());
			System.out.print("Chek-out date (dd/mm/yyyy): ");
			chekOut = sdf.parse(sc.next());
			
			String error = reservation.updatDates(chekIn, chekOut);
			if (error != null) {
				System.out.println("Error in reservation: "+ error);
			}else {
				System.out.println(reservation);
			}
		}
		
		sc.close();
	}

}
