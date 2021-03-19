
package project;

import Calculator.CalculatorGUI;
import Menu.Note_date;
import Menu.Themtaikhoan;
import Menu.qlThongtintaikhoan;
import QLTrungtamtinhoc.SendMailOK;
import dangnhap.Dangnhap;
import QLTrungtamtinhoc.Staff;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.filechooser.FileNameExtensionFilter;
import windowssidepackage.*;

/**
 *
 * @author admin
 */
public final class GuiMain extends JFrame{
    private GroupLayout layout;
    public static JPanel node;
    private JPanel jstack;
    private JPanel jPanel01, jPanel03, jPanel05, jPanel07, jPanel09, jPanel011;
    private JPanel  jPanel013, jPanel015, jPanel017, jPanel019, jPanel021;
    private JPanel  jPanel023, jPanel025;
 
    private JPanel jPanel02, jPanel04, jPanel06, jPanel08, jPanel010, jPanel2;
    private JPanel jPanel3, jPanel4, jPanel7;
    private JLabel jLabel3, jLabel5, jLabel7, jLabel9, jLabel11;
    private JLabel jLabel13,jLabel15,jLabel17,jLabel19,jLabel21,jLabel23,jLabel25;
    private JLabel jLabel4, jLabel6, jLabel8, jLabel10,jLabel40,jLabel60,jLabel80;
    private final int sokhoahoc = 0;
    private final int sohocvien = 0;
    private int sogmail = 0;
    private String nameAccount = " ";
    private int id_staff = Dangnhap.getIddangnhap();
    static String filepath;
    private JMenu jMenu1,jMenu3,jMenu5,jMenu51 ,jMenu52, jMenu7,jMenu71,jMenu72,jMenu9;
    private JMenuBar jMenuBar1;
    List<JPanel> listDanhMuc;
    List<JMenu> listMenu;
    private static int x = 0;
    private static int y = 0;
    int type_staff = 0;
    public static int getWidthFrame(){
         return x;
     }
    public static int getHeightFrame(){
         return y;
     }  
    
    public GuiMain(){ 
       Staff stf =new Staff(id_staff);
       type_staff = stf.getTypestaff();
        System.out.println(type_staff);
       nameAccount = stf.getNamestaff();  
       SendMailOK sm = new SendMailOK();
       sogmail = sm.getSomail();
       Gui_Header();
       GuiMain_Init(); 
       GuiMain_Image();
       jstack = jPanel02;
        listDanhMuc = new ArrayList<>();
        listDanhMuc.add(jPanel05);
        listDanhMuc.add(jPanel07);
        listDanhMuc.add(jPanel09);
        listDanhMuc.add(jPanel011);
        listDanhMuc.add(jPanel013);
        listDanhMuc.add(jPanel015);
        listDanhMuc.add(jPanel017);
        listDanhMuc.add(jPanel019);
        listDanhMuc.add(jPanel04);
        listDanhMuc.add(jPanel06);
        listDanhMuc.add(jPanel08);
        setEvent(listDanhMuc);
        
        listMenu = new ArrayList<>();
        listMenu.add(jMenu3);
        listMenu.add(jMenu5);
        listMenu.add(jMenu51);
        listMenu.add(jMenu52);
        listMenu.add(jMenu7);
        listMenu.add(jMenu71);
        listMenu.add(jMenu72);
        listMenu.add(jMenu9);
        msetEvent(listMenu);
      
       this.setExtendedState(JFrame.MAXIMIZED_BOTH);
      // setResizable(false);
    }
    
    Boolean setWorking(JPanel jPanel){
        if(type_staff == 2){
            if(jPanel == jPanel015||jPanel == jPanel017||jPanel == jPanel019){
                jPanel.setOpaque(false);
                return false;
            }
        }
         return true;
    }
    
    Boolean msetWorking(JMenu jMenu){
       /* if( jPanel == jPanel07||jPanel == jPanel09){
            jPanel.setOpaque(false);
            return false;
        }*/
        return true;
    }

