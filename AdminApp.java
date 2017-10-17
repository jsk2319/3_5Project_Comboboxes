/**
 * Author: Jude Kallista-Fitzpatrick
 * @author jsk2319@email.vccs.edu
 *Purpose: This application lets the user choose an acccount type. If the user does not pick an account type, the user will be told to go back and pick one. When the user is told to go back, the application will loop back.
 */

import javafx.application.Application;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;

public class AdminApp extends Application {
    public enum AccountType {
        SelectAccount, Administrator,Faculty, Student, Staff, Guest //state account types
    }
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Alert alert = new Alert(AlertType.INFORMATION); //set up for all alerts

        //combobox setup
        ComboBox <AccountType>comboBox = new ComboBox<>();
        //set up account type button
        comboBox.getItems().addAll(AccountType.SelectAccount, AccountType.Administrator, AccountType.Faculty, AccountType.Student, AccountType.Staff, AccountType.Guest);
        comboBox.setValue(AccountType.SelectAccount);
        comboBox.setVisible(true);
        //log in button
        Button submitBtn = new Button("Log in");
        submitBtn.setOnAction(e-> {
            //results for selecting an account type
            if (comboBox.getValue().equals(AccountType.Administrator)) {
                primaryStage.close();
                alert.setContentText("Welcome " + AccountType.Administrator + "!");
                alert.showAndWait();

            }else if (comboBox.getValue().equals(AccountType.Faculty)) {
                primaryStage.close();
                alert.setContentText("Welcome " + AccountType.Faculty + "!");
                alert.showAndWait();


            }else if (comboBox.getValue().equals(AccountType.Student)) {
                primaryStage.close();
                alert.setContentText("Welcome " + AccountType.Student + "!");
                alert.showAndWait();



            }else if (comboBox.getValue().equals(AccountType.Staff)) {
                primaryStage.close();
                alert.setContentText("Welcome " + AccountType.Staff + "!");
                alert.showAndWait();


            }else if (comboBox.getValue().equals(AccountType.Guest)) {
                primaryStage.close();
                alert.setContentText("Welcome " + AccountType.Guest + "!");
                alert.showAndWait();

            //when the user does not select an account type
            }else {
                alert.setContentText("You have to choose an account type.");
                alert.showAndWait();

            }
        });

        VBox pane = new VBox();
        pane.getChildren().addAll(comboBox,submitBtn);

        //shows everything
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Authentication");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
