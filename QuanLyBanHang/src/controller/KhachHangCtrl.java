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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.KhachHang;
/**
 *
 * @author Nam Anh
 */
public class KhachHangCtrl {
    public static List<KhachHang> findAll(){
        List<KhachHang> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from khach_hang";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                KhachHang std;
                std = new KhachHang(resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("gioi_tinh"),
                        resultSet.getString("dia_chi"),
                        resultSet.getString("email"),
                        resultSet.getString("dien_thoai"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    
    public static void insert(KhachHang kh) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into khach_hang(id_kh, ten_kh, gioi_tinh, dia_chi, email, dien_thoai) values(?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, kh.getId());
            statement.setString(2, kh.getName());
            statement.setString(3, kh.getGender());
            
            statement.setString(4, kh.getAddress());
            statement.setString(5, kh.getEmail());
            statement.setString(6, kh.getPhone());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void update(KhachHang kh) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "update khach_hang set ten_kh=?,gioi_tinh=?,dia_chi=?,email=?,dien_thoai=? where id_kh = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, kh.getName());
            statement.setString(2, kh.getGender());
            statement.setString(3, kh.getAddress());
            statement.setString(4, kh.getEmail());
            statement.setString(5, kh.getPhone());
            statement.setInt(6, kh.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void delete(int id) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement1 = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql1 = "delete from hoa_don_xuat where id_kh = ?";
            statement1 = connection.prepareCall(sql1);
            statement1.setInt(1, id);
            statement1.execute();
            
            String sql = "delete from khach_hang where id_kh = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
                       
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<KhachHang> findByName (String fullname) {
        List<KhachHang> khList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from khach_hang where ten_kh like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                KhachHang std;
                std = new KhachHang(resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("gioi_tinh"),
                        
                        resultSet.getString("dia_chi"),
                        resultSet.getString("email"),
                        resultSet.getString("dien_thoai"));
                khList.add(std);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khList;
    }
    
    public static List<KhachHang> findByID (int id) {
        List<KhachHang> khList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from khach_hang where id_kh = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                KhachHang std;
                std = new KhachHang(resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("gioi_tinh"),
                        
                        resultSet.getString("dia_chi"),
                        resultSet.getString("email"),
                        resultSet.getString("dien_thoai"));
                khList.add(std);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khList;
    }
    
    public static List<KhachHang> findByGender (String gender) {
        List<KhachHang> khList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from khach_hang where gioi_tinh like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, gender);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                KhachHang std;
                std = new KhachHang(resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("gioi_tinh"),
                        
                        resultSet.getString("dia_chi"),
                        resultSet.getString("email"),
                        resultSet.getString("dien_thoai"));
                khList.add(std);

            } 
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khList;
    }
}
