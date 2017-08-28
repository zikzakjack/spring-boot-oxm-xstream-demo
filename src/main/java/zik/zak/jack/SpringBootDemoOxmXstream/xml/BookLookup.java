package zik.zak.jack.SpringBootDemoOxmXstream.xml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

import lombok.Data;

@XStreamAlias("root")
@Data
public class BookLookup {

	private String sourceName;

	private String delimiter;

	private String valueDate;

	private Books books;

	private Response response;

	@Data
	public static class Books {

		private Attributes attributes;

		private Values values;

		@Data
		public static class Attributes {

			@XStreamImplicit(itemFieldName = "attribute")
			private List<Attribute> attributes;

			public void addAttribute(Attribute attribute) {
				if (attributes == null)
					attributes = new ArrayList<Attribute>();
				attributes.add(attribute);
			}

			@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "attribute" })
			@Data
			public static class Attribute {

				private String attribute;

				public Attribute() {

				}

				public Attribute(String attribute) {
					this.attribute = attribute;
				}

			}
		}

		@Data
		public static class Values {

			@XStreamImplicit(itemFieldName = "value")
			private List<Value> values;

			public void addValue(Value value) {
				if (values == null)
					values = new ArrayList<Value>();
				values.add(value);
			}

			@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "value" })
			@Data
			public static class Value {

				private String value;

				public Value() {

				}

				public Value(String value) {
					this.value = value;
				}
			}
		}
	}

	@Data
	public static class Response {

		@XStreamImplicit(itemFieldName = "attributes")
		private List<Attribute> attributes;

		@Data
		public static class Attribute {

			private String attribute;

			public Attribute() {

			}

			public Attribute(String attribute) {
				this.attribute = attribute;
			}

		}

	}
}
