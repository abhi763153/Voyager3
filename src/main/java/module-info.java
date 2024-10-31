module com.abhiapps.voyager3 {
    requires javafx.controls;
    requires javafx.web;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.abhiapps.voyager3 to javafx.fxml;
    exports com.abhiapps.voyager3;
}