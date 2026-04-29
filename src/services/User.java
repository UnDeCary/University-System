package services;

import enums.Language;

import java.io.Serializable;
import java.util.Objects;

public abstract class User implements Serializable {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Language language;

    public User(String id, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.language = Language.EN;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
    }

    public void sendMessage(User to, String text) {
    }

    public void switchLanguage(Language lang) {
        this.language = lang;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " <" + email + ">";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
