module edu.au.cpsc.module4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.au.cpsc.module4 to javafx.fxml;
    exports edu.au.cpsc.module4;
    exports edu.au.cpsc.module4.Controller;
    opens edu.au.cpsc.module4.Controller to javafx.fxml;
    exports edu.au.cpsc.module4.Data;
    opens edu.au.cpsc.module4.Data to javafx.fxml;
    exports edu.au.cpsc.module4.Model;
    opens edu.au.cpsc.module4.Model to javafx.fxml;
}