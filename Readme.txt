
Create XML data with Java and Netbeans:
    
  - create java project Java2XML 
    
  - create schema file persons.xsd:

        go to http://www.freeformatter.com, XSD generator
        copy the following xml (XML structure represents a list of persons with tags specified):

        <?xml version="1.0" encoding="ISO-8859-1"?>
        <listpersons>
            <person>
                <lastname/>
                <firstname/>
                <birthday/>
                <address>
                    <street/>
                    <streetno/>
                    <zipcode/>
                    <town/>
                    <country/>
                </address>
            </person>
        </listpersons>

        execute "Generate XSD" button.
        Then choose "SELECT ALL" and "COPY TO CLIPBOARD"

        Generate persons.xsd in Netbeans now:
        File / New File / XML / XML Schema (empty), choose persons as name and
        copy the text from the clipboard into your file with CTRL-V.

        generated schema file persons.xsd should look like this:

        <?xml version="1.0" encoding="UTF-8"?>
        <xs:schema attributeFormDefault="unqualified" elementFormDefault="qualified" xmlns:xs="http://www.w3.org/2001/XMLSchema">
            <xs:element name="listpersons">
                <xs:complexType>
                    <xs:sequence>
                        <xs:element name="person">
                            <xs:complexType>
                                <xs:sequence>
                                    <xs:element type="xs:string" name="lastname"/>
                                    <xs:element type="xs:string" name="firstname"/>
                                    <xs:element type="xs:string" name="birthday"/>
                                    <xs:element name="address">
                                        <xs:complexType>
                                            <xs:sequence>
                                                <xs:element type="xs:string" name="street"/>
                                                <xs:element type="xs:byte" name="streetno"/>
                                                <xs:element type="xs:short" name="zipcode"/>
                                                <xs:element type="xs:string" name="town"/>
                                                <xs:element type="xs:string" name="country"/>
                                            </xs:sequence>
                                        </xs:complexType>
                                    </xs:element>
                                </xs:sequence>
                            </xs:complexType>
                        </xs:element>
                    </xs:sequence>
                </xs:complexType>
            </xs:element>
        </xs:schema>

  - create Java Code from your persons.xsd file:
    File / New File / XML / JAXB Binding
    choose Persons as name and select persons.xsd as schema file
    => Java classes are generated under directory generated-sources

  - add application logic to Java2XML.java under src directory:
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

  -  run project
     => XML with 2 persons (Mozart, Beethoven) is displayed on screen
