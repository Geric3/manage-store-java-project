/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base_de_donnée;







import com.mysql.jdbc.Driver;


import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;

import java.sql.*;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;




 


/**
 *
 * @author Roger
 */
public class Produit extends javax.swing.JFrame {
    
    ResultSet rs;
    BDD db;
    
    String codepro, nompro, hak;
    int old,dec,now;
    private static Pattern motif=null;
    private static Pattern motif1=null;
    Matcher matcher,matcher1,matcher2;
    /**
     * Creates new form Produit
     */
    public Produit() {
        db= new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new 
        Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        initComponents();
        table();
    }
    
        public void table(){
        String a[]={"id","code_produit","nom_produit","fournisseur","prix","stock"};
        rs=db.querySelect(a,"produit");
        table_pro.setModel(new ResultSetTableModel(rs));
    }
    
    void actualiser(){
        txt_co.setText("");
        txt_no.setText("");
        txt_fo.setText("");
        txt_rem.setText("");
        txt_pri.setText("");
        txt_sto.setText("");
        txt_rech.setText("");
        //com_ty.setSelectedItem("Typpppe");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_sto = new javax.swing.JTextField();
        txt_co = new javax.swing.JTextField();
        txt_no = new javax.swing.JTextField();
        txt_rech = new javax.swing.JTextField();
        txt_rem = new javax.swing.JTextField();
        txt_pri = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        com_rech = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        txt_fo = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_pro = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(330, 100));
        setPreferredSize(new java.awt.Dimension(800, 560));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("stock:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(430, 280, 100, 30);

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Rechercher par catégorie:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(360, 330, 210, 30);

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("nom_produit:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(50, 230, 150, 30);

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("fournisseur:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 280, 120, 30);

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("autre prix:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(430, 180, 100, 30);

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel6.setText("prix:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(430, 230, 90, 30);

        txt_sto.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_sto.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_sto);
        txt_sto.setBounds(540, 280, 170, 30);

        txt_co.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_co.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txt_co.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_coActionPerformed(evt);
            }
        });
        getContentPane().add(txt_co);
        txt_co.setBounds(210, 180, 170, 30);

        txt_no.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_no.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_no);
        txt_no.setBounds(210, 230, 170, 30);

