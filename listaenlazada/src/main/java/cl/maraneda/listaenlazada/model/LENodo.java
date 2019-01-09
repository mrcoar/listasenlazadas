package cl.maraneda.listaenlazada.model;

import java.io.Serializable;

/** Clase conteniendo la informacion de un nodo. En estructuras
 *  de datos, un nodo contiene la siguiente informacion: <br> - 
 *  El dato contenido en el nodo <br> - Un puntero al siguiente nodo.
 * @author Marco Araneda
 * @since 2019-01-09
 * @param <T> Cualquier clase bien definida
 */
public class LENodo<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private T data;
	private LENodo<T> prox;
	
	/** Crea un nodo vacio
	 * 
	 */
	public LENodo() {
		this.data=null;
		this.prox=null;
	}
	
	/** Crea un nodo especificando el dato y el nodo hacia donde
	 *  sera apuntado.
	 * @param data El dato del nuevo nodo
	 * @param prox El nodo apuntado desde el nuevo nodo
	 */
	public LENodo(T data, LENodo<T> prox) {
		this.data=data;
		this.prox=prox;
	}
	
	/** Crea un nodo especificando el dato y que no habra un nodo
	 * apuntado desde el nuevo nodo
	 * @param data El dato que tendra el nuevo nodo
	 */
	public LENodo(T data) {
		this(data, null);
	}

	/** Obtiene el dato encapsulado en este nodo
	 * 
	 * @return El dato dentro de este nodo
	 */
	public T getData() {
		return data;
	}

	/** Establece un nuevo valor encapsulado en este nodo
	 * 
	 * @param data El nuevo valor a reemplazar al valor actual
	 * en este nodo
	 */
	public void setData(T data) {
		this.data = data;
	}

	/** Obtiene el dato encapsulado en este nodo
	 * 
	 * @return El dato dentro de este nodo
	 */
	public LENodo<T> getProx() {
		return prox;
	}

	/** Reemplaza el nodo al cual este nodo esta siendo apuntado
	 * por un nuevo nodo
	 * @param prox El nuevo nodo a ser apuntado desde este nodo
	 */
	public void setProx(LENodo<T> prox) {
		this.prox = prox;
	}
}
