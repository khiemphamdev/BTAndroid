package thigk1.phamgiakhiem.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class DSVatLieuActivity extends AppCompatActivity {
    ListView lv_dsVatLieu;
    Button btnBack;
    ArrayList<String> dsVatLieu = new ArrayList<String>();
    ArrayAdapter<String> dsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsvat_lieu);
        lv_dsVatLieu = findViewById(R.id.lv_dsVatLieu);
        btnBack = findViewById(R.id.bt_back);
        dsVatLieu = getData ();

        dsAdapter = new ArrayAdapter<>(this, R.layout.item_vat_lieu, dsVatLieu);

        lv_dsVatLieu.setAdapter(dsAdapter);

        lv_dsVatLieu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String VatLieu = dsAdapter.getItem(position).toString();
                Toast.makeText(DSVatLieuActivity.this, "Vật liệu được chọn:" + VatLieu, Toast.LENGTH_LONG).show();
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DSVatLieuActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    ArrayList<String> getData() {
        ArrayList<String> dsVatLieu = new ArrayList<String>();
        dsVatLieu.add("Sắt");
        dsVatLieu.add("Gạch");
        dsVatLieu.add("Đá ốp lát");
        dsVatLieu.add("Ống nhựa");
        dsVatLieu.add("Sơn chống thấm");

        return  dsVatLieu;
    }
}