module edu.au.cpsc.sattrackprototype {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.sattrackprototype to javafx.fxml;
    exports edu.au.cpsc.sattrackprototype;
}