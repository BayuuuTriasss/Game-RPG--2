public class Zombie extends Musuh implements canLoot {
    public Zombie() {
        super("Rusdi", 150);
    } 

    @Override
    public void serangPemain() {
        System.out.println( this.namaMusuhh + " Memukul pemain menggunakan PIPA PARALON!!!, Pemain -15 HP!");
    }

    @Override
    public void suaraKhas() {
        System.out.println( this.namaMusuhh + " Mengeluarkan suara OWAK RUSDIIII!!!!");
    }

    @Override
    public void jatuhkanItem() {
        System.out.println(this.namaMusuhh + " Mengeluarkan Lootingan karna sudah Die!!!");
    }
}
