package com.example.nguyenphucan_ktgk_2202;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView txtResult = findViewById(R.id.txtResult);
        TextView txtBack = findViewById(R.id.btnBack);

        double bmi = getIntent().getDoubleExtra("bmi_value", 0);

        String result;
        if (bmi<18.5) {
            result = "Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + " (Gầy)";
        } else if (bmi<24.9) {
            result = "Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + " (Bình thường)";
        } else if (bmi<29.9) {
            result = "Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + " (Thừa cân)";
        } else {
            result = "Chỉ số BMI của bạn là: " + String.format("%.2f", bmi) + " (Béo phì)";
        }
        txtResult.setText(result);
        txtBack.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
