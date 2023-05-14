package com.example.car;

import com.jfoenix.controls.JFXButton;
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

public class MarutiController implements Initializable {

    @FXML
    JFXButton backBtn;

    @FXML
    ImageView altoImg;

    @FXML
    ImageView wagonrImg;

    @FXML
    ImageView celerioImg;

    @FXML
    ImageView swiftImg;

    public void initialize(URL arg0, ResourceBundle arg1){
        getImage();
    }

    public void backAction(){
        try {
            backBtn.getScene().getWindow().hide();

            Stage home_page = new Stage();
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("home_page.fxml"));

            Scene scene = new Scene(parent);
            home_page.setScene(scene);
            home_page.show();
            home_page.setResizable(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getImage(){
        File altoFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\maruti-alto-800.jpg");
        Image altoImage = new Image(altoFile.toURI().toString());
        altoImg.setImage(altoImage);

        File celerioFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\celerio_maruti.jpg");
        Image celerioImage = new Image(celerioFile.toURI().toString());
        celerioImg.setImage(celerioImage);

        File wagonrFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\wagonr.jpg");
        Image wagonrImage = new Image(wagonrFile.toURI().toString());
        wagonrImg.setImage(wagonrImage);

        File swiftFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\swift.jpg");
        Image swiftImage = new Image(swiftFile.toURI().toString());
        swiftImg.setImage(swiftImage);
    }


}
