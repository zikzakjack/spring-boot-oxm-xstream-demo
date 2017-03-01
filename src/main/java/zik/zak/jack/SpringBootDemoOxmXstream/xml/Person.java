package zik.zak.jack.SpringBootDemoOxmXstream.xml;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.converters.extended.ToAttributedValueConverter;

/**
 * Pojo equivalent of the person xml
 * 
 * @author zikzakjack
 *
 */
@XStreamAlias("person")
public class Person {

	private Name name;

	private String age;

	private String dateOfBirth;

	private String sex;

	private AddressHistory addressHistory;

	public static class Name {

		private String firstName;

		private String lastName;

		public Name() {

		}

		public Name(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}

	public static class AddressHistory {

		@XStreamImplicit(itemFieldName = "address")
		private List<Address> addressHistory;

		public List<Address> getAddressHistory() {
			return addressHistory;
		}

		public void setAddressHistory(List<Address> addressHistory) {
			this.addressHistory = addressHistory;
		}

		public void addAddress(Address address) {
			if (addressHistory == null)
				addressHistory = new ArrayList<Address>();
			addressHistory.add(address);
		}

		@XStreamConverter(value = ToAttributedValueConverter.class, strings = { "postalAddress" })
		public static class Address {

			@XStreamAsAttribute
			private String startDate;

			@XStreamAsAttribute
			private String endDate;

			private String postalAddress;

			public Address() {
			}

			public Address(String startDate, String endDate, String postalAddress) {
				super();
				this.startDate = startDate;
				this.endDate = endDate;
				this.postalAddress = postalAddress;
			}

			public String getStartDate() {
				return startDate;
			}

			public void setStartDate(String startDate) {
				this.startDate = startDate;
			}

			public String getEndDate() {
				return endDate;
			}

			public void setEndDate(String endDate) {
				this.endDate = endDate;
			}

			public String getPostalAddress() {
				return postalAddress;
			}

			public void setPostalAddress(String postalAddress) {
				this.postalAddress = postalAddress;
			}

		}

	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public AddressHistory getAddressHistory() {
		return addressHistory;
	}

	public void setAddressHistory(AddressHistory addressHistory) {
		this.addressHistory = addressHistory;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
