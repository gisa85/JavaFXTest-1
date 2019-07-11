module JavaFXTest {
    requires javafx.controls;
    requires  javafx.fxml;
    requires org.jsoup;
    requires javafx.web;
    requires java.desktop;
    requires javafx.swing;

    opens org.dimigo.gui.festival;
}