package Library;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;

public class FakerDataProvider {
	
	public static final Faker Ofake=new Faker(new Locale("en-IND"));
	
	private FakerDataProvider() {
		
	}
	
	public static Name getName() {
		Name name = Ofake.name();
		return name;
	}
	public static String getLastName() {
		return Ofake.name().firstName();
	}
	public static String getCompanyName() {
		return Ofake.company().name().replaceAll("[^a-zA-Z ]", "");
	}

	public static String getUrl() {
		return Ofake.company().url();
	}

	public static String getAddress() {
		return Ofake.address().streetAddress();
	}
	
	public static String getCity() {
		return Ofake.address().city();
	}

	public static String getCountry() {
		return Ofake.country().toString();
	}

	public static String getUserName() {
		return Ofake.name().username();
	}
	
	
	public static String getFirstName() {
		return Ofake.name().firstName();
	}
	
	public static String getMiddleName() {
		return Ofake.name().nameWithMiddle();
	}
	
	public static String getEmailAddress() {
		return Ofake.internet().emailAddress();
	}
	
	public static String getContactNumber() {
		return Ofake.phoneNumber().cellPhone();
	}

	public static String getBankAccountNumber() {
		return ""+Ofake.number().randomNumber(8, false);
	}
	
	public static String getRandomNumber() {
		return ""+Ofake.number().randomNumber(9, false);
	}
	
	public static String getSwiftCode() {
		return ""+Ofake.number().randomNumber(4, false);
	}
	public static String getTaxNumber() {
		return ""+Ofake.number().randomNumber(7, false);
	}
	
	public static String getRating() {
		return Ofake.options().option("Hot","Warm", "Cold");
	}
	
	public static String getSalutation() {
		return Ofake.options().option("Mr.","Ms.", "Mrs.", "Dr.", "Prof.");
	}
	
	public static String getTitle() {
		return Ofake.options().option("Mr","Ms", "Mrs");
	}
	
	public static String getGender() {
		return Ofake.options().option("Male","Female");
	}
	
	public static String getPassword() {
		return Ofake.regexify("[A-Za-z0-9]{8}");
	}
	
}
;