        txt_rech.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_rech.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_rech);
        txt_rech.setBounds(530, 400, 180, 30);

        txt_rem.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_rem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_rem);
        txt_rem.setBounds(540, 180, 170, 30);

        txt_pri.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_pri.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_pri);
        txt_pri.setBounds(540, 230, 170, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Actualiser");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(170, 390, 120, 50);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Ajouter");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(30, 330, 120, 50);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Supprimer");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(30, 390, 120, 50);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Modifier");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(170, 330, 120, 50);

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setText("code_produit:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 180, 150, 30);

        com_rech.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        com_rech.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "code_produit", "nom_produit", "fournisseur", "stock", "prix" }));
        com_rech.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 204, 153), 3, true));
        getContentPane().add(com_rech);
        com_rech.setBounds(530, 360, 180, 30);

        jButton5.setBackground(new java.awt.Color(0, 255, 153));
        jButton5.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton5.setText("Annuler");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(390, 450, 240, 60);

        txt_fo.setFont(new java.awt.Font("Minion Pro Cond", 0, 14)); // NOI18N
        txt_fo.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        getContentPane().add(txt_fo);
        txt_fo.setBounds(210, 280, 170, 30);

        jButton6.setBackground(new java.awt.Color(0, 255, 153));
        jButton6.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jButton6.setText("Rechercher:");
        jButton6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(360, 390, 130, 50);

        jButton7.setBackground(new java.awt.Color(0, 255, 153));
        jButton7.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jButton7.setText("Retour");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 3, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(150, 450, 240, 60);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        jLabel8.setText("Sauvegarde des produits");
        jLabel8.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel8);
        jLabel8.setBounds(240, 20, 310, 40);

        jLabel9.setText("ETS SMART CODE ATLAS tel:  675692431");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 0, 320, 14);

        table_pro.setBackground(new java.awt.Color(153, 255, 0));
        table_pro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 102), new java.awt.Color(204, 255, 102), null, null));
        table_pro.setForeground(new java.awt.Color(51, 51, 255));
        table_pro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "code_produit", "nom_produit", "fournisseur", "prix", "stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setBounds(0, 70, 790, 100);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 800, 170);

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));
        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 170, 800, 390);
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_coActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_coActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_coActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        actualiser();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                if(txt_rech.getText().equals(""))//si le textfield de recherche est vide le programme affichera "SVP entrer quelque chose"
        {
           JOptionPane.showMessageDialog(this,"SVP entrer quelques chose");
        }else{
           if(com_rech.getSelectedItem().equals("code_produit")){
              rs=db.querySelectAll("produit", "code_produit LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from produit where id_user='"+txt_rech.getText()+"'");
              table_pro.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("nom_produit")){
              rs=db.querySelectAll("produit", "nom_produit LIKE '%"+ txt_rech.getText()+"%'");
              //rs=db.exécutionQuery("select * from produit where username='"+txt_rech.getText()+"'");
              table_pro.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("fournisseur")){
              rs=db.querySelectAll("produit", "fournisseur LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("prix")){
              rs=db.querySelectAll("produit", "prix LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new ResultSetTableModel(rs));
           }else if
              (com_rech.getSelectedItem().equals("stock")){
              rs=db.querySelectAll("produit", "stock LIKE '%"+ txt_rech.getText()+"%'");
              table_pro.setModel(new ResultSetTableModel(rs));
           }
        }
    }//GEN-LAST:event_jButton6ActionPerformed
   //retourner
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Login lo= new Login();
        lo.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton7ActionPerformed
    //ajouter produits
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        motif= Pattern.compile("[0-9]*");
        String id=String.valueOf(txt_rem.getText());
        matcher1= motif.matcher(id);
        String add=String.valueOf(txt_sto.getText());
        matcher= motif.matcher(add);
        String ad=String.valueOf(txt_pri.getText());
        matcher2= motif.matcher(ad);
        if(txt_co.getText().equals("")||txt_no.getText().equals("")||txt_fo.getText().equals("")
                        ||txt_pri.getText().equals("") ||txt_sto.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SVP entrer les informations complètes dans tous les champs!");
        }else if(!(matcher.matches()) || !(matcher1.matches()) || !(matcher2.matches()) ){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour les champs prix  et stock!");
        }
        else{
                   
            rs=db.exécutionQuery("select code_produit,nom_produit from produit ");
            System.out.print(rs);
        try {
            rs.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
           while(rs.next()){
               codepro= rs.getString("code_produit");
               nompro=rs.getString("nom_produit");
               //hak=rs.getString("fonction");
               //System.out.print(username1);
               if(txt_co.getText().equals(codepro) && txt_no.getText().equals(nompro)){
           //JOptionPane.showMessageDialog(this,"le nom de l'utilisateur ou le mots de pass est incorect");
           //jlabel.setText("erreuuuuuuuuuur");
           //jlabel.setVisible(true);
           try{
           def();
           //table();
            actualiser();
           }catch(SQLException e){Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,e);}
        }
           }
           if(!(codepro==txt_co.getText()) && !(nompro==txt_no.getText())){
              String[] colon={"code_produit","nom_produit","fournisseur","prix","stock"};
            String[] inf={txt_co.getText(),txt_no.getText(),txt_fo.getText(),txt_pri.getText(),txt_sto.getText(),};
            
             db.exécutionUpdate("insert into produit(code_produit,nom_produit,fournisseur,prix,stock) values('"
                     +txt_co.getText()+"','"+txt_no.getText()+"','"+txt_fo.getText()+"',"+txt_pri.getText()+" ,"+txt_sto.getText()+")");
            //System.out.println(db.queryInsert("produit",colon,inf));
            
            db.exécutionUpdate("insert into founisseur(nom_produit,nom_founisseur,quantite,prix_unitaire) values('"
                     +txt_no.getText()+"','"+txt_fo.getText()+"' ,"+txt_sto.getText()+",21)");
            
            System.out.println("insert into produit(code_produit,nom_produit,fournisseur,prix,stock) values('"
                    +txt_co.getText()+"','"+txt_no.getText()+"','"+txt_fo.getText()+"',"+txt_pri.getText()+")");
            table();
            actualiser();
            JOptionPane.showMessageDialog(this, "Le produit a bien été ajouté avec succès!!!");
           }
        }catch(SQLException ex){
           Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,ex);
        }
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    // modifier
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        motif= Pattern.compile("[0-9]*");
        String d=String.valueOf(txt_rem.getText());
        matcher1= motif.matcher(d);
        String add=String.valueOf(txt_sto.getText());
        matcher= motif.matcher(add);
        String ad=String.valueOf(txt_pri.getText());
        matcher2= motif.matcher(ad);
        if(txt_co.getText().equals("")||txt_no.getText().equals("")||txt_fo.getText().equals("")
                         ||txt_pri.getText().equals("") ||txt_sto.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SVP entrer les informations compl�tes");
        }else if(!(matcher.matches()) || !(matcher1.matches()) || !(matcher2.matches()) ){
           JOptionPane.showMessageDialog(this,"SVP entrer les chiffres pour les champs prix  et stock!");
        }
        else{
            String[] colon={"code_produit","nom_produit","fournisseur","prix","stock"};
            String[] inf={txt_co.getText(),txt_no.getText(),txt_fo.getText(),txt_pri.getText(),txt_sto.getText()};
            String id=String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("produit",colon,inf,"id="+ id +"\n"));
            table();
            actualiser();
            JOptionPane.showMessageDialog(this, "Le produit a bien été modifié avec succès!!!");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(txt_co.getText().equals("")||txt_no.getText().equals("")||txt_fo.getText().equals("")
                         ||txt_pri.getText().equals("") ||txt_sto.getText().equals("")){
            JOptionPane.showMessageDialog(this,"SVP sélectionner le produit que vous voullez supprimer");
        }else{
        String id=String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),1));
        String idd=String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),2));
        System.out.println("le id est:"+id);
        
        if(JOptionPane.showConfirmDialog(this,"est ce que tu es sure que tu veux suprimer",
                "attention!!!",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            //rs=db.querySelectAll("produit", "fournisseur LIKE '%"+ txt_rech.getText()+"%'");
            //db.queryDelete("produit","code_produit=" +id);
            db.exécutionUpdate("delete  FROM produit WHERE code_produit LIKE'%"+id+"%'");
            //db.queryDelete("founisseur","nom_founisseur=" +idd); 
            db.exécutionUpdate("delete  FROM founisseur WHERE nom_produit LIKE'%"+idd+"%'");
            System.out.println("db.exécutionUpdate(\"delete  FROM produit WHERE code_produit LIKE'%\"+id+\"%'\")");
            System.out.println("db.exécutionUpdate(\"delete  FROM produit WHERE code_produit LIKE'%\"+idd+\"%'\")");
            
        }else{return;}
        table();
        actualiser();
        JOptionPane.showMessageDialog(this, "Le produit a bien été supprimé avec succès!!!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         actualiser(); table();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table_proMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_proMouseClicked
        // TODO add your handling code here:
        txt_co.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),1)));
        txt_no.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),2)));
        txt_fo.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),3)));
        //txt_rem.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),4)));
        txt_pri.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),4)));
        txt_sto.setText(String.valueOf(table_pro.getValueAt(table_pro.getSelectedRow(),5)));
    }//GEN-LAST:event_table_proMouseClicked

    
    public void def() throws  SQLException{
       int odd=0;
       rs=db.querySelectAll("produit", "code_produit = '"+txt_co.getText()+"'");
       while(rs.next()){
          old=rs.getInt("stock");
          hak = rs.getString("fournisseur");
          //odd = old + 3;
       }
      // System.out.println(odd);
        dec= Integer.parseInt(txt_sto.getText());
        now=old+dec;
        String nvstock = Integer.toString(now);
        String nwqte = Integer.toString(dec);
        String a=String.valueOf(nvstock);
        String aqt=String.valueOf(nwqte);
        String [] colon ={"stock"};
        String [] isi={a};
        String [] col = {"quantite"};
        String [] aa = {aqt};
        System.out.println(db.queryUpdate("produit", colon, isi,"code_produit = '" +txt_co.getText()+"'" ));
        System.out.println(db.queryUpdate("founisseur", col, aa,"nom_founisseur = '" +txt_fo.getText()+"'" ));
//        db.exécutionUpdate("insert into founisseur(nom_produit,nom_founisseur,quantite,prix_unitaire) values('"
//                     +txt_no.getText()+"','"+txt_fo.getText()+"' ,"+txt_sto.getText()+",21)");

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
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Produit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
     
            public void run() {
                         ImageIcon image = new ImageIcon("Capture_carré2.png"); 
    new Produit().setIconImage(image.getImage());
                new Produit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> com_rech;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_pro;
    private javax.swing.JTextField txt_co;
    private javax.swing.JTextField txt_fo;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_pri;
    private javax.swing.JTextField txt_rech;
    private javax.swing.JTextField txt_rem;
    private javax.swing.JTextField txt_sto;
    // End of variables declaration//GEN-END:variables
}
