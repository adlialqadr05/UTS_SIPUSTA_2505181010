/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import model.KoleksiPerpustakaan;

import java.util.Comparator;

/**
 *
 * @author 14S
 */
/** Koleksi layak pinjam tampil lebih dulu, lalu diurutkan berdasarkan judul. */
public class UrutLayakLaluJudul implements Comparator<KoleksiPerpustakaan> {
    private final Comparator<KoleksiPerpustakaan> berlapis =
            Comparator.comparing(KoleksiPerpustakaan::layakDipinjam, Comparator.reverseOrder())
                      .thenComparing(KoleksiPerpustakaan::getJudul, String.CASE_INSENSITIVE_ORDER);

    @Override
    public int compare(KoleksiPerpustakaan a, KoleksiPerpustakaan b) {
        return berlapis.compare(a, b);
    }
}