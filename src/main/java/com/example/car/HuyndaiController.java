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

public class HuyndaiController implements Initializable {

    @FXML
    JFXButton homeBtn;

    @FXML
    ImageView tucsonImg;

    @FXML
    ImageView bayonImg;

    @FXML
    ImageView elantraImg;

    @FXML
    ImageView sonataImg;

    public void initialize(URL arg0, ResourceBundle arg1){
        getImage();
    }

    private void getImage(){
        File fileTucson = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\tucson.jpg");
        Image imageTucson = new Image(fileTucson.toURI().toString());
        tucsonImg.setImage(imageTucson);

        File fileBayon = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\bayon.jpg");
        Image bayonTucson = new Image(fileBayon.toURI().toString());
        bayonImg.setImage(bayonTucson);

        File fileElantra = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\elantra.jpg");
        Image imageElantra = new Image(fileElantra.toURI().toString());
        elantraImg.setImage(imageElantra);

        File fileSonata = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\sonata.jpg");
        Image imageSonata = new Image(fileSonata.toURI().toString());
        sonataImg.setImage(imageSonata);
    }

    public void home(ActionEvent e){
        try {
            homeBtn.getScene().getWindow().hide();

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
