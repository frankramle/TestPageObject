
package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArchivoProperties {
	
	public Properties properties;
	
	public String binariochrome;
	public String path;
	public String url;
	public String userOpe;
	public String pass;
	public String userIncorrecto;
	public String passIncorrecto;
	public String tituloEsperado;
	public String mensajeLoginIncorrecto;
	public String mensajeUser;
	public String mensajePass;
	public String tituloEsperadoAgente;
	public String tituloDatosGenerales;
	public String cuit_label;
	public String tipoPersona_label;
	public String nombreFantasia_label;
	public String cuitValido;
	public String razonSocial_label;
	public String cuitInvalido;
	public String mensajeCuitInvalido;
	public String valTipoPersona;
	public String msjNombreFantasia;
	public String msjRazonSocial;
	public String nombreFantasia;
	public String razonSocial;
	public String pestaniaPefil;
	public String msjTipoAgencia;
	public String msjDomicilio;
	public String msjTelefono;
	public String msjCalle;
	public String msjCodigoPostal;
	public String msjLocalidad;
	public String msjProvincia;
	public String calle;
	public String numero;
	public String piso;
	public String dpto;
	public String codigoPostal;
	public String entreCalles;
	public String barrio;
	public String localidad;
	public String provincia;
	public String informacionAdicional;
	public String tipoTelefono;
	public String msjTipoTelefono;
	public String msjCodArea;
	public String msjNumTelefono;	
	public String codigoArea;
	public String numTelefono;
	public String interno;	
	public String msjTipoEmail;
	public String msjEmail;	
	public String tipoEmail;
	public String email;	
	public String tipoAgencia;
	public String tituloPestania;
	public String msjCondicionFiscal;
	public String msjTipoInscripcionGanancia;
	public String msjTipoIIBB;
	
	public void leerArchivoToBefore() {	
		try {
			properties = new Properties();
			properties.load(new FileInputStream("C:\\AutomationSGE\\TestFuncionales_SGE\\src\\properties\\"
					+ "before.properties"));
			//Obtengo los valores de la property
			binariochrome = properties.getProperty("binariochrome");
			path = properties.getProperty("path");    
			url = properties.getProperty("url");
		  } catch (IOException e) {
			   System.out.println("No se pudo leer: before.properties\n" + e);
		  }
	}
	
	public void leerArchivoToLogin() {	
		try {
			properties = new Properties();
			properties.load(new FileInputStream("C:\\AutomationSGE\\TestFuncionales_SGE\\src\\properties\\"
					+ "login.properties"));
			//Obtengo los valores de la property
			userOpe = properties.getProperty("userOpe");
			pass = properties.getProperty("pass");
			userIncorrecto = properties.getProperty("userIncorrecto");
			passIncorrecto = properties.getProperty("passIncorrecto");
			tituloEsperado = properties.getProperty("tituloEsperado");
			mensajeLoginIncorrecto = properties.getProperty("mensajeLoginIncorrecto");
			mensajeUser = properties.getProperty("mensajeUser");
			mensajePass = properties.getProperty("mensajePass");
		  } catch (IOException e) {
			   System.out.println("No se pudo leer: login.properties\n" + e);
		  }
	}

	public void leerArchivoToAgente() {		
		try {
			properties = new Properties();
		    properties.load(new FileInputStream("C:\\AutomationSGE\\TestFuncionales_SGE\\src\\properties\\"
					+ "agente.properties"));
			//Obtengo los valores de la property
			tituloEsperadoAgente = properties.getProperty("tituloEsperadoAgente");
			tituloEsperadoAgente = properties.getProperty("tituloEsperadoAgente");
			tituloDatosGenerales = properties.getProperty("tituloEsperadoAgente");
			cuit_label = properties.getProperty("cuit_label");
			tipoPersona_label = properties.getProperty("tipoPersona_label");
			nombreFantasia_label = properties.getProperty("nombreFantasia_label");
			cuitValido = properties.getProperty("cuitValido");
			razonSocial_label = properties.getProperty("razonSocial_label");			
			cuitInvalido = properties.getProperty("cuitInvalido");
			mensajeCuitInvalido = properties.getProperty("mensajeCuitInvalido");
			valTipoPersona = properties.getProperty("valTipoPersona");
			msjNombreFantasia = properties.getProperty("msjNombreFantasia");
			msjRazonSocial = properties.getProperty("msjRazonSocial");
			nombreFantasia = properties.getProperty("nombreFantasia");
			razonSocial = properties.getProperty("razonSocial");
			pestaniaPefil = properties.getProperty("pestaniaPefil");
			msjTipoAgencia = properties.getProperty("msjTipoAgencia");
			msjDomicilio = properties.getProperty("msjDomicilio");
			msjTelefono = properties.getProperty("msjTelefono");
			msjCalle = properties.getProperty("msjCalle");
			msjCodigoPostal = properties.getProperty("msjCodigoPostal");
			msjLocalidad = properties.getProperty("msjLocalidad");
			msjProvincia = properties.getProperty("msjProvincia");
			calle = properties.getProperty("calle");
			numero = properties.getProperty("numero");
			piso = properties.getProperty("piso");
			dpto = properties.getProperty("dpto");
			codigoPostal = properties.getProperty("codigoPostal");
			entreCalles = properties.getProperty("entreCalles");
			barrio = properties.getProperty("barrio");
			localidad = properties.getProperty("localidad");
			provincia = properties.getProperty("provincia");
			informacionAdicional = properties.getProperty("informacionAdicional");
			tipoTelefono = properties.getProperty("tipoTelefono");
			msjTipoTelefono = properties.getProperty("msjTipoTelefono");
			msjCodArea = properties.getProperty("msjCodArea");
			msjNumTelefono = properties.getProperty("msjNumTelefono");
			codigoArea = properties.getProperty("codigoArea");
			numTelefono = properties.getProperty("numTelefono");
			interno = properties.getProperty("interno");
			msjTipoEmail = properties.getProperty("msjTipoEmail");
			msjEmail = properties.getProperty("msjEmail");
			tipoEmail = properties.getProperty("tipoEmail");
			email = properties.getProperty("email");
			tipoAgencia = properties.getProperty("tipoAgencia");
			tituloPestania = properties.getProperty("tituloPestania");
			msjCondicionFiscal = properties.getProperty("msjCondicionFiscal");
			msjTipoInscripcionGanancia = properties.getProperty("msjTipoInscripcionGanancia");
			msjTipoIIBB = properties.getProperty("msjTipoIIBB");
			} catch (IOException e) {
			   System.out.println("No se pudo leer: agente.properties\n" + e);
		  }
	}
}

