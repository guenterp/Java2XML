/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ch.gelion.java2xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

/**
 *
 * @author gp
 */
public class Java2XML {

    /**
     * @param args the command line arguments
     * @throws javax.xml.bind.PropertyException
     */
    public static void main(String[] args) throws PropertyException, JAXBException {
       
       Listpersons object;  
       Listpersons.Person person;
       Listpersons.Person.Address address;
       
       JAXBContext context = JAXBContext.newInstance(Listpersons.class);
       Marshaller m = context.createMarshaller();
       m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
 
       object = new Listpersons();  
       
       person = new Listpersons.Person();
       address = new Listpersons.Person.Address();
       
       address.setStreet("Getreidegasse");
       address.setStreetno("9");
       address.setZipcode(5020);
       address.setTown("Salzburg");
       address.setCountry("Austria");       
       person.setLastname("Mozart");
       person.setFirstname("Wolfgang Amadeus");
       person.setBirthday("1756-01-27");
       person.setAddress(address);
       object.getPerson().add(person);   
       
       person = new Listpersons.Person();
       address = new Listpersons.Person.Address();
       
       address.setStreet("Bonngsse");
       address.setStreetno("24-26");
       address.setZipcode(53111);
       address.setTown("Bonn");
       address.setCountry("Germany");       
       person.setLastname("Beethoven");
       person.setFirstname("Ludwig van");
       person.setBirthday("1770-12-16");
       person.setAddress(address);
       object.getPerson().add(person);   
        
       m.marshal(object, System.out);    
    }    
}
