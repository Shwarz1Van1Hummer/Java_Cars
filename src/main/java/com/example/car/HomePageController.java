package com.example.car;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPopup;
import com.jfoenix.controls.JFXRippler;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class HomePageController implements Initializable{

    @FXML AnchorPane holderPane;

    AnchorPane home;

    @FXML
    private JFXButton maruti;

    @FXML
    JFXButton logOut;

    @FXML
    JFXButton exit;

    @FXML
    AnchorPane anchor;

    @FXML
    HBox rightToolBar;

    @FXML
    ImageView carView;

    @FXML
    Label welcome;

    private static HomePageController instance;

    public HomePageController(){
        instance = this;
    }

    public static HomePageController getInstance(){
        return instance;
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        setUsername(LoginController.getInstance().username());
        getImage();
        createPage();
    }

    public void setUsername(String user){
        this.welcome.setText("Welcome " + user);
    }

    private void setNode(Node node){

        holderPane.getChildren().clear();
        holderPane.getChildren().add((Node) node);

        FadeTransition ft = new FadeTransition(Duration.millis(1500));
        ft.setNode(node);
        ft.setFromValue(0.1);
        ft.setToValue(1);
        ft.setCycleCount(1);
        ft.setAutoReverse(false);
        ft.play();
    }

    public void createPage() {
        try {
            home = FXMLLoader.load(getClass().getResource("HomeCars.fxml"));
            setNode(home);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    private void getImage(){
        File carFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\car.png");
        Image carImage = new Image(carFile.toURI().toString());
        carView.setImage(carImage);
    }



    @FXML
    void exitAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void logOutAction(ActionEvent event) {
        logOut.getScene().getWindow().hide();

        Stage login = new Stage();
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("login-view.fxml"));

            Scene scene = new Scene(root);
            login.setScene(scene);
            login.show();
            login.setResizable(false);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

}

