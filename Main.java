import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        DBlogic db = new DBlogic();
        Scanner scan = new Scanner(System.in);

        System.out.println("What you want to do (c - creat, r - read, u - update, d - delete, e - exit: ");
        String user_choice = scan.nextLine();


        switch (user_choice) {
            case "c":
                System.out.println("Insert cathegory: ");
                String user_cathegory = scan.nextLine();

                System.out.println("Insert item: ");
                String user_item = scan.nextLine();

                System.out.println("Insert person: ");
                String user_person = scan.nextLine();

                System.out.println("Insert date or write '-': ");
                String user_date = scan.nextLine();

                System.out.println("Insert time or write '-': ");
                String user_time = scan.nextLine();

                db.create(user_cathegory, user_item, user_person, user_date, user_time);
                break;

            case "r":
                db.read();
                break;

            case "u":
                System.out.println("Which row do you want to update: ");
                String user_row = scan.nextLine();
                System.out.println("Which column do you want to update (c - cathegory, i - item, p - person, d - date, t - time");
                String user_col = scan.nextLine();
                System.out.println("Update value of cathegory: ");
                String user_update_row = scan.nextLine();

                switch (user_col){
                    case "c":
                        db.update_cathegory(user_row, user_update_row);
                    break;
                    case "i":
                        db.update_item(user_row, user_update_row);
                        break;
                    case "p":
                        db.update_person(user_row, user_update_row);
                        break;
                    case "d":
                        db.update_date(user_row, user_update_row);
                        break;
                    case "t":
                        db.update_time(user_row, user_update_row);
                        break;
                    default:
                        System.out.println("Don't exist column..");
                }

                break;

            case "d":
                System.out.println("Which row you want to delete: ");
                String row_id = scan.nextLine();

                db.delete(row_id);

                System.out.println("Row with id: " + row_id + "deleted..");
                break;

            case "e":
                System.out.println("Exit..lets do todo list");
                return;

            default:
                System.out.println("Try next time..");
                break;


        }


    }
}


