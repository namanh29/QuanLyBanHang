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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.HDChiTiet;
import model.HoaDon;


/**
 *
 * @author Nam Anh
 */
public class HDChiTietCtrl {
    public static void insert(HDChiTiet hdct) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into hoa_don_chi_tiet(id_hd, id_sp, so_luong, don_gia) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, hdct.getId_hd());
            statement.setInt(2, hdct.getId_sp());          
            statement.setInt(3, hdct.getSl());
            statement.setDouble(4, hdct.getGia());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void insert_kh(HDChiTiet hdct) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into hoa_don_chi_tiet( id_sp, so_luong, don_gia) values(?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setInt(1, hdct.getId_sp());          
            statement.setInt(2, hdct.getSl());
            statement.setDouble(3, hdct.getGia());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static List<HDChiTiet> findByID (int id) {
        List<HDChiTiet> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, hoa_don_chi_tiet.id_sp, so_luong, hoa_don_chi_tiet.don_gia, san_pham.ten_sp, san_pham.bao_hanh "
                    + "from hoa_don_chi_tiet, san_pham "
                    + "where hoa_don_chi_tiet.id_sp = san_pham.id_sp and hoa_don_chi_tiet.id_hd = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HDChiTiet hdct;
                hdct = new HDChiTiet(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_sp"),
                        resultSet.getInt("so_luong"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getString("ten_sp"),
                        resultSet.getDouble("bao_hanh"));
                resultList.add(hdct);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HDChiTietCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
}
