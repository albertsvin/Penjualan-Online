package com.shopee.model;

import com.shopee.service.Pengiriman;

public class Sepatu extends Produk implements Pengiriman {
    private int ukuranSepatu;

    public Sepatu(String namaProduk, float harga, int kuantitas,
                  int ukuranSepatu) {
        super(namaProduk, harga, kuantitas);
        this.ukuranSepatu = ukuranSepatu;
    }

    public Sepatu() {
    }

    public int getUkuranSepatu() {
        return ukuranSepatu;
    }

    public void setUkuranSepatu(int ukuranSepatu) {
        this.ukuranSepatu = ukuranSepatu;
    }

    @Override
    public float hitungOngkir() {
        return 18000.0f * kuantitas;
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim sepatu: " + namaProduk);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Jenis produk  : Sepatu");
        System.out.println("Nama produk   : " + namaProduk);
        System.out.println("Ukuran sepatu : " + ukuranSepatu);
        System.out.println("Harga         : Rp" + harga);
        System.out.println("Kuantitas     : " + kuantitas);
        System.out.println("Subtotal      : Rp" + hitungSubtotal());
    }
}