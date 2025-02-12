public class Category {
    private int id;
    private String name;

    Category() {}

    Category(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    private void setName(String name) {
        this.name = name;
    }
}
