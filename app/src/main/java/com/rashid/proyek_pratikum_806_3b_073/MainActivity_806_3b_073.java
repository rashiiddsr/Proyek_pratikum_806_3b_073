package com.rashid.proyek_pratikum_806_3b_073;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity_806_3b_073 extends AppCompatActivity {
    EditText tahun;
    TextView output;
    Button proses, batal, keluar;
    Integer inputTahun;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_806_3b_073);
        tahun = findViewById(R.id.tahun);
        proses = findViewById(R.id.hitung);
        batal = findViewById(R.id.clear);
        keluar = findViewById(R.id.keluar);
        output = findViewById(R.id.output);

        keluar.setOnClickListener(v -> finish());
        batal.setOnClickListener(v -> {
            if (tahun.getText().toString().isEmpty()) {
                Toast.makeText(this, "Already Clear, DON'T SPAM!!!", Toast.LENGTH_SHORT).show();
                return;
            }
            tahun.setText(null);
        });
        proses.setOnClickListener(v -> {
            if (tahun.getText().toString().isEmpty()) {
                tahun.setError("Mohon masukkan tahun");
                return;
            }
            if (tahun.getText().toString().length() > 6) {
                tahun.setError("Mohon masukkan tahun yang valid");
                return;
            }
            inputTahun = Integer.parseInt(tahun.getText().toString());
            if (inputTahun % 400 == 0 || inputTahun % 4 == 0) {
                output.setText("Tahun " + inputTahun + " Merupakan Tahun Kabisat");
            } else {
                output.setText("Tahun " + inputTahun + " Bukan Tahun Kabisat");
            }
        });
    }

}