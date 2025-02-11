public class Patient {
    private String name;
    private int age;
    private String id;

    public Patient(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
