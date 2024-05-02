package Entidad;

public class Boleta_Detalle_Reporte {

	private String codigo_boleta;
	private String codigo_clz;
	private Integer cantidad_clz;
	private String descripcion_clz;
	private Integer p_unitario_clz;
	private Integer importe_clz;
	
	public Boleta_Detalle_Reporte(){
		
	}

	public Boleta_Detalle_Reporte(String codigo_boleta, String codigo_clz, Integer cantidad_clz, String descripcion_clz,
			Integer p_unitario_clz, Integer importe_clz) {
		super();
		this.codigo_boleta = codigo_boleta;
		this.codigo_clz = codigo_clz;
		this.cantidad_clz = cantidad_clz;
		this.descripcion_clz = descripcion_clz;
		this.p_unitario_clz = p_unitario_clz;
		this.importe_clz = importe_clz;
	}

	public String getCodigo_boleta() {
		return codigo_boleta;
	}

	public void setCodigo_boleta(String codigo_boleta) {
		this.codigo_boleta = codigo_boleta;
	}

	public String getCodigo_clz() {
		return codigo_clz;
	}

	public void setCodigo_clz(String codigo_clz) {
		this.codigo_clz = codigo_clz;
	}

	public Integer getCantidad_clz() {
		return cantidad_clz;
	}

	public void setCantidad_clz(Integer cantidad_clz) {
		this.cantidad_clz = cantidad_clz;
	}

	public String getDescripcion_clz() {
		return descripcion_clz;
	}

	public void setDescripcion_clz(String descripcion_clz) {
		this.descripcion_clz = descripcion_clz;
	}

	public Integer getP_unitario_clz() {
		return p_unitario_clz;
	}

	public void setP_unitario_clz(Integer p_unitario_clz) {
		this.p_unitario_clz = p_unitario_clz;
	}

	public Integer getImporte_clz() {
		return importe_clz;
	}

	public void setImporte_clz(Integer importe_clz) {
		this.importe_clz = importe_clz;
	}
	
	
}
