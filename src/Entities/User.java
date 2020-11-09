package Entities;

public abstract class User {

    private int user_id;
    private String name;
    private String password;
    private int age;
    private String email;

    protected User (int user_id, String name, String password, int age, String email) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.email = email;
    }
}
