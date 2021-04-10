package crud.dao;

import crud.modelo.Operaciones;
import java.util.ArrayList;

import crud.modelo.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAOSistemas implements Operaciones{
    
    Database db = new Database();
    Sistemas sis = new Sistemas();

    @Override
    public boolean insertar(Object obj) {
        sis = (Sistemas) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "insert into sistemas values (?,?,?,?)";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUsr(),
                    db.getPwd()
            );
            pst = con.prepareStatement(sql);
            pst.setInt(1,sis.getN_control());
            pst.setString(2, sis.getNombre());
            pst.setString(3,sis.getCarrera());
            pst.setInt(4,sis.getAnnio_ingreso());
            
            int filas = pst.executeUpdate();
            if(filas > 0){
                con.close();
                return true;
            } else{
                con.close();
                return false;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error: "+ e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean eliminar(Object obj) {
       sis = (Sistemas) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "delete from sistemas where n_control = ?";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUsr(),
                    db.getPwd()
            );
            pst = con.prepareStatement(sql);
            pst.setInt(1,sis.getN_control());
            pst.setString(2, sis.getNombre());
            pst.setString(3,sis.getCarrera());
            pst.setInt(4,sis.getAnnio_ingreso());
            
            int filas = pst.executeUpdate();
            if(filas > 0){
                con.close();
                return true;
            } else{
                con.close();
                return false;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error: "+ e.getMessage());
            return false;
        }
        
    }

    @Override
    public boolean modificar(Object obj) {
               sis = (Sistemas) obj;
        Connection con;
        PreparedStatement pst;
        String sql = "update sistemas set nombre = ?, carrera = ?, annio_ingreso = ? where n_control = ?";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUsr(),
                    db.getPwd()
            );
            pst = con.prepareStatement(sql);

            pst.setString(1, sis.getNombre());
            pst.setString(2,sis.getCarrera());
            pst.setInt(3,sis.getAnnio_ingreso());
            pst.setInt(4,sis.getN_control());
            
            int filas = pst.executeUpdate();
            if(filas > 0){
                con.close();
                return true;
            } else{
                con.close();
                return false;
            }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error: "+ e.getMessage());
            return false;
        }
        
    }

    @Override
    public ArrayList<Object[]> consultar() {
        ArrayList<Object[]> data = new ArrayList<>();
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        String sql = "select * from sistemas";
        
        try{
            Class.forName(db.getDriver());
            con = DriverManager.getConnection(
                    db.getUrl(),
                    db.getUsr(),
                    db.getDriver()
            );
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                Object[] fila = new Object[4];
                for(int i = 0; i <= 3; i++){
                    fila[i] = rs.getObject(i+1);
                }
                data.add(fila);
            }
            con.close();
        }catch(SQLException| ClassNotFoundException e){
            JOptionPane.showMessageDialog(null,"Ocurrio este error: "+e.getMessage());
        }finally{
            return data;
        }
    }
    
}
