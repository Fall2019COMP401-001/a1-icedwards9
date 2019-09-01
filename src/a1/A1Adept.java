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
			// What's in their cart?
			itemsInCart[] personalCart = new itemsInCart[customerList[i].cart];
			for (int h = 0; h < customerList[i].cart; h++) {
				personalCart[h] = new itemsInCart();
				personalCart[h].quantity = scan.nextInt();
				personalCart[h].title = scan.next();
			}
			// Finding the total
			double[] totals = new double[numCustom];
			totals[i] = totalCost(customerList[i].cart, personalCart, stock);
			customerList[i].totalcost = totals[i];
		}
		
		scan.close();
		
		// Finding the total for each customer
		

		// Biggest spender
		Customers big = everybodyEats(customerList);
		System.out.println("Biggest: " + big.first + " " + big.last + " " + big.totalcost);
		
		// Smallest spender
		Customers little = couponQueen(customerList);
		System.out.println("Smallest: " + little.first + " " + little.last + " " + little.totalcost);
		
		// Average
		int avg = 0;
		for (int i = 0; i < numCustom; i++) {
			avg += customerList[i].totalcost;
		}
		avg = avg / customerList.length;
		System.out.println("Average: " + avg);
		
	}

	// Classes 
	
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
		double totalcost;
		
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
	
	// Functions
	
	// total cost for each shopper
	static double totalCost (int numOfItems, itemsInCart[] personalCart, itemsInStore[] stock) {
		double total = 0;
		for (int i = 0; i < numOfItems; i++) {
			// figure out how to match the name of the items in the cart with that of the items in the store.
			// may have something ton do with the i in the for loop
			for (int h = 0; h < stock.length; h++) {
				if (personalCart[i].title == stock[h].name) {
					total += (personalCart[i].quantity * stock[h].price);
				}
			} // not totally sure about this yet
		}
		return total;
	}
	
	// average money spend across ALL shoppers (requires array of each customer's total in main)
	static double average (double[] all) {
		double total = 0;
		for (int i = 0; i < all.length; i++) {
			total += all[i];
		}
		return (total / all.length);
	}
	
	// biggest spender (also requires array of each total)
	static Customers everybodyEats (Customers[] shoppers) {
		Customers big = shoppers[0];
		for (int i = 1; i < shoppers.length; i++) {
			if (shoppers[i].totalcost > shoppers[i - 1].totalcost) {
				big = shoppers[i];
			}
		}
		return big;
	}
	
	// least spender (same as above)
	static Customers couponQueen (Customers[] shoppers) {
		Customers least = shoppers[0];
		for (int i = 1; i < shoppers.length; i++) {
			if (shoppers[i].totalcost < shoppers[i - 1].totalcost) {
				least = shoppers[i];
			}
		}
		return least;
	}
	
}
