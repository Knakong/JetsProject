package com.skilldistillery.jets.entities;

public class SimpleJet extends Jet {

	@Override
	public void fly() {
		System.out.println(getModel() + " flies through sky");
		
	}

	public SimpleJet(String model, double speed, double range, double price) {
		super(model, speed, range, price);

	}

	
	
	
	}
	


