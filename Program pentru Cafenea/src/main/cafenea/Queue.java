package main.cafenea;

import java.awt.*;

public class Queue {

	private Graphics g;
	private String[] queue = new String[20];
	private int count = 0;
	
	public Queue(Graphics g) {
		this.g = g;
	}
	
	public synchronized void enter(String item) {
		queue[count] = item;
		count++;
		display();
		notify();
	}
	
	public synchronized String remove() {
		while(count == 0)
			try {
				wait();
			}
			catch (InterruptedException e) {
				System.err.println("Exceptie Queue!");
			}
		String item = queue[0];
		count--;
		for(int c = 0; c < count; c++)
			queue[c] = queue[c + 1];
		display();
		return item;
	}
	
	public synchronized boolean isFull() {
		return count == queue.length;
	}
	
	private void display() {
		g.drawString("Coada", 120, 50);
		g.clearRect(120, 50, 50, 220);
		for (int c = 0; c < count; c++)
			g.drawString(queue[c], 120, 70 + c * 20);
	}
}
