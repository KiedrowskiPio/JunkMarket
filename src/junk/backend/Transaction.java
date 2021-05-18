/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.backend;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Transaction {
    
    private int id_transakcji, id_samochodu, id_klienta;
    private double cena_uzyskana;
    private Date data_transakcji;
    
    public Transaction(int id_transakcji, int id_samochodu, int id_klienta, double cena_uzyskana, Date data_transakcji){
        this.id_transakcji = id_transakcji;
        this.id_samochodu = id_samochodu;
        this.id_klienta = id_klienta;
        this.cena_uzyskana = cena_uzyskana;
        this.data_transakcji = data_transakcji;
    }

    public Date getDate() {
        return data_transakcji;
    }

    public void setDate(Date date) {
        this.data_transakcji = date;
    }

    public int getId_transakcji() {
        return id_transakcji;
    }

    public void setId_transakcji(int id_transakcji) {
        this.id_transakcji = id_transakcji;
    }

    public int getId_samochodu() {
        return id_samochodu;
    }

    public void setId_samochodu(int id_samochodu) {
        this.id_samochodu = id_samochodu;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public double getCena_uzyskana() {
        return cena_uzyskana;
    }

    public void setCena_uzyskana(double cena_uzyskana) {
        this.cena_uzyskana = cena_uzyskana;
    }
    
}
