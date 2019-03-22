package main.cafenea;

import java.awt.*;

public class Waiter extends Thread{
	
	private Order order;
	private Graphics g;
	private Queue queue;
	
	
	public Waiter(Graphics g, Order order, Queue queue) {
		this.order = order;
		this.g = g;
		this.queue = queue;
	}
	
	public void run() {
		while (true) {
			g.drawString("O noua comanda", 10, 50);
			String nouaComanda = order.waitForEvent();
			g.clearRect(10, 50, 50, 25);
			g.drawString(nouaComanda, 10, 70);
			try {
				Thread.sleep(3000);
			}
			catch (InterruptedException e) {
				System.err.println("Exceptie Waiter !");		
			}
			
			if (!queue.isFull()) 
				queue.enter(nouaComanda);
			
		}
	}
}
