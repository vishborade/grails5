package com.sb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Email;
//import org.hibernate.validator.constraints.NotEmpty;
@grails.gorm.annotation.Entity
@Entity(name = "User")
@Table(name = "base_user")
@SequenceGenerator(name= "base_user_id_seq", sequenceName="base_user_id_seq", allocationSize=1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "base_user_id_seq")
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name")
    //@Size(max = 20, min = 3, message = "{user.name.invalid}")
    //@NotEmpty(message="Please Enter your name")
    private String name;

    @Column(name = "email", unique = true)
    //@Email(message = "{user.email.invalid}")
    //@NotEmpty(message="Please Enter your email")
    private String email;

    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", version=" + version +
                '}';
    }
}