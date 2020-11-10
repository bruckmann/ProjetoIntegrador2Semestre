package Entities;

public abstract class User {

    private int user_id;
    private String name;
    private String role;
    private String password;
    private int age;
    private String email;

    protected User (int user_id, String name, String role, String password, int age, String email) {
        this.user_id = user_id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.age = age;
        this.email = email;
    }

    public int getUser_id(){
        return this.user_id;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return password;
    }

    public int getAge(){
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

}
