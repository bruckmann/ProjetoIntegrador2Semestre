package Entities;

public class Admin extends User {

    private String email;

    public Admin(int admin_id, String name, String role, String password, int age, String email){
        super(admin_id, name, role, password, age);
        this.email = email;
    }



}
