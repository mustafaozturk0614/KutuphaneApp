package com.project;

import java.io.Serializable;
import java.util.List;

public class Yazar implements Serializable {

	private String isim;

	private List<Kitap> kitaplar;

	public Yazar() {
		// TODO Auto-generated constructor stub
	}

	public Yazar(String isim) {
		super();
		this.isim = isim;
	}

	public String getIsim() {
		return isim;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public List<Kitap> getKitaplar() {
		return kitaplar;
	}

	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}

	@Override
	public String toString() {
		return "Yazar [isim=" + isim + ", kitaplar=" + kitaplar + "]";
	}

}
