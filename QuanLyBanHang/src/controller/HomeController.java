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
import javax.swing.JLabel;

/**
 *
 * @author Nam Anh
 */
public class HomeController {
    private JLabel tongSinhVienLb;
    private JLabel tongHocPhanLb;
    private JLabel tongsvGioi;
   

    public HomeController(JLabel tongSinhVienLb, JLabel tongHocPhan, JLabel tongsvGioi) {
        this.tongSinhVienLb = tongSinhVienLb;
        this.tongHocPhanLb = tongHocPhan;
        this.tongsvGioi = tongsvGioi;
    }
    
    public void setData() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/quanlybanhang", "root", "");
            String query = "SELECT COUNT(*) AS tong FROM san_pham";
            PreparedStatement preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongSinhVienLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM khach_hang";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongHocPhanLb.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
            query = "SELECT COUNT(*) AS tong FROM khach_hang";
            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                this.tongsvGioi.setText(String.valueOf(rs.getInt("tong")));
            }
            preparedStatement.close();
            
//            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
//                    "from result rs, subject sb\n" +
//                    "where rs.sid = sb.sid \n" +
//                    "group by rs.id\n" +
//                    "having cpa < 3.2 and cpa >= 2.5) as a";
//            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//            rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                this.tongsvKha.setText(String.valueOf(rs.getInt("tong")));
//            }
//            preparedStatement.close();
//            
//            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
//                    "from result rs, subject sb\n" +
//                    "where rs.sid = sb.sid \n" +
//                    "group by rs.id\n" +
//                    "having cpa < 2.5 and cpa >= 1.5) as a";
//            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//            rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                this.tongsvTB.setText(String.valueOf(rs.getInt("tong")));
//            }
//            preparedStatement.close();
//            
//            query = "SELECT count(*) as tong from (select sum(sb.credit*rs.grade4)/sum(sb.credit) as cpa\n" +
//                    "from result rs, subject sb\n" +
//                    "where rs.sid = sb.sid \n" +
//                    "group by rs.id\n" +
//                    "having cpa < 1.5) as a";
//            preparedStatement = (PreparedStatement)connection.prepareStatement(query);
//            rs = preparedStatement.executeQuery();
//            while (rs.next()){
//                this.tongsvKem.setText(String.valueOf(rs.getInt("tong")));
//            }
//            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
        }
    }

    public JLabel getTongSinhVienLb() {
        return tongSinhVienLb;
    }

    public void setTongSinhVienLb(JLabel tongSinhVienLb) {
        this.tongSinhVienLb = tongSinhVienLb;
    }

    public JLabel getTongHocPhanLb() {
        return tongHocPhanLb;
    }

    public void setTongHocPhanLb(JLabel tongHocPhanLb) {
        this.tongHocPhanLb = tongHocPhanLb;
    }

    public JLabel getTongsvGioi() {
        return tongsvGioi;
    }

    public void setTongsvGioi(JLabel tongsvGioi) {
        this.tongsvGioi = tongsvGioi;
    }

    
    
    
}
