/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionetudiant;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author aba
 */

public class ListeEtudiantGui extends javax.swing.JPanel {
    Connection conn;
    Statement st1, st2;
    ResultSet res1,res2,res3, res4;
    final StringWrapper fill;
    final StringWrapper niv;
    int nbEtudiant;
    /**
     * Creates new form ListeEtudiantGui
     */
    @SuppressWarnings("empty-statement")
    public ListeEtudiantGui() {
        fill = new StringWrapper("Toute les filliéres");
        niv = new StringWrapper("Tout les niveaux");
        initComponents();
        
        conn = DbUtils.createConnection();
        try {
            res3 = conn.createStatement().executeQuery("select * from root.filliere");;
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String data [] = new String[10];
       data[0]="Toute les filliéres";
        int i = 1;
        try {
            while (res3.next()) {
                String nom = res3.getString("nom");
                data[i] = nom;
                i++;
            } } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboFilliere.setModel(new javax.swing.DefaultComboBoxModel<>(data));
        
        afficherTable();
    }
   public void afficherTable(){
       
       conn = DbUtils.createConnection();
       String querry = "";
       comboFilliere.addActionListener((ActionEvent e) -> {
           fill.value = comboFilliere.getSelectedItem().toString();
           afficherTable();
       });
       comboNiveau.addActionListener((ActionEvent e) -> {
           niv.value = comboNiveau.getSelectedItem().toString();
           afficherTable();
       });
       
        try {
            res4 = conn.createStatement().executeQuery("select id from root.filliere where nom = '"+fill.value+"'");
            res4.next();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       if (!(fill.value.equalsIgnoreCase("Toute les filliéres")) && !(niv.value.equalsIgnoreCase("Tout les niveaux"))){
           System.out.println(niv);
           try {
               querry = "select * from root.etudiant where filliere = "+res4.getInt("id")+" and niveau = '"+niv.value+"'";
           } catch (SQLException ex) {
               Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else if (!fill.value.equals("Toute les filliéres") && niv.value.equals("Tout les niveaux")){
           try {
               querry = "select * from root.etudiant where filliere = "+res4.getInt("id")+"";
           } catch (SQLException ex) {
               Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
           }
       }else if (fill.value.equals("Toute les filliéres") && !niv.value.equals("Tout les niveaux")){
           querry = "select * from root.etudiant where niveau = '"+niv.value+"'";
       }else {querry = "select * from root.etudiant";}
      
        try {
            res1 = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(querry);
            res1.last(); nbEtudiant = res1.getRow(); res1.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String colunm [] = {"Code","Prenom","Nom","Date de naissance","Filliere","Niveau"};
        String data[][] = new String[nbEtudiant][6];
       
        int i = 0;
        try {
            while (res1.next()) {
                String code = res1.getString("code");
                String prenom = res1.getString("prenom");
                String nom = res1.getString("nom");
                String date_naissance = res1.getString("date_naissance");
                int fil = res1.getInt("filliere");
                String niveau = res1.getString("niveau");
                st2 = conn.createStatement();
                res2 = st2.executeQuery(" select nom from root.filliere where id = "+fil+"  ");
                res2.next();
                String filliere = res2.getString("nom");
                data[i][0] = code;
                data[i][1] = prenom;
                data[i][2] = nom;
                data[i][3] = date_naissance;
                data[i][4] = filliere;
                data[i][5] = niveau;
                i++;
            } } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        TableEtudiant.setModel(new javax.swing.table.DefaultTableModel(data,colunm));
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
        comboFilliere = new javax.swing.JComboBox<>();
        comboNiveau = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableEtudiant = new javax.swing.JTable();
        bouttonEditer = new javax.swing.JButton();
        bouttonSupprimer = new javax.swing.JButton();

        jLabel1.setBackground(new java.awt.Color(0, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Liste des étudiants");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Filtre :");

        comboFilliere.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboFilliere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboNiveau.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboNiveau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tout les niveaux", "Licence 1", "Licence 2", "Licence 3", "Master 1", "Master 2" }));

        TableEtudiant.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TableEtudiant.setSelectionBackground(new java.awt.Color(51, 102, 255));
        jScrollPane1.setViewportView(TableEtudiant);

        bouttonEditer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bouttonEditer.setText("Editer");
        bouttonEditer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonEditerActionPerformed(evt);
            }
        });

        bouttonSupprimer.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bouttonSupprimer.setText("Supprimer");
        bouttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonSupprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(292, 292, 292)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(comboFilliere, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 155, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bouttonEditer)
                .addGap(18, 18, 18)
                .addComponent(bouttonSupprimer)
                .addGap(292, 292, 292))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboFilliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bouttonEditer)
                    .addComponent(bouttonSupprimer))
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bouttonEditerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonEditerActionPerformed

        int ligneSelectionner = TableEtudiant.getSelectedRow();
            String code = (String) TableEtudiant.getValueAt(ligneSelectionner, 0);
            String pr = (String) TableEtudiant.getValueAt(ligneSelectionner, 1);
            String nom = (String) TableEtudiant.getValueAt(ligneSelectionner, 2);
            String date = (String) TableEtudiant.getValueAt(ligneSelectionner, 3);
            String fl = (String) TableEtudiant.getValueAt(ligneSelectionner, 4);
            String nv = (String) TableEtudiant.getValueAt(ligneSelectionner, 5);
            AjoutEtudiantGui contenu = new AjoutEtudiantGui();
            Window w  = SwingUtilities.windowForComponent(this);
            if (w instanceof JFrame) {
                    JFrame frame = (JFrame) w;
                    contenu.initialiseFormulaire(code, pr, nom, date, fl, nv);
                    frame.setContentPane(contenu);      
                    frame.repaint();
                    frame.revalidate();
            }
    }//GEN-LAST:event_bouttonEditerActionPerformed

    private void bouttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonSupprimerActionPerformed
        int ligneSelectionner = TableEtudiant.getSelectedRow();
        String code = (String) TableEtudiant.getValueAt(ligneSelectionner, 0);  
        int option = JOptionPane.showConfirmDialog(null, 
        "Etes vous sur de vouloir supprimer l'étudiant de code "+code+" ?",
        "Suppression d'un etudiant",
        JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION){
            
            try {
            DbUtils.createConnection().createStatement().executeUpdate("delete from root.etudiant where code = '"+code+"'");
            afficherTable();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_bouttonSupprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableEtudiant;
    private javax.swing.JButton bouttonEditer;
    private javax.swing.JButton bouttonSupprimer;
    private javax.swing.JComboBox<String> comboFilliere;
    private javax.swing.JComboBox<String> comboNiveau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
