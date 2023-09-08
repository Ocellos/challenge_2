import java.util.InputMismatchException;
import java.util.Scanner;

public class AplikasiPemesananMakanan {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        int pesananNasiGoreng = 0; // Variabel untuk menyimpan jumlah pesanan nasi goreng

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
                input.nextLine(); // Membersihkan input yang salah
                continue; // Melanjutkan ke iterasi berikutnya
            }

            switch (pilihan) {
                case 1:
                    // Tambahkan kode untuk menampilkan menu makanan di sini
                    System.out.println("=== Menu Makanan ===");
                    System.out.println("1. Nasi Goreng");
                    System.out.println("2. Mie Ayam");
                    System.out.println("3. Soto Ayam");
                    break;
                case 2:
                    // Tambahkan kode untuk proses pemesanan makanan di sini
                    System.out.print("Masukkan nomor menu yang ingin dipesan (1/2/3): ");

                    try {
                        int nomorMenu = input.nextInt();

                        switch (nomorMenu) {
                            case 1:
                                System.out.print("Masukkan jumlah pesanan Nasi Goreng: ");
                                int jumlahNasiGoreng = input.nextInt();
                                pesananNasiGoreng += jumlahNasiGoreng;
                                System.out.println(jumlahNasiGoreng + " Nasi Goreng telah ditambahkan ke pesanan Anda.");
                                break;
                            case 2:
                                // Tambahkan kode untuk pesanan Mie Ayam di sini
                                break;
                            case 3:
                                // Tambahkan kode untuk pesanan Soto Ayam di sini
                                break;
                            default:
                                System.out.println("Nomor menu tidak valid.");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Input tidak sesuai. Masukkan angka.");
                        input.nextLine(); // Membersihkan input yang salah
                    }
                    break;
                case 3:
                    // Tambahkan layar konfirmasi dan pembayaran di sini
                    System.out.println("=== Konfirmasi dan Pembayaran ===");
                    System.out.println("Pesanan Anda:");
                    System.out.println("- Nasi Goreng: " + pesananNasiGoreng + " porsi");
                    // Tambahkan detail pesanan untuk makanan lainnya jika ada
                    System.out.println("Total Pembayaran: " + calculateTotalPayment(pesananNasiGoreng) + " IDR");
                    System.out.print("Apakah Anda ingin mengkonfirmasi pesanan dan membayar (ya/tidak)? ");
                    String konfirmasi = input.next().toLowerCase();
                    if (konfirmasi.equals("ya")) {
                        // Tambahkan logika pembayaran di sini
                        System.out.println("Terima kasih atas pesanan Anda!");
                        pesananNasiGoreng = 0; // Reset pesanan setelah pembayaran
                    } else {
                        System.out.println("Pesanan dibatalkan.");
                    }
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                    break;
            }

        } while (pilihan != 3);

        input.close();
    }

    // Metode untuk menghitung total pembayaran
    private static int calculateTotalPayment(int pesananNasiGoreng) {
        // Tambahkan logika perhitungan total pembayaran sesuai harga makanan dan jumlah pesanan
        int hargaNasiGoreng = 15000; // Harga per porsi Nasi Goreng
        return pesananNasiGoreng * hargaNasiGoreng;
    }
}
