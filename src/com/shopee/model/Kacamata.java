package com.shopee.model;
import com.shopee.service.Pengiriman;

public class Kacamata extends Produk implements Pengiriman {
    private String warna;
    private String tipeLensa;

    public Kacamata(String namaProduk, float harga, int kuantitas,
                   String warna, String tipeLensa) {
        super(namaProduk, harga, kuantitas);
        this.warna = warna;
        this.tipeLensa = tipeLensa;
    }

    public Kacamata() {
    }

    public String getWarna() {
        return warna;
    }

    public String getTipeLensa() {
        return tipeLensa;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setTipeLensa(String tipeLensa) {
        this.tipeLensa = tipeLensa;
    }

    @Override
    public float hitungOngkir() {
        return 12000.0f * kuantitas;
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim Kacamata: " + namaProduk);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Jenis produk  : Kacamata");
        System.out.println("Nama produk   : " + namaProduk);
        System.out.println("Warna Kacamata : " + warna);
        System.out.println("Tipe Lensa        : " + tipeLensa);
        System.out.println("Harga         : Rp" + harga);
        System.out.println("Kuantitas     : " + kuantitas);
        System.out.println("Subtotal      : Rp" + hitungSubtotal());
    }
}
    
