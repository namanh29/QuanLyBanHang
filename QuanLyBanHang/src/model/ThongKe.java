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
public class ThongKe {
    private double doanhthu;
    private int thang;
    private int nam;

    public ThongKe(double doanhthu, int thang) {
        this.doanhthu = doanhthu;
        this.thang = thang;
    }

    public ThongKe(double doanhthu, int thang, int nam) {
        this.doanhthu = doanhthu;
        this.thang = thang;
        this.nam = nam;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }
    
    public double getDoanhthu() {
        return doanhthu;
    }

    public void setDoanhthu(double doanhthu) {
        this.doanhthu = doanhthu;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }
    
}
