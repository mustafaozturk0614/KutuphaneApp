package com.project;

public enum ETur {

	KURGUDISI("Kurgu Dýþý"), ROMAN("Roman"), SIIR("Þiir");

	String tur;

	ETur(String tur) {
		this.tur = tur;
	}

	public String getTur() {
		return tur;
	}

	public void setTur(String tur) {
		this.tur = tur;
	}

	public ETur getTur(String tur) {

		ETur[] turler = ETur.values();

		if (tur.equalsIgnoreCase(turler[0].tur)) {
			return turler[0];
		} else if (tur.equalsIgnoreCase(turler[1].tur)) {

			return turler[1];
		} else {
			return turler[2];
		}

	}

}
