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
public class HDChiTiet {
    private int id_hd, id_sp, sl;
    private double gia, thanhtien, baohanh;
    private String ten_sp;

    public HDChiTiet(int id_hd, int id_sp, int sl, double gia, String tensp, double baohanh) {
        this.id_hd = id_hd;
        this.id_sp = id_sp;
        this.sl = sl;
        this.gia = gia;
        this.thanhtien = sl*gia;
        this.ten_sp = tensp;
        this.baohanh = baohanh;
    }

    public HDChiTiet(int id_hd, int id_sp, int sl, double gia) {
        this.id_hd = id_hd;
        this.id_sp = id_sp;
        this.sl = sl;
        this.gia = gia;
        this.thanhtien = sl*gia;
        
    }

    public HDChiTiet(int id_sp, int sl, double gia) {
        this.id_sp = id_sp;
        this.sl = sl;
        this.gia = gia;
    }
    
    public int getId_hd() {
        return id_hd;
    }

    public void setId_hd(int id_hd) {
        this.id_hd = id_hd;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public double getBaohanh() {
        return baohanh;
    }

    public void setBaohanh(double baohanh) {
        this.baohanh = baohanh;
    }
    
}
