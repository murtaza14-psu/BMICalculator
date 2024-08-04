package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText weight, height;
        Button calculate;
        TextView result;

        weight=findViewById(R.id.weight_kg);
        height = findViewById(R.id.height_cm);
        calculate = findViewById(R.id.calculate_btn);
        result = findViewById(R.id.result_text);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight_store = Double.parseDouble(weight.getText().toString());
                double height_store = Double.parseDouble(height.getText().toString());

                double BMI = weight_store / (height_store * height_store);

                if (BMI >= 18 && BMI<= 25){
                    result.setText("You're Healthy (BMI: "+BMI+")");
                } else if (BMI > 25) {
                    result.setText("You're Overweight! (BMI: " + BMI + ")");
                }else {
                    result.setText("You're Underweight! (BMI: " + BMI + ")");
                }

            }
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}