package com.example.juiceapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    EditText id,tot, dat;
    Button ins, ups, del, vei;

    DBHelper db;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        id = findViewById(R.id.id);
        tot = findViewById(R.id.tot);
        dat = findViewById(R.id.dat);

        ins = findViewById(R.id.btnins);
        ups = findViewById(R.id.btnups);
        del = findViewById(R.id.btndel);
        vei = findViewById(R.id.btnvei);

        db = new DBHelper(this);



        // code for insert method

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = id.getText().toString();
                String date = dat.getText().toString();
                String amount = tot.getText().toString();


                Boolean check = db.insert(nameTXT, date,amount);
                if(check == true)
                {
                    Toast.makeText(Database.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Database.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });




        // code for update method

        ups.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = id.getText().toString();
                String date = dat.getText().toString();
                String amount = tot.getText().toString();


                Boolean check = db.update(nameTXT, date,amount);
                if(check == true)
                {
                    Toast.makeText(Database.this, "Entry Updated", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Database.this, "Entry Not Updated", Toast.LENGTH_SHORT).show();
                }

            }
        });



        // code for delete method

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameTXT = id.getText().toString();


                Boolean check = db.delete(nameTXT);
                if(check == true)
                {
                    Toast.makeText(Database.this, "Entry Deleted", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Database.this, "Entry Not Deleted", Toast.LENGTH_SHORT).show();
                }

            }
        });


        // code for view method

        vei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = db.getdata();
                if(res.getCount() ==0)
                {
                    Toast.makeText(Database.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext())
                {
                    buffer.append("Name : " +res.getString(0)+"\n");
                    buffer.append("Date : " +res.getString(1)+"\n");
                    buffer.append("Total Amount : " +res.getString(2)+"\n\n");
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(Database.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();


            }
        });






    }



}