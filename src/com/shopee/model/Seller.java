package com.shopee.model;

public class Seller {
    private String namaToko;
    private String alamatToko;
    private String noHPToko;

    public Seller(String namaToko, String alamatToko, String noHPToko) {
        this.namaToko = namaToko;
        this.alamatToko = alamatToko;
        this.noHPToko = noHPToko;
    }

    public Seller() {
    }

    public String getNamaToko() {
        return namaToko;
    }

    public String getAlamatToko() {
        return alamatToko;
    }

    public String getNoHPToko() {
        return noHPToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public void setAlamatToko(String alamatToko) {
        this.alamatToko = alamatToko;
    }

    public void setNoHPToko(String noHPToko) {
        this.noHPToko = noHPToko;
    }
}