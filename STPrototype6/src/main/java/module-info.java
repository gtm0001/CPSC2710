module edu.au.cpsc.stprototype6 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.orekit;


    opens edu.au.cpsc.stprototype6 to javafx.fxml;
    exports edu.au.cpsc.stprototype6;
}