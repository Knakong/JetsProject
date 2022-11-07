package com.skilldistillery.jets.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

public class Airfield {

	private ArrayList<Jet> fleet = new ArrayList<Jet>();
	
	
	


	public void setFleet(ArrayList<Jet> fleet) {
		this.fleet = fleet;
	}

	public ArrayList<Jet> getFleet() {
		return fleet;
	}

	public void loadPlanes() {
		ArrayList<Jet> fleet = new ArrayList<Jet>();

		BufferedReader bufIn = null;
		try {
			bufIn = new BufferedReader(new FileReader("jets.txt"));
			String line;
			while ((line = bufIn.readLine()) != null) {
				String jetRecord[] = line.split(", ");
				

				String model = jetRecord[0];
				double speed = (Double.parseDouble(jetRecord[1]));
				double range = (Double.parseDouble(jetRecord[2]));
				double price = (Double.parseDouble(jetRecord[3]));

				switch (model) {
				case "Cargo":
					fleet.add(new CargoPlane(model, speed, range, price));

					break;

				case "CargoAttack":
					fleet.add(new CargoAttackPlane(model, speed, range, price));
					break;

				case "Fighter":
					fleet.add(new FighterJet(model, speed, range, price));

					break;
				case "FighterJammer":
					fleet.add(new JammerFighterJet(model, speed, range, price));

					break;
				case "CargoSpy":
					fleet.add(new CargoSpyPlane(model, speed, range, price));

					break;
				case "SimpleJet":

					fleet.add(new SimpleJet(model, speed, range, price));
					

					break;
				case "Jammer":
					fleet.add(new JammerJet(model, speed, range, price));

					break;

				}

			}
		} catch (IOException e) {
			System.err.println(e);
		} finally {
			if (bufIn != null) {
				try {
					bufIn.close();
				} catch (IOException e) {
					System.err.println(e);
				}
			}
		}
		this.fleet = fleet;

	}

	@Override
	public int hashCode() {
		return Objects.hash(fleet);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Airfield other = (Airfield) obj;
		return Objects.equals(fleet, other.fleet);
	}
	
	
	public void getMaxRange() {
		TreeSet<Object> treeSet = new TreeSet<>();
		treeSet.addAll(getFleet());
		
		System.out.println(treeSet);
			
		}
	}
	

