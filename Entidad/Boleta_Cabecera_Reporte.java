package Entidad;

import java.sql.Timestamp;

public class Boleta_Cabecera_Reporte {

	private String codigo_boleta;
//	private Date fecha_emision;
//	private Time hora_emision;
	private Timestamp fecha_hora_emision;
	private String codigo_empleado;
	private String nombre_vendedor;
	private String codigo_clienten;
	private String nombre_cliente;
	private String rut_cliente;
	private String direccion_cliente;
	private String comuna_cliente;
	private String celular_cliente;
	private int total_venta;
	
	public Boleta_Cabecera_Reporte(){
		
	}

	public Boleta_Cabecera_Reporte(String codigo_boleta, Timestamp fecha_hora_emision, String codigo_empleado,
			String nombre_vendedor, String codigo_clienten, String nombre_cliente, String rut_cliente,
			String direccion_cliente, String comuna_cliente, String celular_cliente, int total_venta) {
		super();
		this.codigo_boleta = codigo_boleta;
		this.fecha_hora_emision = fecha_hora_emision;
		this.codigo_empleado = codigo_empleado;
		this.nombre_vendedor = nombre_vendedor;
		this.codigo_clienten = codigo_clienten;
		this.nombre_cliente = nombre_cliente;
		this.rut_cliente = rut_cliente;
		this.direccion_cliente = direccion_cliente;
		this.comuna_cliente = comuna_cliente;
		this.celular_cliente = celular_cliente;
		this.total_venta = total_venta;
	}

	public String getCodigo_boleta() {
		return codigo_boleta;
	}

	public void setCodigo_boleta(String codigo_boleta) {
		this.codigo_boleta = codigo_boleta;
	}

	public Timestamp getFecha_hora_emision() {
		return fecha_hora_emision;
	}

	public void setFecha_hora_emision(Timestamp fecha_hora_emision) {
		this.fecha_hora_emision = fecha_hora_emision;
	}

	public String getCodigo_empleado() {
		return codigo_empleado;
	}

	public void setCodigo_empleado(String codigo_empleado) {
		this.codigo_empleado = codigo_empleado;
	}

	public String getNombre_vendedor() {
		return nombre_vendedor;
	}

	public void setNombre_vendedor(String nombre_vendedor) {
		this.nombre_vendedor = nombre_vendedor;
	}

	public String getCodigo_clienten() {
		return codigo_clienten;
	}

	public void setCodigo_clienten(String codigo_clienten) {
		this.codigo_clienten = codigo_clienten;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public String getRut_cliente() {
		return rut_cliente;
	}

	public void setRut_cliente(String rut_cliente) {
		this.rut_cliente = rut_cliente;
	}

	public String getDireccion_cliente() {
		return direccion_cliente;
	}

	public void setDireccion_cliente(String direccion_cliente) {
		this.direccion_cliente = direccion_cliente;
	}

	public String getComuna_cliente() {
		return comuna_cliente;
	}

	public void setComuna_cliente(String comuna_cliente) {
		this.comuna_cliente = comuna_cliente;
	}

	public String getCelular_cliente() {
		return celular_cliente;
	}

	public void setCelular_cliente(String celular_cliente) {
		this.celular_cliente = celular_cliente;
	}

	public int getTotal_venta() {
		return total_venta;
	}

	public void setTotal_venta(int total_venta) {
		this.total_venta = total_venta;
	}

	
}
