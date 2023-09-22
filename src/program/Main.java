package program;

import java.sql.SQLException;
import java.util.Scanner;

import connectionDB.DBconn;

public class Main {

	public static void main(String[] args) throws SQLException {

		DBconn db = new DBconn();
		Scanner sc =  new Scanner(System.in);
		
		int choose = 0;
		boolean run = true;
		
		while(run) {
			
			System.out.println("\nChoose an option");
			System.out.println("0. Exit");
			System.out.println("1. Insert");
			System.out.println("2. Delete");
			System.out.println("3. Query");
			
			choose = sc.nextInt();
			
			switch(choose) {
			
			case 0:
				System.out.println("Exiting...");
				run = false;
				break;
			case 1:
				System.out.print("\nName: ");
				sc.nextLine();
				db.insertClient(sc.nextLine());
				break;
			case 2:
				System.out.print("\nId: ");
				db.deleteClient(sc.nextInt());
				break;
			case 3:
				System.out.println();
				db.queryClients();
				break;
			case 4:
				break;
			default:
				System.out.println("Wrong option!");				
				break;
			
			}
			
		}
		
		sc.close();
	}
	
}
