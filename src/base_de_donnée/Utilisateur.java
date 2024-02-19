/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_donnée;

import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import static javafx.application.ConditionalFeature.SWT;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
//import jdk.nashorn.tools.Shell;

/**
 *
 * @author Roger
 */
public class Utilisateur extends javax.swing.JFrame {
    ResultSet rs;
    BDD db;
    private static Pattern motif=null;
    private static Pattern motif1=null;
    Matcher matcher,matcher1,matcher2;
    /**
     * Creates new form Utilisateur
     */
    public Utilisateur() {
        db= new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new 
        Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        
        initComponents();
        table();
    }
    //FONCTION TABLE
    public void table(){
        String a[]={"id","id_user","username","prenom_user","sexe","adresse","portable","Email","fonction","statut"};
        rs=db.querySelect(a,"utilisateur");
        table_user.setModel(new ResultSetTableModel(rs));
    }
    
    void actualiser(){
        txt_id.setText("");
        txt_us.setText("");
        txt_pu.setText("");
        passe2.setText("");
        passe1.setText("");
        txt_ad.setText("");
        txt_por.setText("");
        txt_eml.setText("");
        com_sex.setSelectedItem("Votre sexe");
        com_fon.setSelectedItem("Votre fonction");
        com_sta.setSelectedItem("Votre statut");
        label.setText("");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_user = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_rech = new javax.swing.JTextField();
        com_rech = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        txt_us = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        com_sex = new javax.swing.JComboBox<>();
        passe2 = new javax.swing.JPasswordField();
        txt_ad = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_eml = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_por = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txt_pu = new javax.swing.JTextField();
        com_fon = new javax.swing.JComboBox<>();
        passe1 = new javax.swing.JPasswordField();
        com_sta = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        label = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 255));
        setLocation(new java.awt.Point(350, 80));
        setPreferredSize(new java.awt.Dimension(886, 596));
        setResizable(false);
        getContentPane().setLayout(null);

        table_user.setBackground(new java.awt.Color(255, 255, 153));
        table_user.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 204), 3, true));
        table_user.setForeground(new java.awt.Color(51, 51, 255));
        table_user.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "id_user", "username", "prenom_user", "sexe", "adresse", "Email", "portable", "fonction", "statut"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_user.setMaximumSize(new java.awt.Dimension(2147483647, 1600));
        table_user.setMinimumSize(new java.awt.Dimension(1700, 1600));
        table_user.setPreferredSize(new java.awt.Dimension(1700, 1600));
        table_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_userMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_user);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 70, 860, 100);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("recherche");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 510, 190, 50);

        jButton2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton2.setText("Ajouter ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(200, 180, 150, 40);

        jButton3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton3.setText("Modifier");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(350, 180, 150, 40);

        jButton4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton4.setText("Suprimer");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(500, 180, 160, 40);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 51));
        jLabel2.setText("fonction:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 440, 80, 30);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 51));
        jLabel3.setText("Recherche par Catégorie:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 470, 200, 30);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 51));
        jLabel4.setText("username:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 280, 120, 20);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 51));
        jLabel5.setText("password:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 360, 80, 30);

        txt_id.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_id.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_id);
        txt_id.setBounds(210, 240, 170, 30);

        txt_rech.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        getContentPane().add(txt_rech);
        txt_rech.setBounds(210, 520, 180, 40);

        com_rech.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        com_rech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adresse", "Email", "fonction", "id_user", "username", "prenom_user", "portable", "sexe", "statut" }));
        getContentPane().add(com_rech);
        com_rech.setBounds(240, 470, 150, 30);

        jButton5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jButton5.setText("actualiser");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(660, 180, 150, 40);

        txt_us.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_us.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_us);
        txt_us.setBounds(210, 280, 170, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 255, 51));
        jLabel6.setText("id_user:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 240, 70, 20);

        com_sex.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        com_sex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Votre sexe", "Masculin", "Feminin" }));
        getContentPane().add(com_sex);
        com_sex.setBounds(600, 400, 210, 30);

        passe2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passe2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(passe2);
        passe2.setBounds(210, 400, 170, 30);

        txt_ad.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_ad.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_ad);
        txt_ad.setBounds(600, 280, 210, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(153, 255, 51));
        jLabel8.setText("adresse:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(440, 280, 80, 30);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 255, 51));
        jLabel9.setText("confirmez password:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 410, 200, 20);

        txt_eml.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_eml.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_eml);
        txt_eml.setBounds(600, 360, 210, 30);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 255, 51));
        jLabel10.setText("Email:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(440, 360, 80, 30);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(153, 255, 51));
        jLabel11.setText("portable:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(440, 320, 100, 30);

        txt_por.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_por.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_por);
        txt_por.setBounds(600, 320, 210, 30);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(153, 255, 51));
        jLabel12.setText("sexe:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(440, 400, 80, 30);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(153, 255, 51));
        jLabel13.setText("prenom_user:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(10, 320, 110, 20);

        txt_pu.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        txt_pu.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_pu);
        txt_pu.setBounds(210, 320, 170, 30);

        com_fon.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        com_fon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Votre fonction", "Directeur", "Magasinier", "Vendeur(se)" }));
        getContentPane().add(com_fon);
        com_fon.setBounds(600, 440, 210, 30);

        passe1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        passe1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(passe1);
        passe1.setBounds(210, 360, 170, 30);

        com_sta.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        com_sta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Votre statut", "Etudiant(e)", "Célibataire", "Marié(e)" }));
        getContentPane().add(com_sta);
        com_sta.setBounds(600, 240, 210, 30);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 255, 51));
        jLabel7.setText("statut:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(440, 240, 80, 30);

        jButton6.setBackground(new java.awt.Color(51, 255, 153));
        jButton6.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 0, 51));
        jButton6.setText("Retour");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 102), 3, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(490, 490, 200, 70);

        label.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        label.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(label);
        label.setBounds(10, 440, 420, 20);
        getContentPane().add(jLabel14);
        jLabel14.setBounds(0, -66, 870, 650);
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
//action bouton ajouter
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        motif= Pattern.compile("[0-9]*");
        motif1= Pattern.compile("([a-z])+[_.&]?([a-z0-9])*@(gmail|yahoo){1}.(com|fr){1}");
        String a=String.valueOf(passe1.getText());
        String d=String.valueOf(txt_por.getText());
        String b=String.valueOf(passe2.getText());
        matcher= motif.matcher(d);
        String id=String.valueOf(txt_id.getText());
        String ad=String.valueOf(txt_eml.getText());
        matcher1= motif.matcher(id);
        matcher2= motif1.matcher(ad);
        if(txt_id.getText().equals("")||txt_us.getText().equals("")||passe2.getText().equals("") ||passe1.getText().equals("") ||txt_pu.getText().equals("") ||txt_ad.getText().equals("")
                ||com_sex.getSelectedItem().equals("Votre sexe") ||txt_eml.getText().equals("") ||txt_por.getText().equals("")
                ||com_sta.getSelectedItem().equals("Votre statut") ||com_fon.getSelectedItem().equals("Votre fonction")){
            JOptionPane.showMessageDialog(this,"SVP entrer les informations complètes");
        }
        else if(!(a.equals(b))){
           JOptionPane.showMessageDialog(this,"SVP mot de passe pas conforme! yaaaaaaa");
           label.setText(String.valueOf("SVP entrer le mème mot de passe!!!"));
        }
        else if(!(matcher.matches()) || !(matcher1.matches()) || !(matcher2.matches()) ){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour les champs id_user et portable! yaaaaaaa");
           label.setText(String.valueOf("SVP l'identifiant et portable sont en chiffre le champs adresse n est pas bien!!!"));
        }
        else {
            String[] colon={"id_user","username","prenom_user","password","sexe","adresse","portable","Email","fonction","statut"};
            String[] inf={txt_id.getText(),txt_us.getText(),txt_pu.getText(),passe1.getText(),com_sex.getSelectedItem().toString(),txt_ad.getText(),txt_por.getText(),
                txt_eml.getText(),com_fon.getSelectedItem().toString(),com_sta.getSelectedItem().toString()};
             db.exécutionUpdate("insert into utilisateur(id_user,username,prenom_user,password,sexe,adresse,portable,Email,fonction,statut) values("+txt_id.getText()+",'"+txt_us.getText()+"','"+txt_pu.getText()+"','"+
                     passe1.getText()+"','"+com_sex.getSelectedItem().toString()+"','"+txt_ad.getText()+"',"+txt_por.getText()+",'"+txt_eml.getText()+"','"+
                     com_fon.getSelectedItem().toString()+"','"+com_sta.getSelectedItem().toString()+"')");
            //System.out.println(db.queryInsert("utilisateur",colon,inf));
            
            System.out.println("insert into utilisateur(id_user,username,prenom_user,password,sexe,adresse,portable,Email,fonction,statut) values("+txt_id.getText()+",'"+txt_us.getText()+"','"+txt_pu.getText()+"','"+
                     passe1.getText()+"','"+com_sex.getSelectedItem().toString()+"','"+txt_ad.getText()+"',"+txt_por.getText()+",'"+txt_eml.getText()+"','"+
                    com_fon.getSelectedItem().toString()+"','"+com_sta.getSelectedItem().toString()+"')");
            table();
            actualiser();
        }
    }//GEN-LAST:event_jButton2ActionPerformed
