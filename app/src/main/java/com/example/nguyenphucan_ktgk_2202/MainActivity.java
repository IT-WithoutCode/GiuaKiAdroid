package com.example.nguyenphucan_ktgk_2202;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        EditText edtH_2202 = findViewById(R.id.edtHeight);
        EditText edtW_2202 = findViewById(R.id.edtWeight);

        Button button_2202 = findViewById(R.id.btnCalculate);
        button_2202.setOnClickListener(v -> {
//            String h = edtH_2202.getText().toString();
//            String w = edtW_2202.getText().toString();
//
//            double  height_2202 = Double.parseDouble(h);
//            double  weight_2202 = Double.parseDouble(w);
//            double bmi = weight_2202 / (height_2202 * height_2202);

            Intent intent_2202 = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent_2202);
//            intent_2202.putExtra("bmi_value", bmi);
            finish();
        });








    }
}