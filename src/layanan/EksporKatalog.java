/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package layanan;
import model.KoleksiPerpustakaan;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
/**
 *
 * @author 14S
 */
public class EksporKatalog {

    public void ekspor(KatalogPerpustakaan katalog, String namaBerkas) throws IOException {
        List<KoleksiPerpustakaan> daftar = katalog.getDaftar();

        int lebarJudul = "Judul".length();
        for (KoleksiPerpustakaan k : daftar) {
            lebarJudul = Math.max(lebarJudul, k.getJudul().length());
        }
        String format = "%-8s %-14s %-" + lebarJudul + "s %-6s %-12s %-9s%n";

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(namaBerkas)))) {
            out.printf(format, "Kode", "Jenis", "Judul", "Tahun", "Layak", "Status");
            out.println("-".repeat(8 + 1 + 14 + 1 + lebarJudul + 1 + 6 + 1 + 12 + 1 + 9));
            for (KoleksiPerpustakaan k : daftar) {
                out.printf(format,
                        k.getKode(),
                        k.getClass().getSimpleName(),
                        k.getJudul(),
                        k.getTahunTerbit(),
                        k.layakDipinjam() ? "Ya" : "Tidak",
                        k.isSedangDipinjam() ? "Dipinjam" : "Tersedia");
            }
        }
    }
}