//action bouton modifier
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        JFrame fen= new JFrame();
        JLabel jPass=new JLabel("Password : ");
        JLabel jConfi=new JLabel("Confirmez : ");
        JPasswordField pass= new JPasswordField();
        JPasswordField confi= new JPasswordField();
        JLabel lab=new JLabel("Entrez l'ancien mot de pass!!!");
        JLabel lab1=new JLabel("Entrez le nouveau mot de pass et le confirmez!!!");
        Object [] tab= new Object[]{jPass,pass,lab};
        Object [] tab1= new Object[]{jPass,pass,jConfi,confi,lab1};
        //int rep= 
        
        
        //String fon="Votre"
        motif= Pattern.compile("[0-9]*");
        motif1= Pattern.compile("([a-z])+[_.&]?([a-z0-9])*@(gmail|yahoo){1}.(com|fr){1}");
        String a=String.valueOf(passe1.getText());
        String d=String.valueOf(txt_por.getText());
        String b=String.valueOf(passe2.getText());
        matcher= motif.matcher(d);
        String idd=String.valueOf(txt_id.getText());
        String ad=String.valueOf(txt_eml.getText());
        matcher1= motif.matcher(idd);
        matcher2= motif1.matcher(ad);
        if(txt_id.getText().equals("")||txt_us.getText().equals("") ||txt_pu.getText().equals("") ||txt_ad.getText().equals("")
                ||com_sex.getSelectedItem().equals("Votre sexe") ||txt_eml.getText().equals("") ||txt_por.getText().equals("")
                ||com_sta.getSelectedItem().equals("Votre statut") ||com_fon.getSelectedItem().equals("Votre fonction")){
            JOptionPane.showMessageDialog(this,"SVP entrer les informations complètes");
        }
        /*else if(!(a.equals(b))){
           JOptionPane.showMessageDialog(this,"SVP mot de passe pas conforme! yaaaaaaa");
           label.setText(String.valueOf("SVP entrer le mème mot de passe!!!"));
        }*/else if(!(matcher.matches()) || !(matcher1.matches()) || !(matcher2.matches()) ){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour les champs id_user et portable!");
           label.setText(String.valueOf("SVP respectez les valeur de chaque champs!!!"));}
        else{
            
            int rep=JOptionPane.showOptionDialog(this,tab,"Information",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
            if(rep==JOptionPane.OK_OPTION){
                if(pass.getText().equals("")){
                   JOptionPane.showMessageDialog(this,"merci vous n'avez rien saisit dans le champ password");
                }
                else{
                 rs=db.exécutionQuery("SELECT password as pas FROM utilisateur WHERE username= '"+txt_us.getText()+"' ");
                 try{
                       rs.next();
                       String dc= rs.getString("pas");
                       if(dc.equals(pass.getText())){
                          int rep1= JOptionPane.showOptionDialog(this,tab1,"Information",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE,null,null,null);
                          if(rep1==JOptionPane.OK_OPTION){
                              String pa=String.valueOf(pass.getText());
                              String con=String.valueOf(confi.getText());
                              if(pass.getText().equals(confi.getText())){
                                   String[] colon={"id_user","username","prenom_user","password","sexe","adresse","portable","Email","fonction","statut"};
                                   String[] inf={txt_id.getText(),txt_us.getText(),txt_pu.getText(),pa,com_sex.getSelectedItem().toString(),txt_ad.getText(),txt_por.getText(),
                                   txt_eml.getText(),com_fon.getSelectedItem().toString(),com_sta.getSelectedItem().toString()};
                                   String id=String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 0));
                                   System.out.println(db.queryUpdate("utilisateur",colon,inf,"id="+ id +"\n"));
                                   table();
                                   actualiser();
                              
                              }else{
                                   JOptionPane.showMessageDialog(this, "SVP le mot de passe n'est pas conforme!!!");
                              }
                          
                          }else{return;}
                          
                       }else{JOptionPane.showMessageDialog(this, "SVP ètes-vous sure que c'est vous l'utilisateur de ce compte??? car mot de incorrect");}

                        
                   }catch(SQLException ex){
                        Logger.getLogger(Cachier.class.getName()).log(Level.SEVERE,null,ex);
                    }
                }
               
            }else{return;}
            
            /* String[] colon={"id_user","username","prenom_user","password","sexe","adresse","portable","Email","fonction","statut"};
            String[] inf={txt_id.getText(),txt_us.getText(),txt_pu.getText(),passe1.getText(),com_sex.getSelectedItem().toString(),txt_ad.getText(),txt_por.getText(),
                txt_eml.getText(),com_fon.getSelectedItem().toString(),com_sta.getSelectedItem().toString()};
            String id=String.valueOf(table_user.getValueAt(table_user.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("utilisateur",colon,inf,"id="+ id +"\n"));
            table();
            actualiser();*/
        }
    }//GEN-LAST:event_jButton3ActionPerformed
  //action bouton supprimer
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         if(txt_id.getText().equals("")||txt_us.getText().equals("") ||txt_pu.getText().equals("") ||txt_ad.getText().equals("")
                ||com_sex.getSelectedItem().equals("Votre sexe") ||txt_eml.getText().equals("") ||txt_por.getText().equals("")
                ||com_sta.getSelectedItem().equals("Votre statut") ||com_fon.getSelectedItem().equals("Votre fonction")){
            JOptionPane.showMessageDialog(this, "Sélectionner une ligne à supprimer SVP!!!");
         }else{
        String id=String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),0));
        if(JOptionPane.showConfirmDialog(this,"est ce que tu es sure que tu veux suprimer",
                "attention!!!",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            db.queryDelete("utilisateur","id=" +id);
            
        }else{return;}
        table();
        actualiser();
         }
    }//GEN-LAST:event_jButton4ActionPerformed
