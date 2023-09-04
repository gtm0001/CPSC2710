module cpsc.auburn.edu.module3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens cpsc.auburn.edu.module3 to javafx.fxml;
    exports cpsc.auburn.edu.module3;
}