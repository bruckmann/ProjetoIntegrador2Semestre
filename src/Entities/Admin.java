package Entities;

public class Admin extends User {

    private String email;

    public Admin(int admin_id, String name,  String password, int age, String email){
        super(admin_id, name,  password, age, email);
    }

    @Override
    public String getEmail() {
        return this.email;
    }

}
