package main.cafenea;

import java.awt.*;
import java.applet.Applet;
import java.awt.event.*;

public class Cafe extends Applet implements ActionListener {
	
	
	private static final long serialVersionUID = 6507435147622754272L;
	private Button burger, fries, cola, cooked;
	private Order order, complete;
	
	public void init() {
		Graphics g = getGraphics();
		burger = new Button("Burger");
		add(burger);
		burger.addActionListener(this);
		fries = new Button("Fries");
		add(fries);
		fries.addActionListener(this);
		cola = new Button("Cola");
		add(cola);
		cola.addActionListener(this);
		cooked = new Button("Cooked");
		add(cooked);
		cooked.addActionListener(this);
		order = new Order();
		Queue queue = new Queue(g);
		complete = new Order();
		Waiter waiter = new Waiter(g, order, queue);
		waiter.start();
		Chef chef = new Chef(g, complete, queue);
		chef.start();
		
	}
	
	
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == burger)
			order.notifyEvent("burger");
		
		if (event.getSource() == fries)
			order.notifyEvent("fries");
		
		if (event.getSource() == cola)
			order.notifyEvent("cola");
		
		if (event.getSource() == cooked)
			complete.notifyEvent("cooked");	
	}
}
