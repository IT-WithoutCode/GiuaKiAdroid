package com.example.nguyenphucan_ktgk_2202;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        Button btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(v -> {
            String h = edtH_2202.getText().toString().trim();
            String w = edtW_2202.getText().toString().trim();

            if (h.isEmpty() || w.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đủ chiều cao và cân nặng", Toast.LENGTH_SHORT).show();
                return;
            }
            try {
                double height_2202 = Double.parseDouble(h);
                double weight_2202 = Double.parseDouble(w);

                if (height_2202 > 3) height_2202 /= 100;

                double bmi = weight_2202 / (height_2202 * height_2202);
                Intent intent_2202 = new Intent(MainActivity.this, MainActivity2.class);
                intent_2202.putExtra("bmi_value", bmi);
                startActivity(intent_2202);

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Dữ liệu nhập không hợp lệ", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
