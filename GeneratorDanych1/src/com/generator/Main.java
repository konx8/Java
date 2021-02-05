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


        for (int i = 1; i < 10; i++) {
            User user = new User("imie"+i, "nazwisko"+i,"login"+i);
            people.addUser(user);
            }

        //people.createBankAcc(0,1000,0);


        jaxbMarshaller.marshal(people, new FileWriter("test.xml"));
        }
}
