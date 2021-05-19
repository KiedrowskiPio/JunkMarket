/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.frontend;

import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.*;
import junk.backend.Car;
import junk.backend.Database;

public class CarList extends javax.swing.JFrame {

    public ArrayList<JTextField> parametry = new ArrayList<JTextField>();
    public ArrayList<String> lista = new ArrayList<String>();
    Database db = new Database();
    
    public CarList() {
        initComponents();
        ConfigureTable();        
    }
    
    private void ConfigureTable(){
        parametry.add(MARKA_TEXTFIELD);
        parametry.add(MODEL_TEXTFIELD);
        parametry.add(OPIS_TEXTFIELD);
        parametry.add(CENA_TEXTFIELD);
        parametry.add(ROCZNIK_TEXTFIELD);
        parametry.add(STAN_TEXTFIELD);
        
        carList = db.getCars();
        DefaultTableModel tblModel = (DefaultTableModel)carTable.getModel();
        for (Car car: carList) {
            Object[] row = {car.getId_smochodu(), car.getMarka(), car.getModel(), car.getOpis(), car.getCena(), car.getRocznik(), car.getStan()};
            
             tblModel.addRow(row);
        }
        
        carTable.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                int row = carTable.getSelectedRow();
                String currentValue;
                for(int i = 0; i<carTable.getColumnCount(); i++){
                    String value = carTable.getValueAt(row, i).toString();
                    lista.add(value);
                }
                for(int i = 0; i<carTable.getColumnCount() - 1; i++){
                    currentValue = lista.get(i + 1);
                    JTextField currentParameter = parametry.get(i);
                    currentParameter.setText("");
                    currentParameter.setText(currentValue);
                }
                lista.clear();
            }
        }); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        deleteCarButton = new javax.swing.JButton();
        MARKA_TEXTFIELD = new javax.swing.JTextField();
        MODEL_TEXTFIELD = new javax.swing.JTextField();
        OPIS_TEXTFIELD = new javax.swing.JTextField();
        CENA_TEXTFIELD = new javax.swing.JTextField();
        ROCZNIK_TEXTFIELD = new javax.swing.JTextField();
        STAN_TEXTFIELD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        editCarButton = new javax.swing.JButton();

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id Samochodu", "Marka", "Model", "Opis", "Cena", "Rocznik", "Stan"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(carTable);

        deleteCarButton.setText("Usuń samochód");
        deleteCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Marka");

        jLabel2.setText("Model");

        jLabel3.setText("Opis");

        jLabel4.setText("Cena");

        jLabel5.setText("Rocznik");

        jLabel6.setText("Stan");

        editCarButton.setText("Edytuj samochód");
        editCarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCarButtonActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(deleteCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(editCarButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MODEL_TEXTFIELD)
                            .addComponent(OPIS_TEXTFIELD)
                            .addComponent(CENA_TEXTFIELD)
                            .addComponent(ROCZNIK_TEXTFIELD)
                            .addComponent(MARKA_TEXTFIELD)
                            .addComponent(STAN_TEXTFIELD))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MARKA_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MODEL_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OPIS_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CENA_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ROCZNIK_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(STAN_TEXTFIELD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteCarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deleteCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCarButtonActionPerformed

        Database db = new Database();
        int row = carTable.getSelectedRow();
        int value = Integer.parseInt(carTable.getModel().getValueAt(row, 0).toString());
        db.deleteCar(value);
        ((DefaultTableModel)carTable.getModel()).removeRow(row);
        
    }//GEN-LAST:event_deleteCarButtonActionPerformed

    private void editCarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCarButtonActionPerformed

        Database db = new Database();
        int row = carTable.getSelectedRow();
        int value = Integer.parseInt(carTable.getModel().getValueAt(row, 0).toString());
        db.editCar(value, MARKA_TEXTFIELD.getText(), MODEL_TEXTFIELD.getText(), OPIS_TEXTFIELD.getText(), Integer.parseInt(CENA_TEXTFIELD.getText()) , Integer.parseInt(ROCZNIK_TEXTFIELD.getText()), STAN_TEXTFIELD.getText());
        
        for(int i = 0; i<carTable.getColumnCount() - 1; i++)
        {
            JTextField currentParameter = parametry.get(i);
            currentParameter.setText("");
        }
    }//GEN-LAST:event_editCarButtonActionPerformed

    
    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarList().setVisible(true);
            }
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CENA_TEXTFIELD;
    private javax.swing.JTextField MARKA_TEXTFIELD;
    private javax.swing.JTextField MODEL_TEXTFIELD;
    private javax.swing.JTextField OPIS_TEXTFIELD;
    private javax.swing.JTextField ROCZNIK_TEXTFIELD;
    private javax.swing.JTextField STAN_TEXTFIELD;
    private javax.swing.JTable carTable;
    private javax.swing.JButton deleteCarButton;
    private javax.swing.JButton editCarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Car> carList;
}
