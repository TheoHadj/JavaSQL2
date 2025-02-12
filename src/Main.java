import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {




    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
        DbConnect db = new DbConnect();
        ArrayList<Task> tasks = dbTask.getAll(db.getConnection());
        for(Task task : tasks) {
            task.displayTask();
        }

        dbTask.remove(db.getConnection(),1);

        ArrayList<Task> tasksBy = dbTask.getBy("title", "Finish report",db.getConnection());
        for(Task task : tasksBy) {
            task.displayTask();
        }






    }
}