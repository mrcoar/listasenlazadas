package cl.maraneda.listaenlazadaservice;

import java.util.Arrays;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import cl.maraneda.listaenlazada.controller.ListaEnlazadaController;
import cl.maraneda.listaenlazada.model.LENodo;
import cl.maraneda.listaenlazada.model.ListaEnlazada;
import cl.maraneda.listaenlazadaservice.model.ServiceResponse;

/** Clase que implementa el web service SOAP de operaciones 
 *  con listas enlazadas. No se utilizaron librerias externas
 *  para la definicion del web service, pero si para el logging
 * @author Marco Araneda
 * @since 2019-01-09
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ListaEnlazadaService {
	
	/**Metodo web para generar una lista enlazada a partir 
	 * de un arreglo de datos de un mismo tipo T
	 * @param data El arreglo con cuyos datos se creara la lista
	 * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
	 */
	@WebMethod(operationName="generarListaEnlazada")
	public <T> ServiceResponse<T> generarListaEnlazada(T[] data){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl = new ListaEnlazadaController();
			ListaEnlazada<T> lista=ctrl.fromList(Arrays.asList(data));
			resp.setCode(0);
			resp.setDesc("Lista creada exitosamente");
			resp.setResultado(lista);
		}catch(NullPointerException e) {
			resp.setCode(-1);
			resp.setDesc("Se obtuvo un error al intentar crear la lista: " + e);
			resp.setResultado(null);
			e.printStackTrace();
		}catch(Exception e) {
			resp.setCode(-2);
			resp.setDesc("Se produjo un error al tratar de agregar los elementos: " + e);
			resp.setResultado(null);
		}
		return resp;
	}
	
	/** Metodo web para agregar un elemento al principio de
	 *  la lista.
	 * @param data El nodo a ser agregado a la lista.
	 * @param lista La lista a la cual agregar el nodo
	 * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
	 */
	@WebMethod(operationName="agregarElementoPrimero")
	public <T> ServiceResponse<T> agregarElementoPrimero(LENodo<T> data, ListaEnlazada<T> lista){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl=new ListaEnlazadaController();
			ctrl.addFirst(data, lista);
			resp.setCode(0);
			resp.setDesc("Elemento agregado exitosamente");
			resp.setResultado(lista);
		}catch(NullPointerException e) {
			resp.setCode(-1);
			resp.setDesc("La lista (o el dato recibido) es nula");
			resp.setResultado(null);
		}catch(Exception e) {
			resp.setCode(-2);
			resp.setDesc("Se produjo un error al tratar de agregar el elemento: " + e);
			resp.setResultado(null);
		}
		return resp;
	}
	
	/** Metodo web para agregar un elemento al final de
	 *  la lista.
	 * @param data El nodo a ser agregado a la lista.
	 * @param lista La lista a la cual agregar el nodo
	 * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
	 */
	@WebMethod(operationName="agregarElementoUltimo")
	public <T> ServiceResponse<T> agregarElementoUltimo(LENodo<T> data, ListaEnlazada<T> lista){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl=new ListaEnlazadaController();
			ctrl.addLast(data, lista);
			resp.setCode(0);
			resp.setDesc("Elemento agregado exitosamente");
			resp.setResultado(lista);
		}catch(NullPointerException e) {
			resp.setCode(-1);
			resp.setDesc("La lista (o el dato recibido) es nula");
			resp.setResultado(null);
		}catch(Exception e) {
			resp.setCode(-2);
			resp.setDesc("Se produjo un error al tratar de agregar el elemento: " + e);
			resp.setResultado(null);
		}
		return resp;
	}
	
    /** Metodo web para remover el primer elemento de la lista
     * 
     * @param lista La lista de la cual remover el primer elemento
     * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
     */
	@WebMethod(operationName="quitarElementoPrimero")
	public <T> ServiceResponse<T> quitarElementoPrimero(ListaEnlazada<T> lista){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl=new ListaEnlazadaController();
			boolean res=ctrl.removeFirst(lista);
			if(res) {
				resp.setCode(0);
				resp.setDesc("Elemento quitado exitosamente");
				resp.setResultado(lista);
			}else {
				resp.setCode(1);
				resp.setDesc("La lista enlazada ya esta vacia");
				resp.setResultado(lista);
			}
		}catch(Exception e) {
			resp.setCode(-1);
			resp.setDesc("Se produjo un error al tratar de quitar el elemento: " + e);
			resp.setResultado(null);
		}
		return resp;
	}
	
	/** Metodo web para remover el ultimo elemento de la lista
     * 
     * @param lista La lista de la cual remover el ultimo elemento
     * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
     */
	@WebMethod(operationName="quitarElementoUltimo")
	public <T> ServiceResponse<T> quitarElementoUltimo(ListaEnlazada<T> lista){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl=new ListaEnlazadaController();
			boolean res=ctrl.removeLast(lista);
			if(res) {
				resp.setCode(0);
				resp.setDesc("Elemento quitado exitosamente");
				resp.setResultado(lista);
			}else {
				resp.setCode(1);
				resp.setDesc("La lista enlazada ya esta vacia");
				resp.setResultado(lista);
			}
		}catch(Exception e) {
			resp.setCode(-1);
			resp.setDesc("Se produjo un error al tratar de quitar el elemento:" + e);
			resp.setResultado(null);
		}
		return resp;
	}
	
	/** Metodo web para remover todos los elementos de la lista
	 * 
	 * @param lista La lista de la cual remover todos los elementos
	 * @return Un objeto de respuesta conteniendo un 0 y la lista
	 * resultante en caso de exito, o un valor distinto de cero
	 * y un null en caso contrario, mas la descripcion correspondiente
	 */
	@WebMethod(operationName="quitarTodos")
	public <T> ServiceResponse<T> quitarTodos(ListaEnlazada<T> lista){
		ServiceResponse<T> resp=new ServiceResponse<>();
		try {
			ListaEnlazadaController ctrl=new ListaEnlazadaController();
			ctrl.removeAll(lista);
			resp.setCode(0);
			resp.setDesc("Todos los elementos quitados exitosamente");
			resp.setResultado(lista);
		}catch(Exception e) {
			resp.setCode(-1);
			resp.setDesc("Se produjo un error al intentar vaciar la lista enlazada: " + e);
			resp.setResultado(null);
		}
		return resp;
	}
}
