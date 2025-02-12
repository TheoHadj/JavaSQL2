import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dbTask {
//REGROUPER getAll et getBy
    public static ArrayList<Task> getBy(String attr, String value, Connection connection) {
        String sql = "SELECT t.id, t.title, t.description, t.createdAt, t.status, c.id, c.name, a.id, a.firstname, a.lastname, a.email, a.password FROM Task t " +
                "LEFT JOIN Account a ON t.account_id = a.id LEFT " +
                "JOIN TaskCategory tc ON t.id = tc.task_id " +
                "LEFT JOIN Category c ON tc.category_id = c.id " +
                "WHERE t." + attr +  " = ?";

        ArrayList<Task> tasks = get(connection, sql, value);

        return tasks;
    }

    public static ArrayList<Task> getAll(Connection connection){

        String sql = "SELECT t.id, t.title, t.description, t.createdAt, t.status, c.id, c.name, a.id, a.firstname, a.lastname, a.email, a.password FROM Task t LEFT JOIN Account a ON t.account_id = a.id LEFT JOIN TaskCategory tc ON t.id = tc.task_id LEFT JOIN Category c ON tc.category_id = c.id";
        ArrayList<Task> tasks = get(connection, sql, null);
        return tasks;
    }


    private static ArrayList<Task> get(Connection connection, String sql, String value) {
        ArrayList<Task> tasks = new ArrayList<>();
        ArrayList<Integer> alreadyParsedId= new ArrayList<>();
        int id;
        String title;
        String description;
        Date createdAt;
        boolean status;
        Task task = new Task();
        int actualIndex=-1;

        try (PreparedStatement statement = connection.prepareStatement(sql);){

             if(value!=null){
                statement.setString(1, value);
            }
             try(ResultSet resultSet = statement.executeQuery();){
                System.out.println(resultSet);

                while (resultSet.next()) {

                    if(alreadyParsedId.contains(resultSet.getInt("t.id"))){
                        System.out.println("do not recast");
                    }
                    else{

                        id = resultSet.getInt("t.id");
                        title = resultSet.getString("t.title");
                        description = resultSet.getString("t.description");
                        createdAt = resultSet.getDate("t.createdAt");
                        status = resultSet.getBoolean("t.status");
                        Account account = new Account(resultSet.getInt("a.id"),resultSet.getString("a.firstname"),resultSet.getString("a.lastname"),resultSet.getString("a.email"),resultSet.getString("a.password"));
                        task = new Task(id, title, description, createdAt, status, account);
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
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }


        return tasks;
        }

    public static void remove(Connection dbConnection, int id){
        if (id == 0) { //petit tricks, java initialise les int a 0 quand ils n'ont pas de valeur
            System.out.println("Erreur cette tâche n'est pas en bdd!");
            return;
        }

        String sql = "DELETE FROM Task WHERE id = ?";

        try (PreparedStatement statement = dbConnection.prepareStatement(sql)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Tâche supprimée avec succès !");
            } else {
                System.out.println("Tâche introuvable.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    }


