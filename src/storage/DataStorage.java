package storage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataStorage implements Serializable {
    private List<User> users;
    private List<Course> courses;
    private List<News> news;
    private List<String> logs;

    private static final DataStorage INSTANCE = new DataStorage();

    {
        this.users = new ArrayList<User>();
        this.courses = new ArrayList<Course>();
        this.news = new ArrayList<News>();
        this.logs = new ArrayList<String>();
    }

    private DataStorage(){}

    public static DataStorage getInstance(){
        return INSTANCE;
    }
    public List<User> getUsers() {
        return this.users;
    }

    public List<Course> getCourses() {
        return this.courses;
    }
    //Zhelau Udachi Ilie i Vadimu
    public void saveUsers() {

    }

    public void loadUsers() {

    }

    public void addLog(String action) {
        this.logs.add(action);
    }

    public User findUser(String email) {

        return null;
    }


}
