
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;

public class ConsultasProducto extends conexion {
    
    //////////////INICIO METODO RESGISTRAR/////
    public boolean registrar(Producto p){
        PreparedStatement ps =null;
        Connection con = getConexion();
        String sql ="insert into producto (codigo,nombre,precio)values(?,?,?)";
    try{
            ps =con.prepareStatement(sql);
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getNombre());
            ps.setInt(3,p.getPrecio());
            ps.execute();
            return true;
    }catch(SQLException e){  
        System.err.print(e);
            return false;
    }        
    }
    //////// FIN METODO REGISTAR/////////////
    
    
 //////////////INICIO METODO MODIFICAR /////

public boolean modificar (Producto p){

    
        PreparedStatement ps =null;
        Connection con = getConexion();
        String sql ="update producto set codigo=?,nombre=?,precio=? where id=?";
    try{
            ps =con.prepareStatement(sql);
            ps.setString(1,p.getCodigo());
            ps.setString(2,p.getNombre());
            ps.setInt(3,p.getPrecio());
            ps.setInt(4, p.getId());
            ps.execute();
            return true;
    }catch(SQLException e){  
       System.err.print(e);
            return false;
    }        
}
//////////////FIN METODO MODIFICAR /////


///////INICIO METODOO ELIMINAR/////

public boolean eliminar (Producto p){    
        PreparedStatement ps =null;
        Connection con = getConexion();
        String sql ="delete from producto where id=?";
    try{
            ps =con.prepareStatement(sql);
            ps.setInt(1,p.getId());
            ps.execute();
            return true;
    }catch(SQLException e){  
       System.err.print(e);
            return false;
    }        
}
///////FIN METODOO ELIMINAR/////


//////// METODO BUSCAR/////////////
public boolean buscar (Producto p){    
        PreparedStatement ps = null;
        Connection con = getConexion();
        ResultSet rs = null;
        String sql = "select *from producto where id=?";
    try{
            ps =con.prepareStatement(sql);
            ps.setInt(1,p.getId());
            rs = ps.executeQuery();
            if(rs.next())
        {
            p.setId(Integer.parseInt(rs.getString("id")));
            p.setCodigo(rs.getString("codigo"));
            p.setNombre(rs.getString("nombre"));
            p.setPrecio(Integer.parseInt(rs.getString("precio")));
            return true;
        }
            return false;
    }
        catch(SQLException e){
        System.err.print (e);
        return false;
        }
}
}
///////FIN METODOO BUSCAR/////
