public class Naga extends Musuh implements canFly, canLoot {
    
    public Naga() {
        super("Nasir", 300);
    }

    @Override
    public void serangPemain() {
        System.out.println(this.namaMusuhh + " Menyemburkan Nafas MUWANI!!! Player -20 HP.");
    }

    @Override
    public void suaraKhas() {
        System.out.println(this.namaMusuhh + " Mengeluarkan suara PERGI KAU SUKI.");
    }

    @Override
    public void lepasLandas() {
        System.out.println(this.namaMusuhh + " Sedang terbang tinggi!! Sulit untuk diserang.");
    }

    @Override
    public void seranganUdara () {
        System.out.println(this.namaMusuhh + " Menyemburkan fire puanas!!! Pemain -80 HP.");
    }

    @Override
    public void jatuhkanItem() {
        System.out.println(this.namaMusuhh + " Mengeluarkan Lootingan karna sudah Die!!!");
    }
}
