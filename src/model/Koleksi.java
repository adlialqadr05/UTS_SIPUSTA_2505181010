/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 14S
 */
/** Kelas induk seluruh jenis koleksi perpustakaan. */
public abstract class Koleksi {
    private final String kode;
    private final String judul;
    private final int tahunTerbit;
    private boolean sedangDipinjam;

    protected Koleksi(String kode, String judul, int tahunTerbit) {
        this.kode = kode;
        this.judul = judul;
        this.tahunTerbit = tahunTerbit;
    }

    public String getKode() { return kode; }
    public String getJudul() { return judul; }
    public int getTahunTerbit() { return tahunTerbit; }
    public boolean isSedangDipinjam() { return sedangDipinjam; }
    public void setSedangDipinjam(boolean sedangDipinjam) { this.sedangDipinjam = sedangDipinjam; }

    /** Aturan kelayakan pinjam, berbeda untuk tiap jenis koleksi. */
    public abstract boolean layakDipinjam();

    /** Alasan yang mudah dipahami ketika koleksi tidak layak dipinjam. */
    public abstract String alasanTidakLayak();

    /** Deskripsi dasar; diperluas oleh setiap turunan memakai super. */
    public String deskripsi() {
        return String.format("[%s] \"%s\" (%d)", kode, judul, tahunTerbit);
    }
}