package Hospital;

import java.util.Scanner;

public class Receptionist {

  private int[] r_id = { 110 };
  private String[] r_name = { "Aulia"};
  Billing billing;
  Rooms room;

  public Receptionist() {

  }

  public Receptionist(int[] r_id, String[] r_name, Billing billing, Rooms room) {
    this.r_id = r_id;
    this.r_name = r_name;
    this.billing = billing;
    this.room = room;
  }

  public Rooms getRoom() {
    return this.room;
  }

  public void setRoom(Rooms room) {
    this.room = room;
  }

  public Billing getBilling() {
    return this.billing;
  }

  public void setBilling(Billing billing) {
    this.billing = billing;
  }

  public int[] getR_id() {
    return r_id;
  }

  public String[] getR_name() {
    return r_name;
  }

  // public static final String GREEN_BOLD = "\033[1;32m";
  // public static final String RED_BOLD = "\033[1;31m";
  // public static final String RESET = "\033[0m";

  Patient patient = new Patient();
  Billing B = new Billing(new int[] { 005134, 004163, 138007, 001742, 007114 },
      new int[] { 700000, 500000, 800000, 600000, 900000 }, patient);
  Rooms R = new Rooms(new int[] { 10, 5, 7, 2, 8, 3, 1, 4 },
      new String[] { "Lantai 1", "Lantai 3", "Lantai 2", "Lantai 1", "Lantai 3", "Lantai 2", "Lantai 1", "Lantai 3" });

  public void Choice() {
    Scanner sc = new Scanner(System.in);
    System.out.println("\nId Resepsionis : ");
    int choice = sc.nextInt();

    boolean found = false;
    int[] r_id = getR_id();
    for (int i = 0; i < r_id.length; i++) {
      if (r_id[i] == choice) {
        System.out.println("\nLOGIN SUKSES SEBAGAI " + r_name[i]);
        found = true;

        while (true) {
          System.out.println("\n=== Menu Resepsionis ===");
          System.out.print(
              "\n1) Lihat Daftar Pasien\n2) Lihat Pembayaran\n3) Cek Kamar Tersedia\n4) Kembali\nEnter your choice: ");
          Scanner s = new Scanner(System.in);
          int ch = s.nextInt();

          switch (ch) {
            case 1:
              LihatPasien();
              break;
            case 2:
              LihatPembayaran();
              break;
            case 3:
              CheckRoomAvalibility();
              break;
            case 4:
              Main.main(null);
          }
        }
      }
    }
    if (found == false) {
      System.out.println("Resepsionis dengan id " + choice + " tidak ditemukan");
    }
  }

  public void LihatPembayaran() {
    Receptionist sz = new Receptionist(r_id, r_name, B, R);
    Patient P = new Patient();
    int[] p_id = P.getP_id();
    String[] p_name = P.getP_name();

    int[] b_amt1 = sz.getBilling().getB_amt();
    int[] b_no1 = sz.getBilling().getB_no();
    String[] patient_name = sz.getBilling().getPatient().getP_name();

    Scanner sc = new Scanner(System.in);
    System.out.print("\nInput id pasien: ");
    int id = sc.nextInt();
    boolean found = false;
    for (int i = 0; i < 5; i++) {

      if (p_id[i] == id) {
        System.out.println("\n=== Menampilkan informasi pembayaran pasien dengan id " + id + " ===");
        System.out.println(
            "\nNomor Pembayaran" + "        " + "Id Pasien" + "        " + "Nama Pasien" + "       " + "Biaya");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%10d %18d %19s %14d%n", b_no1[i], p_id[i], patient_name[i], b_amt1[i]);
        found = true;
      }
    }
    if (found == false) {
      System.out.println("\nPasien dengan id " + id + " tidak ditemukan");
      LihatPembayaran();
    }

  }

  public void LihatPasien() {

    Patient P = new Patient();
    int[] p_id = P.getP_id();
    int[] age = P.getAge();
    String[] p_name = P.getP_name();
    String[] diagnosis = P.getSickness();
    String[] sex = P.getSex();
    String[] d_name = P.getDokter();
    String[] c_nama = P.getKonsul();

    System.out.println("\n=== Daftar Pasien ===");
    System.out.println(
        "\nId_Pasien" + "   " + "Nama_Pasien" + "   " + "Penyakit" + "   " + "Umur_Pasien" + "   " + "Gender_Pasien"
            + "      " + "Nama_Dokter" + "                  " + "Nama_Konsultan");
    System.out.println(
        "---------------------------------------------------------------------------------------------------------------------------");
    for (int i = 0; i < 5; i++) {
      System.out.printf("%6d %13s %12s %10d %16s         %18s     %13s %n", p_id[i], p_name[i], diagnosis[i], age[i],
          sex[i], d_name[i], c_nama[i]);
    }
  }

  public void CheckRoomAvalibility() {
    Patient p = new Patient();
    int[] p_id = p.getP_id();
    String[] p_name = p.getP_name();
    String[] p_sex = p.getSex();

    Receptionist sz = new Receptionist(r_id, r_name, B, R);

    int[] r_no = sz.getRoom().getR_no();
    String[] r_loc = sz.getRoom().getR_loc();

    System.out.println("\n=== Daftar Kamar ===");
    System.out.println("\nLokasi Kamar" + "         " + "Nomor Kamar" + "         " + "Status" + "         "
        + "Nama Pasien" + "         " + "Gender Pasien");
    System.out.println("------------------------------------------------------------------------------------------");
    for (int j = p_id.length; j < r_no.length; j++) {
      System.out.printf("%7s %17d            %21s %12s %20s%n", r_loc[j], r_no[j], "Tersedia",
          "-", "-");
    }
    System.out.println();
    for (int i = 0; i < p_id.length; i++) {
      // System.out.printf("%7s %17d            %21s %14s %22s%n", r_loc[i], r_no[i], (RED_BOLD + "Terpakai" + RESET),
      //     p_name[i], p_sex[i]);
      System.out.printf("%7s %17d            %21s %14s %22s%n", r_loc[i], r_no[i], "Terpakai",
          p_name[i], p_sex[i]);
    }

  }
}
