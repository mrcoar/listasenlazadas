package cl.maraneda.listaenlazadaclient;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.log4j.Logger;

import cl.maraneda.listaenlazadaservice.LeNodo;
import cl.maraneda.listaenlazadaservice.ListaEnlazada;
import cl.maraneda.listaenlazadaservice.ListaEnlazadaService;
import cl.maraneda.listaenlazadaservice.ListaEnlazadaServiceService;
import cl.maraneda.listaenlazadaservice.ServiceResponse;
import net.java.dev.jaxb.array.AnyTypeArray;

/** Clase utilizada para probar la invocacion del web service
 *  de manejo de listas enlazadas. Para esta aplicacion se
 *  configuro el archivo pom.xml para trabajar con Apache CXF
 *  para generar, mediante la opcion generate-sources de Maven
 *  las clases e interfaces encargadas de la interaccion con el
 *  web service, en los paquetes cl.maraneda.listaenlazadaservice
 *  y net.java.deb.jaxb.array.
 *  Al ser generadas automaticamente las clases e interfaces,
 *  se recomienda no editarlas.
 * @author Marco
 * @since 2019-01-09
 */
public class ListaEnlazadaClient {
	private static final Logger log=Logger.getLogger(ListaEnlazadaClient.class);
	public static void mostrarLista(ListaEnlazada lista) {
		int i;
		LeNodo nodo;
		for(i=1, nodo=lista.getFirst(); nodo!=null; nodo=nodo.getProx(), i++) {
			log.info("Nodo " + i + ": " + nodo.getData().toString());
		}
		System.out.print("\n");
	}
	public static void main(String[] args) {
		try {
			log.info("Inicio ejecucion cliente");
			URL url=new URL("http://localhost:8080/listaenlazadaservice/listaEnlazadaService?wsdl");
			ListaEnlazadaServiceService service=new ListaEnlazadaServiceService(url);
			ListaEnlazadaService port=service.getListaEnlazadaServicePort();
			Client cli=ClientProxy.getClient(port);
			HTTPConduit http = (HTTPConduit) cli.getConduit(); 
			HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();			 
			httpClientPolicy.setConnectionTimeout(36000);
			httpClientPolicy.setAllowChunking(false);
			httpClientPolicy.setReceiveTimeout(36000);
			 
			http.setClient(httpClientPolicy);
			ListaEnlazada lista;
			AnyTypeArray array=new AnyTypeArray();
			array.getItem().add("PAN");
			array.getItem().add("CON");
			array.getItem().add("PALTA");
			ServiceResponse response=port.generarListaEnlazada(array);
			if(response.getCode()!=0) {
				log.error("Error: " + response.getDesc());
			}else {
				lista=response.getResultado();
				mostrarLista(lista);
				response=port.quitarElementoUltimo(lista);
				if(response.getCode()!=0) {
					log.error("Error: " + response.getDesc());
				}else {
					lista=response.getResultado();
					mostrarLista(lista);
				}
				LeNodo nuevoNodo=new LeNodo();
				nuevoNodo.setData("CHANCHO");
				response=port.agregarElementoUltimo(nuevoNodo, lista);
				if(response.getCode()!=0)
					log.error("Error: " + response.getDesc());
				else {
					lista=response.getResultado();
					mostrarLista(lista);
				}
				response=port.quitarElementoPrimero(lista);
				if(response.getCode()!=0)
					log.error("Error: " + response.getDesc());
				else {
					lista=response.getResultado();
					mostrarLista(lista);
				}
				nuevoNodo=new LeNodo();
				nuevoNodo.setData("ARROZ");
				response=port.agregarElementoPrimero(nuevoNodo, lista);
				if(response.getCode()!=0)
					log.error("Error: " + response.getDesc());
				else {
					lista=response.getResultado();
					mostrarLista(lista);
				}
			}
			log.info("Fin ejecucion cliente");
		} catch (MalformedURLException e) {
			log.error("URL de endpoint mal formada");
			e.printStackTrace();
		}
		

	}

}
