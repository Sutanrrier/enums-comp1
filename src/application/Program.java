package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		//Criando o pedido
		System.out.println("Enter client Data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth Date (DD/MM/YYYY): ");
		Date birthdate = sdf.parse(sc.nextLine());
		
		System.out.println("Enter the order data: ");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthdate));
		
		//Criando os items do pedido do cliente
		System.out.print("How many itens to this order: ");
		int n = sc.nextInt(); //Candidate de itens no pedido
		for(int i=1;i<=n;i++) {
			sc.nextLine();
			System.out.println("Enter the #" + i + " item data: ");
			System.out.print("Product Name: ");
			String itemName = sc.nextLine();
			System.out.print("Product price: ");
			Double itemPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int itemQt =sc.nextInt();
			OrderItem item = new OrderItem(itemQt, itemPrice, new Product(itemName, itemPrice));
			order.addItem(item);
		}
		//IMPRIME TODAS AS INFORMAÇÕES NA TELA
		System.out.println("");
		System.out.println("ORDER SUMMARY: ");
		System.out.println("Order Moment: " + sdf2.format(order.getMoment()));
		System.out.println("Order Staus: " + order.getStatus());
		System.out.println("Client: " + order.getClient().getName() + 
				" (" + sdf.format(order.getClient().getBirthDate()) + ") - " + order.getClient().getEmail());
		System.out.println("Order Items: ");
		order.total(); //Mostra os pedidos e o valor total deles;
		
		sc.close();
	}
}
