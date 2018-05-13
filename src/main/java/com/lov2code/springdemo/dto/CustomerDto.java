package com.lov2code.springdemo.dto;


import com.lov2code.springdemo.entitiy.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDto 
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String home_tel;
    private String mobile_tel;
    private String user_id;

    public CustomerDto() {}

    @Builder
    public CustomerDto(int id, String firstName, String lastName, String email, String home_tel, String mobile_tel, String user_id) 
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.home_tel = home_tel;
        this.mobile_tel = mobile_tel;
        this.user_id = user_id;
    }

    public Customer toEntity()
    {
        return null;
    }

    public CustomerDto toDto(Customer customer)
    {
        return null;
    }

    @Override
    public String toString() 
    {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", home_tel='" + home_tel + '\'' +
                ", mobile_tel='" + mobile_tel + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
