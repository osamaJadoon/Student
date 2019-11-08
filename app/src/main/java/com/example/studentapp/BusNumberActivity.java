package com.example.studentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class BusNumberActivity extends AppCompatActivity {
    private EditText nextBusNumber;
    String bus1 = "1085";
    String bus2 = "1251";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_number);

        nextBusNumber = findViewById(R.id.next_editTx_id);

    }
    public void nextBtn(View view) {
        String busNumber = nextBusNumber.getText().toString().trim();

        if (busNumber.equals(bus1) || busNumber.equals(bus2))
        {

            Intent intent = new Intent(this,MapsActivityS.class);
            intent.putExtra("busNumber",busNumber);
            startActivity(intent);
            nextBusNumber.setText("");
        }
        else {
            Toasty.error(BusNumberActivity.this, "Wrong Bus Number", Toast.LENGTH_SHORT).show();
        }

    }
    //back press function start here

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("EXIT?")
                .setIcon(R.drawable.exit)
                .setMessage("Are u sure you want to exit")
                .setCancelable(false)
                .setPositiveButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finishAffinity();
                    }
                })
                .setNegativeButton("Stay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create().show();
    }

    //back press ends.....
}
