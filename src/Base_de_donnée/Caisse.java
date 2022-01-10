/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base_de_donnée;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import com.mysql.jdbc.Driver;

import Application.StatementBd;
import Application.Settings;
import Application.TableModel;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

import java.awt.Dimension;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
//import sun.util.logging.PlatformLogger;


/**
 *
 * @author Tchoute
 */

public class Caisse extends javax.swing.JFrame {

    ResultSet rs,rd,rq;
    StatementBd db;
    int old,dec,now;
    private static Pattern motif=null;
    private static Pattern motif1=null;
    private static Pattern motif2=null;
    Matcher matcher,matcher1,matcher2,matcher3;
    String users;
    
    Connection con = null;
    int résultats ;
    ResultSet résultat;
    
    /**
     * Creates new form Caisse
     */

    public Caisse(String user){
          db= new StatementBd(new Settings().HOST_DB, new Settings().USERNAME_DB, new 
        Settings().PASSWORD_DB, new Settings().IPHOST, new Settings().PORT);
        initComponents();
        ImageIcon image = new ImageIcon("C:\\Users\\ERIC\\workspace\\Gestion_stock\\bin\\Base_de_donn�e\\Cabture_carr�2.png");
        this.setIconImage(image.getImage());
        users=user;
        j_no.setText(String.valueOf("WELCOM"));
        j_nom.setText(users);
        
         table();
        jam();
    }
    
    public Caisse() {
         db= new StatementBd(new Settings().HOST_DB, new Settings().USERNAME_DB, new 
        Settings().PASSWORD_DB, new Settings().IPHOST, new Settings().PORT);
         
         initComponents();
         ImageIcon image = new ImageIcon("C:\\Users\\ERIC\\workspace\\Gestion_stock\\bin\\Base_de_donn�e\\Capture_carr�2.png");
         this.setIconImage(image.getImage());
        
        
        table();
        jam();
    }

      public void table(){
        String a[]={"id","code_produit","nom_produit","fournisseur","remise","prix","stock"};
        rs=db.querySelect(a,"produit");
        table_pro.setModel(new TableModel(rs));
    }
     // 
      public void importer(){
          rs=db.exécutionQuery("SELECT id_caisse as subtotal FROM caisse WHERE num_facture= "+txt_fac.getText()+"");
                    try{
                       rs.next();
                       String dc= rs.getString("subtotal");
                       

                        String[] colon={"id_caisse","code_produit","nom_produit","prix_vente","stock_sortie","subtotal"};
                        rq=db.fcSelectCommand(colon,"vente"," id_caisse = " +dc+" ");
                        table_ven.setModel(new TableModel(rq));
                   }catch(SQLException ex){
                        Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
                    }
          

       
      
      }
      
      //actualiser
       void actualiser(){
        txt_co.setText("");
        txt_no.setText("");
        txt_fo.setText("");
        txt_rem.setText("");
        txt_pri.setText("");
        txt_np.setText("");
        txt_sto1.setText("");
        txt_fac.setText("");
        txt_cli.setText("");
        jbito2.setText("0");
        txt_cas.setText("");
        txt_pay.setText("");
        jbto.setText("");
        txt_dat.setText("");
    }
       
       void actualiser3(){
        txt_co.setText("");
        txt_no.setText("");
        txt_fo.setText("");
        txt_rem.setText("");
        txt_pri.setText("");
        txt_np.setText("");
        txt_sto1.setText("");
        jbto.setText("");
    }
      
      //
      public void jam(){
        long s = 0;
        Date date = new Date();
        SimpleDateFormat tgl= new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat jam= new SimpleDateFormat("HH:mm:ss");
        bit4.setText(jam.format(date));
        
        bit6.setText(tgl.format(date));
      }
       /*  public Caisse(Date date){
         SimpleDateFormat tgl= new SimpleDateFormat("EEEE-dd-MM-YYYY");
         SimpleDateFormat jam= new SimpleDateFormat("HH:mm");
         bit4.setText(jam.format(date));
         bit6.setText(tgl.format(date));
      }*/
      
     //les acesseurs
      public String getTxt_fac(){
         return this.txt_fac.getText();
      }
      public void setTxt_fac(JLabel txt_fac){
         this.txt_fac= txt_fac;
      }
      
