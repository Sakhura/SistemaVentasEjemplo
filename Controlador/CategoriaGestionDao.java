package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidad.Categoria;
import Interfaces.CategoriaInterfaceDao;

public class CategoriaGestionDao implements CategoriaInterfaceDao {
	
	private Connection cn; 
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Categoria> lista;
	private Categoria obj;

// Sentencias sql
	
	final String GETALL_ORG = "{call pa_listar_categoria_original()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_categoria()}";
	final String INSERT = "{call pa_insertar_categoria(?,?)}";
	final String UPDATE = "{call pa_actualizar_categoria(?,?)}";
	final String SEARCH_ORG_ALL_IXT = "{call pa_buscar_categoria_original_all_ixt(?)}";
	
	@Override
	public String generarCodigo() {
		
		String codCategoria = "CAT01";
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00");
				codCategoria = "CAT" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - CATEGORIA --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia generarCodigo() - CATEGORIA --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codCategoria;
	
	}

	
	
	@Override
	public ArrayList<Categoria> listarOriginal() {
		
		lista = new ArrayList<Categoria>();
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Categoria(
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia Listar() - CATEGORIA" + e.getMessage());
		}catch (Exception e1){
			System.out.println("Error en la sentencia Listar() - CATEGORIA --> " + e1.getMessage());
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
	public int registrar(Categoria c) {
		
		int respuesta = -1;
		try {
			cn = Conexion.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, c.getCod_categoria());
			cs.setString(i++, c.getDescripcion());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - CATEGORIA --> " + e1.getMessage());
		}catch (Exception e1){
			System.out.println("Error en la sentencia registrar() - CATEGORIA --> " + e1.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return respuesta;
}



	@Override
	public int actualizar(Categoria c) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ArrayList<Categoria> buscarOrgAllIxt(String valor) {
		// TODO Auto-generated method stub
		return null;
	}
}
