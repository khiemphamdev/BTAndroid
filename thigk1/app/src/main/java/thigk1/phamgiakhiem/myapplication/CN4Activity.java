package thigk1.phamgiakhiem.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CN4Activity extends AppCompatActivity {
    HoatDongAdapter hoatdongAdapter;
    Button btnBack;
    ArrayList<HoatDongModel> dsHoatDong;
    RecyclerView RecyclerViewHoatDong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cn4);
        EdgeToEdge.enable(this);
        btnBack = findViewById(R.id.bt_back);
        dsHoatDong = getData();
        RecyclerViewHoatDong = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        RecyclerViewHoatDong.setLayoutManager(layoutLinear);
        hoatdongAdapter = new HoatDongAdapter(this, dsHoatDong);
        RecyclerViewHoatDong.setAdapter(hoatdongAdapter);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CN4Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    ArrayList<HoatDongModel> getData(){
        ArrayList<HoatDongModel> dsDuLieu = new ArrayList<>();
        HoatDongModel hd1 = new HoatDongModel("Hoạt động 1", "nhatrang", "30/04/2025");
        HoatDongModel hd2 = new HoatDongModel("Hoạt động 2", "nhatrang", "30/04/2025");
        HoatDongModel hd3 = new HoatDongModel("Hoạt động 3", "nhatrang", "30/04/2025");
        HoatDongModel hd4 = new HoatDongModel("Hoạt động 4", "nhatrang", "30/04/2025");
        HoatDongModel hd5 = new HoatDongModel("Hoạt động 5", "nhatrang", "30/04/2025");
        HoatDongModel hd6 = new HoatDongModel("Hoạt động 5", "nhatrang", "30/04/2025");
        HoatDongModel hd7= new HoatDongModel("Hoạt động 5", "nhatrang", "30/04/2025");
        HoatDongModel hd8 = new HoatDongModel("Hoạt động 5", "nhatrang", "30/04/2025");

        dsDuLieu.add(hd1);
        dsDuLieu.add(hd2);
        dsDuLieu.add(hd3);
        dsDuLieu.add(hd4);
        dsDuLieu.add(hd5);
        dsDuLieu.add(hd6);
        dsDuLieu.add(hd7);
        dsDuLieu.add(hd8);
        return dsDuLieu;
    }
}