package com.example.BaiKiemTra.Entity;

public class Sach {

    private long id;

    private String theLoai;

    private String tieuDe;

    private int soLuong;

    public Sach(long id, String theLoai, String tieuDe, int soLuong) {
        this.id = id;
        this.theLoai = theLoai;
        this.tieuDe = tieuDe;
        this.soLuong = soLuong;
    }

    public Sach() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Sach{" +
                "id=" + id +
                ", theLoai='" + theLoai + '\'' +
                ", tieuDe='" + tieuDe + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}
