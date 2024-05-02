README

Chicos recuerden cambiar al JDK que tienen uds en sus pc 
Sistema de Ventas
IDE Eclipse - Java 
MySQL
Visual studio code

Posibles errores (librerias faltantes dentro del proyecto agregare las librerias
que por lo menos yo debi descargar)

Se realizo:
*ojo esta todo en el login, tambien estan los archivos separados(fue solo para realizar pruebas)
*La estructura de paneles del sistema.
*Base de datos, se creo en primera instancia una base de datos sencilla;
luego se mejoro acorde a la necesidad del proyecto
  Nota: La base de dato deben cargarla desde cero en el SGBD que utilicen.
  Para poblar la base sugerencia solicitar a chat gpt los insert, si es que no quieren hacer ingreso manual
 
 Configuración Eclipse:
- Windows/preference/windows Builder/Swing/Code Genereation, ahi “Field” tebe tener un check, 
	ahora entramos a Event Handlers, ahi debe estar seleccionado Implement Listener inter.... 
	y create stub event, debe tener un check y de la lista seleccionamos la penultima opcion 
	“$(event_name)$(Component_name)” hora entramos a LookAndFeel que esta dentro de Layouts 
	los cuatro opciones deben tener check aplicamos y cerramos.
- Ortografia ( Desabilitar ) : Window / Preference / General / Editor / Text Editors / Spelling, 
	desactivamos la casilla general “Enable spell checking” y le das “OK”.
- Para cambiar el tamaño del código o fuente Window / Preferences / General / Appearance / 
	Color and Fonts / Basic / Text Font.
- Activar Java Asistente: - Windows / Preferences / Java / Editor / Content Assist / Advanced, 
	en la segunda caja de herramientas debe estar marcado Java Proposals.
	En la primera caja tambien debe estar marcado Java Proposals, en la primera caja todos 
	los que esten marcados, apareceran al principio(default) cuando apretemos Ctrl + Space, y 
	cuando lo volvamos a apretar se mostrará los seleccionamos en la segunda caja pero de manera individual y en 
	el orden elegido de arriba hacia abajo.
--------------------------------------------------------------------------
System.exit(0); // libera recursos y cierra la aplicacion
JFrame.dispose(); // libera recursos y cierra la ventana actual (JFrame)

btnCancelar.setFocusable(false); // el boton se vuelve infocusiable
btnCancelar.setRolloverEnabled(false); // desabilita el efecto rollver del boton


- bloque estatico --> se utiliza para inicializar variables estaticas.

- String hereda de Object, para convertir String to Object:

	String s="hello";  
	Object obj=s;  
	System.out.println(obj);  
	output --> hello

- estado Empleado 
	0 -> inactivo
	1 -> activo

- solucion del panel strip, con opaque.

- zorder par componentes (no contenedores):
        contenedor.setComponentZOrder(button1, 1);
        panel.setComponentZOrder(button2, 0);
        panel.setComponentZOrder(button3, 2);

- Libreria PoiApache : sirve para exportar excel (SOLUCIONADO)
	- poi.apache.org / Downloads / the Latest stable release is Apache POI 5.2.2
	- Binary Distribution / Click en el ZIP / CLick en el primer link que recomienda / Se descarga
	- descomprimes el archivo y solo utilizaremos "poi-5.2.2" que es el basico y principal.
	- En eclipse, entramos a "Build Path" para añadirlo al projecto como libreria.
	------------------------------------------------------------------
	
 
 
 Tiempo total de desarrollo: 6 horas 26 minutos ( desconte el momento que 
 me fui a tomar café y comer algo), aprox 3 horas para darme cuenta del 
 error de las librerias :(
 la última hora aprox fue realizar el readme
