package thigk1.phamgiakhiem.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LamThemActivity extends AppCompatActivity {


    EditText editWeight, editHeight;
    Button btnCalculate, btnBack;
    TextView tvResult;
    CheckBox cbAsian;
    void timDK() {
        editWeight = findViewById(R.id.editWeight);
        editHeight = findViewById(R.id.editHeight);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.bt_back);
        cbAsian = findViewById(R.id.cbAsian);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lam_them);

        timDK();



        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LamThemActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateBMI() {
        String weightStr = editWeight.getText().toString();
        String heightStr = editHeight.getText().toString();

        if (weightStr.isEmpty() || heightStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
            return;
        }

        double weight = Double.parseDouble(weightStr);
        double height = Double.parseDouble(heightStr);

        if (height <= 0 || weight <= 0) {
            Toast.makeText(this, "Chiều cao và cân nặng phải lớn hơn 0!", Toast.LENGTH_SHORT).show();
            return;
        }

        double bmi = weight / (height * height);
        String category;
        if (cbAsian.isChecked()) {
            if (bmi < 17.5) {
                category = "Gầy";
            } else if (bmi < 22.9) {
                category = "Bình thường";
            } else if (bmi < 27.9) {
                category = "Thừa cân";
            } else {
                category = "Béo phì";
            }
        } else {
            if (bmi < 18.5) {
                category = "Gầy";
            } else if (bmi < 24.9) {
                category = "Bình thường";
            } else if (bmi < 29.9) {
                category = "Thừa cân";
            } else {
                category = "Béo phì";
            }
        }



        tvResult.setText(String.format("BMI: %.2f\nTình trạng: %s", bmi, category));
    }
}