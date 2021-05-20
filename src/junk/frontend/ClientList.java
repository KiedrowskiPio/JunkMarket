/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.frontend;

import java.util.ArrayList;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import junk.backend.Client;
import junk.backend.Database;

/**
 *
 * @author kiedr
 */
public class ClientList extends javax.swing.JFrame {

    public ArrayList<JTextField> parametry = new ArrayList<JTextField>();
    public ArrayList<String> lista = new ArrayList<String>();
    Database db = new Database();
    
    public ClientList() {
        initComponents();
        ConfigureTable();
        
    }
    
    public void ConfigureTable(){
        
        parametry.add(IMIE_TEXTFIELD);
        parametry.add(NAZWISKO_TEXTFIELD);
        parametry.add(NR_TELEFONU_TEXTFIELD);
        parametry.add(MIASTO_TEXTFIELD);
        parametry.add(NIP_TEXTFIELD);
        
        clientList = db.getClient();
        DefaultTableModel tblModel = (DefaultTableModel)clientTable.getModel();
        tblModel.fireTableDataChanged();
        for (Client client: clientList) {
            Object[] row = {client.getId_klienta(),client.getImie(),client.getNazwisko(),client.getNr_telefonu(),client.getMiasto(),client.getNip()};
            
             tblModel.addRow(row);
        }
        
        clientTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                
                int row = clientTable.getSelectedRow();
                String currentValue;
                for(int i = 0; i<clientTable.getColumnCount(); i++){
                    String value = clientTable.getValueAt(row, i).toString();
                    lista.add(value);
                }
                System.out.println(parametry);
                for(int i = 0; i<clientTable.getColumnCount() - 1; i++){
                    currentValue = lista.get(i + 1);
                    JTextField currentParameter = parametry.get(i);
                    currentParameter.setText("");
                    currentParameter.setText(currentValue);
                }
                lista.clear();
            }
        }); 
        
    }
    
        private void SyncTable(){
        clientList = db.getClient();
        clientTable.revalidate();
        DefaultTableModel model = (DefaultTableModel)clientTable.getModel();
        model.setRowCount(0);
        ConfigureTable();
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        clientTable = new javax.swing.JTable();
        deleteClientButton = new javax.swing.JButton();
        IMIE_TEXTFIELD = new javax.swing.JTextField();
        NAZWISKO_TEXTFIELD = new javax.swing.JTextField();
        NR_TELEFONU_TEXTFIELD = new javax.swing.JTextField();
        MIASTO_TEXTFIELD = new javax.swing.JTextField();
        NIP_TEXTFIELD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        editClientButton = new javax.swing.JButton();
        SyncBtn = new javax.swing.JButton();

        clientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Klienta", "Imię", "Nazwisko", "Nr Telefonu", "Miasto", "NIP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(clientTable);

        deleteClientButton.setText("Usuń Wybranego Klienta");
        deleteClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteClientButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Imie");

        jLabel2.setText("Nazwisko");

        jLabel3.setText("Nr Tel");

        jLabel4.setText("Miasto");

        jLabel5.setText("Nip");

        editClientButton.setText("Edytuj wybranego klienta");
        editClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editClientButtonActionPerformed(evt);
            }
        });

        SyncBtn.setText("Odśwież tablicę");
        SyncBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SyncBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NAZWISKO_TEXTFIELD)
                            .addComponent(NR_TELEFONU_TEXTFIELD)
                            .addComponent(MIASTO_TEXTFIELD)
                            .addComponent(NIP_TEXTFIELD)
                            .addComponent(IMIE_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(editClientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(deleteClientButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SyncBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IMIE_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NAZWISKO_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NR_TELEFONU_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MIASTO_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NIP_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editClientButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SyncBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteClientButtonActionPerformed
        
        Database db = new Database();
        int row = clientTable.getSelectedRow();
        int value = Integer.parseInt(clientTable.getModel().getValueAt(row, 0).toString());
        db.deleteClient(value);
        SyncTable();
    }//GEN-LAST:event_deleteClientButtonActionPerformed

    private void editClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editClientButtonActionPerformed

        Database db = new Database();
        int row = clientTable.getSelectedRow();
        int value = Integer.parseInt(clientTable.getModel().getValueAt(row, 0).toString());
        db.editClient(value, IMIE_TEXTFIELD.getText(), NAZWISKO_TEXTFIELD.getText(), NR_TELEFONU_TEXTFIELD.getText(), MIASTO_TEXTFIELD.getText(), NIP_TEXTFIELD.getText());
        
        for(int i = 0; i<clientTable.getColumnCount() - 1; i++)
        {
            JTextField currentParameter = parametry.get(i);
            currentParameter.setText("");
        }
        SyncTable();
    }//GEN-LAST:event_editClientButtonActionPerformed

    private void SyncBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SyncBtnActionPerformed
        // TODO add your handling code here:
        
        SyncTable();
    }//GEN-LAST:event_SyncBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IMIE_TEXTFIELD;
    private javax.swing.JTextField MIASTO_TEXTFIELD;
    private javax.swing.JTextField NAZWISKO_TEXTFIELD;
    private javax.swing.JTextField NIP_TEXTFIELD;
    private javax.swing.JTextField NR_TELEFONU_TEXTFIELD;
    private javax.swing.JButton SyncBtn;
    private javax.swing.JTable clientTable;
    private javax.swing.JButton deleteClientButton;
    private javax.swing.JButton editClientButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Client> clientList;
    
}
