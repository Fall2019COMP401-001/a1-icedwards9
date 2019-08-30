package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		

		// Your code follows here.
		int numCustom = scan.nextInt();
		Customer[] customerList = new Customer[numCustom];
		double[] total = new double[3];

		for (int i = 0; i < numCustom; i++) {
			customerList[i] = new Customer();
			customerList[i].firstName = scan.next();
			customerList[i].lastName = scan.next();
			customerList[i].numberItems = scan.nextInt();
			items[] itemsList = new items[customerList[i].numberItems];

			for (int h = 0; h < customerList[i].numberItems; h++) {
				// items[] itemsList = new items[customerList[i].numberItems];
				itemsList[h] = new items();
				itemsList[h].quantity = scan.nextInt();
				itemsList[h].name = scan.next();
				itemsList[h].price = scan.nextDouble(); 
			}
			customerList[i].totalCost = calculateTotal(customerList[i].numberItems, itemsList);

		}
		
		
		
		
		
		scan.close();
		
		for (int i = 0; i < numCustom; i++) {
			System.out.println(customerList[i].firstName.charAt(0) + ". " + customerList[i].lastName + ": " + String.format("%.2f", customerList[i].totalCost));
		}
		// System.out.println(~F. LAST: TOTAL)
		// System.out.println(customerList[i].firstName.charAt(0) + ". " + customer[Lis])
		
		
		
		
		
		
		
		
	// calculate total price of all items
		/* for (int i = 0; i < numI; i++) {
			sum = sum + itemsList[i].quantity * itemsList[i].price;
			
		} 
		
		
		for (int i = 0; i < numCustom; i++) {
			customerList[i].firstName = 
			char initial = customerList[i].firstName.charAt(0);
			String surname = customerList[i].lastName;
			
			
			for (int h = 0; h < numI; h++) {
				double sum = sum + itemsList[h].quantity * itemsList[h].price;
				double total = 
				System.out.println(initial + ". " + surname + sum);

			}
		} */
		
		
		
			
	
		
		// System.out.println(~F. LAST: TOTAL)
		
		
	}
	static double calculateTotal (int numOfItems, items[] cart) {
		double total = 0;
		for (int i = 0; i < numOfItems; i++) {
			total += (cart[i].quantity * cart[i].price);
		}
		return total;
	}
	
	
	public static class Customer {
		Scanner scan = new Scanner(System.in);

		String firstName; // = scan.next();
		String lastName; // = scan.next();
		int numberItems; // = scan.nextInt();
		double totalCost;
		
		/* public void sum () {
			totalCost = calculateTotal ()
		} */
		
		public void cusName (String input) {
			firstName = (input);
		}
		public void cusLastName () {
			lastName = scan.next();
		}
		public void cusItems () {
			this.numberItems = scan.nextInt();
		}
		
		
	}
	public static class items {
		Scanner scan = new Scanner(System.in);

		int quantity; // = scan.nextInt();
		String name; // = scan.next();
		double price; // = scan.nextDouble();
		
		public void count () {
			quantity = scan.nextInt();
		}
		public void brand () {
			name = scan.next();
		}
		public void cost () {
			price = scan.nextDouble();
		}
		
	}
		
}
