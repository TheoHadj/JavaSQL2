import java.util.ArrayList;
import java.util.Date;

public class Task {
    private int id;
    private String title;
    private String description;
    private Date createdAt;
    private boolean status;
//    private static ArrayList<Task> tasks;
    private ArrayList<Category> categories;


    Task(){

    }

    Task(int id, String title, String description, Date createdAt, boolean status){
        setId(id);
        setTitle(title);
        setDescription(description);
        setCreatedAt(createdAt);
        setStatus(status);
        categories = new ArrayList<>();
    }

    public int getId() {
        return id;
    }
    private void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    private void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }
    private void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
    private void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean getStatus() {
        return status;
    }
    private void setStatus(boolean status) {
        this.status = status;
    }

//    public static ArrayList<Task> getTasks() {
//        return tasks;
//    }
//    private static void setTasks(ArrayList<Task> tasks) {
//        Task.tasks = tasks;
//    }
//    public static void addTask(Task task){
//        tasks.add(task);
//    }

    public ArrayList<Category> getCategories() {
        return categories;
    }
    private void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }
    public void addCategory(Category category){
        categories.add(category);
    }


    public void displayTask(){
        System.out.println("Title: " + getTitle());
        System.out.println("Description: " + getDescription());
        System.out.println("Status: " + getStatus());
        for(Category category : categories){
            System.out.println(category.getName());
        }
    }


}
