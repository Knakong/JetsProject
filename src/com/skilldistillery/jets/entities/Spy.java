package com.skilldistillery.jets.entities;

public interface Spy{

	default void spy() {
		System.out.println("Spies on enemies");
	}

	
}
