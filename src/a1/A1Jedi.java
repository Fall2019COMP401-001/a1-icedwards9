package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		// Number of Items in the Store
				int numItems = scan.nextInt();
				
				// What's in stock at the store?
				// Array of the items available, the name and price of each
				itemsInStore[] stock = new itemsInStore[numItems];
				for (int i = 0; i < numItems; i++) {
					stock[i] = new itemsInStore();
					stock[i].name = scan.next();
					stock[i].price = scan.nextDouble();
				}
				
				// Number of Customers
				int numCustomers = scan.nextInt();
				
				// Who's Shopping?
				// Array of customers, their name and how many items they bought.
				customers[] shoppers = new customers[numCustomers];
				for (int i = 0; i < numCustomers; i++) {
					shoppers[i] = new customers();
					shoppers[i].first = scan.next();
					shoppers[i].last = scan.next();
					shoppers[i].numOfItemsBought = scan.nextInt(); 
					
					// What's in their cart?
					// Array of the quantity and name of the items each costumer bought
					itemsInCart[] cart = new itemsInCart[shoppers[i].numOfItemsBought];
					for (int h = 0; h < shoppers[i].numOfItemsBought; h++) {
						cart[h] = new itemsInCart();
						cart[h].quantity = scan.nextInt();
						cart[h].name = scan.next();
					}
				}
		
	}
	
	// Classes

	// in stock at the store
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
	// customers shopping at the store
		public static class customers {
			Scanner scan = new Scanner(System.in);
			
			String first;
			String last;
			int numOfItemsBought;
			
			public void firstName () {
				first = scan.next();
			}
			public void lastName () {
				last = scan.next();
			}
			public void itemsPurchased () {
				numOfItemsBought = scan.nextInt();
			}
		}
	
	// items in the carts of each customer
		public static class itemsInCart {
			Scanner scan = new Scanner(System.in);
			
			int quantity;
			String name;
			
			public void amount () {
				quantity = scan.nextInt();
			}
			public void itemName () {
				name = scan.next();
			}
			
		}
		
		
}
