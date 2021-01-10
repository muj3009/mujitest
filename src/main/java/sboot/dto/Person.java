package sboot.dto;


import javax.validation.constraints.*;

public class Person {

    private int id;
//    private String title;
    private String name;
    private String email;
    
    @NotNull
    private String telephone;
    
    private String username;
    private String password;

    public Person() {
    }

    public Person(int person_id,String title, String name, String email, String telephone, String username, String password) {
//        this.title=title;
        this.id = person_id;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }

}
