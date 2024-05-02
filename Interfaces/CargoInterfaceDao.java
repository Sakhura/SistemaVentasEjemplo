package Interfaces;

import java.util.ArrayList;

import Entidad.Cargo;

public interface CargoInterfaceDao {

	public ArrayList<Cargo> listarOriginal();
	
	public Cargo buscarOrgAllExt(String valor);
}
