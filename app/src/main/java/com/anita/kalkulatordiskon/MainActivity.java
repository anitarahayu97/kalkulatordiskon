package com.anita.kalkulatordiskon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtHargaAsli,edtDiskon;
    Button btnHitung;
    TextView tvHargaDiskon,tvHemat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtHargaAsli = findViewById(R.id.editHargaAsli);
        edtDiskon = findViewById(R.id.editDiskon);
        btnHitung = findViewById(R.id.btnHitung);
        tvHargaDiskon = findViewById(R.id.tvHargaDiskon);
        tvHemat = findViewById(R.id.tvHemat);
        btnHitung.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnHitung){
            String strHargaAsli = edtHargaAsli.getText().toString().trim();
            String strDiskon = edtDiskon.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(strHargaAsli)) {
                isEmptyFields = true;
                edtHargaAsli.setError("isi dulu harga asli");

            }
            if (TextUtils.isEmpty(strDiskon)) {
                isEmptyFields = true;
                edtHargaAsli.setError("isi dulu diskon");
            }
            if (!isEmptyFields) {
                Integer hargaAsli = Integer.valueOf(strHargaAsli);
                double diskon = Double.parseDouble(strDiskon);
                // rumus hitung diskon => harga * (diskon / 100)
                Integer hemat = (int) (hargaAsli * (diskon/100));
                Integer hargaDiskon = hargaAsli - hemat;
                tvHargaDiskon.setText("Harga Setelah Diskon : Rp. "+hargaDiskon);
                tvHemat.setText("Hemat : Rp. "+hemat);
            }




        }
    }
}
