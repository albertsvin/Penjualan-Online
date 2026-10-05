package com.shopee.model;

public abstract class Produk {
    protected String namaProduk;
    protected float harga;
    protected int kuantitas;

    public Produk(String namaProduk, float harga, int kuantitas) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.kuantitas = kuantitas;
    }

    public Produk() {
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public float getHarga() {
        return harga;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public void setKuantitas(int kuantitas) {
        this.kuantitas = kuantitas;
    }

    public float hitungSubtotal() {
        return harga * kuantitas;
    }

    public abstract void tampilkanData();
}