/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;

import eksepsi.KoleksiSedangDipinjamException;
import eksepsi.KoleksiTidakLayakException;
import eksepsi.PustakaException;
import model.Koleksi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author 14S
 */
public class KatalogPerpustakaan {
    private final List<Koleksi> daftar = new ArrayList<>();

    public void tambah(Koleksi koleksi) {
        daftar.add(koleksi);
    }

    public List<Koleksi> getDaftar() {
        return Collections.unmodifiableList(daftar);
    }

    /** Memproses semua koleksi secara polimorfik, tanpa pengecekan tipe. */
    public void cetakStatus() {
        for (Koleksi k : daftar) {
            String layak = k.layakDipinjam() ? "LAYAK" : "TIDAK LAYAK";
            String dipinjam = k.isSedangDipinjam() ? "Dipinjam" : "Tersedia";
            System.out.println(k.deskripsi());
            System.out.println("    Status: " + layak + " | " + dipinjam);
        }
    }

    /** Aturan pengurutan ditentukan dari luar lewat Comparator. */
    public void urut(Comparator<? super Koleksi> pembanding) {
        daftar.sort(pembanding);
    }

    public void pinjam(String kode) throws PustakaException {
        Koleksi k = cari(kode);
        if (k.isSedangDipinjam()) {
            throw new KoleksiSedangDipinjamException(k.getJudul());
        }
        if (!k.layakDipinjam()) {
            throw new KoleksiTidakLayakException(k.getJudul(), k.alasanTidakLayak());
        }
        k.setSedangDipinjam(true);
    }

    public void kembalikan(String kode) throws PustakaException {
        cari(kode).setSedangDipinjam(false);
    }

    private Koleksi cari(String kode) throws PustakaException {
        for (Koleksi k : daftar) {
            if (k.getKode().equalsIgnoreCase(kode)) {
                return k;
            }
        }
        throw new PustakaException("Koleksi dengan kode \"" + kode + "\" tidak ditemukan di katalog.");
    }
}
