/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import controller.Controller;
import domain.Member;
import domain.Publication;
import domain.Publisher;
import static form.FormMode.EDIT;
import static form.FormMode.NEW;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tamarica
 */
public class FrmAddPublication extends javax.swing.JDialog {

    FormMode mode;
    private Publication publication;

    public FrmAddPublication(java.awt.Frame parent, boolean modal, FormMode mode) {
        super(parent, modal);
        initComponents();
        this.mode = mode;
        centerForm();
        getPublishers();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        lblAuthor = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        lblQuantity = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        lblPrice = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        lblPublisher = new javax.swing.JLabel();
        jComboBoxPublishers = new javax.swing.JComboBox();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Publication");

        lblTitle.setText("Title:");

        lblAuthor.setText("Author:");

        lblQuantity.setText("Quantity:");

        lblPrice.setText("Price:");

        lblPublisher.setText("Publisher:");

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblPrice, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(lblPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPublishers, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantity, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAuthor))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblQuantity))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPrice))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPublishers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPublisher))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        if (mode == NEW) {
            try {
                Publisher publisher = (Publisher) jComboBoxPublishers.getSelectedItem();
                Publication publication = new Publication(txtTitle.getText().trim(), txtAuthor.getText().trim(), Long.valueOf(txtQuantity.getText().trim()), Double.parseDouble(txtPrice.getText().trim()), publisher.getPublisherID());
                Controller.getInstance().addPublication(publication);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if (mode == EDIT) {
             try {
                Publisher publisher = (Publisher) jComboBoxPublishers.getSelectedItem();
                Publication publication = new Publication(this.publication.getPublicationID(),txtTitle.getText().trim(), txtAuthor.getText().trim(), Long.valueOf(txtQuantity.getText().trim()),Double.parseDouble(txtPrice.getText().trim()), publisher.getPublisherID());
                Controller.getInstance().updatePublication(publication);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }       
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox jComboBoxPublishers;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables

    private void centerForm() {
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void getPublishers() {
        try {
            Controller.getInstance().getAllPublishers();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setPublisherComboBox(List<Publisher> publishers) {
        jComboBoxPublishers.removeAllItems();
        for (Publisher publisher : publishers) {
            jComboBoxPublishers.addItem(publisher);
        }
    }
  public void setForm() {
        txtTitle.setText(publication.getTitle());
        txtAuthor.setText(publication.getAuthor());
        txtQuantity.setText(String.valueOf(publication.getQuantity()));
        txtPrice.setText(String.valueOf(publication.getPrice()));
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }
  
    public void setSelectedPublisher(List<Publisher> publishers) {
        setPublisherComboBox(publishers);
        
        Optional<Publisher> optionalPublisher = publishers.stream()
                .filter(publisher -> publisher.getPublisherID().equals(publication.getPublisherID()))
                .findFirst();

        if (optionalPublisher.isPresent()) {
            Publisher p = optionalPublisher.get();
            jComboBoxPublishers.setSelectedItem(p);
        }
             
    }
    
}
