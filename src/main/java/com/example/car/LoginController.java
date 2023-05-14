package com.example.car;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.util.Duration;
import DBConnection.*;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private JFXButton signup;

    @FXML
    private ImageView carImage;

    @FXML
    private ImageView iconPerson;

    @FXML
    private ImageView iconLocked;

    @FXML
    private TextField username;

    @FXML
    private JFXCheckBox remember;

    @FXML
    private JFXButton login;

    @FXML
    private JFXButton forgotpassword;

    @FXML
    private PasswordField password;

    private DBHandler handler;
    private Connection connection;
    private PreparedStatement pst;
    private static LoginController instance;

    public LoginController(){
        instance = this;
    }

    public static LoginController getInstance(){
        return instance;
    }

    public String username(){
        return username.getText();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        getImage();

        handler = new DBHandler();

    }

    @FXML
    public void loginAction(ActionEvent e){
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {

        });
        pt.play();

        connection = handler.getConnection();
        String q1 = "SELECT * from users where names=? and password=?";

        try {
            pst = connection.prepareStatement(q1);
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            ResultSet rs = pst.executeQuery();

            int count = 0;
            while (rs.next())
            {
                count= count+1;
            }
            if (count==1)
            {
                login.getScene().getWindow().hide();

                Stage home = new Stage();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("home_page.fxml"));
                    Scene scene = new Scene(root);
                    home.setScene(scene);
                    home.show();

                } catch (IOException e1){
                    e1.printStackTrace();
                }
            }
            else
            {
                Alert alert =new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Username or password is not correct");
                alert.show();

            }
        } catch (SQLException sq1){
            sq1.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    public void signUp(ActionEvent e1) throws IOException {

        login.getScene().getWindow().hide();

        Stage signup = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene scene = new Scene(root);
        signup.setScene(scene);
        signup.show();
        signup.setResizable(false);

    }

    public void getImage(){
        File carFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\car.png");
        Image carView = new Image(carFile.toURI().toString());
        carImage.setImage(carView);

        File personFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\man.png");
        Image personView = new Image(personFile.toURI().toString());
        iconPerson.setImage(personView);

        File lockedFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\unlock.png");
        Image lockedView = new Image(lockedFile.toURI().toString());
        iconLocked.setImage(lockedView);
    }
}