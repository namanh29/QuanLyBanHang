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
import model.SanPham;

/**
 *
 * @author Nam Anh
 */
public class SanPhamCtrl {
    public static List<SanPham> findAll(){
        List<SanPham> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    public static List<SanPham> findAll2(){
        List<SanPham> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham where don_gia < 1000";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    public static List<SanPham> findAll3(){
        List<SanPham> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham where don_gia >= 1000 and don_gia <= 10000";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    
    public static void insert(SanPham kh) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into san_pham(id_sp, ten_sp, loai_sp, hang_sx, mo_ta, don_gia, bao_hanh) values(?, ?, ?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, kh.getId());
            statement.setString(2, kh.getTen());
            statement.setString(3, kh.getLoai());
            
            statement.setString(4, kh.getHang());
            statement.setString(5, kh.getMota());
            statement.setDouble(6, kh.getGia());
            statement.setDouble(7, kh.getBaohanh());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<SanPham> findAll4(){
        List<SanPham> studentList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham where don_gia >= 10000";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                studentList.add(std);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return studentList;
    }
    public static void update(SanPham kh) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "update san_pham set ten_sp=?,loai_sp=?,hang_sx=?,mo_ta=?,don_gia=?,bao_hanh=? where id_sp = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, kh.getTen());
            statement.setString(2, kh.getLoai());
            statement.setString(3, kh.getHang());
            statement.setString(4, kh.getMota());
            statement.setDouble(5, kh.getGia());
            statement.setDouble(6, kh.getBaohanh());
            statement.setInt(7, kh.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
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
//            String sql1 = "delete from result where id = ?";
//            statement1 = connection.prepareCall(sql1);
//            statement1.setInt(1, id);
//            statement1.execute();
            
            String sql = "delete from san_pham where id_sp = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
                       
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<SanPham> findByName (String fullname) {
        List<SanPham> khList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham where ten_sp like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+fullname+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                khList.add(std);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khList;
    }
    
//    public static List<SanPham> findByID (int id) {
//        List<SanPham> khList = new ArrayList<>();
//        
//        Connection connection = null;
//        PreparedStatement statement = null;
//        try {
//            //lay tat ca danh sach sinh vien
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
//            
//            //query
//            String sql = "select * from khach_hang where id_kh = ?";
//            statement = connection.prepareCall(sql);
//            statement.setInt(1, id);
//            
//            ResultSet resultSet;
//            resultSet = statement.executeQuery();
//            
//            while (resultSet.next()) {
//                SanPham std;
//                std = new SanPham(resultSet.getInt("id_kh"),
//                        resultSet.getString("ten_kh"),
//                        resultSet.getString("gioi_tinh"),
//                        
//                        resultSet.getString("dia_chi"),
//                        resultSet.getString("email"),
//                        resultSet.getString("dien_thoai"));
//                khList.add(std);
//            } 
//        } catch (SQLException ex) {
//            Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            if (statement != null){
//                try {
//                    statement.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(KhachHangCtrl.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return khList;
//    }
    
    public static List<SanPham> findByType (String type) {
        List<SanPham> khList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select * from san_pham where loai_sp like ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, type);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                SanPham std;
                std = new SanPham(resultSet.getInt("id_sp"),
                        resultSet.getString("ten_sp"),
                        resultSet.getString("loai_sp"),
                        
                        resultSet.getString("hang_sx"),
                        resultSet.getString("mo_ta"),
                        resultSet.getDouble("don_gia"),
                        resultSet.getDouble("bao_hanh"));
                khList.add(std);

            } 
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(SanPhamCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return khList;
    }
}