//action bouton actualiser
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        actualiser(); table();
    }//GEN-LAST:event_jButton5ActionPerformed
//action bouton recherche
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txt_rech.getText().equals(""))//si le textfield de recherche est vide le programme affichera "SVP entrer quelque chose"
        {
           JOptionPane.showMessageDialog(this,"SVP entrer quelques chose");
        }else{
           if(com_rech.getSelectedItem().equals("id_user")){
              rs=db.querySelectAll("utilisateur", "id_user LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from utilisateur where id_user='"+txt_rech.getText()+"'");
              table_user.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("username")){
              rs=db.querySelectAll("utilisateur", "username LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from utilisateur where username='"+txt_rech.getText()+"'");
              table_user.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("prenom_user")){
              rs=db.querySelectAll("utilisateur", "prenom_user LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("sexe")){
              rs=db.querySelectAll("utilisateur", "sexe LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
           else if
              (com_rech.getSelectedItem().equals("portable")){
              rs=db.querySelectAll("utilisateur", "portable LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
           else if
              (com_rech.getSelectedItem().equals("fonction")){
              rs=db.querySelectAll("utilisateur", "fonction LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
            else if
              (com_rech.getSelectedItem().equals("Email")){
              rs=db.querySelectAll("utilisateur", "Email LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
           else if
              (com_rech.getSelectedItem().equals("adresse")){
              rs=db.querySelectAll("utilisateur", "adresse LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
           else if
              (com_rech.getSelectedItem().equals("statut")){
              rs=db.querySelectAll("utilisateur", "statut LIKE '%"+ txt_rech.getText()+"%'");
              table_user.setModel(new ResultSetTableModel(rs));
           }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//action table
    private void table_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_userMouseClicked
        // TODO add your handling code here:
        txt_id.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),1)));
        txt_us.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),2)));
        //passe.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),3)));
        txt_pu.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),3)));
        com_sex.setSelectedItem(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),4)));
        txt_ad.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),5)));
        txt_eml.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),7)));
        txt_por.setText(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),6)));
        com_fon.setSelectedItem(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),8)));
        com_sta.setSelectedItem(String.valueOf(table_user.getValueAt(table_user.getSelectedRow(),9)));
    }//GEN-LAST:event_table_userMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Principale p= new Principale();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Utilisateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Utilisateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_fon;
    private javax.swing.JComboBox<String> com_rech;
    private javax.swing.JComboBox<String> com_sex;
    private javax.swing.JComboBox<String> com_sta;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label;
    private javax.swing.JPasswordField passe1;
    private javax.swing.JPasswordField passe2;
    private javax.swing.JTable table_user;
    private javax.swing.JTextField txt_ad;
    private javax.swing.JTextField txt_eml;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_por;
    private javax.swing.JTextField txt_pu;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_us;
    // End of variables declaration//GEN-END:variables

}
