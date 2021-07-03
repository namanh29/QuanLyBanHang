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
public class HoaDon {
    private int id, id_kh;
    private String ten_kh, ngay;
    private double tongtien;
    private String trang_thai;

    public HoaDon(int id, int id_kh, String ten_kh, String ngay, double tongtien, String trang_thai) {
        this.id = id;
        this.id_kh = id_kh;
        this.ten_kh = ten_kh;
        this.ngay = ngay;
        this.tongtien = tongtien*11/10;
        this.trang_thai = trang_thai;
    }

    public HoaDon(int id, int id_kh, String ngay, double tongtien, String trang_thai) {
        this.id = id;
        this.id_kh = id_kh;
        this.ngay = ngay;
        this.tongtien = tongtien*11/10;
        this.trang_thai = trang_thai;
    }

    public String getTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(String trang_thai) {
        this.trang_thai = trang_thai;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_kh() {
        return id_kh;
    }

    public void setId_kh(int id_kh) {
        this.id_kh = id_kh;
    }

    public String getTen_kh() {
        return ten_kh;
    }

    public void setTen_kh(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
}