      //acesseur pour cash
       public String getTxt_cas(){
         return this.txt_cas.getText();
      }
      public void setTxt_cas(JTextField txt_cas){
         this.txt_cas= txt_cas;
      }
      //acesseur pour total
       public String getJbito2(){
         return this.jbito2.getText();
      }
      public void setJbito2(JLabel jbito2){
         this.jbito2= jbito2;
      }
      //acesseur pour heure
      public String getBit6(){
         return this.bit6.getText();
      }
      public void setBit6(JLabel bit6){
         this.bit6= bit6;
      }
      //acesseur pour date
       public String getBit4(){
         return this.bit4.getText();
      }
      public void setBit4(JLabel bit4){
         this.bit4= bit4;
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pro = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        bit4 = new javax.swing.JLabel();
        bit6 = new javax.swing.JLabel();
        j_nom = new javax.swing.JLabel();
        j_no = new javax.swing.JLabel();
        labele = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        com_rech = new javax.swing.JComboBox<>();
        txt_rech = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        txt_co = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_no = new javax.swing.JTextField();
        txt_fo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_rem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jbto = new javax.swing.JLabel();
        txt_pri = new javax.swing.JTextField();
        txt_np = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_sto1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jbito = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_ven = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        txt_fac = new javax.swing.JLabel();
        jbito3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_cas = new javax.swing.JTextField();
        txt_pay = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jbito5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_dat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        Lab = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Label2 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_cli = new javax.swing.JTextField();
        jbito2 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int)tailleEcran.getHeight();
        int largeur = (int)tailleEcran.getWidth();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(largeur, hauteur));
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 255));
        jPanel1.setLayout(null);

        table_pro.setBackground(new java.awt.Color(102, 102, 102));
        table_pro.setForeground(new java.awt.Color(0, 255, 102));
        table_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "nom_produit", "fournisseur", "remise", "prix", "stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_pro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_proMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_pro);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 1020, 100);

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel4.setText("VENTE DES PRODUITS");
        jLabel4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 20, 250, 30);

        bit4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel1.add(bit4);
        bit4.setBounds(10, 20, 150, 30);

        bit6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel1.add(bit6);
        bit6.setBounds(830, 20, 240, 30);

        j_nom.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        j_nom.setForeground(new java.awt.Color(102, 0, 204));
        jPanel1.add(j_nom);
        j_nom.setBounds(320, 20, 160, 30);

        j_no.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        j_no.setForeground(new java.awt.Color(102, 0, 153));
        jPanel1.add(j_no);
        j_no.setBounds(180, 20, 130, 30);

        labele.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        labele.setForeground(new java.awt.Color(51, 0, 0));
        labele.setText("Entrepise: ENTERPRISE. tel:(+237)675692431. Email:tomiyems@gmail.com");
        jPanel1.add(labele);
        labele.setBounds(10, 0, 660, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 1370, 170);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel3.setText("Rechercher par cat�gorie:");
        jLabel3.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 10, 230, 30);

        com_rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_rech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "code_produit", "nom_produit", "fournisseur", "stock", "prix", "remise", " " }));
        com_rech.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 153), 3, true));
        jPanel2.add(com_rech);
        com_rech.setBounds(270, 10, 130, 30);

        txt_rech.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_rech.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_rech);
        txt_rech.setBounds(190, 60, 170, 30);

        jButton6.setBackground(new java.awt.Color(0, 255, 153));
        jButton6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton6.setText("Ajouter au produit");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(80, 500, 280, 50);

        txt_co.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_co.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_co.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coActionPerformed(evt);
            }
        });
        jPanel2.add(txt_co);
        txt_co.setBounds(190, 110, 170, 30);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("code_produit:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 110, 130, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("nom_produit:");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 160, 120, 30);

        txt_no.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_no.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_no);
        txt_no.setBounds(190, 160, 170, 30);

        txt_fo.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_fo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_fo);
        txt_fo.setBounds(190, 210, 170, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("fournisseur:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 210, 100, 30);

        txt_rem.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_rem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_rem);
        txt_rem.setBounds(190, 260, 170, 30);

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setText("remise:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 260, 70, 30);

        jbto.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbto.setText("0");
        jbto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jbtoKeyReleased(evt);
            }
        });
        jPanel2.add(jbto);
        jbto.setBounds(140, 460, 220, 30);

        txt_pri.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_pri.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_pri);
        txt_pri.setBounds(190, 310, 170, 30);

        txt_np.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_np.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel2.add(txt_np);
        txt_np.setBounds(190, 360, 170, 30);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("nouveau prix:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 360, 110, 30);

        txt_sto1.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_sto1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_sto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sto1KeyReleased(evt);
            }
        });
        jPanel2.add(txt_sto1);
        txt_sto1.setBounds(190, 410, 170, 30);

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setText("stock sortie:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 410, 100, 30);

        jLabel11.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel11.setText("prix:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 310, 50, 30);

        jbito.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbito.setText("RP:");
        jPanel2.add(jbito);
        jbito.setBounds(40, 460, 50, 30);

        jButton7.setBackground(new java.awt.Color(0, 255, 153));
        jButton7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton7.setText("Rechercher:");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(20, 50, 130, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 170, 400, 570);

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(null);

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setText("num_facture:");
        jPanel3.add(jLabel9);
        jLabel9.setBounds(10, 20, 120, 30);

        table_ven.setBackground(new java.awt.Color(255, 255, 204));
        table_ven.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 255, 153), 3, true));
        table_ven.setForeground(new java.awt.Color(102, 51, 255));
        table_ven.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "nom_produit", "prix_vente", "stock_sortie", "subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_ven.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_venMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_ven);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(10, 140, 620, 100);

        jButton8.setBackground(new java.awt.Color(0, 255, 153));
        jButton8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jButton8.setText("actualiser");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton8);
        jButton8.setBounds(400, 390, 180, 60);

        jButton9.setBackground(new java.awt.Color(0, 255, 153));
        jButton9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton9.setText("recherche");
        jButton9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton9);
        jButton9.setBounds(440, 30, 170, 30);

        txt_fac.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel3.add(txt_fac);
        txt_fac.setBounds(120, 20, 210, 30);

        jbito3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbito3.setText("Total");
        jPanel3.add(jbito3);
        jbito3.setBounds(60, 270, 60, 30);

        jLabel12.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel12.setText("Cash:");
        jPanel3.add(jLabel12);
        jLabel12.setBounds(20, 330, 80, 30);

        txt_cas.setFont(new java.awt.Font("Minion Pro Cond", 1, 24)); // NOI18N
        txt_cas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_cas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_casActionPerformed(evt);
            }
        });
        txt_cas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_casKeyReleased(evt);
            }
        });
        jPanel3.add(txt_cas);
        txt_cas.setBounds(100, 330, 180, 30);

        txt_pay.setFont(new java.awt.Font("Minion Pro Cond", 1, 24)); // NOI18N
        txt_pay.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_payActionPerformed(evt);
            }
        });
        jPanel3.add(txt_pay);
        txt_pay.setBounds(420, 330, 180, 30);

        jLabel13.setFont(new java.awt.Font("Verdana", 3, 18)); // NOI18N
        jLabel13.setText("Payer apr�s:");
        jPanel3.add(jLabel13);
        jLabel13.setBounds(290, 330, 140, 30);

        jButton10.setBackground(new java.awt.Color(0, 255, 153));
        jButton10.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton10.setText("Effectuer vente");
        jButton10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton10);
        jButton10.setBounds(20, 390, 340, 60);

        jbito5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbito5.setText("RP:");
        jPanel3.add(jbito5);
        jbito5.setBounds(270, 270, 50, 30);

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel14.setText("nom du client:");
        jPanel3.add(jLabel14);
        jLabel14.setBounds(10, 70, 120, 30);

        txt_dat.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_dat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_dat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_datActionPerformed(evt);
            }
        });
        jPanel3.add(txt_dat);
        txt_dat.setBounds(470, 70, 160, 30);

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel15.setText("N� Facture :");
        jPanel3.add(jLabel15);
        jLabel15.setBounds(360, 70, 110, 30);

        Lab.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        Lab.setForeground(new java.awt.Color(204, 0, 51));
        jPanel3.add(Lab);
        Lab.setBounds(50, 100, 560, 0);

        jButton1.setBackground(new java.awt.Color(153, 255, 153));
        jButton1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jButton1.setText("Fermer");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(400, 450, 180, 60);

        Label2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(Label2);
        Label2.setBounds(50, 50, 460, 0);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(jLabel2);
        jLabel2.setBounds(50, 104, 600, 30);

        txt_cli.setFont(new java.awt.Font("Minion Pro Cond", 1, 18)); // NOI18N
        txt_cli.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_cli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cliActionPerformed(evt);
            }
        });
        jPanel3.add(txt_cli);
        txt_cli.setBounds(130, 70, 210, 30);

        jbito2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbito2.setText("0");
        jPanel3.add(jbito2);
        jbito2.setBounds(360, 270, 220, 30);

        jButton11.setBackground(new java.awt.Color(0, 255, 153));
        jButton11.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton11.setText("Annuler une vente");
        jButton11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton11);
        jButton11.setBounds(20, 450, 340, 60);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(400, 170, 970, 570);

        pack();
    }// </editor-fold>                        
