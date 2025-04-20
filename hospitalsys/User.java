package hospitalsys;

public abstract class User {
    protected int id; //id is a numbers, so it gotta be int
    protected String name;
    protected String password;
    // public is not secure for sensitive info, private won't give that info, protected though is delicious for sensitive info

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
}