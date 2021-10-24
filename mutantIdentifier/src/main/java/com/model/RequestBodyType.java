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
 * <p>Clase Java para requestBodyType complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="requestBodyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{dna}mutantIdentifierRQ"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestBodyType", namespace = "body", propOrder = {
    "mutantIdentifierRQ"
})
public class RequestBodyType {

    @XmlElement(namespace = "dna", required = true)
    protected DnaType mutantIdentifierRQ;

    /**
     * Obtiene el valor de la propiedad mutantIdentifierRQ.
     * 
     * @return
     *     possible object is
     *     {@link DnaType }
     *     
     */
    public DnaType getMutantIdentifierRQ() {
        return mutantIdentifierRQ;
    }

    /**
     * Define el valor de la propiedad mutantIdentifierRQ.
     * 
     * @param value
     *     allowed object is
     *     {@link DnaType }
     *     
     */
    public void setMutantIdentifierRQ(DnaType value) {
        this.mutantIdentifierRQ = value;
    }

}
