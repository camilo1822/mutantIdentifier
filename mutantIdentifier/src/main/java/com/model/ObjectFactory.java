//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.8-b130911.1802 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2021.10.24 a las 02:40:41 PM COT 
//


package com.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _MutantIdentifierRS_QNAME = new QName("dna", "mutantIdentifierRS");
    private final static QName _MutantIdentifierRQ_QNAME = new QName("dna", "mutantIdentifierRQ");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestBodyType }
     * 
     */
    public RequestBodyType createRequestBodyType() {
        return new RequestBodyType();
    }

    /**
     * Create an instance of {@link ResponseBodyType }
     * 
     */
    public ResponseBodyType createResponseBodyType() {
        return new ResponseBodyType();
    }

    /**
     * Create an instance of {@link DnaType }
     * 
     */
    public DnaType createDnaType() {
        return new DnaType();
    }

    /**
     * Create an instance of {@link StatusType }
     * 
     */
    public StatusType createStatusType() {
        return new StatusType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StatusType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dna", name = "mutantIdentifierRS")
    public JAXBElement<StatusType> createMutantIdentifierRS(StatusType value) {
        return new JAXBElement<StatusType>(_MutantIdentifierRS_QNAME, StatusType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DnaType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "dna", name = "mutantIdentifierRQ")
    public JAXBElement<DnaType> createMutantIdentifierRQ(DnaType value) {
        return new JAXBElement<DnaType>(_MutantIdentifierRQ_QNAME, DnaType.class, null, value);
    }

}
