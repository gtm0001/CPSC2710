module edu.au.cpsc.part2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.au.cpsc.part2 to javafx.fxml;
    exports edu.au.cpsc.part2;
    exports edu.au.cpsc.part2.Controller;
    opens edu.au.cpsc.part2.Controller to javafx.fxml;
    exports edu.au.cpsc.part2.Data;
    opens edu.au.cpsc.part2.Data to javafx.fxml;
    exports edu.au.cpsc.part2.Model;
    opens edu.au.cpsc.part2.Model to javafx.fxml;
    opens edu.au.cpsc.part2.uimodel to javafx.fxml;
    exports edu.au.cpsc.part2.uimodel;
}