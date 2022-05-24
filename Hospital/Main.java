package Hospital;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    System.out.println("\n=== Sistem Informasi Manajemen Rumah Sakit ===");
    System.out.print("1) Resepsionis\n2) Pasien\n3) Dokter\n4) Konsultan\n5) Stop\nEnter your choice: ");
    Scanner sc = new Scanner(System.in);
    int choice = sc.nextInt();

    while (true) {
      if (choice <= 5 && choice >= 1) {
        switch (choice) {
          case 1:
            Receptionist R = new Receptionist();
            R.Choice();
            break;
          case 2:
            Patient P = new Patient();
            P.Choice();
            break;
          case 3:
            Doctor D = new Doctor();
            D.Choice();
            break;
          case 4:
            ConsultantDoctor C = new ConsultantDoctor();
            C.Choice();
            break;
          case 5:
            System.exit(0);  
        }
      }
      else {
        System.out.println("\nMenu tidak tersedia, silahkan input kembali !!");
        main(null);
        break;
      }
    }
  }
}


