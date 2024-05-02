package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidad.Comuna;
import Interfaces.*;



public class ComunaGestionDao implements ComunaInterfaceDao{

	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Comuna> lista;
	private Comuna obj;
	
	// Sentencias
	
	final String GETALL_ORG = "{call pa_listar_comuna_original()}";
	final String SEARCH_ORG_ALL_EXT = "{call pa_buscar_comuna_original_all_ext(?)}";
	
	@Override
	public ArrayList<Comuna> listarOriginal() {
		
		lista = new ArrayList<Comuna>();
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Comuna(
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listarComuna" + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return lista;
	}

	
	
	@Override
	public Comuna buscarOrgAllExt(String valor) {
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_ALL_EXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				obj = new Comuna(
						rs.getString(1),
						rs.getString(2)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarComuna" + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return obj;
		
	}



	@Override
	public ArrayList<Comuna> listaOriginal() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
