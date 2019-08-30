package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Number of Items in the Store
		int numItems = scan.nextInt();
		
		// Store Catalog 
		itemsInStore[] stock = new itemsInStore[numItems];
		for (int i = 0; i < numItems; i++) {
			stock[i] = new itemsInStore();
			stock[i].name = scan.next();
			stock[i].price = scan.nextDouble();
		}
		
		// Number of Costumers
		int numCustom = scan.nextInt();
		
		// Who's Shopping?
		Customers[] customerList = new Customers[numCustom];
		for (int i = 0; i < numCustom; i++) {
			customerList[i] = new Customers();
			customerList[i].first = scan.next();
			customerList[i].last = scan.next();
			customerList[i].cart = scan.nextInt();
			
			itemsInCart[] personalCart = new itemsInCart[customerList[i].cart];
			for (int h = 0; h < customerList[i].cart; h++) {
				personalCart[h] = new itemsInCart();
				personalCart[h].quantity = scan.nextInt();
				personalCart[h].title = scan.next();
			}
		}
		
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
	
	public static class Customers {
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
