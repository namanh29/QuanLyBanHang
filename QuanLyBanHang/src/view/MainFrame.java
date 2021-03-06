/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.DanhMucBean;
import controller.MainController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Nam Anh
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("QUẢN LÝ BÁN HÀNG");
        List<DanhMucBean> listDanhMuc = new ArrayList<>();
        listDanhMuc.add(new DanhMucBean("TrangChu", Home, jblTrangChu));
        listDanhMuc.add(new DanhMucBean("KhachHang", KhachHangBtn, jlbKhachHang));
        listDanhMuc.add(new DanhMucBean("SanPham", SanPhamBtn, jlbSanPham));
        listDanhMuc.add(new DanhMucBean("HoaDon", HoaDonBtn, jlbHoaDon));
        listDanhMuc.add(new DanhMucBean("ThongKe", ThongKeBtn, jlbThongKe));
        
        MainController controller = new MainController(jpnBean, this);
        controller.setView(Home, jblTrangChu, "TrangChu");
        controller.setEvent(listDanhMuc);
        
        // confirm de thuc hien dong
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Are you sure to close??", "Confirm", JOptionPane.YES_NO_OPTION) == 0) {
                    dispose();
                }
            }
        }); 
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnContainer = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        Home = new javax.swing.JPanel();
        jblTrangChu = new javax.swing.JLabel();
        KhachHangBtn = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        SanPhamBtn = new javax.swing.JPanel();
        jlbSanPham = new javax.swing.JLabel();
        HoaDonBtn = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        ThoatBtn = new javax.swing.JPanel();
        jlbThoat = new javax.swing.JLabel();
        ThongKeBtn = new javax.swing.JPanel();
        jlbThongKe = new javax.swing.JLabel();
        jpnBean = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnContainer.setBackground(new java.awt.Color(255, 255, 255));

        jpnMenu.setBackground(new java.awt.Color(204, 204, 255));

        Home.setBackground(new java.awt.Color(102, 102, 102));

        jblTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jblTrangChu.setForeground(new java.awt.Color(255, 255, 255));
        jblTrangChu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/home.png"))); // NOI18N
        jblTrangChu.setText("Trang chủ");

        javax.swing.GroupLayout HomeLayout = new javax.swing.GroupLayout(Home);
        Home.setLayout(HomeLayout);
        HomeLayout.setHorizontalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HomeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jblTrangChu)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HomeLayout.setVerticalGroup(
            HomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HomeLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jblTrangChu)
                .addGap(21, 21, 21))
        );

        KhachHangBtn.setBackground(new java.awt.Color(102, 102, 102));
        KhachHangBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jlbKhachHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        jlbKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/customer.png"))); // NOI18N
        jlbKhachHang.setText("Khách Hàng");

        javax.swing.GroupLayout KhachHangBtnLayout = new javax.swing.GroupLayout(KhachHangBtn);
        KhachHangBtn.setLayout(KhachHangBtnLayout);
        KhachHangBtnLayout.setHorizontalGroup(
            KhachHangBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbKhachHang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        KhachHangBtnLayout.setVerticalGroup(
            KhachHangBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbKhachHang)
                .addContainerGap())
        );

        SanPhamBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbSanPham.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbSanPham.setForeground(new java.awt.Color(255, 255, 255));
        jlbSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/iphone.png"))); // NOI18N
        jlbSanPham.setText("Sản Phẩm");

        javax.swing.GroupLayout SanPhamBtnLayout = new javax.swing.GroupLayout(SanPhamBtn);
        SanPhamBtn.setLayout(SanPhamBtnLayout);
        SanPhamBtnLayout.setHorizontalGroup(
            SanPhamBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPhamBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SanPhamBtnLayout.setVerticalGroup(
            SanPhamBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SanPhamBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSanPham)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        HoaDonBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbHoaDon.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        jlbHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/receipt.png"))); // NOI18N
        jlbHoaDon.setText("Hóa đơn");

        javax.swing.GroupLayout HoaDonBtnLayout = new javax.swing.GroupLayout(HoaDonBtn);
        HoaDonBtn.setLayout(HoaDonBtnLayout);
        HoaDonBtnLayout.setHorizontalGroup(
            HoaDonBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HoaDonBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbHoaDon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HoaDonBtnLayout.setVerticalGroup(
            HoaDonBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HoaDonBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbHoaDon)
                .addContainerGap())
        );

        ThoatBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbThoat.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThoat.setForeground(new java.awt.Color(255, 255, 255));
        jlbThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logout.png"))); // NOI18N
        jlbThoat.setText("Đăng xuất");
        jlbThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbThoatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout ThoatBtnLayout = new javax.swing.GroupLayout(ThoatBtn);
        ThoatBtn.setLayout(ThoatBtnLayout);
        ThoatBtnLayout.setHorizontalGroup(
            ThoatBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThoatBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThoatBtnLayout.setVerticalGroup(
            ThoatBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThoatBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThoat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ThongKeBtn.setBackground(new java.awt.Color(102, 102, 102));

        jlbThongKe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbThongKe.setForeground(new java.awt.Color(255, 255, 255));
        jlbThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/analytics.png"))); // NOI18N
        jlbThongKe.setText("Thống kê");

        javax.swing.GroupLayout ThongKeBtnLayout = new javax.swing.GroupLayout(ThongKeBtn);
        ThongKeBtn.setLayout(ThongKeBtnLayout);
        ThongKeBtnLayout.setHorizontalGroup(
            ThongKeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeBtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbThongKe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ThongKeBtnLayout.setVerticalGroup(
            ThongKeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ThongKeBtnLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbThongKe)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpnMenuLayout = new javax.swing.GroupLayout(jpnMenu);
        jpnMenu.setLayout(jpnMenuLayout);
        jpnMenuLayout.setHorizontalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KhachHangBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SanPhamBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThoatBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThongKeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpnMenuLayout.setVerticalGroup(
            jpnMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnMenuLayout.createSequentialGroup()
                .addComponent(Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(KhachHangBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SanPhamBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(HoaDonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ThongKeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(ThoatBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jpnBean.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jpnBeanLayout = new javax.swing.GroupLayout(jpnBean);
        jpnBean.setLayout(jpnBeanLayout);
        jpnBeanLayout.setHorizontalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
        );
        jpnBeanLayout.setVerticalGroup(
            jpnBeanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnContainerLayout = new javax.swing.GroupLayout(jpnContainer);
        jpnContainer.setLayout(jpnContainerLayout);
        jpnContainerLayout.setHorizontalGroup(
            jpnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnContainerLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnBean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnContainerLayout.setVerticalGroup(
            jpnContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnBean, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlbThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbThoatMouseClicked
        // TODO add your handling code here:
        dispose();
        LoginForm lg = new LoginForm();
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
        lg.setResizable(false);
    }//GEN-LAST:event_jlbThoatMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel HoaDonBtn;
    private javax.swing.JPanel Home;
    private javax.swing.JPanel KhachHangBtn;
    private javax.swing.JPanel SanPhamBtn;
    private javax.swing.JPanel ThoatBtn;
    private javax.swing.JPanel ThongKeBtn;
    private javax.swing.JLabel jblTrangChu;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbSanPham;
    private javax.swing.JLabel jlbThoat;
    private javax.swing.JLabel jlbThongKe;
    private javax.swing.JPanel jpnBean;
    private javax.swing.JPanel jpnContainer;
    private javax.swing.JPanel jpnMenu;
    // End of variables declaration//GEN-END:variables
}
