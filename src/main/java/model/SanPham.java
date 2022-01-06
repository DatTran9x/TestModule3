package model;

public class SanPham {
    private int id;
    private String name_sp;
    private int price;
    private int quantity;
    private String color;
    private String mota_sp;
    private int id_category;
    private String name_category;

    public SanPham() {
    }

    public SanPham(String name_sp, int price, int quantity, String color, String mota_sp, int id_category) {
        this.name_sp = name_sp;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.mota_sp = mota_sp;
        this.id_category = id_category;
    }

    public SanPham(int id, String name_sp, int price, int quantity, String color, String mota_sp, int id_category) {
        this.id = id;
        this.name_sp = name_sp;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.mota_sp = mota_sp;
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_sp() {
        return name_sp;
    }

    public void setName_sp(String name_sp) {
        this.name_sp = name_sp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMota_sp() {
        return mota_sp;
    }

    public void setMota_sp(String mota_sp) {
        this.mota_sp = mota_sp;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }
}
