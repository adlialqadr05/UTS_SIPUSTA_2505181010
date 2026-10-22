/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 14S
 */
public class Majalah extends KoleksiPerpustakaan implements Terarsip {
    private final int edisi;
    private final String bulanTerbit;
    private final boolean edisiTerbaru;
    private final String nomorRak;
    private final int lantai;

    public Majalah(String kode, String judul, int tahunTerbit, int edisi, String bulanTerbit,
                   boolean edisiTerbaru, String nomorRak, int lantai) {
        super(kode, judul, tahunTerbit);
        this.edisi = edisi;
        this.bulanTerbit = bulanTerbit;
        this.edisiTerbaru = edisiTerbaru;
        this.nomorRak = nomorRak;
        this.lantai = lantai;
    }

    public int getEdisi() { return edisi; }
    public String getBulanTerbit() { return bulanTerbit; }
    public boolean isEdisiTerbaru() { return edisiTerbaru; }

    @Override
    public boolean layakDipinjam() { return !edisiTerbaru; }

    @Override
    public String alasanTidakLayak() { return "majalah ini adalah edisi terbaru dan hanya boleh dibaca di perpustakaan"; }

    @Override
    public String nomorRak() { return nomorRak; }

    @Override
    public int lokasiLantai() { return lantai; }

    @Override
    public String deskripsi() {
        return super.deskripsi() + " | Majalah, edisi " + edisi + " (" + bulanTerbit + ") | " + ringkasanArsip();
    }
}