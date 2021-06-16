package school21.spring.service.models;

public class User {
    private int Identifier;
    private String Email;

    public User(int identifier, String email) {
        Identifier = identifier;
        Email = email;
    }

    public User() {
    }

    public int getId() {
        return Identifier;
    }

    public void setIdentifier(int identifier) {
        Identifier = identifier;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "Identifier=" + Identifier +
                ", Email='" + Email + '\'' +
                '}';
    }
}
