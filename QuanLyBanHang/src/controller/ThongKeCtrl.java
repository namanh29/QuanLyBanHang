/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SanPham;

import model.ThongKe;

/**
 *
 * @author Nam Anh
 */
public class ThongKeCtrl {
    public static List<ThongKe> findAll(){
        List<ThongKe> tkList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select sum(tong_tien) as doanhthu, month(ngay_lap) as thang from hoa_don_xuat "
                            + "group by month(ngay_lap)";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                ThongKe tk;
                tk = new ThongKe(resultSet.getDouble("doanhthu"),                        
                        resultSet.getInt("thang"));
                tkList.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tkList;
    }
    public static List<ThongKe> findByTime(String date1, String date2){
        List<ThongKe> tkList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select sum(tong_tien) as doanhthu, month(ngay_lap) as thang, year(ngay_lap) as nam\n" +
                        "from hoa_don_xuat\n" +
                        "WHERE ngay_lap >= ? and ngay_lap <= ?\n" +
                        "group by  year(ngay_lap), month(ngay_lap) ";
                            
            statement = connection.prepareCall(sql);
            statement.setString(1, date1);
            statement.setString(2,  date2);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ThongKe tk;
                tk = new ThongKe(resultSet.getDouble("doanhthu"),                        
                        resultSet.getInt("thang"),
                        resultSet.getInt("nam"));
                tkList.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tkList;
    }
    public static List<ThongKe> findByMonth(int date1, int date2, int y1, int y2){
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(y1);
        System.out.println(y2);
        List<ThongKe> tkList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select sum(tong_tien) as doanhthu, month(ngay_lap) as thang, year(ngay_lap) as nam\n" +
                    "from hoa_don_xuat\n" +
                    "WHERE (year(ngay_lap) >= ?) and (year(ngay_lap) <= ?) and (month(ngay_lap) >= ?) and (month(ngay_lap) <= ?)\n" +
                    "group by month(ngay_lap), year(ngay_lap)";

                            
            statement = connection.prepareCall(sql);
            statement.setInt(1, y1);
            statement.setInt(2, y2);
            statement.setInt(3, date1+1);
            statement.setInt(4, date2+1);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                ThongKe tk;
                tk = new ThongKe(resultSet.getDouble("doanhthu"),                        
                        resultSet.getInt("thang"),
                        resultSet.getInt("nam"));
                        
                tkList.add(tk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return tkList;
    }
    public static List<SanPham> sp(){
        List<SanPham> spList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "SELECT hoa_don_chi_tiet.id_sp, ten_sp, SUM(so_luong) AS daban " + 
                    "FROM hoa_don_chi_tiet, san_pham " + 
                    "where hoa_don_chi_tiet.id_sp = san_pham.id_sp " +
                    "GROUP by id_sp ORDER by daban desc limit 5";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SanPham sp;
                sp = new SanPham(resultSet.getInt("id_sp"),                        
                        resultSet.getString("ten_sp"),
                        resultSet.getInt("daban"));
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return spList;
    }
    public static List<SanPham> sp2(String date1, String date2){
        List<SanPham> spList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "SELECT hoa_don_chi_tiet.id_sp, ten_sp, SUM(so_luong) AS daban \n" +
                        "FROM hoa_don_chi_tiet, san_pham, hoa_don_xuat\n" +
                        "where hoa_don_chi_tiet.id_sp = san_pham.id_sp and hoa_don_xuat.id_hd = hoa_don_chi_tiet.id_hd\n" +
                        "and ngay_lap >= ? and ngay_lap <= ?\n" +
                        "GROUP by id_sp ORDER by daban desc limit 5 ";
                    
            statement = connection.prepareCall(sql);
            statement.setString(1, date1);
            statement.setString(2, date2);
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                SanPham sp;
                sp = new SanPham(resultSet.getInt("id_sp"),                        
                        resultSet.getString("ten_sp"),
                        resultSet.getInt("daban"));
                spList.add(sp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ThongKeCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return spList;
    }
}
