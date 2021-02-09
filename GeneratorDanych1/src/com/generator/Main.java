package com.generator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.FileWriter;

@XmlRootElement
public class Main {

    public static void main(String[] args) throws Exception {

        JAXBContext jaxbContext = JAXBContext.newInstance(People.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        People people = new People();

        people.addUser("jacek2","placek2","mis2","jacek@gmail.com");
        people.addUser("jacek3","placek3","mis3","jacek3@gmail.com",12341234,1000);

        for (int i = 1; i < 10; i++) {
            User user = new User("imie"+i, "nazwisko"+i,"login"+i);
            people.addUser(user);
            }

        jaxbMarshaller.marshal(people, new FileWriter("test.xml"));
        }
}
