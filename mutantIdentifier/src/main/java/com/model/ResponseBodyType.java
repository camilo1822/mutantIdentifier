//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.24 a las 02:40:41 PM COT 
//


package com.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para responseBodyType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="responseBodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{dna}mutantIdentifierRS"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseBodyType", namespace = "body", propOrder = {
    "mutantIdentifierRS"
})
public class ResponseBodyType {

    @XmlElement(namespace = "dna", required = true)
    protected StatusType mutantIdentifierRS;

    /**
     * Obtiene el valor de la propiedad mutantIdentifierRS.
     * 
     * @return
     *     possible object is
     *     {@link StatusType }
     *     
     */
    public StatusType getMutantIdentifierRS() {
        return mutantIdentifierRS;
    }

    /**
     * Define el valor de la propiedad mutantIdentifierRS.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusType }
     *     
     */
    public void setMutantIdentifierRS(StatusType value) {
        this.mutantIdentifierRS = value;
    }

}
