package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	private Date moment;
	private OrderStatus status;
	
	private Client client;
	private List<OrderItem> itens = new ArrayList<>();
	//Construtores
	public Order() {
	
	}
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	//Getters and Setters
	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		itens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itens.remove(item);
	}
	//Calcula o total do pedido do cliente
	public Double total() {
		Double sum = 0.0;
		for(OrderItem c : itens) {
			System.out.println(c.getProduct().getName() + ", $" + c.getPrice() 
			+ ", Quantity: " + c.getQuantity() + ", Subtotal: " + c.subTotal());
			
			sum += c.subTotal(); //Adiciona o subtotal de cada produto nesta variável
		}
		System.out.print("Total price: " + sum);
		return sum;
	}

}	
