
package cl.maraneda.listaenlazadaservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para leNodo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="leNodo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/>
 *         &lt;element name="prox" type="{http://listaenlazadaservice.maraneda.cl/}leNodo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "leNodo", propOrder = {
    "data",
    "prox"
})
public class LeNodo {

    protected Object data;
    protected LeNodo prox;

    /**
     * Obtiene el valor de la propiedad data.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getData() {
        return data;
    }

    /**
     * Define el valor de la propiedad data.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setData(Object value) {
        this.data = value;
    }

    /**
     * Obtiene el valor de la propiedad prox.
     * 
     * @return
     *     possible object is
     *     {@link LeNodo }
     *     
     */
    public LeNodo getProx() {
        return prox;
    }

    /**
     * Define el valor de la propiedad prox.
     * 
     * @param value
     *     allowed object is
     *     {@link LeNodo }
     *     
     */
    public void setProx(LeNodo value) {
        this.prox = value;
    }

}
