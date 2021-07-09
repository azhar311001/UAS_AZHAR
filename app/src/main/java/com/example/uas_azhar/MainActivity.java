package com.example.uas_azhar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputCode, inputJumlah;
    private Button btnBayar;
    private TextView code_buah, harga_buah, total_buah;

    private final Object[][] buah = {
            {"B01", "Apel", 3000},
            {"B02", "Jeruk", 2000},
            {"B03", "Semangka", 10000},
            {"B04", "Anggur", 15000},
            {"B05", "Mangga", 5000},
            {"B06", "Pepaya", 5000},
            {"B07", "Durian", 30000},
            {"B08", "Manggis", 4000},
            {"B09", "strowbery", 2000},
            {"B10", "Pisang", 10000}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buah);
    }
    public void pilih(View view) {
        setContentView(R.layout.data_buah);

    }
    public void input(View view) {
        setContentView(R.layout.hasil);

        inputCode = findViewById(R.id.etCodeBuah);
        inputJumlah = findViewById(R.id.etJumlahBuah);
        btnBayar = findViewById(R.id.btnKalkulasi);
        code_buah = findViewById(R.id.tvNama_Buah);
        harga_buah = findViewById(R.id.tvHarga_Buah);
        total_buah = findViewById(R.id.tvTotal_Harga);

        btnBayar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnKalkulasi) {
            String itemInput = inputCode.getText().toString().trim();
            String itemTotal = inputJumlah.getText().toString().trim();
            String itemCode = itemInput.substring(0,3);


            //nomor item array
            int i, noItem = 0;
            for (i = 0; i <10; i++) {
                if (itemCode.equals((buah[i][0].toString()))) {
                    noItem = i;
                    i = 10;
                }
            }

            //
            String itemName = buah[noItem][1].toString();
            String itemPrice = buah[noItem][2].toString();
            String totalPrice = String.valueOf(Integer.parseInt(itemPrice) * Integer.parseInt(itemTotal));

            code_buah.setText(itemName);
            harga_buah.setText(itemPrice);
            total_buah.setText(totalPrice);
        }
    }


}