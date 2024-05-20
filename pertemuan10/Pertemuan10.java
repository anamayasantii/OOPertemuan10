/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan10;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Anamaya Santi - 2201010156
 * 20 Mei 2024
 */
public class Pertemuan10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        list_all();
    }
    
    static void list_all() throws SQLException{
        Connection cnn = koneksi.getKoneksi();
        if (cnn.isClosed()){
            System.out.println("Koneksi gagal");
        }else{
            PreparedStatement PS = cnn.prepareStatement("SELECT * FROM datateman;");
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                System.out.println( "No Record : "+ rs.getInt("idteman") );
                System.out.println( "Nama : "+ rs.getString("nama") );
                System.out.println( "Alamat : "+ rs.getString("alamat") );
                System.out.println( "Telepon : "+ rs.getString("telp") );
            }
            
            cnn.close();
        }
    }
}
