package ua.nure.kn156.slepanska;

import java.util.Calendar;
import java.util.Date;

public class User {
	private Long id;
	private String firstName;
	private String lastName;
	private Date dateOfBirth;

	public User(User user) {
		
		id=user.getId();
		firstName=user.getFirstName();
		lastName=user.getLastName();
		dateOfBirth=user.getDateOfBirth();
	}
public User(){
	
}
public User(Long id, String firstName, String lastName, Date date ){
	this.id=id;
	this.firstName=firstName;
	this.lastName=lastName;
	this.dateOfBirth=date;
	
}
	public User(String firstName, String lastName, Date date) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.dateOfBirth=date;
}
	public User(long id2, String firstName2, String lastName2, Date date) {
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date date) {
		this.dateOfBirth = date;
	}

	public String getFullName() {

		if (getLastName() == null || getFirstName() == null){
			throw new IllegalArgumentException("firstName or lastName is NULL");
		}
		return new StringBuilder(getLastName()).append(",").append(getFirstName()).toString();
	}
	public int getAge() {
		// TODO Auto-generated method stub

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int currentYear = calendar.get(Calendar.YEAR);
		int currentMonth = calendar.get(Calendar.MONTH);
		calendar.setTime(getDateOfBirth());
		int yearOfBirth = calendar.get(Calendar.YEAR);
		int monthOfBirth = calendar.get(Calendar.MONTH);
		if (monthOfBirth > currentMonth) {
			return currentYear - yearOfBirth - 1;
		} else {
			return currentYear - yearOfBirth;

		}
	}
	
	@Override
	  public int hashCode() {
	    if (this.getId()==null) {
	      return 0;
	    }
	    return this.getId().hashCode();
	  }
	
	  @Override
	  public boolean equals(Object obj) {
	    if (obj == null) {
	      return false;
	    }
	    if (this== obj) {
	      return true;
	    }
	    if (this.getId()==null && ((User) obj).getId()==null){
	      return true;
	    }
	    return this.getId().equals(((User) obj).getId());
	  }


}