//BOUTON AJOUTER VENTE
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        motif= Pattern.compile("[0-9]*");
        motif2= Pattern.compile("[0-9]{4}-[0-9]{2}-[0-9]{2}");
        motif1= Pattern.compile("([a-z])+[_.&]?([a-z0-9])*@(gmail|yahoo){1}.(com|fr){1}");
        //matcher= motif.matcher(d);
        String id=String.valueOf(txt_fac.getText());
        String dat=String.valueOf(txt_dat.getText());
        String ad=String.valueOf(txt_fac.getText());
        
        matcher1= motif.matcher(id);
        matcher2= motif1.matcher(ad);
        matcher3= motif2.matcher(dat);
        
       if(txt_co.getText().equals("") || txt_no.getText().equals("") || txt_np.getText().equals("") || txt_fo.getText().equals("") ||
               txt_rem.getText().equals("") || txt_np.getText().equals("") || txt_sto1.getText().equals("") ){
            JOptionPane.showMessageDialog(this,"SVP entrer vos donn�es");
       }
       else if(txt_cli.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SVP entrer le nom du client!");
            jLabel2.setText(String.valueOf("SVP le nom du client!!!"));
       }
       else{
           
           try{
               if(!test_stock()){
           /* String [] colon={"num_facture","code_produit","nom_produit","prix_vente","stock_sortie","subtotal","nom_client","jour_de_vente"};
            String [] isi={txt_fac.getText(),txt_co.getText(),txt_no.getText(),txt_np.getText(),txt_sto1.getText(),jbto.getText(),txt_fac.getText(),txt_dat.getText()};
            System.out.println(db.queryInsert("vente", colon, isi));*/
            //try{
               //if(!test_stock()){
                  JOptionPane.showMessageDialog(this, "Le stock est limit�");
               }else if(txt_fac.getText().equals("")){
                   numero();
                  /* rs=db.exécutionQuery("INSERT INTO caisse(nom_caisse,num_facture,nom_client,jour_vente) VALUES('','"+j_nom.getText()+"','"+txt_fac.getText()+"','"+txt_cli.getText()+"','"+bit6.getText()+"')");
                   System.out.println(rs);*/
                   
                   String [] colon={"nom_caisse","num_facture","nom_client","frais_total","cash","payer_apr�s","jour_vente"};
                   String [] isi={j_nom.getText(),txt_fac.getText(),txt_cli.getText(),"0","0","0",bit6.getText()};
                   System.out.println(db.queryInsert("caisse", colon, isi));
               }else{
                   //selection de l id_caisse
                    rs=db.exécutionQuery("SELECT id_caisse as subtotal FROM caisse WHERE num_facture= "+txt_fac.getText()+"");
                    try{
                       rs.next();
                       String dc= rs.getString("subtotal");
                       
                       String [] colon={"id_caisse","code_produit","nom_produit","prix_vente","stock_sortie","subtotal"};
                       String [] isi={dc,txt_co.getText(),txt_no.getText(),txt_np.getText(),txt_sto1.getText(),jbto.getText()};
                       
                       System.out.println(db.queryInsert("vente", colon, isi));
                       def();//true
                       table();//true
                  
                       jLabel2.setText(String.valueOf(""));
                       subtotal();
                       importer();
                       total();
                       actualiser3();
                   }catch(SQLException ex){
                        Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
                    }

               }
            }catch(SQLException ex){
              Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
              System.out.println("\n" +ex);
            }
            
            
            
            
       }
            
    }                                        

    private void txt_coActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    }                                      
