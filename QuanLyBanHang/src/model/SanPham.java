/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Nam Anh
 */
public class SanPham {
    private int id;
    private String ten, loai, hang, mota;
    private double gia, baohanh;
    private int daban;
    public SanPham(int id) {
        this.id = id;
    }

    public SanPham(int id, String ten, String loai, String hang, String mota, double gia, double baohanh) {
        this.id = id;
        this.ten = ten;
        this.loai = loai;
        this.hang = hang;
        this.mota = mota;
        this.gia = gia;
        this.baohanh = baohanh;
    }

    public SanPham(int id, String ten, int daban) {
        this.id = id;
        this.ten = ten;
        this.daban = daban;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(double baohanh) {
        this.baohanh = baohanh;
    }

    public int getDaban() {
        return daban;
    }

    public void setDaban(int daban) {
        this.daban = daban;
    }
    
}

