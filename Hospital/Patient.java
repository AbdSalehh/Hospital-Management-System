/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hospital;

/**
 *
 * @author Saleh
 */
import java.util.Scanner;

public class Patient {

      private int[] p_id = { 101, 102, 103, 104, 105 };
      private String[] p_name = { "Indah", "Jufri", "Supri", "Winda", "Jefri" };
      private String[] sickness = { "Asma", "Diare", "Demam", "Campak", "Malaria" };
      private int[] age = { 20, 21, 22, 23, 24 };
      private String[] sex = { "Wanita", "Pria", "Pria", "Wanita", "Pria" };
      private int[] RoomNo;

      Billing billing;
      Rooms room;

      public Patient() {

      }

      ConsultantDoctor cd = new ConsultantDoctor();
      Doctor dc = new Doctor();

      public Patient(int[] p_id, String[] p_name, String[] sickness, int[] age, String[] sex, Rooms room,
                  Billing billing) {
            this.p_id = p_id;
            this.p_name = p_name;
            this.sickness = sickness;
            this.sex = sex;
            this.age = age;
            this.room = room;
            this.billing = billing;
            this.room = room;
      }

      public Billing getBilling() {
            return billing;
      }

      public void setBilling(Billing billing) {
            this.billing = billing;
      }

      public Rooms getRoom() {
            return room;
      }

      public void setRoom(Rooms room) {
            this.room = room;
      }

      public String[] getDokter() {
            return dc.getD_name();
      }

      public String[] getKonsul() {
            return cd.getC_Name();
      }

      public int[] getP_id() {
            return p_id;
      }

      public int[] getRoomNo() {
            return RoomNo;
      }

      public String[] getP_name() {
            return p_name;
      }

      public String[] getSickness() {
            return sickness;
      }

      public int[] getAge() {
            return age;
      }

      public String[] getSex() {
            return sex;
      }

      public void Choice() {
            boolean found = false;
            System.out.println("\nInput id :");
            Scanner sc1 = new Scanner(System.in);
            int id = sc1.nextInt();

            Patient p = new Patient();
            Receptionist r = new Receptionist();
            

            Rooms R = new Rooms(new int[] { 10, 5, 7, 2, 8, 3, 1, 4 }, new String[] { "Lantai 1", "Lantai 3", "Lantai 2", "Lantai 1", "Lantai 3", "Lantai 2", "Lantai 1", "Lantai 3" });
            Billing billing1 = new Billing(new int[] { 005134, 004163, 138007, 001742, 007114 },
                        new int[] { 700000, 500000, 800000, 600000, 900000 }, p);
            Patient patient = new Patient(p_id, p_name, sickness, age, sex, R, billing1);
            Billing billing2 = new Billing(new int[] { 005134, 004163, 138007, 001742, 007114 },
                        new int[] { 700000, 500000, 800000, 600000, 900000 }, patient);

            int[] b_amt = patient.getBilling().getB_amt();
            int[] b_no = patient.getBilling().getB_no();
            String[] patient_name = getP_name();
            String[] n_dokter = patient.getDokter();
            String[] n_konsultan = patient.getKonsul();
            int[] r_no = patient.getRoom().getR_no();
            String[] r_name = r.getR_name();

            for (int i = 0; i < p_id.length; i++) {
                  if (p_id[i] == id) {
                        System.out.println("\n=== Menampilkan detail pasien dengan id " + id + " ===");
                        System.out.println("\nId" + "   \t" + "Nama" + "   \t" + "Diagnosis" + "\t" + "Umur" + "   \t"
                                    + "Jenis Kelamin" + "\t" + "Nama Dokter" + "     \t\t" + "Nama Konsultan"
                                    + "     \t" + "Nama Konsultan");
                        System.out.println(
                                    "-------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(p_id[i] + " \t" + patient_name[i] + " \t" + sickness[i] + "\t\t" + age[i]
                                    + " \t" + sex[i] + " \t\t" + n_dokter[i] + "     " + n_konsultan[i] + " \t"
                                    + r_name[r_name.length-1]);
                        found = true;
                        while (true) {
                              System.out.println("\n=== Menu Pasien ===");
                              System.out.print("1) Lihat Detail Tagihan\n2) Kembali\nEnter your choice: ");
                              Scanner sc = new Scanner(System.in);
                              int choice = sc.nextInt();
                              switch (choice) {
                                    case 1:
                                          System.out.println("=== Menampilkan pasien dengan id " + id + " ===");
                                          System.out.println("\nId Pasien" + "   \t" + "Nomor Pembayaran" + "   \t"
                                                      + "Nama" + "   \t" + "Biaya");
                                          System.out.println("------------------------------------------------------");
                                          System.out.println(p_id[i] + " \t\t" + b_no[i] + " \t\t\t" + patient_name[i]
                                                      + " \t" + b_amt[i] + "\n");
                                          PayBill(id);
                                          break;
                                    case 2:
                                          Main.main(null);
                                          ;
                              }
                        }
                  }
            }
            if (found == false) {
                  System.out.println("Pasien dengan id " + id + " tidak ditemukan");
            }

      }

      public void PayBill(int id) {

            Patient p = new Patient();

            Rooms R = new Rooms(new int[] { 10, 5, 7, 2, 8, 3, 1, 4 }, new String[] { "Lantai 1", "Lantai 3",
                        "Lantai 2", "Lantai 1", "Lantai 3", "Lantai 2", "Lantai 1", "Lantai 3" });
            Billing billing1 = new Billing(new int[] { 005134, 004163, 138007, 001742, 007114 },
                        new int[] { 700000, 500000, 800000, 600000, 900000 }, p);
            Patient patient = new Patient(p_id, p_name, sickness, age, sex, R, billing1);
            Billing billing2 = new Billing(new int[] { 005134, 004163, 138007, 001742, 007114 },
                        new int[] { 700000, 500000, 800000, 600000, 900000 }, patient);

            int[] b_amt = billing2.getB_amt();
            int[] b_no = billing2.getB_no();
            String[] patient_name = getP_name();
            

            System.out.println("Apakah anda ingin membayar sekarang? (y/n)");
            Scanner sc2 = new Scanner(System.in);
            String answer = sc2.nextLine();
            for (int i = 0; i < p_id.length; i++) {
                  if (p_id[i] == id) {
                        if (answer.equals("y") || answer.equals("Y")) {
                              System.out.println("Masukkan nominal pembayaran: ");
                              Scanner sc3 = new Scanner(System.in);
                              int amt = sc3.nextInt();
                              int a = b_amt[i] - amt;
                              if (a > 0) {
                                    System.out.println("\n=== INFORMASI PEMBAYARAN ===");
                                    System.out.println("\nId Pasien" + "   \t" + "Nomor Pembayaran" + "   \t" + "Nama"
                                                + "   \t" + "Sisa Biaya");
                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println(p_id[i] + " \t\t" + b_no[i] + " \t\t\t" + patient_name[i] + " \t"
                                                + a + "\n");
                              } else {
                                    System.out.println("\n=== INFORMASI PEMBAYARAN ===");
                                    System.out.println("\nId Pasien" + "   \t" + "Nomor Pembayaran" + "   \t" + "Nama"
                                                + "   \t" + "Sisa Biaya");
                                    System.out.println("-----------------------------------------------------------");
                                    System.out.println(p_id[i] + " \t\t" + b_no[i] + " \t\t\t" + patient_name[i] + " \t"
                                                + "LUNAS" + "\n");
                              }

                              System.out.println("TERIMA KASIH TELAH MELAKUKAN PEMBAYARAN");
                              break;

                        } else {
                              break;
                        }


                  }
            }
      }

}

