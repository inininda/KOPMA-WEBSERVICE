package pojos;
// Generated Nov 24, 2018 1:57:22 PM by Hibernate Tools 4.3.1



/**
 * Pembelian generated by hbm2java
 */
public class Pembelian  implements java.io.Serializable {


     private String idBarang;
     private String kodeUnik;
     private double jumlahPembayaran;
     private String statusPembayaran;

    public Pembelian() {
    }

    public Pembelian(String idBarang, String kodeUnik, double jumlahPembayaran, String statusPembayaran) {
       this.idBarang = idBarang;
       this.kodeUnik = kodeUnik;
       this.jumlahPembayaran = jumlahPembayaran;
       this.statusPembayaran = statusPembayaran;
    }
   
    public String getIdBarang() {
        return this.idBarang;
    }
    
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }
    public String getKodeUnik() {
        return this.kodeUnik;
    }
    
    public void setKodeUnik(String kodeUnik) {
        this.kodeUnik = kodeUnik;
    }
    public double getJumlahPembayaran() {
        return this.jumlahPembayaran;
    }
    
    public void setJumlahPembayaran(double jumlahPembayaran) {
        this.jumlahPembayaran = jumlahPembayaran;
    }
    public String getStatusPembayaran() {
        return this.statusPembayaran;
    }
    
    public void setStatusPembayaran(String statusPembayaran) {
        this.statusPembayaran = statusPembayaran;
    }




}


