package parseoJson;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

import util.Utilidades;


public class ConsultaMonumentos {

	
	private static final String _PROTOCOLO  = "https";
	private static final String _HOST  = "www.zaragoza.es";
	private static final String _PATH  = "/sede/servicio/monumento.json";
	// QUERY  = "srsname=wgs84&rows=2&fl=id,title";
	private static final String _QUERY1  = "srsname=wgs84&rows=";
	private static final String _QUERY2  = "&fl=id,title";

	
	public static void main(String[] args) throws Exception {
		
		int numFilas = Utilidades.pedirEntero("Cuantos monumentos quieres consultar?");
		URL url = new URL(_PROTOCOLO, _HOST, _PATH + "?" + _QUERY1 + numFilas + _QUERY2);

		ParseaJson parseador = new ParseaJson();
		parseador.parseaMonumentos(new InputStreamReader(url.openStream()));
		
	}

}