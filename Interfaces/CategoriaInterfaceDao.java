package Interfaces;

import java.util.ArrayList;

import Entidad.Categoria;

public interface CategoriaInterfaceDao {

	public String generarCodigo();

	public ArrayList<Categoria> listarOriginal();
	
	public int registrar(Categoria c);
	
	public int actualizar(Categoria c);
	
	public ArrayList<Categoria> buscarOrgAllIxt(String valor);
}
