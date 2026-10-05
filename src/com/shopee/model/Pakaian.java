package com.shopee.model;
import com.shopee.service.Pengiriman;

public class Pakaian extends Produk implements Pengiriman {
    private String jenisPakaian;
    private String ukuran;

    public Pakaian(String namaProduk, float harga, int kuantitas,
                   String jenisPakaian, String ukuran) {
        super(namaProduk, harga, kuantitas);
        this.jenisPakaian = jenisPakaian;
        this.ukuran = ukuran;
    }

    public Pakaian() {
    }

    public String getJenisPakaian() {
        return jenisPakaian;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setJenisPakaian(String jenisPakaian) {
        this.jenisPakaian = jenisPakaian;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    @Override
    public float hitungOngkir() {
        return 12000.0f * kuantitas;
    }

    @Override
    public void kirim() {
        System.out.println("Mengirim pakaian: " + namaProduk);
    }

    @Override
    public void tampilkanData() {
        System.out.println("Jenis produk  : Pakaian");
        System.out.println("Nama produk   : " + namaProduk);
        System.out.println("Jenis pakaian : " + jenisPakaian);
        System.out.println("Ukuran        : " + ukuran);
        System.out.println("Harga         : Rp" + harga);
        System.out.println("Kuantitas     : " + kuantitas);
        System.out.println("Subtotal      : Rp" + hitungSubtotal());
    }
}