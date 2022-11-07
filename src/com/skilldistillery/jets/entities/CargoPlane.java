package com.skilldistillery.jets.entities;

public class CargoPlane extends Jet {
	
	public CargoPlane(String model, double speed, double range, double price) {
		super(model, speed, range, price);
		
	}

	@Override
	public void fly() {
		System.out.println(getModel() + " flies through the sky");
		
	}
	
	public void loadCargo(){
	System.out.println(" Cargo Loaded");
	
	}

	
	
	}


