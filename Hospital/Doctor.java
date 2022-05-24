package Hospital;

import java.util.Scanner;

public class Doctor {

      private int[] d_id = { 341, 312, 353, 374, 335 };
      private String[] d_name = { "dr. Abdul Haris, Sp.PD", "dr. Moh Buchori, Sp.PD", "dr. Anton K, M,Sc Sp.PD",
                  "dr. Adesiawan S , Sp.PD", "dr. Adi Nugroho, Sp.PD" };
      private String[] address = { "Malang", "Surabaya", "Jakarta", "Bandung", "Semarang" };
      private int[] no_telp = { 12345678, 23456789, 34567890, 45678901, 56789012 };
      protected String[] specialization = { "Penyakit Dalam", "Penyakit Dalam", "Penyakit Dalam", "Penyakit Dalam",
                  "Penyakit Dalam" };
      protected String[] location = { "Gedung 1", "Gedung 2", "Gedung 3", "Gedung 4", "Gedung 5" };

      public Doctor() {

      }

      public Doctor(String[] d_name) {
            this.d_name = d_name;
      }

      public int[] getD_id() {
            return d_id;
      }

      public String[] getD_name() {
            return d_name;
      }

      public void Choice() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nId Dokter : ");
            int choice = sc.nextInt();

            boolean found = false;
            int[] d_id = getD_id();
            for (int i = 0; i < 5; i++) {
                  if (d_id[i] == choice) {
                        System.out.println("\n=== Menampilkan informasi dokter dengan id " + choice + " ===");
                        System.out.println("\nId Dokter" + "         " + "Nama Dokter" + "           " + "Alamat"
                                    + "        " + "No Telp" + "        " + "Spesialis" + "      " + "Lokasi Kantor");
                        System.out.println(
                                    "--------------------------------------------------------------------------------------------------");
                        System.out.printf("%5d %28s %11s %15d %18s %14s%n", d_id[i], d_name[i], address[i], no_telp[i],
                                    specialization[i], location[i]);
                        found = true;

                        while (true) {
                              System.out.println("\n=== Menu Dokter ===");
                              System.out.print("\n1) Cek Pasien\n2) Kembali\nEnter your choice: ");
                              int choice2 = sc.nextInt();
                              switch (choice2) {
                                    case 1:
                                          CheckPatient(choice);
                                          break;
                                    case 2:
                                          Main.main(null);
                              }
                        }

                  }
            }
            if (!found) {
                  System.out.println("\nId Dokter tidak ditemukan");
            }

      }

      public void CheckPatient(int choice) {
            Patient pat = new Patient();

            String[] p_name = pat.getP_name();
            int[] p_id = pat.getP_id();
            String[] diagnosis = pat.getSickness();

            for (int i = 0; i < p_id.length; i++) {
                  if (d_id[i] == choice) {
                        System.out.println("\n=== Pasien yang anda tangani adalah sebagai berikut ===");
                        System.out.println("\nId Pasien" + "\t" + "Nama Pasien" + "\t" + "Penyakit");
                        System.out.println("------------------------------------------");
                        System.out.println("   " + p_id[i] + " \t\t" + p_name[i] + " \t\t" + diagnosis[i]);
                  }

            }
      }

}
