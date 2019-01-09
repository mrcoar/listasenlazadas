package cl.maraneda.listaenlazadaservice.model;

import java.io.Serializable;

import cl.maraneda.listaenlazada.model.ListaEnlazada;

/** Clase que contiene los mensajes de respuesta a las
 *  invocaciones a cada metodo del Web Service
 * @author Marco Araneda
 * @since 2019-01-09
 * @param <T> El tipo de objeto que deben tener los elementos
 * de la lista enlazada en caso de una operacion exitosa.
 */
public class ServiceResponse<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	private int code;
	private String desc;
	private ListaEnlazada<T> resultado;
	
	/** Obtiene el codigo de estado de la operacion invocada.
	 * Un cero indica estado exitoso, un numero negativo indica
	 * una excepcion y un numero positivo indica una operacion
	 * fallida por otros motivos.
	 * @return El estado de la operacion
	 */
	public int getCode() {
		return code;
	}
	
	/** Establece el estado de la operacion invocada.
	 * 
	 * @param code El nuevo estado de la operacion
	 */
	public void setCode(int code) {
		this.code = code;
	}
	
	/** Obtiene la descripcion correspondiente al codigo de estado
	 * 
	 * @return La descripcion del resultado
	 */
	public String getDesc() {
		return desc;
	}
	
	/** Establece la descripcion del estado de la operacion
	 * 
	 * @param desc La descripcion del resultado
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	/** Obtiene la lista enlazada resultante de la operacion
	 *  invocada
	 * 
	 * @return Una lista enlazada si la operacion es exitosa
	 * o null en caso contrario.
	 */
	public ListaEnlazada<T> getResultado() {
		return resultado;
	}
	
	/** Establece la lista enlazada resultante de una operacion
	 *  invocada. Se permite establecer null en caso de una
	 *  operacion fallida.
	 * @param resultado La lista enlazada resultante de la operacion invocada
	 */
	public void setResultado(ListaEnlazada<T> resultado) {
		this.resultado = resultado;
	}
}
