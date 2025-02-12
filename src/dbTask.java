import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dbTask {

    public static ArrayList<Task> getAll(Connection connection){
        ArrayList<Task> tasks = new ArrayList<>();
        String sql = "SELECT t.id, t.title, t.description, t.createdAt, t.status, c.id, c.name FROM Task t LEFT JOIN TaskCategory tc ON t.id = tc.task_id LEFT JOIN Category c ON tc.category_id = c.id";
        ArrayList<Integer> alreadyParsedId= new ArrayList<>();
        int id;
        String title;
        String description;
        Date createdAt;
        boolean status;
        Task task = new Task();
        int actualIndex=-1;

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery();){
            System.out.println(resultSet);

            while (resultSet.next()) {
                System.out.println(alreadyParsedId.contains(resultSet.getInt("t.id")));
                System.out.println(alreadyParsedId);
                if(alreadyParsedId.contains(resultSet.getInt("t.id"))){
                    System.out.println("do not recast");
                }
                else{

                    id = resultSet.getInt("t.id");
                    System.out.println(id);
                    System.out.println();
                    title = resultSet.getString("t.title");
                    description = resultSet.getString("t.description");
                    createdAt = resultSet.getDate("t.createdAt");
                    status = resultSet.getBoolean("t.status");
                    task = new Task(id, title, description, createdAt, status);
                    tasks.add(task);
                    actualIndex++;
                    alreadyParsedId.add(id);
                }
                int categoryId = resultSet.getInt("c.id");
                String categoryName = resultSet.getString("c.name");
                Category category = new Category(categoryId, categoryName);
                tasks.get(actualIndex).addCategory(category);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return tasks;
    }
}
