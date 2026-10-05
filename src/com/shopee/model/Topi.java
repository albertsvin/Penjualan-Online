package com.shopee.model;
import com.shopee.service.Pengiriman;

public class Topi extends Produk implements Pengiriman {
    private String warna;
    private String jenisTopi;

    public Topi(String namaProduk, float harga, int kuantitas,
                   String warna, String jenisTopi) {
        super(namaProduk, harga, kuantitas);
        this.warna = warna;
        this.jenisTopi = jenisTopi;
    }

    public Topi() {
    }

    public String getWarna() {
        return warna;
    }

    public String getJenisTopi() {
        return jenisTopi;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public void setJenisTopi(String jenisTopi) {
        this.jenisTopi= jenisTopi;
    }

    @Override
    public float hitungOngkir() {
        return 12000.0f * kuantitas;
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim Topi: " + namaProduk);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Jenis produk  : Topi");
        System.out.println("Nama produk   : " + namaProduk);
        System.out.println("Warna Topi : " + warna);
        System.out.println("Jenis Topi    : " + jenisTopi);
        System.out.println("Harga         : Rp" + harga);
        System.out.println("Kuantitas     : " + kuantitas);
        System.out.println("Subtotal      : Rp" + hitungSubtotal());
    }
}
    
  
