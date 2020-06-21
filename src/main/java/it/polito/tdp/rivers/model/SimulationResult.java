package it.polito.tdp.rivers.model;

public class SimulationResult {

	
	double avgC;
	int numeroDiGiorni;

	public SimulationResult(double avgC, int numeroDiGiorni) {
		super();
		this.avgC = avgC;
		this.numeroDiGiorni = numeroDiGiorni;
	}

	public double getAvgC() {
		return avgC;
	}

	public void setAvgC(double avgC) {
		this.avgC = avgC;
	}

	public int getNumeroDiGiorni() {
		return numeroDiGiorni;
	}

	public void setNumeroDiGiorni(int numeroDiGiorni) {
		this.numeroDiGiorni = numeroDiGiorni;
	}
	
	
}
