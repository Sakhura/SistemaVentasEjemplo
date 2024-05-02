package Entidad;

public class Modelo {

	private String cod_modelo;
	private String nombre_modelo;
	private int precio_compra;
	private int precio_venta;
	private String cod_marca;
	private String cod_categoria;
	
	public Modelo() {
		
	}
	
	public Modelo(String cod_modelo, String nombre_modelo, int precio_compra, int precio_venta, String cod_marca,
			String cod_categoria) {
		super();
		this.cod_modelo = cod_modelo;
		this.nombre_modelo = nombre_modelo;
		this.precio_compra = precio_compra;
		this.precio_venta = precio_venta;
		this.cod_marca = cod_marca;
		this.cod_categoria = cod_categoria;
	}

	public String getCod_modelo() {
		return cod_modelo;
	}

	public void setCod_modelo(String cod_modelo) {
		this.cod_modelo = cod_modelo;
	}

	public String getNombre_modelo() {
		return nombre_modelo;
	}

	public void setNombre_modelo(String nombre_modelo) {
		this.nombre_modelo = nombre_modelo;
	}

	public int getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(int precio_compra) {
		this.precio_compra = precio_compra;
	}

	public int getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(int precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getCod_marca() {
		return cod_marca;
	}

	public void setCod_marca(String cod_marca) {
		this.cod_marca = cod_marca;
	}

	public String getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(String cod_categoria) {
		this.cod_categoria = cod_categoria;
	}
	
	
	
}
