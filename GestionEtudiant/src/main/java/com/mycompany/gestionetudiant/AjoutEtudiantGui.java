/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionetudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author aba
 */
public class AjoutEtudiantGui extends javax.swing.JPanel {
    
    Connection conn;
    Statement st1, st2;
    ResultSet res1,res2;
    String codeSelectionner;

    /**
     * Creates new form AjoutEdudiantGui
     */
    public AjoutEtudiantGui() {
        initComponents();
        
        conn = DbUtils.createConnection();
        try {
            st1 = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            res1 = st1.executeQuery("select * from root.filliere");
        } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       String data [] = new String[10];
       data[0]="Filliére";
        int i = 1;
        try {
            while (res1.next()) {
                String nom = res1.getString("nom");
                data[i] = nom;
                i++;
            } } catch (SQLException ex) {
            Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        comboFilliere.setModel(new javax.swing.DefaultComboBoxModel<>(data));
       
    }
    public void initialiseFormulaire(String code, String pr, String n, String dn, String fl, String nv){
        LabelTitre.setText("Editer l'étudiant");
        codeEtudiant.setText(code);
        prenomEtudiant.setText(pr);
        nomEtudiant.setText(n);
        dateNaissanceEtudiant.setText(dn);
        comboFilliere.setSelectedItem(fl);
        comboNiveau.setSelectedItem(nv);
        codeSelectionner = code;
        ErrorLabel.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelTitre = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        prenomEtudiant = new javax.swing.JTextField();
        nomEtudiant = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dateNaissanceEtudiant = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        codeEtudiant = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboFilliere = new javax.swing.JComboBox<>();
        comboNiveau = new javax.swing.JComboBox<>();
        BouttonValide = new javax.swing.JButton();
        ErrorLabel = new javax.swing.JLabel();

        LabelTitre.setBackground(new java.awt.Color(0, 102, 255));
        LabelTitre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        LabelTitre.setText("Ajouter un Etudiant");
        LabelTitre.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel2.setText("Prenom :");

        prenomEtudiant.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        prenomEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prenomEtudiantActionPerformed(evt);
            }
        });

        nomEtudiant.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        nomEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomEtudiantActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel3.setText("nom :");

        dateNaissanceEtudiant.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        dateNaissanceEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateNaissanceEtudiantActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel4.setText("Date Naissance :");

        codeEtudiant.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        codeEtudiant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codeEtudiantActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel5.setText("Code Etudiant :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel6.setText("Filliére :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel7.setText("Niveau :");

        comboFilliere.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboFilliere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboFilliere.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboFilliereActionPerformed(evt);
            }
        });

        comboNiveau.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        comboNiveau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Niveau", "Licence 1", "Licence 2", "Licence 3", "Master 1", "Master 2" }));

        BouttonValide.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        BouttonValide.setText("Valider");
        BouttonValide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BouttonValideActionPerformed(evt);
            }
        });

        ErrorLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ErrorLabel.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(59, 59, 59)
                                    .addComponent(jLabel2)
                                    .addGap(44, 44, 44))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7))
                                    .addGap(44, 44, 44)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nomEtudiant)
                                .addComponent(prenomEtudiant)
                                .addComponent(codeEtudiant)
                                .addComponent(dateNaissanceEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGap(169, 169, 169)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboNiveau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboFilliere, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(LabelTitre))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BouttonValide, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(ErrorLabel)))))
                .addContainerGap(210, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(LabelTitre)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(codeEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prenomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nomEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(dateNaissanceEtudiant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboFilliere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboNiveau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addComponent(BouttonValide, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ErrorLabel)
                .addContainerGap(34, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void prenomEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prenomEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prenomEtudiantActionPerformed

    private void nomEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomEtudiantActionPerformed

    private void dateNaissanceEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateNaissanceEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateNaissanceEtudiantActionPerformed

    private void codeEtudiantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_codeEtudiantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_codeEtudiantActionPerformed

    private void comboFilliereActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboFilliereActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboFilliereActionPerformed

    private void BouttonValideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BouttonValideActionPerformed
            ErrorLabel.setForeground(new java.awt.Color(255, 0, 0));                                 
            String code = codeEtudiant.getText();
            String prenom = prenomEtudiant.getText();
            String nom = nomEtudiant.getText();
            String dateNaissance = dateNaissanceEtudiant.getText();
            String filliere = comboFilliere.getSelectedItem().toString();
            String niveau = comboNiveau.getSelectedItem().toString();
            if (code.length() == 0){
                ErrorLabel.setText("Le code etudiant doit etre renseigner");
            }else if (prenom.length() == 0){
                ErrorLabel.setText("Le Prenom de l'etudiant doit etre renseigner");
            }else if (nom.length() == 0){
                ErrorLabel.setText("Le nom de l'etudiant doit etre renseigner");
            }else if (dateNaissance.length() != 10){
                ErrorLabel.setText("Le format de la date est invalide ! mettez une date sous forme 09/08/1998");
            }else if(filliere.equals("Filliére")){
                ErrorLabel.setText("Aucune filliére séléctioner !");
            }else if(niveau.equals("Niveau")){
                ErrorLabel.setText("Aucun Niveau séléctioner !");
            }else { 
                ErrorLabel.setText("");
                try {
                    res2 = conn.createStatement().executeQuery("select id from root.filliere where nom = '"+filliere+"'");
                    res2.next();
                } catch (SQLException ex) {
                    Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if(LabelTitre.getText().equalsIgnoreCase("ajouter un etudiant")){
                        conn.createStatement().execute(
            "insert into etudiant (code,prenom,nom,date_naissance,filliere,niveau) values ('"+code+"','"+prenom+"','"+nom+"','"+dateNaissance+"',"+res2.getInt("id")+",'"+niveau+"')");
                    ErrorLabel.setForeground(new java.awt.Color(51, 51, 255));
                    ErrorLabel.setText("Etudiant ajouter avec succés");
                    }else {  conn.createStatement().executeUpdate(
            "update root.ETUDIANT set code = '"+code+"',prenom = '"+prenom+"',nom = '"+nom+"',date_naissance = '"+dateNaissance+"',filliere = "+res2.getInt("id")+",niveau = '"+niveau+"' where code = '"+codeSelectionner+"' ");
                    ErrorLabel.setForeground(new java.awt.Color(51, 51, 255));
                    ErrorLabel.setText("Etudiant editer avec succés");
                    }
                    codeEtudiant.setText("");prenomEtudiant.setText("");nomEtudiant.setText("");
                    dateNaissanceEtudiant.setText("");comboFilliere.setSelectedItem("Filliére");
                    comboNiveau.setSelectedItem("Niveau");
                    } catch (SQLException ex) {
                        Logger.getLogger(ListeEtudiantGui.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
    }//GEN-LAST:event_BouttonValideActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BouttonValide;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JLabel LabelTitre;
    private javax.swing.JTextField codeEtudiant;
    private javax.swing.JComboBox<String> comboFilliere;
    private javax.swing.JComboBox<String> comboNiveau;
    private javax.swing.JTextField dateNaissanceEtudiant;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField nomEtudiant;
    private javax.swing.JTextField prenomEtudiant;
    // End of variables declaration//GEN-END:variables
}