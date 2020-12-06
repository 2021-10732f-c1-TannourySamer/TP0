import java.util.HashMap;
import java.util.Map;

public class Customer {

	private String _id;
	private String _firstname;
	private String _lastname;
	private String _telephone;
	private String _street1;
	private String _street2;
	private String _city;
	private String _state;
	private String _zipcode;
	private String _country;
	private String _mail;
	
	static private Map<String,Customer> customers = new HashMap<>();
	
	Customer(String ID, String FirstName,String LastName){
	    this._id = ID;
        this._firstname = FirstName;
        this._lastname = LastName;
	}
	
	Customer(String ID, String FirstName,String LastName,String _telephone, String _street1,String _street2,String _city, String _state,String _zipcode,String _country,String _mail){
	    this._id = ID;
        this._firstname = FirstName;
        this._lastname = LastName;
	    this._telephone = _telephone;
        this._street1 = _street1;
        this._street2 = _street2;
	    this._city = _city;
        this._state = _state;
        this._zipcode = _zipcode;
        this._country = _country;
        this._mail = _mail;
	}
	
	public String getId() {
		return _id;
	}
	
	public String getFirstname() {
		return _firstname;
	}
    
	public String getLastname() {
		return _lastname;
	}
	
	public String getTelephone() {
		return _telephone;
	}
    
	public String getStreet1() {
		return _street1;
	}
	
	public String getStreet2() {
		return _street2;
	}
    
	public String getCity() {
		return _city;
	}
	
	public String getState() {
		return _state;
	}
	public String getZipcode() {
		return _zipcode;
	}
	
	public String getCountry() {
		return _country;
	}
	public String getMail() {
		return _mail;
	}

	public void setFirstname(String FirstName) {
		this._firstname = FirstName;
	}
	public void setLastname(String LastName) {
		this._lastname = LastName;
	}
	public void setTelephone(String _telephone) {
		this._telephone = _telephone;
	}
	public void setStreet1(String _street1) {
		this._street1 = _street1;
	}
	public void setStreet2(String _street2) {
		this._street2 = _street2;
	}
	public void setCity(String _city) {
		this._city = _city;
	}
	public void setState(String _state) {
		this._state = _state;
	}
	public void setZipcode(String _zipcode) {
		this._zipcode = _zipcode;
	}
	public void setCountry(String _country) {
		this._country = _country;
	}
	public void setMail(String _mail) {
		this._mail = _mail;
	}

	public boolean checkMail() {
		
        if (_mail.endsWith(".us")) { 
            return false;
        }
        
        if (_mail.endsWith("x.com")) { 
            return false;
        }
		
	      String regex = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";	     	      
	      return _mail.matches(regex) && _mail.length() > 6 && _mail.length() < 20;
	   }
	
	 public boolean checkId(String ID) {
		    return ID != null ;
		  }
	
	 public boolean checkData() {
		    return _id != null && _firstname != null && _lastname != null && _id != "" && _firstname != "" && _lastname != "";
		  }
	 
	 public String getCheckDataError() {
	 
		 String response="No Error";			 
		    if (_id == "" || _id == null){ 
		    		response="Invalid id";
		    }else if(_firstname == "")
		    {		
		    	response="Invalid first name";
		    }else if(_lastname == "")
		    {		
		    	response="Invalid last name";
		    }
		    return response;
		  }
	 
	 public static Customer find(String ID) {
		        if (ID != "" && customers.get(ID)!=null) {
		            return customers.get(ID);
		    }
		    return null;
		  }
	 
	 public static boolean remove(String ID){
		    if(ID != "" && customers.containsKey(ID)){
		        customers.remove(ID);
		        return true;
		    }
		    return false;
		}
	 
	 public static boolean insert(Customer customer){
		
		 if(customer != null){
		    customers.put(customer.getId(),customer);
			return true;
		 }
		  return false;
		 
		}
}