    void Gui_Header(){
        jMenuBar1 = new JMenuBar();
        jMenuBar1.setPreferredSize(new java.awt.Dimension(1300, 35));
        setJMenuBar(jMenuBar1);
        
        jMenu1 = new JMenu();
        jMenu1.setText(" "+nameAccount);
        jMenu1.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 2, 20));
        jMenuBar1.add(jMenu1);

        jMenu3 = new JMenu();
        jMenu3.setText("Thông tin tài khoản");
        jMenu3.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu3.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu3);
        
        jMenu5 = new JMenu();
        jMenu5.setText("Tiện ích mở rộng");
        jMenu5.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu5.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu5);
        
        jMenu51 = new JMenu();
        jMenu51.setText("Ghi chú công việc");
        jMenu51.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu51.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu5.add(jMenu51);
        
        jMenu52 = new JMenu();
        jMenu52.setText("Máy tính");
        jMenu52.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu52.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu5.add(jMenu52);
        
        jMenu7 = new JMenu();
        jMenu7.setText("Cài đặt");
        jMenu7.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu7.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu7);
        
        jMenu71 = new JMenu();
        jMenu71.setText("Hình nền");
        jMenu71.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu71.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu7.add(jMenu71);
        
        jMenu72 = new JMenu();
        jMenu72.setText("Chưa hỗ trợ");
        jMenu72.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu72.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu7.add(jMenu72);
        
        jMenu9 = new JMenu();
        jMenu9.setText("Đăng xuất");
        jMenu9.setPreferredSize(new java.awt.Dimension(250, 35));
        jMenu9.setFont(new java.awt.Font("Segoe UI", 2, 15));
        jMenu1.add(jMenu9);
        
    }
    
    void GuiMain_Image(){
      jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/home .png"))); 
      jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/student.png")));
      jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/teacher1.png"))); 
      jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/class.png"))); 
      jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/team1.png"))); 
      jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money.png")));
      jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/diagrampng.png"))); 
      jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/course.png"))); 
      jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/other.png"))); 

      jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lesson2.png"))); 
      jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/room.png"))); 
      jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/gmail1.png"))); 
      jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background/main.png"))); 
      BufferedImage image;
        try {
            File file = new File(".");
            String s = file.getAbsolutePath();
            filepath = s.substring(0, s.length() - 1);
            image = ImageIO.read(new File(filepath+"\\src\\Image\\background\\main.png"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(x*3/4-x/25, y*487/660, image.SCALE_SMOOTH));
            jLabel10.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
        }
            
      
      jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/user.png")));
    }
    
    void GuiMain_Init(){
/******************************** label left *********************************/        
// <editor-fold defaultstate="collapsed" desc="Generated Code">  

       this.setTitle("Phần mềm quản lý trung tâm tin học ABC");
       this.setBounds(0, 0, 1370, 730); 
       this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       this.setVisible(true);
       x = this.getWidth(); 
       y = this.getHeight();
       jstack = new JPanel();
       
        jLabel3 = new JLabel("TRUNG TÂM TIN HỌC ABC");
        jLabel3.setFont(new Font(Font.SERIF, Font.BOLD,  25));
        jLabel3.setForeground(Color.WHITE);
        
      /*  jLabel30 = new JLabel();
        jLabel30.setText("Chào, " + nameAccount);
        jLabel30.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel30.setForeground(Color.WHITE);*/    

        jLabel5 = new JLabel("   MÀN HÌNH CHÍNH");
        jLabel5.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel5.setForeground(Color.WHITE);
        
        jLabel7 = new JLabel("   QUẢN LÝ HỌC VIÊN");
        jLabel7.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel7.setForeground(Color.WHITE);

        jLabel9 = new JLabel("   QUẢN LÝ GIÁO VIÊN");
        jLabel9.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel9.setForeground(Color.WHITE);
  
        jLabel11 = new JLabel("   QUẢN LÝ LỚP HỌC");
        jLabel11.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel11.setForeground(Color.WHITE);
    
        
        jLabel13 = new JLabel("  QUẢN LÝ NHÂN VIÊN");
        jLabel13.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel13.setForeground(Color.WHITE);
        
        jLabel15 = new JLabel("   QUẢN LÝ THU CHI");
        jLabel15.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel15.setForeground(Color.WHITE);
        
        jLabel17 = new JLabel("   THỐNG KÊ DỮ LIỆU");
        jLabel17.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel17.setForeground(Color.WHITE);
        
        jLabel19 = new JLabel("   TẠO LẬP HÓA ĐƠN");
        jLabel19.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel19.setForeground(Color.WHITE);
        
        jLabel21 = new JLabel("   TRỐNG");
        jLabel21.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel21.setForeground(Color.WHITE);
        
        jLabel23 = new JLabel("   TRỐNG");
        jLabel23.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel23.setForeground(Color.WHITE);
        
        jLabel25 = new JLabel("   TRỐNG");
        jLabel25.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel25.setForeground(Color.WHITE);
 // </editor-fold>  
 /******************************* label right ********************************/
 // <editor-fold defaultstate="collapsed" desc="Generated Code">  

        jLabel4 = new JLabel("   KHÓA HỌC");
        jLabel4.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel4.setForeground(Color.WHITE);
                 
        jLabel40 = new JLabel();
        jLabel40.setFont(new Font(Font.SERIF, Font.BOLD,  25));
        jLabel40.setForeground(Color.WHITE);  
        jLabel40.setText(String.valueOf(sokhoahoc));
        
        jLabel6 = new JLabel("    PHÒNG HỌC");
        jLabel6.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel6.setForeground(Color.WHITE);
    
        jLabel60 = new JLabel();
        jLabel60.setFont(new Font(Font.SERIF, Font.BOLD,  25));
        jLabel60.setForeground(Color.WHITE);  
        jLabel60.setText(String.valueOf(sohocvien));
        
        jLabel8 = new JLabel("   HỘP THƯ");
        jLabel8.setFont(new Font(Font.SERIF, Font.BOLD,  20));
        jLabel8.setForeground(Color.WHITE);
      
        jLabel80 = new JLabel();
        jLabel80.setFont(new Font(Font.SERIF, Font.BOLD,  25));
        jLabel80.setForeground(Color.WHITE);  
        jLabel80.setText(String.valueOf(sogmail));
        
        jLabel10 = new JLabel(/*"TRUNG TÂM TIN HỌC ABC "
                + "CÙNG BẠN VƯƠN TỚI TƯƠNG LAI"*/);
        jLabel10.setFont(new Font(Font.SERIF, Font.BOLD,  15));
        jLabel10.setForeground(Color.magenta);
      
  // </editor-fold>  
    
 /******************************** GROUP LAYOUT RIGHT *************************/
 // <editor-fold defaultstate="collapsed" desc="Generated Code">
        jPanel2 = new   JPanel();
        jPanel3 = new   JPanel();
        jPanel7 = new   JPanel();
        jPanel4 = new   JPanel();
        
        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(x/4)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(y/8)
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7,GroupLayout.DEFAULT_SIZE,
                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jPanel7,GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
// </editor-fold> 
 // <editor-fold defaultstate="collapsed" desc="Generated Code">
        jPanel02 = new  JPanel();
        jPanel04 = new  JPanel();
        jPanel06 = new  JPanel();
        jPanel08 = new  JPanel();
        jPanel010 = new JPanel();
        GroupLayout jPanel04Layout = new GroupLayout(jPanel04);
        jPanel04.setLayout(jPanel04Layout);
        jPanel04Layout.setHorizontalGroup(
          jPanel04Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel04Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel4)
            )
            .addGroup(jPanel04Layout.createSequentialGroup()
            .addGap(x/9)
            .addComponent(jLabel40)
            )
            .addGap(x/4-x/55)
        );
        jPanel04Layout.setVerticalGroup(
            jPanel04Layout.createParallelGroup(GroupLayout.Alignment.LEADING)       
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel04Layout.createSequentialGroup()   
            .addComponent(jLabel4)
            .addGap(y/18)
            )
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel04Layout.createSequentialGroup()   
            .addComponent(jLabel40)
            .addGap(y/36)
            )
            .addGap(y/6)
        );
        jPanel04.setBackground(new java.awt.Color(255, 64, 25));

        GroupLayout jPanel06Layout = new GroupLayout(jPanel06);
        jPanel06.setLayout(jPanel06Layout);
        jPanel06Layout.setHorizontalGroup(
            jPanel06Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel06Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel6)
             )
            .addGroup(jPanel06Layout.createSequentialGroup()
            .addGap(x/9)
            .addComponent(jLabel60)
             )
            .addGap(x/4-x/55)
        );
        jPanel06Layout.setVerticalGroup(
            jPanel06Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel06Layout.createSequentialGroup()
            .addComponent(jLabel6)
            .addGap(y/18)
            )
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel06Layout.createSequentialGroup()
            .addComponent(jLabel60)
            .addGap(y/36)
            )
            .addGap(y/6)
        );
        jPanel06.setBackground(new java.awt.Color(25, 25, 255));


        GroupLayout jPanel08Layout = new GroupLayout(jPanel08);
        jPanel08.setLayout(jPanel08Layout);
        jPanel08Layout.setHorizontalGroup(
            jPanel08Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel08Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel8)
        )
           .addGroup(jPanel08Layout.createSequentialGroup()
            .addGap(x/9)
            .addComponent(jLabel80)
        )
            .addGap(x/4-x/55)
        );
        jPanel08Layout.setVerticalGroup(
            jPanel08Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel08Layout.createSequentialGroup()
            .addComponent(jLabel8)
            .addGap(y/18)
            )
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel08Layout.createSequentialGroup()
            .addComponent(jLabel80)
            .addGap(y/36)
            )
            .addGap(y/6)
        );
        jPanel08.setBackground(new java.awt.Color( 0, 153, 77));


        GroupLayout jPanel010Layout = new GroupLayout(jPanel010);
        jPanel010.setLayout(jPanel010Layout);
        jPanel010Layout.setHorizontalGroup(
            jPanel010Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(jPanel010Layout.createSequentialGroup()
            .addGap(0)
            .addComponent(jLabel10)
        )
            .addGap(x*3/4-x/25)
        );
        jPanel010Layout.setVerticalGroup(
            jPanel010Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel010Layout.createSequentialGroup()
            .addComponent(jLabel10)
            .addGap(y/6)
            )
            .addGap(y*5/6)
        );
        jPanel010.setBackground(Color.WHITE);

