package clc65.phamgiakhiem.viduintent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent iNhanDuoc = getIntent();
        //2. Boc ra
        String intNhanDuoc = iNhanDuoc.getStringExtra("ht");
        //3. Xu ly
        //3.1 Set len TextView
        TextView tv_hienthi = findViewById(R.id.tv_hienthi);
        tv_hienthi.setText(intNhanDuoc);

        //4. Tao nut quay lai
        Button btn_return = findViewById(R.id.btn_return);
        btn_return.setOnClickListener(v -> {
            Intent iQuayLai = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(iQuayLai);
        });
    }
}