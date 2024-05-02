package Interfaces;

import java.util.ArrayList;
import Entidad.Modelo;
import Entidad.ModeloReporte;

public interface ModeloInterfaceDao {

	public String generarCodigo();
	
	public ArrayList<Modelo> listarOriginal();
	
	public ArrayList<ModeloReporte> listarModificado();
	
	public int registrar (Modelo m);
	
	public int actualizar (Modelo m);
	
	public ArrayList<ModeloReporte> buscarModAllIxt (String valor); 
	
	public Modelo buscarOrgNombreExt (String nombre);
	
}
