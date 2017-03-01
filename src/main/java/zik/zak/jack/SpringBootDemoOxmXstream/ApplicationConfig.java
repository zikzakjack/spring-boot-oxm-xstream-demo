package zik.zak.jack.SpringBootDemoOxmXstream;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xstream.XStreamMarshaller;

/**
 * Convenient class to declare all the Bean defintions
 * 
 * @author zikzakjack
 *
 */
@Configuration
public class ApplicationConfig {

	@Bean
	public XStreamMarshaller xstreamMarshaller() {
		XStreamMarshaller xstreamMarshaller = new XStreamMarshaller();
		Map<String, String> aliasesMap = new HashMap<>();
		aliasesMap.put("fileServiceMessage", "zik.zak.jack.SpringBootDemoOxmXstream.xml.Person");
		xstreamMarshaller.setAliases(aliasesMap);
		xstreamMarshaller.setAutodetectAnnotations(true);
		return xstreamMarshaller;
	}
}