package io.jfxdevelop.lab5_2;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private Label welcomeText;

    @FXML
    private Slider fontSizeSlider;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TextField textInput;

    @FXML
    public void initialize() {
        // начальные значения
        colorPicker.setValue(Color.BLACK);
        fontSizeSlider.setValue(24);
        textInput.setText("Hello!");
        welcomeText.setText("Hello!");

        // привязка изменения текста
        textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            updateLabelText(newValue);
        });

        fontSizeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateStyle(newValue.doubleValue(), colorPicker.getValue());
        });

        colorPicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            updateStyle(fontSizeSlider.getValue(), newValue);
        });
    }

    private void updateLabelText(String newText) {
        if (newText == null || newText.trim().isEmpty()) {
            welcomeText.setText(" ");
        } else {
            welcomeText.setText(newText);
        }
        updateStyle(fontSizeSlider.getValue(), colorPicker.getValue());
    }

    private void updateStyle(double fontSize, Color textColor) {
        String cssColor = toCssColor(textColor);
        welcomeText.setStyle("-fx-font-size: " + fontSize + "px; -fx-text-fill: " + cssColor + ";");
    }

    private String toCssColor(Color color) {
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        return String.format("#%02X%02X%02X", r, g, b);
    }

    @FXML
    protected void onResetButtonClick() {
        fontSizeSlider.setValue(24);
        colorPicker.setValue(Color.BLACK);
        textInput.setText("Hello!");
    }
}