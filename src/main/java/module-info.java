module com.kensoftph.javafxapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;

    opens com.kensoftph.javafxapi to javafx.fxml;
    exports com.kensoftph.javafxapi;
}