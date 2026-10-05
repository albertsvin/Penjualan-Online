package com.shopee;

import com.shopee.core.Penjualan;
import com.shopee.model.Buyer;
import com.shopee.model.Kacamata;
import com.shopee.model.KaosKaki;
import com.shopee.model.MetodePembayaran;
import com.shopee.model.Pakaian;
import com.shopee.model.Produk;
import com.shopee.model.Seller;
import com.shopee.model.Sepatu;
import com.shopee.model.Topi;
import com.shopee.service.Pengiriman;
import java.awt.Font;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class App {

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {

            System.out.println("===== INPUT DATA BUYER =====");

            String nama = bacaNama(input);

            String kota = bacaKota(input);

            String jalan = bacaJalan(input);

            String kecamatan = bacaKecamatan(input);

            String rt = bacaAngkaString(
                    input,
                    "Masukkan RT: "
            );

            String rw = bacaAngkaString(
                    input,
                    "Masukkan RW: "
            );

            String kodePos = bacaKodePos(input);

            String noHP = bacaNomorHP(input);

            String alamat =
                    kota + ", "
                    + jalan + ", "
                    + kecamatan + ", "
                    + "RT " + rt + "/RW " + rw + ", "
                    + kodePos;

            Buyer buyer = new Buyer(
                    nama,
                    alamat,
                    noHP
            );

            Seller seller = new Seller(
                    "Eagle Clothing",
                    "Jakarta",
                    "081298765432"
            );

            MetodePembayaran metode = new MetodePembayaran(
                    "SopiPay",
                    1500.0f
            );

            int nomorOrder = getNomorOrderBerikutnya();
            String orderId = "ORD-" + nomorOrder;

            // Waktu transaksi real-time WIB
            ZonedDateTime waktuSekarang =
                    ZonedDateTime.now(
                            ZoneId.of("Asia/Jakarta")
                    );

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd/MM/yyyy HH:mm:ss"
                    );

            String tanggalTransaksi =
                    waktuSekarang.format(formatter);

            Penjualan penjualan = new Penjualan(
                    orderId,
                    tanggalTransaksi,
                    buyer,
                    seller,
                    metode
            );

            boolean tambahLagi = true;

            while (tambahLagi) {

                System.out.println("\n===== KATALOG PRODUK =====");
                System.out.println(
                        "1. Kaos I Love My Poodle - Rp60.000"
                );
                System.out.println(
                        "2. Sepatu Hitam Kasual   - Rp150.000"
                );
                System.out.println(
                        "3. Kacamata Fashion      - Rp75.000"
                );
                System.out.println(
                        "4. Kaos Kaki Premium     - Rp35.000"
                );
                System.out.println(
                        "5. Topi Polos Kekinian   - Rp15.000"
                );
                System.out.println(
                        "6. Selesai memilih"
                );

                System.out.print("Pilih produk: ");

                int pilihan =
                        bacaAngka(input, 1, 6);

                switch (pilihan) {

                    case 1 -> {

                        System.out.println(
                                "\n===== DATA KAOS ====="
                        );

                        String ukuranKaos =
                                bacaUkuranBaju(input);

                        int kuantitasKaos =
                                bacaKuantitas(input);

                        Pakaian pakaian =
                                new Pakaian(
                                        "Kaos I Love My Poodle",
                                        60000.0f,
                                        kuantitasKaos,
                                        "Kaos",
                                        ukuranKaos
                                );

                        penjualan.addProduk(
                                pakaian
                        );

                        System.out.println(
                                "Kaos berhasil ditambahkan ke pesanan!"
                        );
                    }

                    case 2 -> {

                        System.out.println(
                                "\n===== DATA SEPATU ====="
                        );

                        int ukuranSepatu =
                                bacaUkuranSepatu(input);

                        int kuantitasSepatu =
                                bacaKuantitas(input);

                        Sepatu sepatu =
                                new Sepatu(
                                        "Sepatu Kasual",
                                        150000.0f,
                                        kuantitasSepatu,
                                        ukuranSepatu
                                );

                        penjualan.addProduk(
                                sepatu
                        );

                        System.out.println(
                                "Sepatu berhasil ditambahkan ke pesanan!"
                        );
                    }

                    case 3 -> {

                        System.out.println(
                                "\n===== DATA KACAMATA ====="
                        );

                        String warna =
                                bacaPilihan(
                                        input,
                                        "Pilih warna kacamata:",
                                        new String[]{
                                                "Hitam",
                                                "Putih",
                                                "Coklat",
                                                "Biru",
                                                "Transparan"
                                        }
                                );

                        String lensa =
                                bacaTipeLensa(input);

                        int qty =
                                bacaKuantitas(input);

                        Kacamata kacamata =
                                new Kacamata(
                                        "Kacamata Fashion",
                                        75000.0f,
                                        qty,
                                        warna,
                                        lensa
                                );

                        penjualan.addProduk(
                                kacamata
                        );

                        System.out.println(
                                "Kacamata berhasil ditambahkan ke pesanan!"
                        );
                    }

                    case 4 -> {

                        System.out.println(
                                "\n===== DATA KAOS KAKI ====="
                        );

                        String warna =
                                bacaPilihan(
                                        input,
                                        "Pilih warna kaos kaki:",
                                        new String[]{
                                                "Hitam",
                                                "Putih",
                                                "Abu-abu",
                                                "Biru",
                                                "Merah"
                                        }
                                );

                        String ukuran =
                                bacaPilihan(
                                        input,
                                        "Pilih ukuran kaos kaki:",
                                        new String[]{
                                                "XS (17-18 cm)",
                                                "S (19-20 cm)",
                                                "M (21-22 cm)",
                                                "L (23-24 cm)",
                                                "XL (25-26 cm)"
                                        }
                                );

                        int qty =
                                bacaKuantitas(input);

                        KaosKaki kaosKaki =
                                new KaosKaki(
                                        "Kaos Kaki Premium",
                                        35000.0f,
                                        qty,
                                        warna,
                                        ukuran
                                );

                        penjualan.addProduk(
                                kaosKaki
                        );

                        System.out.println(
                                "Kaos kaki berhasil ditambahkan ke pesanan!"
                        );
                    }

                    case 5 -> {

                        System.out.println(
                                "\n===== DATA TOPI ====="
                        );

                        String jenis =
                                bacaPilihan(
                                        input,
                                        "Pilih jenis topi:",
                                        new String[]{
                                                "Baseball Cap",
                                                "Bucket Hat",
                                                "Trucker Hat",
                                                "Beanie Hat"
                                        }
                                );

                        String warna =
                                bacaPilihan(
                                        input,
                                        "Pilih warna topi:",
                                        new String[]{
                                                "Hitam",
                                                "Putih",
                                                "Coklat",
                                                "Biru",
                                                "Merah"
                                        }
                                );

                        int qty =
                                bacaKuantitas(input);

                        Topi topi =
                                new Topi(
                                        "Topi Polos Kekinian",
                                        15000.0f,
                                        qty,
                                        jenis,
                                        warna
                                );

                        penjualan.addProduk(
                                topi
                        );

                        System.out.println(
                                "Topi berhasil ditambahkan ke pesanan!"
                        );
                    }

                    case 6 -> {

                        if (penjualan
                                .getListProduk()
                                .isEmpty()) {

                            System.out.println(
                                    "Anda belum memilih produk. "
                                    + "Silakan pilih setidaknya satu produk."
                            );

                            break;
                        }

                        System.out.println(
                                "\n--- ISI KERANJANG SAAT INI ---"
                        );

                        for (
                                int i = 0;
                                i < penjualan
                                        .getListProduk()
                                        .size();
                                i++
                        ) {

                            Produk produk =
                                    penjualan
                                            .getListProduk()
                                            .get(i);

                            System.out.printf(
                                    "%d. %s - Qty: %d%n",
                                    i + 1,
                                    produk.getNamaProduk(),
                                    produk.getKuantitas()
                            );
                        }

                        while (true) {

                            System.out.print(
                                    "\nPilih nomor produk yang ingin dihapus "
                                    + "atau ketik 0 untuk menyelesaikan pesanan: "
                            );

                            int indexUbah =
                                    bacaAngka(
                                            input,
                                            0,
                                            penjualan
                                                    .getListProduk()
                                                    .size()
                                    );

                            if (indexUbah == 0) {

                                tambahLagi = false;
                                break;
                            }

                            Produk produkDihapus =
                                    penjualan
                                            .getListProduk()
                                            .get(indexUbah - 1);

                            penjualan
                                    .getListProduk()
                                    .remove(indexUbah - 1);

                            System.out.println(
                                    produkDihapus
                                            .getNamaProduk()
                                    + " berhasil dihapus dari pesanan."
                            );

                            if (penjualan
                                    .getListProduk()
                                    .isEmpty()) {

                                System.out.println(
                                        "Keranjang sekarang kosong. "
                                        + "Silakan pilih produk kembali."
                                );

                                break;
                            }

                            System.out.println(
                                    "\n--- ISI KERANJANG TERBARU ---"
                            );

                            for (
                                    int i = 0;
                                    i < penjualan
                                            .getListProduk()
                                            .size();
                                    i++
                            ) {

                                Produk produk =
                                        penjualan
                                                .getListProduk()
                                                .get(i);

                                System.out.printf(
                                        "%d. %s - Qty: %d%n",
                                        i + 1,
                                        produk.getNamaProduk(),
                                        produk.getKuantitas()
                                );
                            }
                        }
                    }

                    default -> {
                        System.out.println(
                                "Pilihan tidak tersedia."
                        );
                    }
                }
            }

            if (penjualan
                    .getListProduk()
                    .isEmpty()) {

                System.out.println(
                        "Pesanan dibatalkan karena tidak ada produk."
                );

                return;
            }

            StringBuilder struk =
                    new StringBuilder();

            String garisTebal =
                    "================================================================================\n";

            String garisTipis =
                    "--------------------------------------------------------------------------------\n";

            struk.append(garisTebal);
            struk.append(
                    "                                SOPI INDONESIA\n"
            );
            struk.append(
                    "                                  NOTA PESANAN\n"
            );
            struk.append(garisTebal);

            struk.append(String.format(
                    "Nama Pembeli        : %-28s Nama Penjual : %s%n",
                    penjualan
                            .getPembeli()
                            .getNama(),
                    penjualan
                            .getPenjual()
                            .getNamaToko()
            ));

            struk.append(String.format(
                    "Alamat Pembeli      : %-28s%n",
                    penjualan
                            .getPembeli()
                            .getAlamat()
            ));

            struk.append(String.format(
                    "No. Handphone       : %-28s%n%n",
                    penjualan
                            .getPembeli()
                            .getNoHP()
            ));

            struk.append(garisTipis);

            struk.append(String.format(
                    "No. Pesanan         : %s%n",
                    penjualan.getNoPesanan()
            ));

            struk.append(String.format(
                    "Tanggal Transaksi   : %s WIB%n",
                    penjualan.getTanggal()
            ));

            struk.append(String.format(
                    "Metode Pembayaran   : %s%n",
                    penjualan
                            .getMetode()
                            .getJenisPembayaran()
            ));

            struk.append(
                    "Jasa Kirim          : Reguler\n"
            );

            struk.append(
                    garisTipis
            ).append("\n");

            struk.append(
                    "RINCIAN PESANAN:\n"
            );

            struk.append(
                    garisTipis
            );

            struk.append(String.format(
                    "%-3s %-33s %-12s %-10s %-5s %s%n",
                    "No",
                    "Produk",
                    "Variasi",
                    "Harga",
                    "Qty",
                    "Subtotal"
            ));

            struk.append(garisTipis);

            float totalSubtotal = 0.0f;
            float totalOngkir = 0.0f;
            int totalQty = 0;
            int no = 1;

            for (
                    Produk produk :
                    penjualan.getListProduk()
            ) {

                String namaProd =
                        produk.getNamaProduk();

                if (namaProd.length() > 30) {
                    namaProd =
                            namaProd.substring(0, 30)
                            + "...";
                }

                String variasi = "-";

                if (produk instanceof Pakaian pakaian) {

                    variasi =
                            pakaian.getJenisPakaian()
                            + ","
                            + pakaian.getUkuran();

                } else if (
                        produk instanceof Sepatu sepatu
                ) {

                    variasi =
                            "Uk."
                            + sepatu.getUkuranSepatu();

                } else if (
                        produk instanceof Kacamata kacamata
                ) {

                    variasi =
                            kacamata.getWarna()
                            + ","
                            + kacamata.getTipeLensa();

                } else if (
                        produk instanceof Topi topi
                ) {

                    variasi =
                            topi.getWarna()
                            + ","
                            + topi.getJenisTopi();

                } else if (
                        produk instanceof KaosKaki kaosKaki
                ) {

                    variasi =
                            kaosKaki.getWarna()
                            + ","
                            + kaosKaki.getBentukPola();
                }

                if (variasi.length() > 11) {
                    variasi =
                            variasi.substring(0, 11);
                }

                String hargaStr =
                        String.format(
                                "Rp%.0f",
                                produk.getHarga()
                        );

                String subtotalStr =
                        String.format(
                                "Rp%.0f",
                                produk.hitungSubtotal()
                        );

                struk.append(String.format(
                        "%-3d %-33s %-12s %-10s %-5d %s%n",
                        no++,
                        namaProd,
                        variasi,
                        hargaStr,
                        produk.getKuantitas(),
                        subtotalStr
                ));

                totalSubtotal +=
                        produk.hitungSubtotal();

                totalQty +=
                        produk.getKuantitas();

                if (
                        produk instanceof Pengiriman pengiriman
                ) {

                    totalOngkir +=
                            pengiriman.hitungOngkir();
                }
            }

            struk.append(garisTipis);

            float biayaLayanan =
                    penjualan
                            .getMetode()
                            .getBiayaLayanan();

            float totalPembayaran =
                    totalSubtotal
                    + totalOngkir
                    + biayaLayanan;

            String pad =
                    "                                              ";

            struk.append(pad).append(
                    String.format(
                            "%-18s: Rp%.0f%n",
                            "Subtotal",
                            totalSubtotal
                    )
            );

            struk.append(pad).append(
                    String.format(
                            "%-18s: %d produk%n%n",
                            "Total Kuantitas",
                            totalQty
                    )
            );

            struk.append(pad)
                    .append(
                            "----------------------------------\n"
                    );

            struk.append(pad).append(
                    String.format(
                            "%-18s: Rp%.0f%n",
                            "Subtotal Pesanan",
                            totalSubtotal
                    )
            );

            if (totalOngkir > 0) {

                struk.append(pad).append(
                        String.format(
                                "%-18s: Rp%.0f%n",
                                "Ongkos Kirim",
                                totalOngkir
                        )
                );
            }

            struk.append(pad).append(
                    String.format(
                            "%-18s: Rp%.0f%n",
                            "Biaya Layanan",
                            biayaLayanan
                    )
            );

            struk.append(pad)
                    .append(
                            "----------------------------------\n"
                    );

            struk.append(pad).append(
                    String.format(
                            "%-18s: Rp%.0f%n",
                            "TOTAL PEMBAYARAN",
                            totalPembayaran
                    )
            );

            struk.append(garisTebal);

            struk.append(
                    "               Biaya-biaya yang ditagihkan sudah termasuk PPN\n"
            );

            struk.append(garisTebal);

            JTextArea areaStruk =
                    new JTextArea(
                            struk.toString()
                    );

            areaStruk.setFont(
                    new Font(
                            "Monospaced",
                            Font.PLAIN,
                            12
                    )
            );

            areaStruk.setEditable(false);
            areaStruk.setBackground(null);

            JOptionPane.showMessageDialog(
                    null,
                    areaStruk,
                    "Nota Pesanan Shopee",
                    JOptionPane.PLAIN_MESSAGE
            );

            String namaFileInvoice =
                    "invoice"
                    + nomorOrder
                    + ".txt";

            try (
                    FileWriter fw =
                    new FileWriter(
                            namaFileInvoice,
                            false
                    )
            ) {

                fw.write(
                        struk.toString()
                );

                System.out.println(
                        "Struk berhasil dicetak ke file "
                        + namaFileInvoice
                );

            } catch (IOException e) {

                System.out.println(
                        "Terjadi kesalahan saat menyimpan struk: "
                        + e.getMessage()
                );
            }

            System.out.println(
                    "\n===== STATUS PENGIRIMAN ====="
            );

            for (
                    Produk produk :
                    penjualan.getListProduk()
            ) {

                if (
                        produk instanceof Pengiriman pengiriman
                ) {

                    pengiriman.kirim();
                }
            }
        }
    }

    // =========================================================
    // VALIDASI NAMA
    // =========================================================

    private static String bacaNama(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan nama: "
            );

            String nama =
                    input.nextLine().trim();

            if (
                    !nama.isEmpty()
                    && nama.matches(
                            "[a-zA-ZÀ-ÿ ]+"
                    )
            ) {

                return nama;
            }

            System.out.println(
                    "Nama tidak valid!"
            );

            System.out.println(
                    "Nama hanya boleh berisi huruf dan spasi."
            );
        }
    }

    // =========================================================
    // VALIDASI KOTA
    // =========================================================

    private static String bacaKota(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan kota: "
            );

            String kota =
                    input.nextLine().trim();

            if (
                    !kota.isEmpty()
                    && kota.matches(
                            "[a-zA-ZÀ-ÿ ]+"
                    )
            ) {

                return kota;
            }

            System.out.println(
                    "Kota tidak valid!"
            );

            System.out.println(
                    "Kota hanya boleh berisi huruf dan spasi."
            );
        }
    }

    // =========================================================
    // VALIDASI JALAN
    // =========================================================

    private static String bacaJalan(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan jalan: "
            );

            String jalan =
                    input.nextLine().trim();

            if (
                    !jalan.isEmpty()
                    && jalan.matches(
                            "[a-zA-ZÀ-ÿ0-9 .,/\\-]+"
                    )
            ) {

                return jalan;
            }

            System.out.println(
                    "Jalan tidak valid!"
            );

            System.out.println(
                    "Jalan boleh berisi huruf, angka, spasi, "
                    + "titik, koma, garis miring, atau tanda -."
            );
        }
    }

    // =========================================================
    // VALIDASI KECAMATAN
    // =========================================================

    private static String bacaKecamatan(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan kecamatan: "
            );

            String kecamatan =
                    input.nextLine().trim();

            if (
                    !kecamatan.isEmpty()
                    && kecamatan.matches(
                            "[a-zA-ZÀ-ÿ ]+"
                    )
            ) {

                return kecamatan;
            }

            System.out.println(
                    "Kecamatan tidak valid!"
            );

            System.out.println(
                    "Kecamatan hanya boleh berisi huruf dan spasi."
            );
        }
    }

    // =========================================================
    // VALIDASI RT / RW
    // =========================================================

    private static String bacaAngkaString(
            Scanner input,
            String pertanyaan
    ) {

        while (true) {

            System.out.print(
                    pertanyaan
            );

            String angka =
                    input.nextLine().trim();

            if (
                    !angka.isEmpty()
                    && angka.matches("\\d+")
            ) {

                return angka;
            }

            System.out.println(
                    "Input tidak valid!"
            );

            System.out.println(
                    "Input hanya boleh berupa angka."
            );
        }
    }

    // =========================================================
    // VALIDASI NOMOR HP
    // =========================================================

    private static String bacaNomorHP(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan nomor HP: "
            );

            String noHP =
                    input.nextLine().trim();

            if (
                    !noHP.isEmpty()
                    && noHP.matches("\\d+")
            ) {

                return noHP;
            }

            System.out.println(
                    "Nomor HP tidak valid!"
            );

            System.out.println(
                    "Nomor HP hanya boleh berisi angka."
            );
        }
    }

    // =========================================================
    // VALIDASI KODE POS
    // =========================================================

    private static String bacaKodePos(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan kode pos: "
            );

            String kodePos =
                    input.nextLine().trim();

            if (
                    kodePos.matches("\\d{5}")
            ) {

                return kodePos;
            }

            System.out.println(
                    "Kode pos tidak valid!"
            );

            System.out.println(
                    "Kode pos harus terdiri dari tepat 5 angka."
            );
        }
    }

    // =========================================================
    // NOMOR ORDER
    // =========================================================

    private static int getNomorOrderBerikutnya() {

        int nomor = 1;

        while (true) {

            File fileInvoice =
                    new File(
                            "invoice"
                            + nomor
                            + ".txt"
                    );

            if (!fileInvoice.exists()) {
                return nomor;
            }

            nomor++;
        }
    }

    // =========================================================
    // VALIDASI ANGKA
    // =========================================================

    private static int bacaAngka(
            Scanner input,
            int minimum,
            int maksimum
    ) {

        while (true) {

            try {

                int nilai =
                        Integer.parseInt(
                                input.nextLine()
                        );

                if (
                        nilai >= minimum
                        && nilai <= maksimum
                ) {

                    return nilai;
                }

                System.out.println(
                        "Input tidak valid. "
                        + "Masukkan angka dari "
                        + minimum
                        + " sampai "
                        + maksimum
                        + "."
                );

                System.out.print(
                        "Masukkan ulang: "
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input tidak valid! "
                        + "Harap masukkan angka."
                );

                System.out.print(
                        "Masukkan ulang: "
                );
            }
        }
    }

    // =========================================================
    // VALIDASI KUANTITAS
    // =========================================================

    private static int bacaKuantitas(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan kuantitas: "
            );

            try {

                int qty =
                        Integer.parseInt(
                                input.nextLine()
                        );

                if (qty > 0) {
                    return qty;
                }

                System.out.println(
                        "Kuantitas harus lebih dari 0."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Kuantitas tidak valid! "
                        + "Harap masukkan angka."
                );
            }
        }
    }

    // =========================================================
    // UKURAN BAJU
    // =========================================================

    private static String bacaUkuranBaju(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan ukuran baju "
                    + "(S, M, L, XL, XXL): "
            );

            String ukuran =
                    input.nextLine()
                            .trim()
                            .toUpperCase();

            if (
                    ukuran.equals("S")
                    || ukuran.equals("M")
                    || ukuran.equals("L")
                    || ukuran.equals("XL")
                    || ukuran.equals("XXL")
            ) {

                return ukuran;
            }

            System.out.println(
                    "Ukuran tidak tersedia! "
                    + "Hanya S, M, L, XL, atau XXL."
            );

            System.out.println(
                    "Silakan masukkan ulang."
            );
        }
    }

    // =========================================================
    // UKURAN SEPATU
    // =========================================================

    private static int bacaUkuranSepatu(
            Scanner input
    ) {

        while (true) {

            System.out.print(
                    "Masukkan ukuran sepatu "
                    + "(35 - 45): "
            );

            try {

                int ukuran =
                        Integer.parseInt(
                                input.nextLine()
                        );

                if (
                        ukuran >= 35
                        && ukuran <= 45
                ) {

                    return ukuran;
                }

                System.out.println(
                        "Ukuran sepatu tidak tersedia! "
                        + "Hanya ukuran 35 sampai 45."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input tidak valid! "
                        + "Masukkan ukuran berupa angka."
                );
            }

            System.out.println(
                    "Silakan masukkan ulang."
            );
        }
    }

    // =========================================================
    // TIPE LENSA
    // =========================================================

    private static String bacaTipeLensa(
            Scanner input
    ) {

        while (true) {

            System.out.println(
                    "\nPilih tipe lensa:"
            );

            System.out.println(
                    "1. Minus"
            );

            System.out.println(
                    "2. Anti Radiasi"
            );

            System.out.println(
                    "3. Minus + Anti Radiasi"
            );

            System.out.print(
                    "Pilih nomor: "
            );

            String pilihan =
                    input.nextLine().trim();

            if (pilihan.equals("1")) {

                int minus =
                        bacaAngka(
                                input,
                                1,
                                6
                        );

                if (minus == 1) {
                    return "M";
                }

                return "M" + minus;

            } else if (
                    pilihan.equals("2")
            ) {

                return "AR";

            } else if (
                    pilihan.equals("3")
            ) {

                System.out.print(
                        "Masukkan minus berapa (1 - 6): "
                );

                int minus =
                        bacaAngka(
                                input,
                                1,
                                6
                        );

                return (
                        minus == 1
                                ? "M"
                                : "M" + minus
                ) + "+AR";

            } else {

                System.out.println(
                        "Pilihan tidak valid! "
                        + "Silakan pilih 1, 2, atau 3."
                );
            }
        }
    }

    // =========================================================
    // VALIDASI PILIHAN
    // =========================================================

    private static String bacaPilihan(
            Scanner input,
            String pertanyaan,
            String[] pilihan
    ) {

        while (true) {

            System.out.println(
                    "\n" + pertanyaan
            );

            for (
                    int i = 0;
                    i < pilihan.length;
                    i++
            ) {

                System.out.println(
                        (i + 1)
                        + ". "
                        + pilihan[i]
                );
            }

            System.out.print(
                    "Pilih nomor: "
            );

            try {

                int nomor =
                        Integer.parseInt(
                                input.nextLine()
                        );

                if (
                        nomor >= 1
                        && nomor <= pilihan.length
                ) {

                    return pilihan[
                            nomor - 1
                    ];
                }

                System.out.println(
                        "Pilihan tidak tersedia. "
                        + "Silakan pilih nomor yang ada."
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input tidak valid! "
                        + "Masukkan nomor pilihan."
                );
            }
        }
    }
}