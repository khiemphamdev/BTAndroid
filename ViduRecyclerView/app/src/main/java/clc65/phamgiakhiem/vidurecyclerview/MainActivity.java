package clc65.phamgiakhiem.vidurecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LandScapeAdapter landScapeAdapter;
    ArrayList<LandScape> recyclerViewDatas;
    RecyclerView recyclerViewLandScape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // B1: Tạo model constructor, get, set các biến cho item
        // B2: Tạo layout, thiết kế bố cục cho item và đặt RecyclerView vào activity_main
        // B3: Tạo class Adapter, kế thừa lớp RecyclerView.Adapter (Qua lớp Adapter đọc tiếp)
        // B4: Khởi tạo và cài đặt tại main

        recyclerViewDatas = getDataForRecyclerView();

        // --B4.2: link Recycler
        recyclerViewLandScape = findViewById(R.id.recyclerLand);

        // --B4.3: Tạo layout manager để đặt bố cục cho Recycler
        RecyclerView.LayoutManager layoutLinear = new LinearLayoutManager(this);
        recyclerViewLandScape.setLayoutManager(layoutLinear);

        // --B4.4: Tạo Adapter gắn với nguồn dữ liệu
        landScapeAdapter = new LandScapeAdapter(this, recyclerViewDatas);

        // --B4.5: Gắn Adapter với Recycler
        recyclerViewLandScape.setAdapter(landScapeAdapter);
    }
    // --B4.1: Chuẩn bị dữ liệu cho landscapeList
    ArrayList<LandScape> getDataForRecyclerView(){
        ArrayList<LandScape> dsDuLieu = new ArrayList<LandScape>();
        LandScape landscape1 = new LandScape("nha_trang", "Nha Trang");
        dsDuLieu.add(landscape1);
        dsDuLieu.add(new LandScape("da_nang", "Đà Nẵng"));
        dsDuLieu.add(new LandScape("sai_gon", "Sài Gòn"));
        return dsDuLieu;
    }
}