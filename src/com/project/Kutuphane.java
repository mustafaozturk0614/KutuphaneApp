package com.project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Kutuphane implements Serializable {

	private List<Kitap> kitaplar;
	private Map<String, List<String>> yazarKitapListesi;
	private Map<String, List<String>> turKitapListesi;
	private List<Yazar> yazarlar;

	public Kutuphane() {
		this.kitaplar = new ArrayList<Kitap>();
		this.yazarlar = new ArrayList<Yazar>();
		this.yazarKitapListesi = new TreeMap<String, List<String>>();
		this.turKitapListesi = new TreeMap<String, List<String>>();
	}

	public List<Kitap> getKitaplar() {
		return kitaplar;
	}

	public void setKitaplar(List<Kitap> kitaplar) {
		this.kitaplar = kitaplar;
	}

	public Map<String, List<String>> getYazarKitapListesi() {
		return yazarKitapListesi;
	}

	public void setYazarKitapListesi(Map<String, List<String>> yazarKitapListesi) {
		this.yazarKitapListesi = yazarKitapListesi;
	}

	public Map<String, List<String>> getTurKitapListesi() {
		return turKitapListesi;
	}

	public void setTurKitapListesi(Map<String, List<String>> turKitapListesi) {
		this.turKitapListesi = turKitapListesi;
	}

	public List<Yazar> getYazarlar() {
		return yazarlar;
	}

	public void setYazarlar(List<Yazar> yazarlar) {
		this.yazarlar = yazarlar;
	}

	@Override
	public String toString() {
		return "Kutuphane [kitaplar=" + kitaplar + ", yazarKitapListesi=" + yazarKitapListesi + ", turKitapListesi="
				+ turKitapListesi + ", yazarlar=" + yazarlar + "]";
	}

}
