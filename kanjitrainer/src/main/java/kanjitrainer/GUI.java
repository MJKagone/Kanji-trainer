package kanjitrainer;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Random;
import javafx.util.Duration;

public class GUI extends Application {

    private Dictionary dictionary;

    public GUI() {
        this.dictionary = new Dictionary("kanji.txt");
    }

    public void randomizeOptions(ArrayList<Button> options, Label kanjiLabel) {

        String kanji = dictionary.getKanji();
        kanjiLabel.setText(kanji);
        kanjiLabel.setFont(new Font(40));
        Random random = new Random();
        int correct = random.nextInt(3);
        ArrayList<String> alreadySelected = new ArrayList<>();

        for (int i = 0; i < 3; i++) {

            if (i == correct) {
                String translation = dictionary.getTranslation(kanji);
                while (alreadySelected.contains(translation)) {
                    translation = dictionary.getTranslation(kanji);
                }
                alreadySelected.add(translation);
                options.get(i).setText(translation);
                options.get(i).setFont(new Font(14));
            } 
            else {
                String translation = dictionary.getTranslation(dictionary.getKanji());
                while (alreadySelected.contains(translation)) {
                    translation = dictionary.getTranslation(dictionary.getKanji());
                }
                alreadySelected.add(translation);
                options.get(i).setText(translation);
                options.get(i).setFont(new Font(14));
            }
        }
    }

    public BorderPane scene2(Label kanjiLabel, Dictionary dictionary) {
        BorderPane layout2 = new BorderPane();
        layout2.setPrefSize(500, 250);
        Label correctAnswer = new Label("Correct!");
        correctAnswer.setFont(new Font(16));
        Label answer1 = new Label(kanjiLabel.getText());
        answer1.setFont(new Font(40));
        Label answer2 = new Label(dictionary.getReading(kanjiLabel.getText()));
        answer2.setFont(Font.font("System", FontPosture.ITALIC, 14));
        Label answer3 = new Label(dictionary.getTranslation(kanjiLabel.getText()));
        answer3.setFont(new Font(16));
        VBox vbox = new VBox(correctAnswer, answer1, answer2, answer3);
        layout2.setCenter(vbox);
        vbox.setAlignment(Pos.CENTER);
        return layout2;
    }

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();
        layout.setPrefSize(500, 250);

        Label kanjiLabel = new Label();
        Label question = new Label("Choose the correct translation for");
        question.setFont(new Font(14));

        Button option1 = new Button();
        Button option2 = new Button();
        Button option3 = new Button();
        ArrayList<Button> options = new ArrayList<>();
        options.add(option1);
        options.add(option2);
        options.add(option3);

        randomizeOptions(options, kanjiLabel);

        layout.setTop(question);
        StackPane centerPane = new StackPane();
        centerPane.getChildren().add(kanjiLabel);
        layout.setCenter(centerPane);
        
        HBox hbox = new HBox(option1, option2, option3);
        hbox.setMaxWidth(Double.MAX_VALUE);
        for (Node node : hbox.getChildren()) {
            HBox.setHgrow(node, Priority.ALWAYS);
            ((Button)node).setMaxWidth(Double.MAX_VALUE);
        }
        layout.setBottom(hbox);
        
        Scene view = new Scene(layout);

        for (Button option : options) {
            option.setOnAction((event) -> {
                if (option.getText().equals(dictionary.getTranslation(kanjiLabel.getText()))) {
                    BorderPane layout2 = scene2(kanjiLabel, dictionary);
                    Scene view2 = new Scene(layout2);
                    window.setScene(view2);
                    PauseTransition pause = new PauseTransition(Duration.seconds(3.5));
                    pause.setOnFinished(e -> {
                        window.setScene(view);
                        randomizeOptions(options, kanjiLabel);
                    });
                    pause.play();
                    layout.requestFocus();
                    question.setText("Choose the correct translation for");
                } else {
                    question.setText("Incorrect!");
                }
            });
        }
        
        window.setScene(view);
        window.setResizable(false);
        window.setTitle("Kanji trainer");
        window.show();
        layout.requestFocus();
    }

}
