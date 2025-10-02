package clc65.phamgiakhiem.th_bai2_basicgui_bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtCanNang, edtChieuCao;
    CheckBox checkChauA;
    Button btnTinhBMI;
    TextView txtKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCanNang = findViewById(R.id.edtCanNang);
        edtChieuCao = findViewById(R.id.edtChieuCao);
        checkChauA = findViewById(R.id.checkChauA);
        btnTinhBMI = findViewById(R.id.btnTinhBMI);
        txtKetQua = findViewById(R.id.txtKetQua);

        btnTinhBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    double canNang = Double.parseDouble(edtCanNang.getText().toString());
                    double chieuCaoCm = Double.parseDouble(edtChieuCao.getText().toString());
                    double chieuCaoM = chieuCaoCm / 100.0;

                    if (chieuCaoM <= 0) {
                        txtKetQua.setText("Chiều cao phải lớn hơn 0!");
                        return;
                    }

                    double bmi = canNang / (chieuCaoM * chieuCaoM);
                    String danhGia;

                    if (checkChauA.isChecked()) {
                        // Chuẩn đánh giá BMI cho người Châu Á
                        if (bmi < 17.5) danhGia = "Gầy";
                        else if (bmi < 23) danhGia = "Bình thường";
                        else if (bmi < 28) danhGia = "Thừa cân";
                        else danhGia = "Béo phì";
                    } else {
                        // Chuẩn đánh giá của WHO (Thế giới)
                        if (bmi < 18.5) danhGia = "Gầy";
                        else if (bmi < 25) danhGia = "Bình thường";
                        else if (bmi < 30) danhGia = "Thừa cân";
                        else danhGia = "Béo phì";
                    }

                    txtKetQua.setText(String.format("BMI = %.2f\nĐánh giá: %s", bmi, danhGia));

                } catch (NumberFormatException e) {
                    txtKetQua.setText("Vui lòng nhập đúng định dạng số.");
                }
            }
        });
    }
}
