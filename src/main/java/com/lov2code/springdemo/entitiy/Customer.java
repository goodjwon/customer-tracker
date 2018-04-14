package com.lov2code.springdemo.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "customer")
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name="email")
    private String email;
    
    @Column(name="home_tel")
    @Pattern(regexp = "(02|03[1-3]|04[1-4]|05[1-5]|06[1-4])-(\\d{3})-(\\d{4})", message = "Check your home tel number")
    private String home_tel;
   
    @Column(name="mobile_tel")
    @Pattern(regexp = "(01[01678])-(\\d{4})-(\\d{4})", message = "Check your mobile number")
    private String mobile_tel;

    @Column(name="user_id")
    @Pattern(regexp="^[a-zA-Z]{1}[a-zA-Z0-9_]{4,11}$", message ="Check your user id")
    private String user_id;
    
    public Customer() {
    }

    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getHome_tel() {
		return home_tel;
	}

	public void setHome_tel(String home_tel) {
		this.home_tel = home_tel;
	}

	public String getMobile_tel() {
		return mobile_tel;
	}

	public void setMobile_tel(String mobile_tel) {
		this.mobile_tel = mobile_tel;
	}
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	@Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", home_tel='" + home_tel + '\'' +
                ", mobile_tel='" + mobile_tel + '\'' +
                '}';
    }
}