//ACTION bouton rechercher1
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
                 if(txt_rech.getText().equals(""))//si le textfield de recherche est vide le programme affichera "SVP entrer quelque chose"
        {
           JOptionPane.showMessageDialog(this,"SVP entrer quelques chose");
        }else{
           if(com_rech.getSelectedItem().equals("code_produit")){
              rs=db.querySelectAll("produit", "code_produit LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from produit where id_user='"+txt_rech.getText()+"'");
              table_pro.setModel(new TableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("nom_produit")){
              rs=db.querySelectAll("produit", "nom_produit LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from produit where username='"+txt_rech.getText()+"'");
              table_pro.setModel(new TableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("fournisseur")){
              rs=db.querySelectAll("produit", "fournisseur LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new TableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("prix")){
              rs=db.querySelectAll("produit", "prix LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new TableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("stock")){
              rs=db.querySelectAll("produit", "stock LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new TableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("remise")){
              rs=db.querySelectAll("produit", "remise LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new TableModel(rs));
           }
        }
    }                                        
// action supprimer
    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        actualiser();
        table();
       /* String id= String.valueOf(table_ven.getValueAt(table_ven.getSelectedRow(),1));
        if(JOptionPane.showConfirmDialog(this,"est tu sure de vouloire supprimer?","Attention", JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
           db.queryDelete("vente"," code_produit = "+id);
        }else{
           return;
        }
        importer();
        total();*/
    }                                        
//action bouton rechercher 2
    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
       // importer();total();
       String po="de re";
        String sz=po.replace(" ", "");
        System.out.println(sz);
      if(!txt_dat.getText().equals("")){
              //rs=db.querySelectAll("vente", "num_facture LIKE '%"+ txt_fac.getText()+"%' AND nom_client  LIKE  '%"+txt_fac.getText()+"%'");
              //rs=db.exécutionQuery("select * from produit where id_user='"+txt_rech.getText()+"'");
              rs=db.exécutionQuery("SELECT v.id_caisse,v.code_produit,v.nom_produit,v.prix_vente,v.stock_sortie,v.subtotal FROM vente v WHERE v.id_caisse IN (SELECT id_caisse FROM caisse WHERE num_facture= "+txt_dat.getText()+")");
              table_ven.setModel(new TableModel(rs));
              jbito2.setText("");
           }
    }                                        

    private void txt_casActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // 
    }                                       

    private void txt_payActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // 
    }                                       
//action �ffectuer vente
    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
    	if(txt_fac.getText().equals("")){
    		JOptionPane.showMessageDialog(this, "Impossible d'�ffectuer la vente!!!");
    	}
    	else{
            String[] colon={"frais_total","cash","payer_apr�s"};
            String[] inf={jbito2.getText(),txt_cas.getText(),txt_pay.getText()};
            String fac= String.valueOf(txt_fac.getText());
        
        //String id=String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("caisse",colon,inf,"num_facture= " + fac+"\n"));
            actualiser();
    	}
        
       

       
     /* Recu d= new Recu();
      d.setVisible(true);*/
      
    }                                         

    private void txt_sto1KeyReleased(java.awt.event.KeyEvent evt) {                                     
        
        subtotal();
    }                                    

    private void txt_casKeyReleased(java.awt.event.KeyEvent evt) {                                    
        
        payaprés();
    }                                   

    private void table_proMouseClicked(java.awt.event.MouseEvent evt) {                                       
        
        txt_co.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),1)));
        txt_no.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),2)));
        txt_fo.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),3)));
        txt_rem.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),4)));
        txt_pri.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),5)));
        //txt_sto.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),6)));
        cout();
    }                                      

    private void jbtoKeyReleased(java.awt.event.KeyEvent evt) {                                 
        
        //subtotal();
    }                                

    private void txt_datActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // 
    }                                       

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        
        dispose();
    }                                        

    private void txt_cliActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // 
    }                                       

    private void table_venMouseClicked(java.awt.event.MouseEvent evt) {                                       
        // 
    }                                      
