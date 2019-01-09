
package cl.maraneda.listaenlazadaservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listaEnlazada complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listaEnlazada">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="first" type="{http://listaenlazadaservice.maraneda.cl/}leNodo" minOccurs="0"/>
 *         &lt;element name="last" type="{http://listaenlazadaservice.maraneda.cl/}leNodo" minOccurs="0"/>
 *         &lt;element name="size" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listaEnlazada", propOrder = {
    "first",
    "last",
    "size"
})
public class ListaEnlazada {

    protected LeNodo first;
    protected LeNodo last;
    protected int size;

    /**
     * Obtiene el valor de la propiedad first.
     * 
     * @return
     *     possible object is
     *     {@link LeNodo }
     *     
     */
    public LeNodo getFirst() {
        return first;
    }

    /**
     * Define el valor de la propiedad first.
     * 
     * @param value
     *     allowed object is
     *     {@link LeNodo }
     *     
     */
    public void setFirst(LeNodo value) {
        this.first = value;
    }

    /**
     * Obtiene el valor de la propiedad last.
     * 
     * @return
     *     possible object is
     *     {@link LeNodo }
     *     
     */
    public LeNodo getLast() {
        return last;
    }

    /**
     * Define el valor de la propiedad last.
     * 
     * @param value
     *     allowed object is
     *     {@link LeNodo }
     *     
     */
    public void setLast(LeNodo value) {
        this.last = value;
    }

    /**
     * Obtiene el valor de la propiedad size.
     * 
     */
    public int getSize() {
        return size;
    }

    /**
     * Define el valor de la propiedad size.
     * 
     */
    public void setSize(int value) {
        this.size = value;
    }

}
