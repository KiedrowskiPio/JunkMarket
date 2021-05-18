/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.backend;

/**
 *
 * @author kiedr
 */
public class Car {
    private int id_smochodu, rocznik, cena;
    private String marka, model, opis, stan;

    public Car (int id_smochodu, String marka, String model, String opis, int cena, int rocznik, String stan ){
        this.id_smochodu = id_smochodu;
        this.marka = marka;
        this.model = model;
        this.opis = opis;
        this.cena = cena;
        this.rocznik = rocznik;
        this.stan = stan;
    }

    public int getId_smochodu() {
        return id_smochodu;
    }

    public void setId_smochodu(int id_smochodu) {
        this.id_smochodu = id_smochodu;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getStan() {
        return stan;
    }

    public void setStan(String stan) {
        this.stan = stan;
    }
}