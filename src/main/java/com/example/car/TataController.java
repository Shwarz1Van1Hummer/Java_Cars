package com.example.car;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class TataController implements Initializable {

    @FXML
    JFXButton exitBtn;

    @FXML
    ImageView tataNano;

    @FXML
    ImageView tataNexon;

    @FXML
    ImageView tataPunch;

    @FXML
    ImageView tataTigor;

    public void initialize(URL arg0, ResourceBundle arg1){
        getImage();
    }

    public void getImage(){
        File fileNano = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\tata-nano.jpg");
        Image imgNano = new Image(fileNano.toURI().toString());
        tataNano.setImage(imgNano);

        File fileNexon = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\tata-nexon.jpg");
        Image imgNexon = new Image(fileNexon.toURI().toString());
        tataNexon.setImage(imgNexon);

        File filePunch = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\Tata-Punch.jpg");
        Image imgPunch = new Image(filePunch.toURI().toString());
        tataPunch.setImage(imgPunch);

        File fileTigor = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\tata-tigor.jpg");
        Image imgTigor = new Image(fileTigor.toURI().toString());
        tataTigor.setImage(imgTigor);
    }

    public void exit(ActionEvent e){
        try {
            exitBtn.getScene().getWindow().hide();

            Stage stage = new Stage();
            Parent homepage;
            homepage = FXMLLoader.load(getClass().getResource("home_page.fxml"));

            Scene scene = new Scene(homepage);
            stage.setScene(scene);
            stage.show();
            stage.setResizable(false);

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
