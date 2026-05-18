public abstract class Musuh {

    // Atribut
    protected String namaMusuhh;
    protected int healthPoint;


    // Constructor
    public Musuh(String nama, int hp) {
        this.namaMusuhh = nama;
        this.healthPoint = hp;
    }


    // Method
    public void terimaDamage(int damage) {
        this.healthPoint -= damage;
        System.out.println(this.namaMusuhh + " Menerima Damage Sebesar " + damage + " Sisa HP: " + this.healthPoint );
    }

    public abstract void serangPemain();    

    public abstract void suaraKhas();
} 