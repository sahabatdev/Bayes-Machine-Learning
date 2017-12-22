package com.sahabatdeveloper.bayes;

/**
 * Created by Sahabat Developer on 25/10/2017.
 */

public class Pertanyaan {
    String judul;
    int jumlah;
    int jumlahNo;

    public Pertanyaan(String judul, int jumlah, int jumlahNo) {
        this.judul = judul;
        this.jumlah = jumlah;
        this.jumlahNo = jumlahNo;
    }

    public int getJumlahNo() {
        return jumlahNo;
    }

    public void setJumlahNo(int jumlahNo) {
        this.jumlahNo = jumlahNo;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }
}
