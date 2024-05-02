package Interfaces;

import java.util.ArrayList;
import Entidad.Cliente;

public interface ClienteInterfaceDao {

public ArrayList<Cliente> listarOriginal();
	
	public String generarCodigo();
	
	public int registrar(Cliente c);
	
	public int actualizar(Cliente c);
	
	public Cliente buscarOrgCodigoIxt(String codigo); 
	
	public ArrayList<Cliente> buscarOrgNombreIxt(String valor);
	
	public ArrayList<Cliente> buscarOrgRutIxt(String valor);
	
	public Cliente buscarOrgRutExt(String valor);
	
	public ArrayList<Cliente> buscarModComunaIxt(String valor); 
	
}
