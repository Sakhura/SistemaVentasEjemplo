package Controlador;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Conexion.Conexion;
import Entidad.Cliente;

public class ClienteGestionDao {

	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Cliente> lista;
	private Cliente obj;
	
	final String GETALL_ORG = "{call pa_listar_cliente_original()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_cliente()}";
	final String INSERT = "{call pa_insertar_cliente(?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_cliente(?,?,?,?,?,?,?,?)}";
	
	final String SEARCH_ORG_CODE_IXT = "{call pa_buscar_cliente_original_codigo_ixt(?)}";
	final String SEARCH_ORG_NAME_IXT = "{call pa_buscar_cliente_original_nombreapellido_ixt(?)}";
	final String SEARCH_ORG_RUT_IXT = "{call pa_buscar_cliente_original_rut_ixt(?)}";
	final String SEARCH_ORG_RUT_EXT = "{call pa_buscar_cliente_original_rut_ext(?)}";
	final String SEARCH_MOD_COMUNA_IXT = "{call pa_buscar_cliente_modificado_comuna_ixt(?)}";
	
	public ArrayList<Cliente> listarOriginal() {
		
		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia listar() - CLIENTE" + e.getMessage());
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

	
	
	public String generarCodigo() {

		String codCliente = "200001";
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("00000");
				codCliente = "CL" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia generarCodigo() - CLIENTE" + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codCliente;
		
	}

	
	

	public int registrar(Cliente c) {
		
		int respuesta = -1;
		try {
			cn = Conexion.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, c.getCod_cliente());
			cs.setString(i++, c.getNombre());
			cs.setString(i++, c.getApellidos());
			cs.setString(i++, c.getRut());
			cs.setString(i++, c.getDireccion());
			cs.setString(i++, c.getCelular());
			cs.setString(i++, c.getEmail());
			cs.setString(i++, c.getCod_comuna());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - CLIENTE" + e1.getMessage());
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

	
	

	public int actualizar(Cliente c) {

		int respuesta = -1;
		try {
			cn = Conexion.getConnection();
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, c.getCod_cliente());
			cs.setString(i++, c.getNombre());
			cs.setString(i++, c.getApellidos());
			cs.setString(i++, c.getRut());
			cs.setString(i++, c.getDireccion());
			cs.setString(i++, c.getCelular());
			cs.setString(i++, c.getEmail());
			cs.setString(i++, c.getCod_comuna());

			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - CLIENTE" + e1.getMessage());
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

	
	

	public Cliente buscarOrgCodigoIxt(String codigo) { 
		
		Cliente obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_CODE_IXT);
			cs.setString(1, codigo);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigo() - CLIENTE" + e.getMessage());
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

	
	

	public ArrayList<Cliente> buscarOrgNombreIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_NAME_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorNombre() - CLIENTE" + e.getMessage());
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

	
	

	public ArrayList<Cliente> buscarOrgRutIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_RUT_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDni() - CLIENTE" + e.getMessage());
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
	
	
	

	public Cliente buscarOrgRutExt(String valor) {
		
		Cliente obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_RUT_EXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDniExacto() - CLIENTE --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorDniExacto() - CLIENTE --> " + e.getMessage());
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
	
	


	public ArrayList<Cliente> buscarModComunaIxt(String valor) {

		lista = new ArrayList<Cliente>();
		Cliente obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_COMUNA_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Cliente(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDistrito() - CLIENTE" + e.getMessage());
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
}
