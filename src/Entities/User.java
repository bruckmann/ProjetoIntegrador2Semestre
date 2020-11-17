package Entities;

public abstract class User {

    private int user_id;
    private String name;
    private String role;
    private String password;
    private int age;

    protected User (int user_id, String name, String role, String password, int age) {
        this.user_id = user_id;
        this.name = name;
        this.setRole(role);
        this.setPassword(password);
        this.setAge(age);
    }

    public int getId(){
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

    private void setAge(int age) {
        if(age > 0) {
            this.age = age;
        }
    }

    private void setRole(String role){
        if (role.toLowerCase().equals("admin")) {
            this.role = "admin";
        }
        else if (role.toLowerCase().equals("jogador")){
            this.role = "player";
        } else {
            this.role = null;
        }
    }

    private void setPassword(String password) {
        if (password.length() <= 10) {
            this.password = password;
        } else {
            this.password = null;
        }
    }

    public String getRole() {
        return this.role;
    }


}
