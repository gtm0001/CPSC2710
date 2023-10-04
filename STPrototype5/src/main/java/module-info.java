module edu.cpsc.au.stprototype5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.cpsc.au.stprototype5 to javafx.fxml;
    exports edu.cpsc.au.stprototype5;
}