// </editor-fold> 

 // <editor-fold defaultstate="collapsed" desc="Generated Code">  

        javax.swing.GroupLayout jPanel02Layout = new javax.swing.GroupLayout(jPanel02);
        jPanel02.setLayout(jPanel02Layout);
        jPanel02Layout.setHorizontalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel02Layout.createSequentialGroup()
                .addComponent(jPanel04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
               .addGroup(jPanel02Layout.createSequentialGroup()
                .addComponent(jPanel010, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()
                .addGap(3*x/4))
        );
        jPanel02Layout.setVerticalGroup(
            jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel02Layout.createSequentialGroup()
                .addGroup(jPanel02Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel04, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel06, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel08, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel010, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap()
                .addGap(y))
        );
        jPanel02.setBackground(Color.WHITE);
// </editor-fold> 
/********************************* GROUP LAYOUT LEFT **************************/
 // <editor-fold defaultstate="collapsed" desc="Generated Code">  
        jPanel01 = new  JPanel();
        jPanel03 = new  JPanel();
        jPanel05 = new  JPanel();
        jPanel07 = new  JPanel();
        jPanel09 = new  JPanel();
        jPanel011 = new JPanel();
        jPanel013 = new JPanel();
        jPanel015 = new JPanel();
        jPanel017 = new JPanel();
        jPanel019 = new JPanel();
        jPanel021 = new JPanel();
        jPanel023 = new JPanel();
        jPanel025 = new JPanel();

        javax.swing.GroupLayout jPanel03Layout = new javax.swing.GroupLayout(jPanel03);
        jPanel03.setLayout(jPanel03Layout);
        jPanel03Layout.setHorizontalGroup(
            jPanel03Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
            .addGroup(jPanel03Layout.createSequentialGroup()
            .addGap(x/100)
            .addComponent(jLabel3)
        )
            .addGap(x/4)    
        );
        jPanel03Layout.setVerticalGroup(
            jPanel03Layout.createParallelGroup(GroupLayout.Alignment.CENTER)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel03Layout.createSequentialGroup()
            .addComponent(jLabel3)
            .addGap(y/40)
            )
            .addGap(y/10)
        );
        jPanel03.setBackground(new java.awt.Color(255, 51, 51));

        GroupLayout jPanel05Layout = new GroupLayout(jPanel05);
        jPanel05.setLayout(jPanel05Layout);
        jPanel05Layout.setHorizontalGroup(
            jPanel05Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel05Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel5)
        )
            .addGap(x/4)
        );
        jPanel05Layout.setVerticalGroup(
            jPanel05Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel05Layout.createSequentialGroup()
            .addComponent(jLabel5)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel05.setBackground(new java.awt.Color(34, 204, 0));

        GroupLayout jPanel07Layout = new GroupLayout(jPanel07);
        jPanel07.setLayout(jPanel07Layout);
        jPanel07Layout.setHorizontalGroup(
            jPanel07Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel07Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel7)
        )
            .addGap(x/4)
        );
        jPanel07Layout.setVerticalGroup(
            jPanel07Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel07Layout.createSequentialGroup()
            .addComponent(jLabel7)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel07.setBackground(new java.awt.Color(34, 204, 0));


        GroupLayout jPanel09Layout = new GroupLayout(jPanel09);
        jPanel09.setLayout(jPanel09Layout);
        jPanel09Layout.setHorizontalGroup(
            jPanel09Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel09Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel9)
        )
            .addGap(x/4)
        );
        jPanel09Layout.setVerticalGroup(
            jPanel09Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel09Layout.createSequentialGroup()
            .addComponent(jLabel9)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel09.setBackground(new java.awt.Color(34, 204, 0));


        GroupLayout jPanel011Layout = new GroupLayout(jPanel011);
        jPanel011.setLayout(jPanel011Layout);
        jPanel011Layout.setHorizontalGroup(
            jPanel011Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel011Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel11)
        )
            .addGap(x/4)
        );
        jPanel011Layout.setVerticalGroup(
            jPanel011Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel011Layout.createSequentialGroup()
            .addComponent(jLabel11)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel011.setBackground(new java.awt.Color(34, 204, 0));


        GroupLayout jPanel013Layout = new GroupLayout(jPanel013);
        jPanel013.setLayout(jPanel013Layout);
        jPanel013Layout.setHorizontalGroup(
            jPanel013Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel013Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel13)
        )
            .addGap(x/4)
                
        );
        jPanel013Layout.setVerticalGroup(
            jPanel013Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel013Layout.createSequentialGroup()
            .addComponent(jLabel13)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel013.setBackground(new java.awt.Color(34, 204, 0));
              
        GroupLayout jPanel015Layout = new GroupLayout(jPanel015);
        jPanel015.setLayout(jPanel015Layout);
        jPanel015Layout.setHorizontalGroup(
            jPanel015Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel015Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel15)
        )
            .addGap(x/4)
        );
        jPanel015Layout.setVerticalGroup(
            jPanel015Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel015Layout.createSequentialGroup()
            .addComponent(jLabel15)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel015.setBackground(new java.awt.Color(34, 204, 0));
        
        
        GroupLayout jPanel017Layout = new GroupLayout(jPanel017);
        jPanel017.setLayout(jPanel017Layout);
        jPanel017Layout.setHorizontalGroup(
            jPanel017Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel017Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel17)
        )
            .addGap(x/4)
        );
        jPanel017Layout.setVerticalGroup(
            jPanel017Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel017Layout.createSequentialGroup()
            .addComponent(jLabel17)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel017.setBackground(new java.awt.Color(34, 204, 0));
        
        GroupLayout jPanel019Layout = new GroupLayout(jPanel019);
        jPanel019.setLayout(jPanel019Layout);
        jPanel019Layout.setHorizontalGroup(
            jPanel019Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel019Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel19)
        )
            .addGap(x/4)
        );
        jPanel019Layout.setVerticalGroup(
            jPanel019Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel019Layout.createSequentialGroup()
            .addComponent(jLabel19)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel019.setBackground(new java.awt.Color(34, 204, 0));
        
        
        GroupLayout jPanel021Layout = new GroupLayout(jPanel021);
        jPanel021.setLayout(jPanel021Layout);
        jPanel021Layout.setHorizontalGroup(
        jPanel021Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel021Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel21)
        )
            .addGap(x/4)
        );
        jPanel021Layout.setVerticalGroup(
            jPanel021Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel021Layout.createSequentialGroup()
            .addComponent(jLabel21)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel021.setBackground(new java.awt.Color(34, 204, 0));
        
        GroupLayout jPanel023Layout = new GroupLayout(jPanel023);
        jPanel023.setLayout(jPanel023Layout);
        jPanel023Layout.setHorizontalGroup(
        jPanel023Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel023Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel23)
        )
            .addGap(x/4)
        );
        jPanel023Layout.setVerticalGroup(
            jPanel023Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel023Layout.createSequentialGroup()
            .addComponent(jLabel23)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel023.setBackground(new java.awt.Color(34, 204, 0));
        
        GroupLayout jPanel025Layout = new GroupLayout(jPanel025);
        jPanel025.setLayout(jPanel025Layout);
        jPanel025Layout.setHorizontalGroup(
        jPanel025Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel025Layout.createSequentialGroup()
            .addGap(x/50)
            .addComponent(jLabel25)
        )
            .addGap(x/4)
        );
        jPanel025Layout.setVerticalGroup(
            jPanel025Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel025Layout.createSequentialGroup()
            .addComponent(jLabel25)
            .addGap(y/75)
            )
            .addGap(y/15)
        );
        jPanel025.setBackground(new java.awt.Color(34, 204, 0));
        
 // </editor-fold>         
 // <editor-fold defaultstate="collapsed" desc="Generated Code">  
 javax.swing.GroupLayout jPanel01Layout = new javax.swing.GroupLayout(jPanel01);
 jPanel01.setLayout(jPanel01Layout);
 jPanel01Layout.setHorizontalGroup(
     jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel03, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)        
        .addGroup(jPanel01Layout.createSequentialGroup()
        .addGap(x/100)                                        // can le truoc
        .addGroup(jPanel01Layout.createParallelGroup(GroupLayout.Alignment.LEADING)

        .addComponent(jPanel05, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel07, GroupLayout.DEFAULT_SIZE,
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel09, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel011, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel013, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel015, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel017, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel019, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
       /* .addComponent(jPanel021, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel023, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel025, GroupLayout.DEFAULT_SIZE, 
            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)*/
        )
        .addContainerGap(x/100, Short.MAX_VALUE))       //can le sau
        .addGap(x/4)
 );
 jPanel01Layout.setVerticalGroup(
     jPanel01Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
     .addGroup(jPanel01Layout.createSequentialGroup()
        .addGap(0)                                        //can le ten
        .addComponent(jPanel03, GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
             
        .addContainerGap()
        .addGap(y/50)                                  //can le tren

        .addComponent(jPanel05, GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel07, GroupLayout.PREFERRED_SIZE,
            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel09, GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel011, GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        .addComponent(jPanel013, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        .addComponent(jPanel015, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)

        .addComponent(jPanel017, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        .addComponent(jPanel019, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        /*.addComponent(jPanel021, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
             
        .addComponent(jPanel023, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
          
        .addComponent(jPanel025, javax.swing.GroupLayout.PREFERRED_SIZE, 
            GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)*/
        .addGap(y))
        );      
        jPanel01.setBackground(new java.awt.Color(51,51,51));
// </editor-fold>  
/********************************* LAYOUT ************************************/
 // <editor-fold defaultstate="collapsed" desc="Generated Code">       

        layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel01, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel02, GroupLayout.PREFERRED_SIZE, 
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(x)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4,  GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel02, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel01, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(y)
        );
 /****************************************************************************/
  // </editor-fold>  
    } 
    
    void addLayout(JPanel jPanel0x){
           this.remove(jstack);
           this.remove(jPanel01);
           this.remove(jPanel3);
           this.remove(jPanel4);
           jstack = jPanel0x;
           
 /*************** Add LAYOUT ***********************************************/
 // <editor-fold defaultstate="collapsed" desc="Generated Code">
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel01, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE,
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel0x, GroupLayout.PREFERRED_SIZE, 
                    GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(x)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel4,  GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel0x, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel01, GroupLayout.DEFAULT_SIZE, 
                    GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(y)
        );
       pack(); 
     // </editor-fold>
  }
    
 /********************* EVENT *************************************************/       
    class LabelEvent implements MouseListener {

      private final JPanel jpnItem;

      public LabelEvent(JPanel jpnItem) {
           this.jpnItem = jpnItem;
      }
      
      @Override
      public void mouseClicked(MouseEvent e) {
        if(setWorking(jpnItem)){  
            if(jpnItem == jPanel05) {
                node = jPanel02;
            }
            else if(jpnItem == jPanel07){
                node = new qlHocvien();
            }
            else if(jpnItem == jPanel09){
                node = new qlGiaovien();
            }
            else if(jpnItem == jPanel011){
                node = new qlLophoc();
            }
            else if(jpnItem == jPanel013){
                 node = new qlNhanvien();
            }
            else if(jpnItem == jPanel015){
                node = new qlThuchi();
            }
            else if(jpnItem == jPanel017){
                node = new tkDulieu();
            }
            else if(jpnItem == jPanel019){
                node = new tlHoadon();
                
            }else if(jpnItem == jPanel04){
                node = new showKhoahoc();
            }
            else if(jpnItem == jPanel06){
                node = new showPhonghoc();
            }
            else if(jpnItem == jPanel08){
                node = new showGmail();
            }
            
            addLayout(node);
        }
    }

      @Override
      public void mousePressed(MouseEvent e) {
          // jpnItem.setBackground(new Color(96, 100, 191));
      }
      @Override
      public void mouseReleased(MouseEvent e) {
         
      }
      @Override
      public void mouseEntered(MouseEvent e) {
           if(jpnItem == jPanel04)  
                jpnItem.setBackground(new Color(128,0, 0));
           else if (jpnItem == jPanel06)
                jpnItem.setBackground(new Color(34, 0, 102));
           else if (jpnItem == jPanel08)
                jpnItem.setBackground(new Color(34, 51, 0));
           else 
                jpnItem.setBackground(new Color(102, 102, 255));
      }
      @Override
      public void mouseExited(MouseEvent e) {
           if(jpnItem == jPanel04)  
                jpnItem.setBackground(new java.awt.Color(255, 64, 25));
           else if (jpnItem == jPanel06)
                jpnItem.setBackground(new java.awt.Color(25, 25, 255));
           else if (jpnItem == jPanel08)
                jpnItem.setBackground(new java.awt.Color( 0, 153, 77));
           else 
                jpnItem.setBackground(new java.awt.Color(34, 204, 0));
          }
    }
    
     public void setEvent(List<JPanel> listDanhMuc) {
            listDanhMuc.forEach(( item) -> {
                item.addMouseListener(new LabelEvent(item));
                setWorking(item);
            });
     }
/******************************************************************************/
 class MenuEvent implements MouseListener {

        private JFrame node;
        private final JMenu jmnItem;

        public MenuEvent(JMenu jmnItem) {
             this.jmnItem = jmnItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
          if(msetWorking(jmnItem)){
              if(jmnItem == jMenu3) {
                  node = new qlThongtintaikhoan(id_staff);
                  node.setVisible(true);
              }
              else if(jmnItem == jMenu51){
                  node = new Note_date();
                  node.setVisible(true);
              } 
              else if(jmnItem == jMenu52){
                  node = new CalculatorGUI();
                  node.setVisible(true);
              } 
              else if(jmnItem == jMenu9){
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        Dangnhap dangnhap = new Dangnhap();
                        dangnhap.setVisible(true);
                        dispose();
              }
              else if(jmnItem == jMenu71){
                  JFileChooser fc = new JFileChooser();
                  fc.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "gif", "bmp"));
                  fc.setAcceptAllFileFilterUsed(true);
                  
                  int rVal = fc.showOpenDialog(null);
                  if (rVal == JFileChooser.APPROVE_OPTION) {
                    String filename = fc.getSelectedFile().getName();
                    String dir = fc.getCurrentDirectory().toString();
                    File file = new File(filepath + "\\src\\Image\\background\\main.png");
                    if (file.exists()) {
                           file.delete();
	                } 
                    Path source = Paths.get(dir+"\\"+filename);
                    Path dest = Paths.get(filepath + "\\src\\Image\\background\\main.png");  
                    try {
                        Files.move(source, dest);
                        setDefaultCloseOperation(EXIT_ON_CLOSE);
                        GuiMain guimail = new GuiMain();
                        guimail.setVisible(true);
                        dispose();
                    } catch (IOException ex) { 
                          Logger.getLogger(GuiMain.class.getName()).log(Level.SEVERE, null, ex);
                      } 
                  }
              }
            }
          
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // jpnItem.setBackground(new Color(96, 100, 191));
        }
        @Override
        public void mouseReleased(MouseEvent e) {

        }
        @Override
        public void mouseEntered(MouseEvent e) {
           jmnItem.setBackground(new Color(128, 128, 128));
        }
        @Override
        public void mouseExited(MouseEvent e) {
           jmnItem.setBackground(new java.awt.Color(240, 240, 240));
        }
    }  
 
        public void msetEvent(List<JMenu> listMenun) {
             listMenun.forEach(( item) -> {
                item.addMouseListener(new MenuEvent(item));
                msetWorking(item);
                
            });
     }
    
}