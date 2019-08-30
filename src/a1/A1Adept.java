package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Number of Items in the Store
		int numItems = scan.nextInt();
		
		// Number of Costumers
		int numCostum = scan.nextInt();
	}

	public static class itemsInStore {
		Scanner scan = new Scanner(System.in);

		
		String name;
		double price;
		
		public void brand () {
			name = scan.next();
		}
		public void cost () {
			price = scan.nextDouble();
		}
	}
	
	public static class Costumers {
		Scanner scan = new Scanner(System.in);

		String first;
		String last;
		int cart;
		
		public void firstName () {
			first = scan.next();
		}
		public void lastName () {
			last = scan.next();
		}
		public void numItemsPurchased () {
			cart = scan.nextInt();
		}
	}
	
	public static class itemsInCart {
		Scanner scan = new Scanner(System.in);
		
		int quantity;
		String title;
		
		public void amount () {
			quantity = scan.nextInt();
		}
		public void whatsItCalled () {
			title = scan.next();
		}
	}
}
