module com.example.testhipparchus {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.orekit;
    requires hipparchus.core;


    opens com.example.testhipparchus to javafx.fxml;
    exports com.example.testhipparchus;
}