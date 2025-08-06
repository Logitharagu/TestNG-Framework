package Factory;

public class BrowserManager {
	
	public static BrowserFactoryInf getDriver(String broswerTypeInv) {
		
		switch (broswerTypeInv.toLowerCase()) {
		case "chrome":
			System.out.println("user Invoke chrome browser");
			return new ChromeBro();
			
		case "edge":
			System.out.println("user Invoke edge browser");
			return new EdgeBro();
				

		default:
			throw new IllegalArgumentException("Browser Type is not valid");
		}
	}

}
