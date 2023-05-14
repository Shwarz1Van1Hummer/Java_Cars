module com.example.car {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;


    opens com.example.car to javafx.fxml;
    exports com.example.car;
}