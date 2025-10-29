package thigk1.phamgiakhiem.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

public class DienTichActivity extends AppCompatActivity {

    TextInputEditText edtThang, edtNam, tvKetQua;
    Button btnBack;
    MaterialCardView btnKiemTra;
    void TimDK() {

        edtThang = findViewById(R.id.edtThang);
        edtNam = findViewById(R.id.edtNam);
        tvKetQua = findViewById(R.id.tvKetQua);
        btnKiemTra = findViewById(R.id.btnKiemTra);
        btnBack = findViewById(R.id.bt_back);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dien_tich);
        TimDK();
        btnKiemTra.setOnClickListener(v -> kiemTraThoiGian());
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DienTichActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void kiemTraThoiGian() {
        try {
            // Lấy dữ liệu từ 2 EditText
            String daiStr = edtThang.getText().toString().trim();
            String rongStr = edtNam.getText().toString().trim();

            if (daiStr.isEmpty() || rongStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ chiều dài và chiều rộng", Toast.LENGTH_SHORT).show();
                return;
            }


            double dai = Double.parseDouble(daiStr);
            double rong = Double.parseDouble(rongStr);

            if (dai <= 0 || rong <= 0) {
                Toast.makeText(this, "Chiều dài và chiều rộng phải lớn hơn 0", Toast.LENGTH_SHORT).show();
                return;
            }


            double dienTich = dai * rong;

            tvKetQua.setText("Diện tích hình chữ nhật là: " + dienTich);
        } catch (Exception e) {
            Toast.makeText(this, "Lỗi nhập dữ liệu!", Toast.LENGTH_SHORT).show();
        }

    }
}