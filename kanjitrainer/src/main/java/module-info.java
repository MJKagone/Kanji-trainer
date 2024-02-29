module mjkagone {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens kanjitrainer to javafx.fxml;
    exports kanjitrainer;
}