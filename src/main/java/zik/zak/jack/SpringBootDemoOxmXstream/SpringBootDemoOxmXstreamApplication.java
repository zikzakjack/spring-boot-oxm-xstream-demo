package zik.zak.jack.SpringBootDemoOxmXstream;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import zik.zak.jack.SpringBootDemoOxmXstream.xml.Person;
import zik.zak.jack.SpringBootDemoOxmXstream.xml.PersonXmlProcessor;

/**
 * Main Class. Autowired the PersonXmlProcessor. Cooked up some data. Invoked
 * the parse and generate methods.
 * 
 * @author zikzakjack
 *
 */
@SpringBootApplication
public class SpringBootDemoOxmXstreamApplication {

	private PersonXmlProcessor processor;

	@Autowired
	public SpringBootDemoOxmXstreamApplication(PersonXmlProcessor processor) {
		super();
		this.processor = processor;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemoOxmXstreamApplication.class, args);
		SpringBootDemoOxmXstreamApplication app = (SpringBootDemoOxmXstreamApplication) context
				.getBean("springBootDemoOxmXstreamApplication");

		Person person1 = loadPerson();
		String person1XmlStr = app.getProcessor().generate(person1);
		System.out.println("person1XmlStr :: " + person1XmlStr);

		String person2XmlStr = "<?xml version='1.0' encoding='UTF-8'?><person><name><firstName>TeenaMeena</firstName><lastName>Teekka</lastName></name><age>16</age><dateOfBirth>2002-02-10</dateOfBirth><sex>Male</sex><addressHistory><address startDate='2002-02-10' endDate='2005-12-31'>Congo Main Road, Congo - 24680</address><address startDate='2006-01-01' endDate='2017-03-31'>Nigeria Main Road, Nigeira - 13579</address></addressHistory></person>";
		Person person2Obj = app.getProcessor().parse(person2XmlStr);
		System.out.println("person2Obj :: " + person2Obj);

		String person3File = "person3.xml";
		Person person3Obj = app.getProcessor().parse(new File(person3File));
		System.out.println("person3Obj :: " + person3Obj);
	}

	public PersonXmlProcessor getProcessor() {
		return processor;
	}

	private static Person loadPerson() {
		Person.AddressHistory addressHistory = new Person.AddressHistory();
		addressHistory.addAddress(new Person.AddressHistory.Address("1999-02-14", "2005-12-31",
				"Singapore Main Road, Singapore Cross St, Singapore - 12345"));
		addressHistory.addAddress(new Person.AddressHistory.Address("2006-01-01", "2012-12-31",
				"Bahrain Main Road, Bahrain Cross St, Bahrain - 67890"));
		addressHistory.addAddress(new Person.AddressHistory.Address("2013-01-01", "2017-03-01",
				"London Main Road, London Cross St, London - 99999"));

		Person person = new Person();
		person.setName(new Person.Name("ZikZak", "Jack"));
		person.setAge("18");
		person.setDateOfBirth("1999-02-14");
		person.setSex("Male");
		person.setAddressHistory(addressHistory);
		return person;
	}

}
