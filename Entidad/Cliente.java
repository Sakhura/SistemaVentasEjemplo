package Entidad;

public class Cliente {
	
	private String cod_cliente;
	private String nombre;
	private String apellidos;
	private String rut;
	private String direccion;
	private String celular;
	private String email;
	private String cod_comuna;

	public Cliente(){
	}

	public Cliente(String cod_cliente, String nombre, String apellidos, String rut, String direccion, String celular,
			String email, String cod_comuna) {
		super();
		this.cod_cliente = cod_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rut = rut;
		this.direccion = direccion;
		this.celular = celular;
		this.email = email;
		this.cod_comuna = cod_comuna;
		
		
	}

	public String getCod_cliente() {
		return cod_cliente;
	}

	public void setCod_cliente(String cod_cliente) {
		this.cod_cliente = cod_cliente;
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
}
