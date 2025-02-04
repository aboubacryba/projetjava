/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionetudiant;

import java.awt.Window;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author aba
 */
public class ListeFilliereGui extends javax.swing.JPanel {
    
    ResultSet res1,res2;
    int nbFilliere;

    /**
     * Creates new form ListeFilliereGui
     */
    public ListeFilliereGui() {
        initComponents();
        afficherTable();
    }
    
    
       public void afficherTable(){
       
        try {
            res1 = DbUtils.createConnection().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(
                            "select * from root.filliere");
            res1.last(); nbFilliere = res1.getRow(); res1.beforeFirst();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        String colunm [] = {"id","nom de la filliere"};
        String data[][] = new String[nbFilliere][2];
       
        int i = 0;
        try {
            while (res1.next()) {
                String id = res1.getString("id");
                String nom = res1.getString("nom");
                data[i][0] = id;
                data[i][1] = nom;
                i++;
            } } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tableFilliere.setModel(new javax.swing.table.DefaultTableModel(data,colunm));
   }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTitre = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableFilliere = new javax.swing.JTable();
        bouttonSupprimer = new javax.swing.JButton();
        bouttonEditer1 = new javax.swing.JButton();

        labelTitre.setBackground(new java.awt.Color(51, 51, 255));
        labelTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelTitre.setText("Liste des fillieres existantes");
        labelTitre.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableFilliere.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableFilliere.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableFilliere);

        bouttonSupprimer.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bouttonSupprimer.setText("Supprimer");
        bouttonSupprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonSupprimerActionPerformed(evt);
            }
        });

        bouttonEditer1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bouttonEditer1.setText("Editer");
        bouttonEditer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bouttonEditer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(labelTitre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(bouttonEditer1)
                        .addGap(18, 18, 18)
                        .addComponent(bouttonSupprimer)))
                .addContainerGap(194, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(labelTitre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bouttonEditer1)
                    .addComponent(bouttonSupprimer))
                .addContainerGap(32, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bouttonSupprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonSupprimerActionPerformed
        int ligneSelectionner = tableFilliere.getSelectedRow();
        int id = Integer.parseInt((String) tableFilliere.getValueAt(ligneSelectionner, 0));
        int option = JOptionPane.showConfirmDialog(null, 
        "Si vous supprimer cette filliere tout les etudiants qui y sont inscrit seront aussi supprimer ! Continuer ?",
        "Suppression d'une filliére",
        JOptionPane.YES_NO_CANCEL_OPTION, 
        JOptionPane.QUESTION_MESSAGE);
        if(option != JOptionPane.NO_OPTION && option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION){
            
            try {
            DbUtils.createConnection().createStatement().executeUpdate("delete from root.filliere where id = "+id+" ");
            DbUtils.createConnection().createStatement().executeUpdate("delete from root.etudiant where filliere = "+id+" ");
            afficherTable();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }//GEN-LAST:event_bouttonSupprimerActionPerformed

    private void bouttonEditer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bouttonEditer1ActionPerformed
        int ligneSelectionner = tableFilliere.getSelectedRow();
        int id = Integer.parseInt((String) tableFilliere.getValueAt(ligneSelectionner, 0));
        String nom = (String) tableFilliere.getValueAt(ligneSelectionner, 1);
        AjoutFilliereGui contenu = new AjoutFilliereGui();
        Window w  = SwingUtilities.windowForComponent(this);
	if (w instanceof JFrame) {
		JFrame frame = (JFrame) w;
                contenu.initialiseFormulaire(id, nom);
                frame.setContentPane(contenu);      
                frame.repaint();
                frame.revalidate();
	}                                             
    }//GEN-LAST:event_bouttonEditer1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bouttonEditer1;
    private javax.swing.JButton bouttonSupprimer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelTitre;
    private javax.swing.JTable tableFilliere;
    // End of variables declaration//GEN-END:variables
}
