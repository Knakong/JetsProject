package com.skilldistillery.jets.entities;

public interface CombatReady {

	default void dogFight() {
		System.out.println("Fighting the enemy");
	}
}
