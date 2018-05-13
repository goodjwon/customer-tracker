package com.lov2code.springdemo.entitiy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "customer")
@Setter
@Getter
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

    @Builder
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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


    public static enum Status {
        /**
         * 최초계정 생성 상태
         */
        LIVE,
        /**
         * 휴면계정 상태
         */
        SLEEP,


        /**
         * 탈퇴 상태
         */
        OUTED
    }
}

