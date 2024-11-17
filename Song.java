package com.example.java03_NAT.entity;


public class Song {
    private String ten_bai_hat;
    private Integer gia;
    private Integer thoi_luong;
    private String ngay_ra_mat;

    public Song() {
    }

    public Song(String ten_bai_hat, Integer gia, Integer thoi_luong, String ngay_ra_mat) {
        this.ten_bai_hat = ten_bai_hat;
        this.gia = gia;
        this.thoi_luong = thoi_luong;
        this.ngay_ra_mat = ngay_ra_mat;
    }

    public String getTen_bai_hat() {
        return ten_bai_hat;
    }

    public void setTen_bai_hat(String ten_bai_hat) {
        this.ten_bai_hat = ten_bai_hat;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public Integer getThoi_luong() {
        return thoi_luong;
    }

    public void setThoi_luong(Integer thoi_luong) {
        this.thoi_luong = thoi_luong;
    }

    public String getNgay_ra_mat() {
        return ngay_ra_mat;
    }

    public void setNgay_ra_mat(String ngay_ra_mat) {
        this.ngay_ra_mat = ngay_ra_mat;
    }

    @Override
    public String toString() {
        return "Song{" +
                "ten_bai_hat='" + ten_bai_hat + '\'' +
                ", gia=" + gia +
                ", thoi_luong=" + thoi_luong +
                ", ngay_ra_mat='" + ngay_ra_mat + '\'' +
                '}';
    }
}