//annuler
    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        if (jbito2.getText().equals("0"))
            {
                JOptionPane.showMessageDialog(this, "Impossible d'�ffectuer cette action!!!");
            }
        else {
        	int i= table_ven.getRowCount();
        	for(int j=0; j<i; j++){
                String invoice= String.valueOf(table_ven.getValueAt(j,1)).toString();
                String id= String.valueOf(table_ven.getValueAt(j,4)).toString();
                String idd= String.valueOf(table_ven.getValueAt(j,5)).toString();
                if(JOptionPane.showConfirmDialog(this, "etes-vous s�re de vouloir annuler cette vente ?","Attention", 
                     JOptionPane.OK_CANCEL_OPTION)== JOptionPane.OK_OPTION){
                     db.queryDelete("vente", "code_produit LIKE '%"+invoice+"%'");
                     int b= Integer.valueOf(id);
                     int b2= Integer.valueOf(idd);
                     //jLabel2.setText(String.valueOf("SVP"  +b+ "" +b2 ));
            
                     String invoic =invoice.replace(" ","");
                     rs=db.exécutionQuery("SELECT stock AS stoc FROM produit WHERE code_produit LIKE'%"+invoic+"%'");
                     try{
                          rs.next();
                          String dc= rs.getString("stoc"); 
                          int b1= Integer.valueOf(dc);
                          int s;
                          s=b+b1;
                          String s1= String.valueOf(s);
                          String[] colon={"stock"};
                          String[] inf={s1}; 
                          System.out.println(db.queryUpdate("produit",colon,inf,"code_produit LIKE'%"+invoic+"%'"));
                          s= Integer.valueOf(jbito2.getText())-b2;
                          s1= String.valueOf(s);
                          jbito2.setText(s1);
                          table();//true
                      }catch(SQLException ex){
                          Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
                      }
            // jLabel2.setText(String.valueOf("SVP"+invoic+ "" +b+ "" +b2 ));
          
                 }else{
        	//JOptionPane.showMessageDialog(this,"D�sol� impossible d'annuler");
                    return;
                 }
        	}
        importer();
        total();
        }
        
    }                                         

    public void subtotal(){
        motif= Pattern.compile("[0-9]*");
        String id=String.valueOf(txt_sto1.getText());
        matcher1= motif.matcher(id);
        if(!(matcher1.matches())){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour le champ stock de sortie!");
           
        }
        else if(txt_sto1.getText().equals("")){
           JOptionPane.showMessageDialog(this,"entrez le stock de sortie SVP!!!");
        }else{
             String s= String.valueOf(txt_sto1.getText());
             int b= Integer.valueOf(s);
        
             double a=Double.parseDouble(String.valueOf(txt_np.getText()));
       //int b=Integer.parseInt(String.valueOf(txt_sto1.getText()));
             double c=a*b;
             jbto.setText(String.valueOf(c));
        }
    }
    
    public boolean test_stock() throws SQLException{
       boolean teststock;
       rs=db.querySelectAll("produit", "code_produit = '" +txt_co.getText()+"'");
       while(rs.next()){
          old = rs.getInt("stock");
       }
       dec= Integer.parseInt(txt_sto1.getText());
       if(old < dec){
          teststock = false;
       }else{
          teststock = true;
       }
       return teststock;
    }
    
    public void def() throws  SQLException{
       
       rs=db.querySelectAll("produit", "code_produit = '"+txt_co.getText()+"'");
       while(rs.next()){
          old=rs.getInt("stock");
       }
        dec= Integer.parseInt(txt_sto1.getText());
        now=old-dec;
        String nvstock = Integer.toString(now);
        String a=String.valueOf(nvstock);
        String [] colon ={"stock"};
        String [] isi={a};
        System.out.println(db.queryUpdate("produit", colon, isi,"code_produit = '" +txt_co.getText()+"'" ));

    }
    
    public void total(){
        
        rs=db.exécutionQuery("SELECT id_caisse as num FROM caisse WHERE num_facture= "+txt_fac.getText()+"");
                    try{
                       rs.next();
                       String dc= rs.getString("num");
                       rd=db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM vente WHERE id_caisse = "+dc+"");
                       try{
          /* if(matcher.matches()){
              rd.next();
              jbito2.setText(rd.getString("subtotal")); 
           }else{*/
          rd.next();
          String r= rd.getString("subtotal");
          jbito2.setText(r); 
          
      }catch(SQLException ex){
          Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
       }
                   }catch(SQLException ex){
                        Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
                    }
        
        /*motif= Pattern.compile("[a-zA-Z0-9]+");
        String id=String.valueOf(txt_fac.getText());
        matcher= motif.matcher(id);
       rd= db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM vente WHERE num_facture = '"  +txt_fac.getText()+"' ");*/
 //      rs=db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM vente,caisse WHERE vente.id_caisse = caisse.id_caisse ");
        //rs=db.exécutionQuery("SELECT SUM(subtotal) as subtotal FROM vente WHERE num_facture = " +txt_fac.getText()+" group by nom_client ");
      // System.out.println(rs);
      /* try{
          /* if(matcher.matches()){
              rd.next();
              jbito2.setText(rd.getString("subtotal")); 
           }else{*/
         /* rd.next();
          String r= rd.getString("subtotal");
          jbito2.setText(r); 
          
      }
       catch(SQLException ex){
          Logger.getLogger(Caisse.class.getName()).log(Level.SEVERE,null,ex);
       }*/
       //System.out.println(rs); 
    }
    
    
    public void payaprés(){
        motif= Pattern.compile("[0-9]*");
        String id=String.valueOf(txt_cas.getText());
        matcher1= motif.matcher(id);
         if(!(matcher1.matches())){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour les champs Cash! yaaaaaaa");
           
        }else if(txt_cas.getText().equals("")){
           JOptionPane.showMessageDialog(this,"entrez le prix � payer qui est � l'�cran SVP!!!");
        }
         else{
        
        int b=Integer.valueOf(txt_cas.getText());
        
       int a=Integer.parseInt(String.valueOf(jbito2.getText()));
       //int b=Integer.parseInt(String.valueOf(txt_cas.getText()));
       int c=b-a;
       txt_pay.setText(Integer.toString(c));}
    }
    
    public void cout(){
       double a= Double.parseDouble(String.valueOf(txt_pri.getText()));
       double b= Double.parseDouble(String.valueOf(txt_rem.getText()));
       double c= a - a*(b/100);
       txt_np.setText(String.valueOf(c));
    }
    
    public void numero(){
       double a =  Math.random() ; //entier entre -9 et 9
      int b,p,d,q;
      String tes,txt,td,tex ="";
      
      double valeur = Math.random() * 100000; 
      double valeur1 = Math.random() * 100;
      double valeur2 = Math.random() * 100000;
      b= (int) Math.round(valeur);
      p= (int) Math.round(valeur1);
      q= (int) Math.round(a)*10;
      d= (int) Math.round(valeur2);
      tex="084";
      tes="1480";
      
      td = String.valueOf(d);
      tex += String.valueOf(q);
      txt = String.valueOf(b);
      tes += String.valueOf(p);
      
      if(p==0||(p>=5 && p<=30)){
          tex +=txt;
          txt_fac.setText(tex);
      }else if(p>=31 && p<=100){
          tes="0180";
          tes +=txt;
          txt_fac.setText(tes);
      }else{
          
          txt +=td;
         txt_fac.setText(txt);
      }
    }
    
    
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
            java.util.logging.Logger.getLogger(Caisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Caisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Caisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Caisse.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               Caisse c= new Caisse();
               c.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel Lab;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel bit4;
    private javax.swing.JLabel bit6;
    private javax.swing.JComboBox<String> com_rech;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel j_no;
    private javax.swing.JLabel j_nom;
    private javax.swing.JLabel jbito;
    private javax.swing.JLabel jbito2;
    private javax.swing.JLabel jbito3;
    private javax.swing.JLabel jbito5;
    private javax.swing.JLabel jbto;
    private javax.swing.JLabel labele;
    private javax.swing.JTable table_pro;
    private javax.swing.JTable table_ven;
    private javax.swing.JTextField txt_cas;
    private javax.swing.JTextField txt_cli;
    private javax.swing.JTextField txt_co;
    private javax.swing.JTextField txt_dat;
    private javax.swing.JLabel txt_fac;
    private javax.swing.JTextField txt_fo;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_np;
    private javax.swing.JTextField txt_pay;
    private javax.swing.JTextField txt_pri;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_rem;
    private javax.swing.JTextField txt_sto1;
    // End of variables declaration                   
}

