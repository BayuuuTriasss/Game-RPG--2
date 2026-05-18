import java.util.Scanner;
 
public class BattleGround {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
 
        Musuh[] gerombolanJMK48 = new Musuh[3];
        gerombolanJMK48[0] = new Slime();
        gerombolanJMK48[1] = new Naga();
        gerombolanJMK48[2] = new Zombie();
 
        System.out.println("====================================");
        System.out.println("    WELCOME DI BATTLEGROUND RPG 2D  ");
        System.out.println("====================================\n");
        System.out.println("Awas! JMK48 Datang Menghadang!!!");
 
        boolean isiBermain = true;
 
        while (isiBermain) {
 
            System.out.println("\n>>> MONSTER JMK48 <<<");
            for (int i = 0; i < gerombolanJMK48.length; i++) {
                if (gerombolanJMK48[i].healthPoint > 0) {
                    System.out.println((i + 1) + ". " + gerombolanJMK48[i].namaMusuhh + " (HP: " + gerombolanJMK48[i].healthPoint + ")");
                } else {
                    System.out.println((i + 1) + " - " + gerombolanJMK48[i].namaMusuhh + " TEWAS.");
                }
            }
            System.out.println("4. Kabur dari pertarungan");
            System.out.println("\nPilih target monster JMK48 yang ingin diserang (1/2/3) atau 4 untuk kabur");
 
            try {
                int pilihanTarget = input.nextInt();

                if (pilihanTarget == 4) {
                    System.out.println("Anda lari dari kawanan JMK48 dari BattleGround...");
                    isiBermain = false;
                    continue;
                }
 
                if (pilihanTarget < 1 || pilihanTarget > 3) {
                    System.out.println("Pilihan tidak valid! Anda membuang giliran.");
 
                } else {
                    int indeksMonster = pilihanTarget - 1;

                    if (gerombolanJMK48[indeksMonster].healthPoint <= 0) {
                        throw new Targetmatiexception(
                            "Tindakan Ilegal: Anda tidak bisa menyerang monster yang sudah mati"
                        );
                    }
 
                    System.out.print("Masukkan kekuatan serangan di kisaran (10-100): ");
                    int power = input.nextInt();
 
                    if (power < 10 || power > 100) {
                        throw new SeranganTidakValidExc(
                            "Tindakan yang Salah: Kekuatan serangan harus di antara 10 - 100!!"
                        );
                    }
 
                    System.out.println("\n>>> HASIL SERANGAN ANDA <<<");
                    System.out.println("");
                    gerombolanJMK48[indeksMonster].terimaDamage(power);

                    if (gerombolanJMK48[indeksMonster].healthPoint <= 0) {
                        System.out.println(gerombolanJMK48[indeksMonster].namaMusuhh + " berhasil dikalahkan!");
 
                        if (gerombolanJMK48[indeksMonster] instanceof canLoot) {
                            canLoot monsterLoot = (canLoot) gerombolanJMK48[indeksMonster];
                            monsterLoot.jatuhkanItem();
                        }
                    }
                }
 
                System.out.println("\n>>> GILIRAN JMK48 MEMBALAS <<<");
                System.out.println("");
                for (int i = 0; i < gerombolanJMK48.length; i++) {
                    if (gerombolanJMK48[i].healthPoint > 0) {
                        Musuh monsterAktif = gerombolanJMK48[i];
                        System.out.println();
                        monsterAktif.suaraKhas();
 
                        if (monsterAktif instanceof canFly) {
                            System.out.println("PERINGATAN SERANGAN UDARA TERDETEKSI!!!");
                            canFly monsterTerbang = (canFly) monsterAktif;
                            monsterTerbang.lepasLandas();
                            monsterTerbang.seranganUdara();
                        } else {
                            monsterAktif.serangPemain();
                        }
                    } else {
                        System.out.println(gerombolanJMK48[i].namaMusuhh + " Sudah mati dan tidak bisa menyerang.");
                    }
                }
 
            } catch (java.util.InputMismatchException e) {
                System.out.println("ERROR INPUT: Anda harus memasukan ANGKA!!");
                input.nextLine(); // bersihkan buffer
 
            } catch (Targetmatiexception e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());
                input.nextLine();
 
            } catch (SeranganTidakValidExc e) {
                System.out.println("KESALAHAN GAME: " + e.getMessage());
                input.nextLine();
 
            } catch (Exception e) {
                System.err.println("Terjadi kesalahan sistem: " + e.getMessage());
                input.nextLine();
            }
 
        } 

            boolean semuaMati = true;
                for (int i = 0; i < gerombolanJMK48.length; i++) {
                    if (gerombolanJMK48[i].healthPoint > 0) {
                        semuaMati = false;
                        break;
                    }
                }
 
                if (semuaMati) {
                    System.out.println("\nSELAMAT! Anda telah menang melawan Gerombolan JMK48!");
                    isiBermain = false;
                }
 
        input.close();
        System.out.println("\nPermainan Berakhir.");
    }
}