package Entidad;

public class Comuna {

	// Atributos
		private String cod_comuna;
		private String descripcion;
		
		
	
	//Contructores
		public Comuna(String cod_comuna, String descripcion ) {
			super();
			this.cod_comuna = cod_comuna;
			this.descripcion = descripcion;
			//TODO Auto-generated constructor stub
		}



		public String getCod_comuna() {
			return cod_comuna;
		}



		public void setCod_comuna(String cod_comuna) {
			this.cod_comuna = cod_comuna;
		}



		public String getDescripcion() {
			return descripcion;
		}



		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		} 
		
	//getter and setter
		
		
		
		
}
