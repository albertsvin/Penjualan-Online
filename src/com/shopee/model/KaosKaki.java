package com.shopee.model;
import com.shopee.service.Pengiriman;

public class KaosKaki extends Produk implements Pengiriman {
    private String warna;
    private String bentukPola;

    public KaosKaki(String namaProduk, float harga, int kuantitas,
                   String warna, String bentukPola) {
        super(namaProduk, harga, kuantitas);
        this.warna = warna;
        this.bentukPola = bentukPola;
    }

    public KaosKaki() {
    }

    public String getWarna() {
        return warna;
    }

    public String getBentukPola() {
        return bentukPola;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setBentukPola(String bentukPola) {
        this.bentukPola = bentukPola;
    }

    @Override
    public float hitungOngkir() {
        return 12000.0f * kuantitas;
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim Kaos Kaki: " + namaProduk);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Jenis produk  : Kaos Kaki");
        System.out.println("Nama produk   : " + namaProduk);
        System.out.println("Warna Kaos Kaki : " + warna);
        System.out.println("Pola        : " + bentukPola);
        System.out.println("Harga         : Rp" + harga);
        System.out.println("Kuantitas     : " + kuantitas);
        System.out.println("Subtotal      : Rp" + hitungSubtotal());
    }
}
    
  
