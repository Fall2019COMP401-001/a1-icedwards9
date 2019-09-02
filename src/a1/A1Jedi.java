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
		
		// boolean
		boolean hasBought = false; // <-- Why is default value false?
		
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
		//	itemStats[] stats = new itemStats[numItems];
			for (int h = 0; h < shoppers[i].numOfItemsBought; h++) {
				cart[h] = new itemsInCart();
				cart[h].quantity = scan.nextInt();
				cart[h].name = scan.next();
				}
		
			// next
			for (int j = 0; j < numItems; j++) {
	
				for (int k = 0; k < shoppers[i].numOfItemsBought; k++) {
					if (stock[j].name.contentEquals(cart[k].name)) {
						if (hasBought) {
							stock[j].numBought += cart[k].quantity;
							
						} else {
							stock[j].numPeople++;
							stock[j].numBought += cart[k].quantity;
							hasBought = true;
						}
						
					} else {
						hasBought = false;
					}
				}
				
							
			}
			

		}
		
		
		scan.close();
		
		for (int i = 0; i < numItems; i++) {
			if (stock[i].numBought == 0) {
				System.out.println("No customers bought " + stock[i].name);
			} else {
				System.out.println(stock[i].numPeople + " customers bought " + stock[i].numBought + " " + stock[i].name);
			}
		}
		
		
		
				
		
	}
	
	// Classes

	// in stock at the store
		public static class itemsInStore {
			Scanner scan = new Scanner(System.in);
			
			String name;
			double price;
			int numBought;
			int numPeople;
			
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
			itemsInCart[] personalCart;
			
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
	// the number of customers who bought a certain item and the amount bought
		public static class itemStats {
			
			int numCustomers = 0;
			int numBought = 0;
			
			/* public void numberOfPeople (int num) {
				numCustomers = num;
			}
			public void numberItemsBought (int num) {
				numBought = num;
			} */
			// do these need constructors?
			// should they be initialized to zero?
		}
		
		
}
