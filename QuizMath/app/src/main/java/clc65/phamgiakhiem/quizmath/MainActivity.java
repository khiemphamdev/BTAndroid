package clc65.phamgiakhiem.quizmath;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ArrayList<CauHoiHaiSo> dsCauHoi;
    Button nut1, nut2, nut3, nut4, btnNext;
    TextView textViewLoiHoi, txtSoCau;


    int chiSoCauHoi = 0;
    int diem = 0;
    boolean daTraLoi = false;
    CauHoiHaiSo cauHoi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Gắn view
        textViewLoiHoi = findViewById(R.id.textView2);
        nut1 = findViewById(R.id.button1);
        nut2 = findViewById(R.id.button2);
        nut3 = findViewById(R.id.button3);
        nut4 = findViewById(R.id.button4);
        btnNext = findViewById(R.id.buttonNext);
        btnNext.setEnabled(false);
        txtSoCau = findViewById(R.id.txtSoCau);

        // Tạo danh sách câu hỏi
        dsCauHoi = new ArrayList<>();
        dsCauHoi.add(new CauHoiHaiSo(1, "1 + 1", 2, 3, 4, 5));
        dsCauHoi.add(new CauHoiHaiSo(2, "10 + 1", 11, 13, 42, 15));
        dsCauHoi.add(new CauHoiHaiSo(3, "10 + 90", 100, 103, 102, 95));
        dsCauHoi.add(new CauHoiHaiSo(4, "7 x 5", 35, 25, 45, 30));
        dsCauHoi.add(new CauHoiHaiSo(5, "9 - 4", 5, 3, 4, 6));

        // Hiển thị câu đầu tiên
        hienThiCauHoi(dsCauHoi.get(chiSoCauHoi));

        // Gán sự kiện cho nút đáp án
        nut1.setOnClickListener(v -> kiemTraDapAn(nut1));
        nut2.setOnClickListener(v -> kiemTraDapAn(nut2));
        nut3.setOnClickListener(v -> kiemTraDapAn(nut3));
        nut4.setOnClickListener(v -> kiemTraDapAn(nut4));

        // Nút tiếp theo
        btnNext.setOnClickListener(v -> {
            if (!daTraLoi) return;

            chiSoCauHoi++;
            if (chiSoCauHoi >= dsCauHoi.size()) {
                // Hiển thị điểm
                txtSoCau.setVisibility(View.GONE);
                textViewLoiHoi.setText("Bạn đã hoàn thành! Điểm của bạn: " + diem + "/" + dsCauHoi.size());
                nut1.setVisibility(View.GONE);
                nut2.setVisibility(View.GONE);
                nut3.setVisibility(View.GONE);
                nut4.setVisibility(View.GONE);
                btnNext.setVisibility(View.GONE);
            } else {
                hienThiCauHoi(dsCauHoi.get(chiSoCauHoi));
            }
        });
    }

    private void hienThiCauHoi(CauHoiHaiSo cauHoiMoi) {
        cauHoi = cauHoiMoi;
        daTraLoi = false;
        btnNext.setEnabled(false);
        txtSoCau.setText("Câu " + (chiSoCauHoi + 1) + "/" + dsCauHoi.size());
        textViewLoiHoi.setText(cauHoi.getLoiHoi());
        nut1.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        nut2.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        nut3.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        nut4.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
        // Trộn các đáp án
        ArrayList<Integer> dsDapAn = new ArrayList<>();
        dsDapAn.add(cauHoi.getDaDung());
        dsDapAn.add(cauHoi.getSai1());
        dsDapAn.add(cauHoi.getSai2());
        dsDapAn.add(cauHoi.getSai3());
        Collections.shuffle(dsDapAn);

        // Gán text vào nút
        nut1.setText(String.valueOf(dsDapAn.get(0)));
        nut2.setText(String.valueOf(dsDapAn.get(1)));
        nut3.setText(String.valueOf(dsDapAn.get(2)));
        nut4.setText(String.valueOf(dsDapAn.get(3)));
    }

    private void kiemTraDapAn(Button nutDuocChon) {
        if (daTraLoi) return;

        int dapAnNguoiDung = Integer.parseInt(nutDuocChon.getText().toString());
        int dapAnDung = cauHoi.getDaDung();

        if (dapAnNguoiDung == dapAnDung) {
            diem++;
            nutDuocChon.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));

        } else {
            nutDuocChon.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
        }

        daTraLoi = true;
        btnNext.setEnabled(true);
    }

}
