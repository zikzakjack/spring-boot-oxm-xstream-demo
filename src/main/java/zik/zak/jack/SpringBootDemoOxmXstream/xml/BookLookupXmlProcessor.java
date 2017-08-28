package zik.zak.jack.SpringBootDemoOxmXstream.xml;

import java.io.StringWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Component;

import com.thoughtworks.xstream.io.xml.CompactWriter;

import lombok.Data;

@Component
@Data
public class BookLookupXmlProcessor {

	private XStreamMarshaller xstreamMarshaller;

	@Autowired
	public BookLookupXmlProcessor(XStreamMarshaller xstreamMarshaller) {
		super();
		this.xstreamMarshaller = xstreamMarshaller;
	}

	/**
	 * Parse the Xml string to BookLookup object
	 * 
	 * @param bookLookupXmlStr
	 * @return
	 */
	public BookLookup parse(String bookLookupXmlStr) {
		try {
			return (BookLookup) xstreamMarshaller.getXStream().fromXML(bookLookupXmlStr.replaceAll("\n", ""));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Generate the Xml string from Person object
	 * 
	 * @param bookLookupObj
	 * @return
	 */
	public String generate(BookLookup bookLookupObj) {
		StringWriter stringWriter = new StringWriter();
		xstreamMarshaller.getXStream().marshal(bookLookupObj, new CompactWriter(stringWriter));
		String xmlMessageStr = stringWriter.toString();
		return xmlMessageStr;
	}

}
