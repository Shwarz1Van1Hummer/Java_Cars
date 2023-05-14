package com.example.car;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import javafx.animation.PathTransition;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Handler;

import DBConnection.DBHandler;

public class SignUpController implements Initializable {

    @FXML
    private ImageView carImage;

    @FXML
    private ImageView personImage;

    @FXML
    private ImageView lockedImage;

    @FXML
    private ImageView genderImage;

    @FXML
    private ImageView locationImage;

    @FXML
    private JFXRadioButton female;

    @FXML
    private ToggleGroup gender;

    @FXML
    private ToggleGroup gender1;

    @FXML
    private TextField location;

    @FXML
    private JFXButton login;

    @FXML
    private JFXRadioButton male;

    @FXML
    private JFXRadioButton other;

    @FXML
    private AnchorPane parentPane;

    @FXML
    private PasswordField password;

    @FXML
    private JFXButton signup;

    @FXML
    private TextField username;

    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        File car = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\car.png");
        Image carView = new Image(car.toURI().toString());
        carImage.setImage(carView);

        File person = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\man.png");
        Image personView = new Image(person.toURI().toString());
        personImage.setImage(personView);

        File locked = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\unlock.png");
        Image lockedView = new Image(locked.toURI().toString());
        lockedImage.setImage(lockedView);

        File location = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\location.png");
        Image locationView = new Image(location.toURI().toString());
        locationImage.setImage(locationView);

        File gender = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\gender.png");
        Image genderView = new Image(gender.toURI().toString());
        genderImage.setImage(genderView);

        handler = new DBHandler();
    }

    @FXML
    public void signUP(ActionEvent e){
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(3));
        pt.setOnFinished(ev -> {
            System.out.println("SignUp Successfull");
        });
        pt.play();

        String insert = "INSERT INTO users( names, password, gender, location)" +
                "VALUES (?,?,?,?)";

        connection = handler.getConnection();
        try {
            pst = connection.prepareStatement(insert);
        } catch (SQLException e1){
            e1.printStackTrace();
        }
        try {
            pst.setString(1, username.getText());
            pst.setString(2, password.getText());
            pst.setString(3, getGender());
            pst.setString(4, location.getText());

            pst.executeUpdate();

        } catch (SQLException e1){
            e1.printStackTrace();
        }

    }

    @FXML
    public void loginAction(ActionEvent ae2) throws IOException {
        signup.getScene().getWindow().hide();

        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        login.setScene(scene);
        login.show();
        login.setResizable(false);

    }

    public String getGender(){
        String gen = "";

        if(male.isSelected()){
            gen = "Male";
        }
        else if (female.isSelected()){
            gen = "Female";
        }
        else if (other.isSelected()){
            gen = "Other";
        }
        return gen;
    }
}

