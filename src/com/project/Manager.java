package com.project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manager {

	Kutuphane kutuphane;

	public Manager() {
		kutuphane = new Kutuphane();
	}

	public void veriTabanıOlustur() {

		String kontrol = kontrol();
		System.out.println(kontrol);

		if (kontrol.equalsIgnoreCase("0")) {
			BufferedWriter bufferedWriter = null;
			try {
				bufferedWriter = new BufferedWriter(new FileWriter(FileUtil.kontrolPath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("İlk defa Çalıştım");
			okuma(FileUtil.IlkDegerOkumaPath);
			serilestir();
			try {
				bufferedWriter.write("1");
				bufferedWriter.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			System.out.println("Daha Önce Çalışmıstım");
			deserialize();
		}

	}

	public String kontrol() {
		BufferedReader reader = null;
		String deger = "";
		try {
			reader = new BufferedReader(new FileReader(FileUtil.kontrolPath));
			deger = reader.readLine();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deger;
	}

	public void okuma(String path) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			String deger = "";
			while ((deger = reader.readLine()) != null) {
				String[] array = deger.split(",");

				Kitap kitap = new Kitap(array[0], array[1], array[2]);
				kutuphane.getKitaplar().add(kitap);

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void serilestir() {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(new FileOutputStream(FileUtil.ikinciDegerOkumaPath, true));
			for (Kitap kitap : kutuphane.getKitaplar()) {
				objectOutputStream.writeObject(kitap);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deserialize() {
		FileInputStream dosya = null;
		try {
			dosya = new FileInputStream("kitap.txt");
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		}
		ObjectInputStream oku = null;
		try {
			oku = new ObjectInputStream(dosya);
		} catch (IOException e1) {

			e1.printStackTrace();
		}
		Kitap kitap = null;
		boolean kontrol = true;

		do {
			try {
				while ((kitap = (Kitap) oku.readObject()) != null) {
					kutuphane.getKitaplar().add(kitap);
				}

			} catch (Exception e) {
				System.out.println("null eklenemez");
				kontrol = false;
			}

		} while (kontrol);
	}

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.veriTabanıOlustur();

		manager.kutuphane.getKitaplar().forEach(System.out::println);

	}
}
