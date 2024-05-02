package Interfaces;

import java.util.ArrayList;

import Entidad.Marca;

public interface MarcaInterfaceDao {

	public String generarCodigo();

	public ArrayList<Marca> listarOriginal();
	
	public int registrar(Marca c);
	
	public int actualizar(Marca c);
	
	public ArrayList<Marca> buscarOrgAllIxt(String valor);
}
