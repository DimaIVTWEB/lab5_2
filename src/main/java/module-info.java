module io.jfxdevelop.lab5_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens io.jfxdevelop.lab5_2 to javafx.fxml;
    exports io.jfxdevelop.lab5_2;
}