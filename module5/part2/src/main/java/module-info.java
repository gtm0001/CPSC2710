module edu.au.cpsc.launcher {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.launcher to javafx.fxml;
    exports edu.au.cpsc.launcher;
}