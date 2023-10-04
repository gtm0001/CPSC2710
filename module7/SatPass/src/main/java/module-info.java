module edu.au.cpsc.satpass {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.orekit;
    requires hipparchus.ode;
    requires hipparchus.core;


    opens edu.au.cpsc.satpass to javafx.fxml;
    exports edu.au.cpsc.satpass;
    exports edu.au.cpsc.satpass.controller;
    opens edu.au.cpsc.satpass.controller to javafx.fxml;
    opens edu.au.cpsc.satpass.data to javafx.fxml;
    exports edu.au.cpsc.satpass.data;
}