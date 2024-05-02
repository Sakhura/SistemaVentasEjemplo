package Interfaces;

import java.util.ArrayList;

import Entidad.Boleta_Cabecera;
import Entidad.Boleta_Cabecera_Reporte;
import Entidad.Boleta_Detalle;
import Entidad.Boleta_Detalle_Reporte;
import Entidad.Cliente;

public interface VentaInterfaceDao {
	public String generarCodigo();
	
	public int realizarVenta(Cliente c, Boleta_Cabecera cabBoleta, ArrayList<Boleta_Detalle> detBoleta);
	
	public Boleta_Cabecera_Reporte buscarCabezaBoletaModCodigoExt(String valor);
	
	public ArrayList<Boleta_Detalle_Reporte> buscarDetalleBoletaModCodigoExt(String valor);
	
	public int generarBoleta(Boleta_Cabecera_Reporte cabeza ,ArrayList<Boleta_Detalle_Reporte> calzados, int tipoComprobante);
	
}
