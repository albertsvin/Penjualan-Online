package com.shopee.model;

public class MetodePembayaran {
    private String jenisPembayaran;
    private float biayaLayanan;

    public MetodePembayaran(String jenisPembayaran, float biayaLayanan) {
        this.jenisPembayaran = jenisPembayaran;
        this.biayaLayanan = biayaLayanan;
    }

    public MetodePembayaran() {
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public float getBiayaLayanan() {
        return biayaLayanan;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public void setBiayaLayanan(float biayaLayanan) {
        this.biayaLayanan = biayaLayanan;
    }
}