package com.example.doodleapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private DoodleView doodleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doodleView = findViewById(R.id.doodleView);

        // Clear Button
        Button clearButton = findViewById(R.id.clearButton);
        clearButton.setOnClickListener(view -> doodleView.clearCanvas());

        // Brush Size Button
        Button brushSizeButton = findViewById(R.id.brushSizeButton);
        brushSizeButton.setOnClickListener(view -> doodleView.setBrushSize(20));

        // Color Picker Button
        Button colorPickerButton = findViewById(R.id.colorPickerButton);
        colorPickerButton.setOnClickListener(view -> showColorPickerDialog());
    }

    private void showColorPickerDialog() {
        final String[] colors = {"Red", "Green", "Blue", "Yellow", "Black", "Cyan", "Magenta", "Gray"};
        final int[] colorValues = {
                Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
                Color.BLACK, Color.CYAN, Color.MAGENTA, Color.GRAY
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Choose a Color");
        builder.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                doodleView.setBrushColor(colorValues[which]);
            }
        });
        builder.show();
    }
}