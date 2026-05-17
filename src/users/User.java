package users;

import java.io.Serializable;
import java.util.Objects;

import communications.Message;
import research.Journal;
import research.ResearchPaper;
import research.Subsriber;

import enums.Language;

public abstract class User implements Serializable, Subsriber {
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

    public  boolean login(String email, String password){
        boolean ok = this.email.equals(email) && PasswordEncoder.matches(this.password, password);
        if (ok) {
            System.out.println(firstName + " " + lastName + " logged in.");
        }
        return ok;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", language=" + language +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public void sendMessage(User to, String text) {
        Message m = new Message(this, to, text);
        m.send();
    }

    public void switchLanguage(Language lang) {
        this.language = lang;
        System.out.println("Language switched to " + lang);
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // Observer: реакция на новую статью в журнале, на который подписан
    @Override
    public void update(Journal j, ResearchPaper p) {
        System.out.println("[Notification to " + firstName + "] New paper in '"
                + j.getName() + "': " + p.getTitle());
    }

    // Геттеры/сеттеры
    public String getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Language getLanguage() { return language; }

    public String getFullName() { return firstName + " " + lastName; }



}
