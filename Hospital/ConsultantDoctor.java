package Hospital;

import java.util.Scanner;

public class ConsultantDoctor extends Doctor {

      private int[] id = { 241, 275, 211, 237, 245 };
      private String[] name = { "Dr. Supriatmo, Sp.A(K)", "Dr. Melda Deliana, Sp.A(K)", "Dr.Firman Arbi, Sp.A(K)",
                  "Dr.Rusdi,Sp.A(K)", "Dr.Aditiawati,Sp.A(K)" };
      private String[] address = { "Bekasi", "Kediri", "Sumenep", "Gresik", "Tegal" };
      private int[] C_no_telp = { 12345678, 23456789, 34567890, 45678901, 56789012 };

      private String[] c_specialization;
      private String[] c_location;

      public int[] getId() {
            return id;
      }

      public String[] getC_Name() {
            return name;
      }

      public void setLocation() {
            this.c_location = location;
      }

      public String[] getLocation() {
            return c_location;
      }

      public void setSpecialization() {
            this.c_specialization = specialization;
      }

      public String[] getSpecialization() {
            return c_specialization;
      }

      public int[] getC_no_telp() {
            return C_no_telp;
      }

      public String[] getAddress() {
            return address;
      }

      public void Choice() {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nId Konsultan : ");
            int choice = sc.nextInt();

            boolean found = false;
            for (int i = 0; i < 5; i++) {
                  if (id[i] == choice) {
                        System.out.println("\n=== Menampilkan informasi konsultan dengan id " + choice + " ===");
                        System.out.println("\nId Konsultan" + "         " + "Nama Konsultan" + "           " + "Alamat"
                                    + "        " + "No Telp" + "        " + "Spesialis" + "      " + "Lokasi Kantor");
                        System.out.println(
                                    "-------------------------------------------------------------------------------------------------------");
                        System.out.printf("%7d %32s %11s %15d %18s %12s%n", id[i], name[i], address[i], C_no_telp[i],
                                    specialization[i], location[i]);
                        found = true;

                        while (true) {
                              System.out.println("\n=== Menu Konsultan ===");
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
                  System.out.println("\nId Konsultan tidak ditemukan");
            }

      }

      public void CheckPatient(int choice) {
            Patient P = new Patient();

            String[] p_name = P.getP_name();
            int[] p_id = P.getP_id();
            String[] diagnosis = P.getSickness();
            int[] d_id = getD_id();

            for (int i = 0; i < 5; i++) {
                  if (id[i] == choice) {
                        System.out.println("\n=== Pasien yang anda tangani adalah sebagai berikut ===");
                        System.out.println("\nId Pasien" + "\t" + "Nama Pasien" + "\t" + "Penyakit");
                        System.out.println("------------------------------------------");
                        System.out.println("   " + p_id[i] + " \t\t" + p_name[i] + " \t\t" + diagnosis[i]);
                  }

            }
      }

}
