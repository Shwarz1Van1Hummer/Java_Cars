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

public class ChevroletController implements Initializable {

    @FXML
    ImageView camaroImg;

    @FXML
    ImageView cobaltImg;

    @FXML
    ImageView sparkImg;

    @FXML
    ImageView tahoeImg;

    @FXML
    JFXButton exitBtn;


    public void initialize(URL arg0, ResourceBundle arg1){
        getImage();
    }

    private void getImage(){
        File camaroFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\chevrolet-camaro.jpg");
        Image camaroImage = new Image(camaroFile.toURI().toString());
        camaroImg.setImage(camaroImage);

        File cobaltFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\chevrolet-cobalt.jpg");
        Image cobaltImage = new Image(cobaltFile.toURI().toString());
        cobaltImg.setImage(cobaltImage);

        File sparkFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\chevrolet-spark.jpg");
        Image sparkImage = new Image(sparkFile.toURI().toString());
        sparkImg.setImage(sparkImage);

        File tahoeFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\chevrolet-tahoe.jpg");
        Image tahoeImage = new Image(tahoeFile.toURI().toString());
        tahoeImg.setImage(tahoeImage);
    }

    public void home(ActionEvent e){
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
