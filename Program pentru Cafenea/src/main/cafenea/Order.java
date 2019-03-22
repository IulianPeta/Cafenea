package main.cafenea;

public class Order {
	
	private String order = "";
	
	public synchronized void notifyEvent(String nouaComanda) {
		order = nouaComanda;
		notify();
	}
	
	public synchronized String waitForEvent() {
		while (order.equals("")) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				System.err.println("Exceptie Order!");
			}
		}
		String nouaComanda = order;
		order = "";
		return nouaComanda;
	}	
}
