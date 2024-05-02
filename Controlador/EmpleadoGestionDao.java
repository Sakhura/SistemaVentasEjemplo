package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.jar.JarException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Conexion.Conexion;
import Entidad.Empleado;
import Entidad.EmpleadoReporte;
import Interfaces.EmpleadoInterfaceDao;

public class EmpleadoGestionDao implements EmpleadoInterfaceDao {

	private Connection cn;
	private CallableStatement cs;
	private ResultSet rs;
	private ArrayList<Empleado> listaOriginal;
	private ArrayList<EmpleadoReporte> lista;
	private Empleado obj;
	private EmpleadoReporte obj1;
	
	final String VALIDATE = "{call pa_validar_empleado(?,?)}";
	final String GETALL_ORG = "{call pa_listar_empleado_original()}";
	final String GETALL_MOD = "{call pa_listar_empleado_modificado()}";
	final String LASTCODE = "{call pa_buscar_ultimo_codigo_empleado()}";
	final String INSERT = "{call pa_insertar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	final String UPDATE = "{call pa_actualizar_empleado(?,?,?,?,?,?,?,?,?,?,?,?)}";
	
	final String SEARCH_ORG_CODE_IXT = "{call pa_buscar_empleado_original_codigo_ixt(?)}";
	final String SEARCH_MOD_CODE_EXT = "{call pa_buscar_empleado_modificado_codigo_ext(?)}";
	final String SEARCH_MOD_CODE_IXT = "{call pa_buscar_empleado_modificado_codigo_ixt(?)}";

	final String SEARCH_MOD_NAME_IXT = "{call pa_buscar_empleado_modificado_nombreapellido_ixt(?)}";
	final String SEARCH_MOD_DNI_IXT = "{call pa_buscar_empleado_modificado_rut_ixt(?)}";
	final String SEARCH_MOD_DISTRITO_IXT = "{call pa_buscar_empleado_modificado_comuna_ixt(?)}";

	@Override
	public Empleado validarAcceso(String user, String pass) {
		
		Empleado obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(VALIDATE);
			cs.setString(1, user);
			cs.setString(2, pass);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
			}
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia validarAcceso() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia validarAcceso() - EMPLEADO --> " + e2.getMessage());
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
	public ArrayList<Empleado> listarOriginal() {
		
		listaOriginal = new ArrayList<Empleado>();
		Empleado obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(GETALL_ORG);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia listarOriginal() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia listarOriginal() - EMPLEADO --> " + e2.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaOriginal;
		
	}
	
	
	
