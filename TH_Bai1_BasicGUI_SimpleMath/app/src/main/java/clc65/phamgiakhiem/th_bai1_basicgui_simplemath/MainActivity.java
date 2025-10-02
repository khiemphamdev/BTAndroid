package clc65.phamgiakhiem.th_bai1_basicgui_simplemath;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText soA, soB;
    RadioGroup groupPhepToan;
    Button nutTinh;
    TextView textKetQua;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        soA = findViewById(R.id.soA);
        soB = findViewById(R.id.soB);
        groupPhepToan = findViewById(R.id.groupPhepToan);
        nutTinh = findViewById(R.id.nutTinh);
        textKetQua = findViewById(R.id.textKetQua);

        nutTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    double a = Double.parseDouble(soA.getText().toString());
                    double b = Double.parseDouble(soB.getText().toString());
                    double kq = 0;

                    int selectedId = groupPhepToan.getCheckedRadioButtonId();

                    if (selectedId == R.id.cong) {
                        kq = a + b;
                    } else if (selectedId == R.id.tru) {
                        kq = a - b;
                    } else if (selectedId == R.id.nhan) {
                        kq = a * b;
                    } else if (selectedId == R.id.chia) {
                        if (b == 0) {
                            textKetQua.setText("Lỗi: Không thể chia cho 0");
                            return;
                        }
                        kq = a / b;
                    } else {
                        textKetQua.setText("Vui lòng chọn phép toán");
                        return;
                    }

                    textKetQua.setText("Kết quả: " + kq);

                } catch (NumberFormatException e) {
                    textKetQua.setText("Vui lòng nhập đúng định dạng số");
                }
            }
        });
    }
}
