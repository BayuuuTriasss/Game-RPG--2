public class Slime extends Musuh implements canLoot {
    public Slime() {
       super("Ambaruwo", 100);
    }

    @Override
    public void serangPemain() {
        System.out.println( this.namaMusuhh + " Melompat dan Menyiram cairan MUWANI!!!, Pemain -13 HP!");
    }

    @Override
     public void suaraKhas() {
        System.out.println( this.namaMusuhh + " Mengeluarkan suara Ambasing, Ambabus, Ambatukam");
    }

    @Override
    public void jatuhkanItem() {
        System.out.println(this.namaMusuhh + " Mengeluarkan Lootingan karna sudah Die!!!");
    }
}
