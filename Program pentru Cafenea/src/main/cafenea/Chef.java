package main.cafenea;

import java.awt.*;

public class Chef extends Thread{
	private Graphics g;
	private Order complete;
	private Queue queue;
	
	public Chef(Graphics g, Order complete, Queue queue) {
		this.g = g;
		this.complete = complete;
		this.queue = queue;
	}
	
	public void run() {
		g.drawString("Cooking", 200, 50);
		while(true) {
			String order = queue.remove();
			g.clearRect(200, 55, 50, 25);
			g.drawString(order, 200, 70);
			String cookedInfo = complete.waitForEvent();
			g.clearRect(200, 55, 50, 25);
		
		}
	}
}
