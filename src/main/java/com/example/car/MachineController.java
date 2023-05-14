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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class MachineController implements Initializable {
    @FXML
    ImageView suzukiImg;

    @FXML
    ImageView huyndaiImg;

    @FXML
    ImageView chevroletImg;

    @FXML
    ImageView tataImg;

    @FXML
    JFXButton maruti;

    @FXML
    JFXButton huyndaiBtn;

    @FXML
    JFXButton tataBtn;

    @FXML
    JFXButton chevroletBtn;

    @FXML
    AnchorPane home;


    public void initialize(URL arg0, ResourceBundle arg1){
        imageHome();
    }

    private void imageHome(){
        File suzukiFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\maruti-group-m.jpg");
        Image suzukiView = new Image(suzukiFile.toURI().toString());
        suzukiImg.setImage(suzukiView);

        File huyndaiFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\hyundai.jpg");
        Image huyndaiView = new Image(huyndaiFile.toURI().toString());
        huyndaiImg.setImage(huyndaiView);

        File chevroletFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\chevrolet.jpg");
        Image chevroletView = new Image(chevroletFile.toURI().toString());
        chevroletImg.setImage(chevroletView);

        File tataFile = new File("C:\\Users\\user\\Desktop\\Car\\src\\Images\\2021-Tata-Motors-Founders-Edition-Tiago-Altroz-Nexon-.jpg");
        Image tataView = new Image(tataFile.toURI().toString());
        tataImg.setImage(tataView);
    }

    public void marutiAction(ActionEvent e) {

        try {
            maruti.getScene().getWindow().hide();

            Stage maruti_page = new Stage();
            Parent parent;
            parent = FXMLLoader.load(getClass().getResource("Maruti.fxml"));

            Scene scene = new Scene(parent);
            maruti_page.setScene(scene);
            maruti_page.show();
            maruti_page.setResizable(false);

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void huyndaiAction(ActionEvent e){
        try {
            huyndaiBtn.getScene().getWindow().hide();

            Stage huyndai_page = new Stage();
            Parent sceneH;
            sceneH = FXMLLoader.load(getClass().getResource("hyundai.fxml"));

            Scene scene = new Scene(sceneH);
            huyndai_page.setScene(scene);
            huyndai_page.show();
            huyndai_page.setResizable(false);

        } catch (Exception e2){
            e2.printStackTrace();
        }
    }

    public void tataAction(ActionEvent e){
        try {
            tataBtn.getScene().getWindow().hide();

            Stage tata = new Stage();
            Parent sceneT;
            sceneT = FXMLLoader.load(getClass().getResource("tata-motors.fxml"));

            Scene scene = new Scene(sceneT);
            tata.setScene(scene);
            tata.show();
            tata.setResizable(false);

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void chevroletAction(ActionEvent e){
        try {
            chevroletBtn.getScene().getWindow().hide();

            Stage chevrolet = new Stage();
            Parent parent;

            parent = FXMLLoader.load(getClass().getResource("chevrolet.fxml"));

            Scene scene = new Scene(parent);
            chevrolet.setScene(scene);
            chevrolet.show();
            chevrolet.setResizable(false);

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }

}
