package Dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "invaliduserCredentials")                                       //to call using name
	                                                                                     // multilple cases we use dp
public Object[][] userCredetialsData() 
{
	Object[][] data = new Object[3][2];                                                    // array type Object
	data[0][0] = "sree@gmail.com";
	data[0][1] = "sree123@";
	
	data[1][0] = "sreeponnu1996@gmail.com";
	data[1][1] = "sree123";
	
	data[2][0] = "sree@gmail.com";
	data[2][1] = " sree123";
	
	return data;
}


}
