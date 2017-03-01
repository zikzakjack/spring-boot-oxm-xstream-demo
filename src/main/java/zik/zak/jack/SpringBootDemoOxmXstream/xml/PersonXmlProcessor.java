package zik.zak.jack.SpringBootDemoOxmXstream.xml;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.io.xml.CompactWriter;

/**
 * Class to marshal and unmarshall Person Xml
 * 
 * @author zikzakjack
 *
 */
@Component
public class PersonXmlProcessor {

	private static final String XML_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

	private XStreamMarshaller xstreamMarshaller;

	/**
	 * Initialize with xstreamMarshaller
	 * 
	 * @param xstreamMarshaller
	 */
	@Autowired
	public PersonXmlProcessor(XStreamMarshaller xstreamMarshaller) {
		super();
		this.xstreamMarshaller = xstreamMarshaller;
	}

	/**
	 * Parse the Xml file to Person object
	 * 
	 * @param personXmlFile
	 * @return
	 */
	public Person parse(File personXmlFile) {
		try {
			return parse(FileUtils.readFileToString(personXmlFile));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Parse the Xml string to Person object
	 * 
	 * @param personXmlStr
	 * @return
	 */
	public Person parse(String personXmlStr) {
		try {
			return (Person) xstreamMarshaller.getXStream().fromXML(personXmlStr.replaceAll("\n", ""));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Generate the Xml string from Person object
	 * 
	 * @param personObj
	 * @return
	 */
	public String generate(Person personObj) {
		StringWriter stringWriter = new StringWriter();
		xstreamMarshaller.getXStream().marshal(personObj, new CompactWriter(stringWriter));
		String xmlMessageStr = stringWriter.toString();
		return XML_HEADER + xmlMessageStr;
	}

}
