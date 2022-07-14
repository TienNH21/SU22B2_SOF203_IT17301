package lesson5;

public class Product {
    private int id;
    private String tenSP;
    private int soLg;
    private double donGia;
    private String mauSac;
    private int danhMucId;

    public Product() {
    }

    public Product(int id, String tenSP, int soLg, double donGia, String mauSac, int danhMucId) {
        this.id = id;
        this.tenSP = tenSP;
        this.soLg = soLg;
        this.donGia = donGia;
        this.mauSac = mauSac;
        this.danhMucId = danhMucId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSoLg() {
        return soLg;
    }

    public void setSoLg(int soLg) {
        this.soLg = soLg;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public int getDanhMucId() {
        return danhMucId;
    }

    public void setDanhMucId(int danhMucId) {
        this.danhMucId = danhMucId;
    }
    
    
}
