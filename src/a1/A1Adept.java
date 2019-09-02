package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Number of Items in the Store
		int numItems = scan.nextInt();
		
		// What's in stock at the store? 
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
				
				for (int j = 0; j < stock.length; j++) {
					if (personalCart[h].title.contentEquals(stock[j].name)) {
						personalCart[h].price = personalCart[h].cost(stock[j].price);
					} 
				}
			}

			/* for (int k = 0; k < personalCart.length; k++) {
				customerList[i].totalcost += personalCart[k].price;
			} */
	// Finding the total
			customerList[i].totalcost = totalCost(customerList[i].cart, personalCart, stock);
	
		}
		
		scan.close();
		

		// Biggest spender
		Customers big = everybodyEats(customerList);
		System.out.println("Biggest: " + big.first + " " + big.last + " (" + String.format("%.2f", big.totalcost) + ")");
		
		// Smallest spender
		Customers little = couponQueen(customerList);
		System.out.println("Smallest: " + little.first + " " + little.last + " (" + String.format("%.2f", little.totalcost) + ")");
		
		// Average
		double avg = 0;
		for (int i = 0; i < numCustom; i++) {
			avg += customerList[i].totalcost;
		}
		avg = avg / customerList.length;
		System.out.println("Average: " + String.format("%.2f", avg));
		
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
		public double money (int numOfItems, itemsInCart[] personalCart, itemsInStore[] stock) {
			double total = 0;
			for (int i = 0; i < numOfItems; i++) {
				for (int h = 0; h < stock.length; h++) {
					if (personalCart[i].title == stock[h].name) {
						total = total + (personalCart[i].quantity * stock[h].price);
					}
				} 	
			}
			return total;
		}
	
	}
	
	 public static class itemsInCart {
		Scanner scan = new Scanner(System.in);
		
		int quantity;
		String title;
		double price = 0;
		
		public void amount () {
			quantity = scan.nextInt();
		}
		public void whatsItCalled () {
			title = scan.next();
		}
		public double cost (double stockPrice) {
			price = stockPrice;
			return price;
		} 
	} 
	
	// Functions
	
	// total cost for each shopper
	static double totalCost (int numOfItems, itemsInCart[] personalCart, itemsInStore[] stock) {
		double total = 0;
		for (int i = 0; i < numOfItems; i++) {
			for (int h = 0; h < stock.length; h++) {
				if (personalCart[i].title.contentEquals(stock[h].name)) {
					total = total + (personalCart[i].quantity * stock[h].price);
				}
			} 
		}
		return total;
	}
	
	
	// biggest spender 
	static Customers everybodyEats (Customers[] shoppers) {
		Customers big = shoppers[0];
		for (int i = 1; i < shoppers.length; i++) {
			if (shoppers[i].totalcost > shoppers[i - 1].totalcost) {
				big = shoppers[i];
			}
		}
		return big;
	}
	
	// least spender 
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
