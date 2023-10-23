package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class AplikasiPemesananMakanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;
        List<MenuMakanan> daftarMenu = new ArrayList<>();
        daftarMenu.add(new MenuMakanan("Nasi Goreng", 15000));
        daftarMenu.add(new MenuMakanan("Mie Ayam", 12000));
        daftarMenu.add(new MenuMakanan("Soto Ayam", 10000));

        List<Pesanan> pesanan = new ArrayList<>();

        do {
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Lihat Menu Makanan");
            System.out.println("2. Pesan Makanan");
            System.out.println("3. Keluar dari Aplikasi");
            System.out.print("Silakan pilih menu (1/2/3): ");

            try {
                pilihan = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Input tidak sesuai. Masukkan angka (1/2/3).");
                input.nextLine();
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    System.out.println("=== Menu Makanan ===");
                    for (int i = 0; i < daftarMenu.size(); i++) {
                        System.out.println((i + 1) + ". " + daftarMenu.get(i).getNama() + " - " + daftarMenu.get(i).getHarga() + " IDR");
                    }
                }
                case 2 -> {
                    System.out.print("Masukkan nomor menu yang ingin dipesan (1/2/3): ");
                    try {
                        int nomorMenu = input.nextInt();

                        if (nomorMenu >= 1 && nomorMenu <= daftarMenu.size()) {
                            System.out.print("Masukkan jumlah pesanan: ");
                            int jumlahPesanan = input.nextInt();
                            Pesanan pesan = new Pesanan(daftarMenu.get(nomorMenu - 1), jumlahPesanan);
                            pesanan.add(pesan);
                            System.out.println(pesan + " telah ditambahkan ke pesanan Anda.");
                        } else {
                            System.out.println("Nomor menu tidak valid.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak sesuai. Masukkan angka.");
                        input.nextLine();
                    }
                }
                case 3 -> {
                    System.out.println("=== Konfirmasi dan Pembayaran ===");
                    int totalPembayaran = 0;
                    if (!pesanan.isEmpty()) {
                        System.out.println("Pesanan Anda:");
                        for (Pesanan p : pesanan) {
                            System.out.println("- " + p.toString());
                            totalPembayaran += p.hitungTotal();
                        }
                        System.out.println("Total Pembayaran: " + totalPembayaran + " IDR");
                        System.out.print("Apakah Anda ingin mengkonfirmasi pesanan dan membayar (ya/tidak)? ");
                        String konfirmasi = input.next().toLowerCase();
                        if (konfirmasi.equals("ya")) {
                            System.out.println("Terima kasih atas pesanan Anda!");
                            pesanan.clear();
                        } else {
                            System.out.println("Pesanan dibatalkan.");
                        }
                    } else {
                        System.out.println("Tidak ada pesanan yang dibuat.");
                    }
                }
                default -> System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
            }

        } while (pilihan != 3);

        input.close();
    }
}
