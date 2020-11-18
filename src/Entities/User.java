package Entities;

public abstract class User {

    private int user_id;
    private String name;
    private String password;
    private String email;
    private int age;

    protected User (int user_id, String name, String password, int age) {
        this.user_id = user_id;
        this.name = name;
        this.password = password;
        this.age = age;
    }

    protected User(int user_id, String name, String password, int age, String email) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public int getId(){
        return this.user_id;
    }

    public String getName(){
        return this.name;
    }


    public int getAge(){
        return this.age;
    }

    public abstract String getEmail();

}
