package Interfaces;

import java.util.ArrayList;

import Entidad.Comuna;

public interface ComunaInterfaceDao {
	
	public ArrayList<Comuna> listaOriginal(); 
	
	public Comuna buscarOrgAllExt(String valor);

	ArrayList<Comuna> listarOriginal();
}
