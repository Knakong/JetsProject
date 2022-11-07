package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.skilldistillery.jets.entities.Airfield;
import com.skilldistillery.jets.entities.CargoPlane;
import com.skilldistillery.jets.entities.CombatReady;
import com.skilldistillery.jets.entities.Jet;
import com.skilldistillery.jets.entities.SimpleJet;

public class JetsApplication {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		JetsApplication app = new JetsApplication();

		app.run();
	}

	void run() {
		Airfield airfield = new Airfield();
		airfield.loadPlanes();
		ArrayList<Jet> fleet = airfield.getFleet();
		System.out.println(fleet);
		boolean isOn = true;
		while (isOn) {
			System.out.println("1. List Fleet");
			System.out.println("2. Fly all Jets");
			System.out.println("3. View Fastest Jet");
			System.out.println("4. View Jet with Longest Range");
			System.out.println("5. Load all Cargo Jets");
			System.out.println("6. Dog Fight");
			System.out.println("7. Add a jet to Fleet");
			System.out.println("8. Remove a Jet from Fleet");
			System.out.println("9. Quit");

			int input = sc.nextInt();

			switch (input) {
			case 1:
				System.out.println(fleet);
				break;
			case 2:
				fly(fleet);
				break;
			case 3:
				fastest(fleet);
				break;
			case 4:
				longestRange(fleet);
				break;
			case 5:
				loadCargo(fleet);
				break;
			case 6:
				dogFight(fleet);
				break;
			case 7:

				addJet(fleet);
				break;
			case 8:
				removeJet(fleet);

				break;
			case 9:
				System.out.println("GoodBye");
				System.exit(0);
			}

		}

	}

	void removeJet(ArrayList<Jet> fleet) {
		sc.nextLine();
		System.out.println(fleet);

		System.out.println("First Jet is position Zero. Which Jet postion would you like to remove?");

		String input = sc.nextLine();

		if (input.equalsIgnoreCase("Quit")) {
			System.exit(0);
		} else {
			int position = Integer.parseInt(input);
			fleet.remove(position);
		}

	}

	void dogFight(ArrayList<Jet> fleet) {
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).dogFight();
			}
		}

	}

	void addJet(ArrayList<Jet> fleet) {
		System.out.println("Adding SimpleJet to Fleet");
		System.out.println("What is the Speed");
		double speed = sc.nextDouble();
		sc.nextLine();
		System.out.println("What is the Range");
		double range = sc.nextDouble();
		System.out.println("What is the price");
		double price = sc.nextDouble();

		fleet.add(new SimpleJet("SimpleJet", speed, range, price));

	}

	void loadCargo(ArrayList<Jet> fleet) {
		for (Jet jet : fleet) {
			if (jet instanceof CargoPlane) {
				((CargoPlane) jet).loadCargo();
			}
		}
	}

	void longestRange(ArrayList<Jet> fleet) {
		double max = 0;
		String mostRange = null;
		for (Jet jet : fleet) {
			if (jet.getRange() > max) {
				max = jet.getRange();
				mostRange = jet.toString();
			}

		}

		System.out.println("Most Range: " + mostRange);
	}

	void fastest(ArrayList<Jet> fleet) {
		double max = 0;
		String fastest = null;
		for (Jet jet : fleet) {
			if (jet.getSpeed() > max) {
				max = jet.getSpeed();
				fastest = jet.toString();

			}

		}

		System.out.println("Fastest: " + fastest);
	}

	void fly(ArrayList<Jet> fleet) {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}
}
