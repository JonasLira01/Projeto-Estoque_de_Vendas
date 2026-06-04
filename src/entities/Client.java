package entities;

public class Client {
    private String name;
    private String email;
    private java.util.Date birthDate;

    public Client(String name, String email, java.util.Date birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
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
    public java.util.Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(java.util.Date birthDate) {
        this.birthDate = birthDate;
    }

}
