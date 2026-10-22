/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 14S
 */
/** Dimiliki hanya oleh koleksi yang punya lokasi fisik di rak. */
public interface Terarsip {
    String nomorRak();

    int lokasiLantai();

    default String ringkasanArsip() {
        return "Rak " + nomorRak() + ", Lantai " + lokasiLantai();
    }
}