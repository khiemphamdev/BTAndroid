package clc65.phamgiakhiem.vidulistview;

import static android.widget.Toast.makeText;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv_lstPlane;
    ArrayList<String> lstPlane = new ArrayList<String>();
    ArrayAdapter<String> planeAdapter;
    void timDK() {
        lv_lstPlane = (ListView) findViewById(R.id.lv_lstPlane);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        timDK();

        lstPlane = getData();
        planeAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstPlane);
        lv_lstPlane.setAdapter(planeAdapter);

        lv_lstPlane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = lstPlane.get(position);
                String thongBao = "Bạn đã chọn máy bay: " + item;
                Toast.makeText(MainActivity.this, thongBao, Toast.LENGTH_SHORT).show();
            }
        });

    }

    ArrayList<String> getData() {
        ArrayList<String> data = new ArrayList<String>();
        data.add("Airbus");
        data.add("Boeing");
        data.add("Cessna");
        data.add("Fokker");
        data.add("Tupolev");
        data.add("Airbus A320");
        data.add("Boeing B787");

        return data;
    }
}