package cl.maraneda.listaenlazada.controller;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.log4j.Logger;

import cl.maraneda.listaenlazada.model.LENodo;
import cl.maraneda.listaenlazada.model.ListaEnlazada;

/** Clase encargada de las operaciones con listas enlazadas SIMPLES.
 *  Las operaciones conocidas son: Crear Lista, Agregar o quitar
 *  un elemento al principio o al final de la lista o remover
 *  todos los elementos de la lista.
 *  
 * @author Marco Araneda
 * @since 2019-09-01
 *
 */
public class ListaEnlazadaController {
	private static final Logger log=Logger.getLogger(ListaEnlazadaController.class);
	
	/** Agrega un elemento al principio de la lista
	 * 
	 * @param nodo El nodo a agregar a la lista
	 * @param lista La lista a la cual agregar el nodo
	 */
	public <T> void addFirst(LENodo<T> nodo, ListaEnlazada<T> lista) {
		try {
			log.info("Agregando nuevo nodo con elemento " + nodo.getData() + " al inicio de la lista");
		}catch(NullPointerException e) {
			log.warn("Agregando nuevo nodo nulo al inicio de la lista");
		}
		if(lista.getSize()==0) {
			lista.setFirst(nodo);
			lista.setLast(nodo);
			lista.setSize(1);
			log.info("Nodo agregado como primer y ultimo elemento de la lista");
		}else {
			nodo.setProx(lista.getFirst());
			lista.setFirst(nodo);
			lista.setSize(lista.getSize() + 1);
			log.info("Nodo agregado como elemento " + lista.getSize() + "-esimo de la lista");
		}
	}
	
	/** Agrega un elemento al final de la lista
	 * 
	 * @param nodo El nodo a agregar a la lista
	 * @param lista La lista a la cual agregar el nodo
	 */
	public <T> void addLast(LENodo<T> nodo, ListaEnlazada<T> lista) {
		try {
			log.info("Agregando nuevo nodo con elemento " + nodo.getData() + " al final de la lista");
		}catch(NullPointerException e) {
			log.warn("Agregando nuevo nodo nulo al final de la lista");
		}
		if(lista.getSize()==0) {
			lista.setFirst(nodo);
			lista.setLast(nodo);
			lista.setSize(1);
			log.info("Nodo agregado como primer y ultimo elemento de la lista");
		}else {
			/* Lo siguiente permite asegurar que no existan
			 * "enlaces rotos" entre un nodo y el próximo
			 * al agregar un elemento. Se recurre a la clase
			 * EqualsBuilder de Apache Commons Lang3 para una
			 * comparación de dos objetos por reflexión, así
			 * evitando recurrir al método equals, poco apropiado
			 * para comparaciones de objetos definidos recursivamente,
			 * y al operador !=, deficiente cuando se usa para comparar
			 * datos que no son de un tipo primitivo.
			 */
			LENodo<T> aux=lista.getFirst();
			while(!EqualsBuilder.reflectionEquals(aux, lista.getLast()))
				aux=aux.getProx();
			aux.setProx(nodo);
			lista.setLast(nodo);
			lista.setSize(lista.getSize() + 1);
			log.info("Nodo agregado como elemento " + lista.getSize() + "-esimo de la lista");
		}
	}
	
	/** Agrega un elemento al principio de la lista
	 * 
	 * @param nodo El nodo a agregar a la lista
	 * @param lista La lista a la cual agregar el nodo
	 */
	public <T> void addFirst (T data, ListaEnlazada<T> lista) {
		this.addFirst(new LENodo<>(data), lista);
	}
	
	/** Agrega un elemento al final de la lista
	 * 
	 * @param nodo El nodo a agregar a la lista
	 * @param lista La lista a la cual agregar el nodo
	 */
	public <T> void addLast (T data, ListaEnlazada <T> lista) {
		this.addLast(new LENodo<>(data), lista);
	}
	
