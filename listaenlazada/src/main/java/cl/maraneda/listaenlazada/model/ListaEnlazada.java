package cl.maraneda.listaenlazada.model;

import java.io.Serializable;

/** Clase que implementa una lista enlazada simple.
 *  En estructuras de datos, una lista enlazada simple contiene:
 *  <br> - Un puntero al primer nodo
 *  <br> - Un puntero al ultimo nodo nodo
 *  <br> - La cantidad de elementos de la lista
 *  <br> Una lista enlazada simple puede tener uno o mas nodos 
 *  entre el primer y el ultimo nodo
 * @author Marco Araneda
 * @since 2019-01-09
 * @param <T> El tipo de objeto que tendran todos los elementos
 * de la lista
 */
public class ListaEnlazada<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private LENodo<T> first;
	private LENodo<T> last;
	private int size;
	
	/** Crea una lista enlazada a partir de dos nodos
	 * 
	 * @param first El primer nodo de la lista
	 * @param last El ultimo nodo de la lista
	 */
	public ListaEnlazada(LENodo<T> first, LENodo<T> last) {
		this.first=first;
		this.first.setProx(last);
		this.last=last;
		this.size=2;
	}
	
	/** Crea una lista enlazada a partir de un nodo
	 * 
	 * @param first El nodo que tendra la lista.
	 */
	public ListaEnlazada(LENodo<T> first) {
		this.first=first;
		this.last=first;
		this.size=1;
	}
	
	/** Crea una lista vacia
	 * 
	 */
	public ListaEnlazada() {
		this.first=null;
		this.last=null;
		this.size=0;
	}

	/** Obtiene el primer nodo de la lista
	 * 
	 * @return El primer nodo de la lista
	 */
	public LENodo<T> getFirst() {
		return first;
	}

	/** Establece el primer nodo de la lista
	 * 
	 * @param first El nuevo primer nodo de la lista
	 */
	public void setFirst(LENodo<T> first) {
		this.first = first;
	}

	/** Obtiene el ultimo nodo de la lista
	 * 
	 * @return El ultimo nodo de la lista
	 */
	public LENodo<T> getLast() {
		return last;
	}

	/** Establece el ultimo nodo de la lista
	 * 
	 * @param first El nuevo ultimo nodo de la lista
	 */
	public void setLast(LENodo<T> last) {
		this.last = last;
	}
	
	/** Obtiene la cantidad de nodos de la lista
	 * 
	 * @return La cantidad de nodos
	 */
	public int getSize() {
		return size;
	}

	/** Establece la cantidad de nodos de la lista.
	 *  Se recomienda no llamar a este metodo a menos
	 *  que se haya agregado un nodo a la lista.
	 * 
	 * @param size La cantidad de nodos de la lista.
	 */
	public void setSize(int size) {
		this.size = size;
	}
}
