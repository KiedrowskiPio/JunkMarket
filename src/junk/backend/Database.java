/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junk.backend;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import junk.frontend.ClientList;
/**
 *
 * @author kiedr
 */
public class Database {
    
    public void addClient(String id_klienta, String imie, String nazwisko, String nr_telefonu, String miasto, String nip) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.dodajKlienta(?,?,?,?,?,?)}");
                procedure.setInt(1, Integer.parseInt(id_klienta));
                procedure.setString(2, imie);
                procedure.setString(3, nazwisko);
                procedure.setString(4, nr_telefonu);
                procedure.setString(5, miasto);
                procedure.setString(6, nip);
                
                procedure.execute();
                connection.close();
                
                ClientList main = new ClientList();
                
            System.out.println("Dodano Klienta");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }
        
    public void addCar (String id_samochodu, String marka, String model, String opis, String cena, String rocznik, String stan) {
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.dodajSamochod(?,?,?,?,?,?,?)}");
                procedure.setInt(1, Integer.parseInt(id_samochodu));
                procedure.setString(2, marka);
                procedure.setString(3, model);
                procedure.setString(4, opis);
                procedure.setInt(5, Integer.parseInt(cena));
                procedure.setInt(6, Integer.parseInt(rocznik));
                procedure.setString(7, stan);
                
                procedure.execute();
                connection.close();
                
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }
    
    public ArrayList getClientId() {
        
        ArrayList<Integer> clientIdList= new ArrayList<Integer>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.pobierzIdKlienta}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientIdList.add(rs.getInt("id_klienta"));
            }          
            connection.close();
            return(clientIdList);
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
            }
    }
    
    public ArrayList getCarId() {
        
        ArrayList<Integer> clientIdList= new ArrayList<Integer>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.pobierzIdSamochodu}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientIdList.add(rs.getInt("id_samochodu"));
            }          
            connection.close();
            return(clientIdList);
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
            }
    }
    
    public ArrayList<Client> getClient(){
        ArrayList<Client> clientList= new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.pobierzKlientow}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                clientList.add(new Client(rs.getInt("id_klienta"),
                    rs.getString("imie"),
                    rs.getString("nazwisko"),
                    rs.getString("nr_telefonu"),
                    rs.getString("miasto"),
                    rs.getString("nip")));
            }          
            connection.close();
            return(clientList);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public ArrayList<Car> getCars(){
        ArrayList<Car> carList= new ArrayList();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.pobierzSamochody}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                carList.add(new Car(rs.getInt("id_samochodu"),
                    rs.getString("marka"),
                    rs.getString("model"),
                    rs.getString("opis"),
                    rs.getInt("cena"),
                    rs.getInt("rocznik"),
                    rs.getString("stan")));
            }          
            connection.close();
            return(carList);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    public void addTransaction (Integer id_auta, Integer id_samochodu, String cena_uzyskana) {
        try{
            Date date = new Date();
//            Object param = new java.sql.Timestamp(date.getTime());
                java.sql.Date dataStartSql = new java.sql.Date(date.getTime());
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.dodajTransakcje(?,?,?,?)}");
                procedure.setInt(1, id_samochodu);
                procedure.setInt(2, id_auta);
                procedure.setDouble(3, Double.parseDouble(cena_uzyskana));
                procedure.setDate(4, dataStartSql);
                
                procedure.execute();
                connection.close();
                
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }

    public ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> transactionList= new ArrayList();
        
        //private int id_transakcji, id_samochodu, id_klienta;
        //private double cena_uzyskana;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.pobierzTransakcje}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                transactionList.add(new Transaction(rs.getInt("id_transakcji"), 
                        rs.getInt("id_auta"), 
                        rs.getInt("id_klienta"), 
                        rs.getDouble("cena_uzyskana"),
                        rs.getDate("data_transakcji")));
            }          
            connection.close();
            return(transactionList);
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public void deleteClient(int id_klienta){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.usunKlienta(?)}");
                procedure.setInt(1, id_klienta);
                
                procedure.execute();
                connection.close();
                
            System.out.println("usunięto Klienta");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }

    public void deleteCar(int id_samochodu){
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.usunSamochod(?)}");
                procedure.setInt(1, id_samochodu);
                
                procedure.execute();
                connection.close();
                
            System.out.println("usunięto samochód");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }

    public void editClient(int id_klienta, String imie, String nazwisko, String nr_telefonu, String miasto, String nip){
         try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.edytujKlienta(?,?,?,?,?,?)}");
                procedure.setInt(1, id_klienta);
                procedure.setString(2, imie);
                procedure.setString(3, nazwisko);
                procedure.setString(4, nr_telefonu);
                procedure.setString(5, miasto);
                procedure.setString(6, nip);
                
                procedure.execute();
                connection.close();
                
            System.out.println("Edytowano Klienta");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
    }

    public void editCar(int id_samochodu, String marka, String model, String opis, int cena, int rocznik, String stan){
        
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");
            CallableStatement procedure = connection.prepareCall("{call dbo.edytujSamochod(?,?,?,?,?,?,?)}");
                procedure.setInt(1, id_samochodu);
                procedure.setString(2, marka);
                procedure.setString(3, model);
                procedure.setString(4, opis);
                procedure.setInt(5, cena);
                procedure.setInt(6, rocznik);
                procedure.setString(7, stan);
                
                procedure.execute();
                connection.close();
                
            System.out.println("Edytowano Samochód");
        }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
                "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
        
    }

    public ArrayList<String> getMaxPriceCar(){
        ArrayList<String> expCar = new ArrayList<String>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.maxAuto}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                expCar.add(String.valueOf(rs.getInt("id_samochodu")));
                expCar.add(rs.getString("marka"));
                expCar.add(rs.getString("model"));
                expCar.add(rs.getString("opis"));
                expCar.add(String.valueOf(rs.getInt("cena")));
                expCar.add(String.valueOf(rs.getInt("rocznik")));
                expCar.add(rs.getString("stan"));
            }
            connection.close();
            return(expCar);
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
            }
    }

    public ArrayList<String> getMinPriceCar(){
        ArrayList<String> cheapCar = new ArrayList<String>();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.minAuto}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cheapCar.add(String.valueOf(rs.getInt("id_samochodu")));
                cheapCar.add(rs.getString("marka"));
                cheapCar.add(rs.getString("model"));
                cheapCar.add(rs.getString("opis"));
                cheapCar.add(String.valueOf(rs.getInt("cena")));
                cheapCar.add(String.valueOf(rs.getInt("rocznik")));
                cheapCar.add(rs.getString("stan"));
            }
            connection.close();
            return(cheapCar);
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            return null;
            }
    }
    
    public int getSummedPrice(){
        int price = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.wartosc}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                price = rs.getInt("wartosc");
            }
            connection.close();
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
        return(price);
    }

    public int getMaxTransaction(){
        int price = 0;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=JunkMarket",
                    "JunkMarketAdmin", "junkmarket123");

            PreparedStatement ps = connection.prepareStatement("{call dbo.maxTransakcja}");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                price = rs.getInt("maxCenaUzyskana");
            }
            connection.close();
            
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Błąd "+e.getMessage(),
            "Błąd aplikacji",JOptionPane.ERROR_MESSAGE);
            }
        return(price);
    }



}
