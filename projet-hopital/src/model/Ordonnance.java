package model;

import java.util.ArrayList;

public class Ordonnance {

	private String patient;
	private int totalOrdonnance;
	private ArrayList<LigneMedicament> ligneMedicament;

	public Ordonnance(String patient) {
		this.patient = patient;
		this.ligneMedicament = new ArrayList<LigneMedicament>();
	}

	public String getPatient() {
		return patient;
	}

	public int getTotalOrdonnance() {
		return totalOrdonnance;
	}

	public ArrayList<LigneMedicament> getLigneMedicament() {
		return ligneMedicament;
	}

	public void setLigneMedicament (LigneMedicament ligneMedicament) {
		this.ligneMedicament.add(ligneMedicament);
		totalOrdonnance += ligneMedicament.getTotal();
	}

	@Override
	public String toString() {
		return "Ordonnance [patient=" + patient + ", totalOrdonnance=" + totalOrdonnance + ", ligneMedicament="
				+ ligneMedicament + "]";
	}

}
