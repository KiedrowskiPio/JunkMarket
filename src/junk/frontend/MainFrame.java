/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.frontend;

import java.util.ArrayList;
import junk.backend.Car;
import junk.backend.Database;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 *
 * @author kiedr
 */
public class MainFrame extends javax.swing.JFrame {

    Database db = new Database();
    private ImageIcon image1;
    private JLabel label1;
    
    public MainFrame() throws IOException{
        initComponents();
        addClient = new AddClient();
        addClient.setTitle("Dodaj Klienta");
        addCar = new AddCar();
        addCar.setTitle("Dodaj Samochód");
        clientList = new ClientList();
        clientList.setTitle("Lista Klientów");
        carList = new CarList();
        carList.setTitle("Lista Samochodów");
        transactionList = new TransactionList();
        transactionList.setTitle("Lista Transakcji");
        stats = new Stats();
        stats.setTitle("Statystyki");
        
        setLayout(new FlowLayout());
        image1 = new ImageIcon(getClass().getResource("mr2-rusty.jpg"));
        label1 = new JLabel(image1);
        add(label1);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        ClientMenu = new javax.swing.JMenu();
        AddClient = new javax.swing.JMenuItem();
        ClientList = new javax.swing.JMenuItem();
        CarMenu = new javax.swing.JMenu();
        AddCar = new javax.swing.JMenuItem();
        CarList = new javax.swing.JMenuItem();
        StatList = new javax.swing.JMenuItem();
        TransacionMenu = new javax.swing.JMenu();
        TransactionList = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(240, 153, 153));

        ClientMenu.setText("Klienci");

        AddClient.setText("Dodaj");
        AddClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddClientActionPerformed(evt);
            }
        });
        ClientMenu.add(AddClient);

        ClientList.setText("Lista");
        ClientList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientListActionPerformed(evt);
            }
        });
        ClientMenu.add(ClientList);

        jMenuBar1.add(ClientMenu);

        CarMenu.setText("Samochody");

        AddCar.setText("Dodaj");
        AddCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCarActionPerformed(evt);
            }
        });
        CarMenu.add(AddCar);

        CarList.setText("Lista");
        CarList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarListActionPerformed(evt);
            }
        });
        CarMenu.add(CarList);

        StatList.setText("Statystyki");
        StatList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StatListActionPerformed(evt);
            }
        });
        CarMenu.add(StatList);

        jMenuBar1.add(CarMenu);

        TransacionMenu.setText("Transakcje");

        TransactionList.setText("Lista");
        TransactionList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TransactionListActionPerformed(evt);
            }
        });
        TransacionMenu.add(TransactionList);

        jMenuBar1.add(TransacionMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddClientActionPerformed
        // TODO add your handling code here:
        addClient.setVisible(true);
    }//GEN-LAST:event_AddClientActionPerformed

    private void ClientListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientListActionPerformed
        // TODO add your handling code here:
        clientList.setVisible(true);
    }//GEN-LAST:event_ClientListActionPerformed

    private void AddCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCarActionPerformed
        // TODO add your handling code here:
        addCar.setVisible(true);
    }//GEN-LAST:event_AddCarActionPerformed

    private void CarListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarListActionPerformed
        // TODO add your handling code here:
        carList.setVisible(true);
    }//GEN-LAST:event_CarListActionPerformed

    private void TransactionListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TransactionListActionPerformed
        // TODO add your handling code here:
        transactionList.setVisible(true);
    }//GEN-LAST:event_TransactionListActionPerformed

    private void StatListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StatListActionPerformed
        // TODO add your handling code here:
        stats.setVisible(true);
    }//GEN-LAST:event_StatListActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                try {
                    new MainFrame().setVisible(true);
                    
                } catch (IOException ex) {
                    Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AddCar;
    private javax.swing.JMenuItem AddClient;
    private javax.swing.JMenuItem CarList;
    private javax.swing.JMenu CarMenu;
    private javax.swing.JMenuItem ClientList;
    private javax.swing.JMenu ClientMenu;
    private javax.swing.JMenuItem StatList;
    private javax.swing.JMenu TransacionMenu;
    private javax.swing.JMenuItem TransactionList;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    private AddClient addClient;
    private ClientList clientList;
    private AddCar addCar; 
    private CarList carList;
    private TransactionList transactionList;
    private Stats stats;
}