	/** Intenta remover el primer elemento de la lista.
	 * 
	 * @param lista La lista a la cual remover el primer elemento
	 * @return true si el elemento es removido con exito. False en caso contrario
	 */
	public <T> boolean removeFirst(ListaEnlazada <T> lista) {
		log.info("Removiendo primer elemento de la lista");
		if(lista.getFirst()==null || lista.getSize()==0) {
			log.warn("No hay elementos que quitar");
			return false;
		}
		if(lista.getSize()==1) {
			lista.setFirst(null);
			lista.setLast(null);
			lista.setSize(0);
			log.info("Elemento removido de la lista. La lista ahora esta vacia");
		}else {
			LENodo<T> prox=lista.getFirst().getProx();
			lista.getFirst().setProx(null);
			lista.setFirst(prox);
			lista.setSize(lista.getSize() - 1);
			if(lista.getSize()==0)
				lista.setLast(null);
			else if(lista.getSize()==1)
				lista.setLast(lista.getFirst());
			log.info("Elemento removido de la lista. La lista ahora tiene " + lista.getSize() + " elementos");
		}
		/*Se recurre al metodo gc para invocar manualmente al
		 * recolector de basura. Se recomienda fuertemente hacer
		 * esto si se tiene la certeza de la existencia de 
		 * objetos no referenciados.
		 */
		System.gc();
		return true;
	}
	
	/** Intenta remover el ultimo elemento de la lista.
	 * 
	 * @param lista La lista a la cual remover el ultimo elemento
	 * @return true si el elemento es removido con exito. False en caso contrario
	 */
	public <T> boolean removeLast(ListaEnlazada <T> lista) {
		log.info("Removiendo ultimo elemento de la lista");
		
		if(lista.getLast()==null || lista.getSize()==0){
			log.warn("No hay elementos que quitar");
			return false;
		}
		if(lista.getSize()==1) {
			lista.setFirst(null);
			lista.setLast(null);
			lista.setSize(0);
			log.info("Elemento removido de la lista. La lista ahora esta vacia");
		}else {
			LENodo<T> aux=lista.getFirst();
			/* Refierase al metodo addLast para el uso de la clase
			 * EqualsBuilder
			 */
			while(!EqualsBuilder.reflectionEquals(aux.getProx(), lista.getLast()))
				aux=aux.getProx();
			lista.setLast(aux);
			aux.setProx(null);
			lista.setSize(lista.getSize() - 1);
			if(lista.getSize()==0)
				lista.setFirst(null);
			else if(lista.getSize()==1)
				lista.setFirst(lista.getLast());
			log.info("Elemento removido de la lista. La lista ahora tiene " + lista.getSize() + " elementos");
		}
		System.gc();
		return true;
	}
	
	/** Remueve todos los elementos de la lista. Simplemente
	 *  les quita la referencia a todos y se invoca a System.gc
	 *  para activar el recolector de basura.
	 * @param lista La lista a vaciar
	 */
	public <T> void removeAll(ListaEnlazada<T> lista) {
		lista.setFirst(null);
		lista.setLast(null);
		lista.setSize(0);
		System.gc();
		log.info("Todos los elementos removidos de la lista");
	}
	
	/** Crea una lista enlazada simple a partir de una coleccion
	 *  de objetos. Cada objeto de la coleccion es agregado al
	 *  final de la lista
	 * @param items La coleccion de objetos a agregar
	 * @return El objeto ListaEnlazada con los objetos de la coleccion
	 * @throws NullPointerException Si items es nulo.
	 */
	public <T> ListaEnlazada<T> fromList(List<T> items) throws NullPointerException{
		log.info("Creando lista enlazada a partir de una coleccion de items");
		ListaEnlazada<T> lista=new ListaEnlazada<>();
		for(T item : items) {
			this.addLast(item, lista);
		}
		return lista;
	}
}