	@Override
	public ArrayList<EmpleadoReporte> listarModificado() {

		lista = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(GETALL_MOD);
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj1 = new EmpleadoReporte(
				);
				lista.add(obj);
			}
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia listar() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia listar() - EMPLEADO --> " + e2.getMessage());
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
	public int registrar(Empleado e) {
		
		int respuesta = -1;
		try {
			cn = Conexion.getConnection();
			cs = cn.prepareCall(INSERT);
			
			int i = 1;
			cs.setString(i++, e.getCod_empleado());
			cs.setString(i++, e.getNombre());
			cs.setString(i++, e.getApellidos());
			cs.setString(i++, e.getRut());
			cs.setString(i++, e.getDireccion());
			cs.setString(i++, e.getCelular());
			cs.setString(i++, e.getEmail());
			cs.setString(i++, e.getCod_comuna());
			cs.setString(i++, e.getCod_cargo());
			cs.setString(i++, e.getUsuario());
			cs.setString(i++, e.getContrasena());
			cs.setInt(i++, e.getCod_region());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia registrar() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia registrar() - EMPLEADO --> " + e2.getMessage());
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
	public String generarCodigo() {
		
		String codEmpleado = "EMP0001";
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(LASTCODE);
			rs = cs.executeQuery();
			
			if(rs.next()){
				DecimalFormat df = new DecimalFormat("000");
				codEmpleado = "EM" + df.format(Integer.parseInt(rs.getString(1)) + 1); // example -> 003 + 1 = 004
			}
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia generarCodigo() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia generarCodigo() - EMPLEADO --> " + e2.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return codEmpleado;
		
	}



	@Override
	public int actualizar(Empleado e) {

		int respuesta = -1;
		try {
			cn = Conexion.getConnection();
			cs = cn.prepareCall(UPDATE);
			
			int i = 1;
			cs.setString(i++, e.getCod_empleado());
			cs.setString(i++, e.getNombre());
			cs.setString(i++, e.getApellidos());
			cs.setString(i++, e.getRut());
			cs.setString(i++, e.getDireccion());
			cs.setString(i++, e.getCelular());
			cs.setString(i++, e.getEmail());
			cs.setString(i++, e.getCod_comuna());
			cs.setString(i++, e.getCod_cargo());
			cs.setString(i++, e.getUsuario());
			cs.setString(i++, e.getContrasena());
			cs.setInt(i++, e.getCod_region());
			
			respuesta = cs.executeUpdate();
			
		}catch (SQLException e1) {
			System.out.println("Error en la sentencia actualizar() - EMPLEADO --> " + e1.getMessage());
		}catch (Exception e2){
			System.out.println("Error en la sentencia actualizar() - EMPLEADO --> " + e2.getMessage());
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


	
//	@Override
//	public int eliminarEmpleado(String codigo) {
//	
//		int respuesta = -1;
//		try {
//			cn = Conexion.getConnection();
//			cs = cn.prepareCall(DELETE);
//			cs.setString(1, codigo);
//			
//			respuesta = cs.executeUpdate();
//			
//		}catch (SQLException e1) {
//			System.out.println("Error en la sentencia actualizarEmpleado" + e1.getMessage());
//		}finally {
//			try {
//				if( rs != null ) rs.close();
//				if( cs != null ) cs.close();
//				if( cn != null ) cn.close();
//			} catch (SQLException e2) {
//				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
//			}
//		}
//		return respuesta;
//	
//	}
	
	
	@Override
	public ArrayList<Empleado> buscarOrgCodigoIxt(String valor) {
		
		listaOriginal = new ArrayList<Empleado>();
		Empleado obj;
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_ORG_CODE_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj = new Empleado(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getInt(i++)
				);
				listaOriginal.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarOriginalPorCodigo() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarOriginalPorCodigo() - EMPLEADO --> " + e.getMessage());
		}finally {
			try {
				if( rs != null ) rs.close();
				if( cs != null ) cs.close();
				if( cn != null ) cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar la base de datos" + e2.getMessage());
			}
		}
		return listaOriginal;
	}
	
	
	
	@Override
	public EmpleadoReporte buscarModCodigoExt(String valor) {
		
		EmpleadoReporte obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_CODE_EXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			if(rs.next()){
				
				int i=1;
				obj1 = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigoExacto" + e.getMessage());
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
	public ArrayList<EmpleadoReporte> buscarModCodigoIxt(String valor) {
		
		lista = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte obj = null;
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_CODE_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj1 = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorCodigo() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorCodigo() - EMPLEADO --> " + e.getMessage());
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
	public ArrayList<EmpleadoReporte> buscarModNombreIxt(String valor) {
		
		lista = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_NAME_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj1 = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorNombre() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorNombre() - EMPLEADO --> " + e.getMessage());
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
	public ArrayList<EmpleadoReporte> buscarModDniIxt(String valor) {
		
		lista = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_DNI_IXT);
			cs.setString(1, valor);
			
			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj1 = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
			
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDni() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorDni() - EMPLEADO --> " + e.getMessage());
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



	/**
	 * La busqueda por distrito devuelve 2 tablas juntas, pero este metodo devuelve solo 
	 * un empleado, extrayendo solo los primeros valores.
	 * **/
	@Override
	public ArrayList<EmpleadoReporte> buscarModDistritoIxt(String valor) {

		lista = new ArrayList<EmpleadoReporte>();
		EmpleadoReporte obj = null;
		
		try{
			cn = Conexion.getConnection();
			cs = cn.prepareCall(SEARCH_MOD_DISTRITO_IXT);
			cs.setString(1, valor);

			rs = cs.executeQuery();
			
			while(rs.next()){
				int i=1;
				obj1 = new EmpleadoReporte(
						rs.getString(i++), // posicion 1
						rs.getString(i++), // posicion 2
						rs.getString(i++), // ...
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++),
						rs.getString(i++)
				);
				lista.add(obj);
			}
		}catch (SQLException e) {
			System.out.println("Error en la sentencia buscarPorDistrito() - EMPLEADO --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia buscarPorDistrito() - EMPLEADO --> " + e.getMessage());
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
	public int exportarTXT(ArrayList<EmpleadoReporte> empleados) {
		
		
		int respuesta = -1;
		
		try {
			
			File archivo;

			FileOutputStream archivoSalida = null;
			
			
			JFileChooser ventSeleccion = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "txt");
			ventSeleccion.setFileFilter(filtro);
			ventSeleccion.setDialogTitle("Guardar Archivo");
	        ventSeleccion.setAcceptAllFileFilterUsed(true); // true: muestra el tambien filtro de todos los tipos de archivos, false : muestra solo el filtro seleccionado
			
			
			/** showDialog(componentePadre, nombreBotonAprobado) -- devuelve un numero que representa la eleccion del usuario.*/
			if(ventSeleccion.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION){ // 
				
				// toString(), transforma el archivo seleccionado en un cadena de la ruta del archivo, a�adiendole el formarto.
				String ruta = ventSeleccion.getSelectedFile().toString().concat(".txt"); 
				archivo = new File(ruta); //archivo = ventSeleccion.getSelectedFile();
				
				String linea = "";
				String data = linea;
				
				for(EmpleadoReporte emp: empleados ){
				
					linea = emp.getCod_empleado() + "|" +
							emp.getNombre() + "|" +
							emp.getApellidos() + "|" +
							emp.getRut() + "|" +
							emp.getDireccion() + "|" +
							emp.getCelular() + "|" +
							emp.getEmail() + "|" +
							emp.getCod_comuna() + "|" +
							emp.getCod_cargo() + "|" +
							emp.getUsuario() + "|" +
							emp.getContrasena() + "|" +
							emp.getCod_region() + "\n";
					
					data += linea;
				
				}
				
				byte[] dataByte = data.getBytes();
				
				
				archivoSalida = new FileOutputStream(archivo); //<<<
				archivoSalida.write(dataByte); // <<<<
				archivoSalida.close();
				respuesta = 1;
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Error en la sentencia exportarTXT() --> " + e.getMessage());
		}
		
		return respuesta;
		
		
	}



	@Override
	public int exportarXLSX(ArrayList<EmpleadoReporte> empleados) {
		
		int respuesta = -1;
		
		try {
			
			JFileChooser seleccionador = new JFileChooser();
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Excel", "xlsx");
			seleccionador.setFileFilter(filtro);
			seleccionador.setDialogTitle("Guardar Archivo");
			seleccionador.setAcceptAllFileFilterUsed(true); // a�ade la opcion de mostrar todos los archivos
			
			if( seleccionador.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION ) {
				String ruta = seleccionador.getSelectedFile().toString().concat(".xlsx");
				File archivoSave = new File(ruta);
				
				Workbook book = new XSSFWorkbook();  // XSSFWoorkbook >> crea archivos ".xlsx", Workbook es la coleccion de hojas de calculo.
				Sheet hoja = book.createSheet("Hoja_1");  // Crea una hoja en excel
				hoja.setDisplayGridlines(true);  // Oculta las lineas de la hoja de Excel (son gustos)
				
				// Encabezado
				String [] encabezado = {"CODIGO","NOMBRE","APELLIDOS","RUT","DIRECCION","TELEFONO","EMAIL","COMUNA","CARGO","USUARIO","CONTRASEÑA","REGION"};
				
				Row filaInicial = hoja.createRow(0);
				for( int i = 0; i < encabezado.length; i++ ){
					Cell celda = filaInicial.createCell(i);
					celda.setCellValue(encabezado[i].toString());
				}
				
				// Cuerpo
				for( int j = 0; j < empleados.size(); j++ ){
					Row fila = hoja.createRow(j+1);  // Se crea apartir de la segunda fila
					
					for (int i = 0; i < 12; i++) { // i < numero de columnas 
						Cell celda = fila.createCell(i);
						celda.setCellValue(empleados.get(j).atributoObjeto(i));
					}
				}
				
				FileOutputStream archivoSalida = new FileOutputStream(archivoSave);
				book.write(archivoSalida);
				book.close();
				archivoSalida.close();
				 
				respuesta = 1;
//				Desktop.getDesktop().open(archivo);
			}
			
		}catch (FileNotFoundException e) {
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}catch (IOException e) {
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}catch (Exception e){
			System.out.println("Error en la sentencia exportarXLSX() --> " + e.getMessage());
		}
		
		return respuesta;
		
	}



	@Override
	public int exportarPDF(ArrayList<EmpleadoReporte> empleados) {
		
		int respuesta = -1;
		/** existe otra manera, traer el .jrxml , pasarlo a un FileInputStream y resien compilarlo, aca usamos defrente la compilacion ".jasper"  **/
		
		try {
			
			JasperReport report = (JasperReport)JRLoader.loadObject( getClass().getResource("/report_template/reporte_empleado.jasper") ) ;
			
			Map<String, Object> parametros = new HashMap<String, Object>();
			JRBeanCollectionDataSource lista = new JRBeanCollectionDataSource(empleados);
			parametros.put("DATAEmpleado", lista); // El BeanCollection obtiene los datos de una Collection.
			
			String imagen = "logo_reporte.png"; // a�adimos la imagen por su nombre completo
			parametros.put("imagen_logo","\\img\\" + imagen); // por alguna razon marca error cuando se coloca de la siguiente forma: "/img/cc.jpg"
			parametros.put("nombre_empresa","PEPITO");
			parametros.put("direccion_empresa","MUY MUY LEJANO S/N ");
			parametros.put("COMUNA_empresa","CHILOE");
			parametros.put("nombre_empleado","RAFAELA");
			parametros.put("rut_empresa","12345678901");
			
			JasperPrint jprint = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource()); // llenamos los datos, como todo lo llenamos por parametros, le mandamos como data source vacio
			JasperViewer vista = new JasperViewer(jprint, false); // false -> para que al cerrar no se cierre el Viewer no se cierre la aplicacion.
			vista.setVisible(true);
			vista.setTitle("Reporte Empleados");
				 
			respuesta = 1;

				
		}catch (JarException e) {
			System.out.println(e);
		}catch (Exception e){
			System.out.println(e);
		}
		
		return respuesta;
		
	}

}
