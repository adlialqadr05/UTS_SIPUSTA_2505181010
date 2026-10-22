/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 14S
 */
public class BukuCetak extends KoleksiPerpustakaan implements Terarsip {
    private final int jumlahHalaman;
    private final String nomorRak;
    private final int lantai;
    private final boolean sedangDiperbaiki;

    public BukuCetak(String kode, String judul, int tahunTerbit, int jumlahHalaman,
                     String nomorRak, int lantai, boolean sedangDiperbaiki) {
        super(kode, judul, tahunTerbit);
        this.jumlahHalaman = jumlahHalaman;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
        this.sedangDiperbaiki = sedangDiperbaiki;
    }

    public int getJumlahHalaman() { return jumlahHalaman; }
    public boolean isSedangDiperbaiki() { return sedangDiperbaiki; }

    @Override
    public boolean layakDipinjam() { return !sedangDiperbaiki; }

    @Override
    public String alasanTidakLayak() { return "buku ini sedang diperbaiki"; }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public int lokasiLantai() { return lantai; }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Buku Cetak, " + jumlahHalaman + " halaman | " + ringkasanArsip();
    }
}