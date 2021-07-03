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
import model.HoaDon;

/**
 *
 * @author Nam Anh
 */
public class HoaDonCtrl {
    public static int getID() {
        int id = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            String query = "SELECT MAX(id_hd) AS tong FROM hoa_don_xuat";
            statement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                id = rs.getInt("tong");
            }
            statement.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return id;
    }
    
    public static List<HoaDon> findAll(){
        List<HoaDon> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, khach_hang.ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and trang_thai like 'Đã xác nhận'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getDouble("tong_tien"),
                        resultSet.getString("trang_thai"));
                        
                resultList.add(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    
    public static List<HoaDon> findDonHang(){
        List<HoaDon> resultList = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, khach_hang.ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and trang_thai like 'Chưa xác nhận'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getDouble("tong_tien"),
                        resultSet.getString("trang_thai"));
                        
                resultList.add(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    
    public static void insert(HoaDon rs) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into hoa_don_xuat(id_hd, ngay_lap, id_kh, tong_tien, trang_thai) values(?, ?, ?, ?, ?)";
            statement = connection.prepareCall(sql);
            statement.setInt(1, rs.getId());
            statement.setString(2, rs.getNgay());          
            statement.setInt(3, rs.getId_kh());
            statement.setDouble(4, rs.getTongtien());
            statement.setString(5, rs.getTrang_thai());
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void insert_kh(HoaDon rs) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "insert into hoa_don_xuat(id_hd, ngay_lap, id_kh, tong_tien) values( ?, ?, ?)";
            statement = connection.prepareCall(sql);
            
            statement.setString(1, rs.getNgay());          
            statement.setInt(2, rs.getId_kh());
            statement.setDouble(3, rs.getTongtien());
            
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    public static void update(HoaDon rs) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "update hoa_don_xuat set trang_thai=? where id_hd = ?";
            statement = connection.prepareCall(sql);
            statement.setString(1, rs.getTrang_thai());
            
            statement.setInt(2, rs.getId());
            
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static void delete(int id) {
        
        Connection connection = null;
        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql2 = "delete from hoa_don_chi_tiet where id_hd = ?";
            statement2 = connection.prepareCall(sql2);
            statement2.setInt(1, id);
            statement2.execute();
            
            String sql = "delete from hoa_don_xuat where id_hd = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            statement.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public static List<HoaDon> findByName (String sid) {
        List<HoaDon> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and ten_kh like ?";
                    
            statement = connection.prepareCall(sql);
            statement.setString(1, "%"+sid+"%");
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getDouble("tong_tien"),
                        resultSet.getString("trang_thai"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    
    public static List<HoaDon> findByID (int id) {
        List<HoaDon> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and id_hd = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getFloat("tong_tien"),
                        resultSet.getString("trang_thai"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    public static List<HoaDon> findByIDkh_IDhd (int idkh, int idhd) {
        List<HoaDon> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and khach_hang.id_kh = ? and id_hd = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, idkh);
            statement.setInt(2, idhd);
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getFloat("tong_tien"),
                        resultSet.getString("trang_thai"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    public static List<HoaDon> findByIDkh_tt (int idkh, String tt) {
        List<HoaDon> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and khach_hang.id_kh = ? and trang_thai like ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, idkh);
            statement.setString(2, "%"+tt+"%");
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getFloat("tong_tien"),
                        resultSet.getString("trang_thai"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
    public static List<HoaDon> findByID_kh (int id) {
        List<HoaDon> resultList = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            //lay tat ca danh sach sinh vien
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            
            //query
            String sql = "select id_hd, ngay_lap, khach_hang.id_kh, ten_kh, tong_tien, trang_thai "
                    + "from hoa_don_xuat, khach_hang "
                    + "where hoa_don_xuat.id_kh = khach_hang.id_kh and hoa_don_xuat.id_kh = ?";
            statement = connection.prepareCall(sql);
            statement.setInt(1, id);
            
            ResultSet resultSet;
            resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                HoaDon rs;
                rs = new HoaDon(resultSet.getInt("id_hd"),
                        resultSet.getInt("id_kh"),
                        resultSet.getString("ten_kh"),
                        resultSet.getString("ngay_lap"),
                        resultSet.getFloat("tong_tien"),
                        resultSet.getString("trang_thai"));
                resultList.add(rs);
            } 
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonCtrl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultList;
    }
}
