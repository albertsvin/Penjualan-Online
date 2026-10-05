package com.shopee.core;

import java.util.ArrayList;

import com.shopee.model.Buyer;
import com.shopee.model.Seller;
import com.shopee.model.MetodePembayaran;
import com.shopee.model.Produk;

public class Penjualan {
    private static final int BATAS_PER_PRODUK = 30;
    private static final int BATAS_PER_TRANSAKSI = 100;

    private String noPesanan;
    private String tanggal;
    private Buyer pembeli;
    private Seller penjual;
    private MetodePembayaran metode;
    private ArrayList<Produk> listProduk;

    public Penjualan(String noPesanan, String tanggal, Buyer pembeli,
                      Seller penjual, MetodePembayaran metode) {
        this.noPesanan = noPesanan;
        this.tanggal = tanggal;
        this.pembeli = pembeli;
        this.penjual = penjual;
        this.metode = metode;
        this.listProduk = new ArrayList<>();
    }

    public Penjualan() {
        this.listProduk = new ArrayList<>();
    }

    public String getNoPesanan() {
        return noPesanan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public Buyer getPembeli() {
        return pembeli;
    }

    public Seller getPenjual() {
        return penjual;
    }

    public MetodePembayaran getMetode() {
        return metode;
    }

    public ArrayList<Produk> getListProduk() {
        return listProduk;
    }

    public void setNoPesanan(String noPesanan) {
        this.noPesanan = noPesanan;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setPembeli(Buyer pembeli) {
        this.pembeli = pembeli;
    }

    public void setPenjual(Seller penjual) {
        this.penjual = penjual;
    }

    public void setMetode(MetodePembayaran metode) {
        this.metode = metode;
    }

    public void setListProduk(ArrayList<Produk> listProduk) {
        this.listProduk = listProduk;
    }

    public void addProduk(Produk produk) {
        if (produk == null) {
            throw new IllegalArgumentException("Produk tidak boleh null.");
        }

        int kuantitas = produk.getKuantitas();
        if (kuantitas <= 0) {
            throw new IllegalArgumentException("Kuantitas harus lebih dari 0.");
        }
        if (kuantitas > getSisaKuantitasProduk(produk.getClass())) {
            throw new IllegalArgumentException(
                    "Maksimal pembelian untuk jenis produk ini adalah "
                    + BATAS_PER_PRODUK + " barang per transaksi."
            );
        }
        if (kuantitas > getSisaKuantitasTransaksi()) {
            throw new IllegalArgumentException(
                    "Maksimal total pembelian dalam satu transaksi adalah "
                    + BATAS_PER_TRANSAKSI + " barang."
            );
        }

        listProduk.add(produk);
    }

    public int getSisaKuantitasProduk(Class<? extends Produk> jenisProduk) {
        int totalJenisProduk = 0;
        for (Produk produk : listProduk) {
            if (jenisProduk.isInstance(produk)) {
                totalJenisProduk += produk.getKuantitas();
            }
        }
        return Math.max(0, BATAS_PER_PRODUK - totalJenisProduk);
    }

    public int getSisaKuantitasTransaksi() {
        int totalKuantitas = 0;
        for (Produk produk : listProduk) {
            totalKuantitas += produk.getKuantitas();
        }
        return Math.max(0, BATAS_PER_TRANSAKSI - totalKuantitas);
    }
}