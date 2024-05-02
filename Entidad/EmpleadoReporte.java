package Entidad;

public class EmpleadoReporte {

	private String cod_empleado;
	private String nombre;
	private String apellidos;
	private String rut;
	private String direccion;
	private String celular;
	private String email;
	private String cod_comuna;
	private String cod_cargo;
	private String usuario;
	private String contrasena;
	private Integer cod_region;
	
	
	public EmpleadoReporte (){	
	}

	// Constructor para recibir empleados de la Base de Datos
	public EmpleadoReporte(String cod_empleado, String nombre, String apellidos, String rut, String direccion,
			String celular, String email, String cod_comuna, String cargo, String usuario, String contrasena,
			Integer cod_region) {
		super();
		this.cod_empleado = cod_empleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rut = rut;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.cod_comuna = cod_comuna;
		this.cod_cargo = cargo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.cod_region = cod_region;
	}

	public String getCod_empleado() {
		return cod_empleado;
	}

	public void setCod_empleado(String cod_empleado) {
		this.cod_empleado = cod_empleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCod_comuna() {
		return cod_comuna;
	}

	public void setCod_comuna(String cod_comuna) {
		this.cod_comuna = cod_comuna;
	}

	public String getCod_cargo() {
		return cod_cargo;
	}

	public void setCod_cargo(String cod_cargo) {
		this.cod_cargo = cod_cargo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Integer getCod_region() {
		return cod_region;
	}

	public void setCod_region(Integer cod_region) {
		this.cod_region = cod_region;
	}
	
	
	
	
	
}
