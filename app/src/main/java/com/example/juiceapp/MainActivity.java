package com.example.juiceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // create variables

    private String lqnty = "";
    private String cqnty = "";
    private String mqnty = "";
    private String fqnty = "";
    private String oqnty = "";
    private String sqnty = "";

    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();
    private ArrayList<String> data4 = new ArrayList<String>();

    private TableLayout table;


    EditText ed1;

    CheckBox ch1, ch2, ch3, ch4, ch5, ch6;

    Button b1, b2, b3;

    AlertDialog.Builder builder;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // find view that was identified by the id

        ch1 = findViewById(R.id.chk1);
        ch2 = findViewById(R.id.chk2);
        ch3 = findViewById(R.id.chk3);
        ch4 = findViewById(R.id.chk4);
        ch5 = findViewById(R.id.chk5);
        ch6 = findViewById(R.id.chk6);


        ed1 = findViewById(R.id.txttot);

        b1 = findViewById(R.id.btn1);
        b2 = findViewById(R.id.btn2);
        b3 = findViewById(R.id.btn3);


        builder = new AlertDialog.Builder(this);



        // code for display total(refresh button)

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int sum = 0;
                for(int a=0; a< data4.size(); a++)
                {
                    sum = sum + Integer.parseInt(data4.get(a).toString());
                }

                ed1.setText(String.valueOf(sum));
            }
        });




        // code for reset button

       b3.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(ch1.isChecked())
                   ch1.setChecked(false);

               if(ch2.isChecked())
                   ch2.setChecked(false);

               if(ch3.isChecked())
                   ch3.setChecked(false);

               if(ch4.isChecked())
                   ch4.setChecked(false);

               if(ch5.isChecked())
                   ch5.setChecked(false);

               if(ch6.isChecked())
                   ch6.setChecked(false);

           }
       });



        // code for ADD button

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Sales();
            }
        });

    }



    // code for get user input and create bill and view table

    public void Sales()
    {
        if(ch1.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String lemon = ch1.getText().toString();

                    lqnty = input.getText().toString();

                    int lprice = 70;

                    int tot = lprice * Integer.parseInt(lqnty);

                    data1.add(lemon);
                    data2.add(String.valueOf(lqnty));
                    data3.add(String.valueOf(lprice));
                    data4.add(String.valueOf(tot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }

                });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
            }




        else if(ch2.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String cocoa = ch2.getText().toString();

                    cqnty = input.getText().toString();

                    int cprice = 50;

                    int tot = cprice * Integer.parseInt(cqnty);

                    data1.add(cocoa);
                    data2.add(String.valueOf(cqnty));
                    data3.add(String.valueOf(cprice));
                    data4.add(String.valueOf(tot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
        }





        else if(ch3.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String milkshake = ch3.getText().toString();

                    mqnty = input.getText().toString();

                    int mprice = 60;

                    int tot = mprice * Integer.parseInt(mqnty);

                    data1.add(milkshake);
                    data2.add(String.valueOf(mqnty));
                    data3.add(String.valueOf(mprice));
                    data4.add(String.valueOf(tot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
        }




        else if(ch4.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String fruit = ch4.getText().toString();

                    fqnty = input.getText().toString();

                    int fprice = 40;

                    int ftot = fprice * Integer.parseInt(fqnty);

                    data1.add(fruit);
                    data2.add(String.valueOf(fqnty));
                    data3.add(String.valueOf(fprice));
                    data4.add(String.valueOf(ftot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
        }





        else if(ch5.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String orange = ch5.getText().toString();

                    oqnty = input.getText().toString();

                    int oprice = 30;

                    int tot = oprice * Integer.parseInt(oqnty);

                    data1.add(orange);
                    data2.add(String.valueOf(oqnty));
                    data3.add(String.valueOf(oprice));
                    data4.add(String.valueOf(tot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
        }




        else if(ch6.isChecked())
        {
            final TableRow row = new TableRow(this);
            final TextView t1 = new TextView(this);
            final TextView t2 = new TextView(this);
            final TextView t3 = new TextView(this);
            final TextView t4 = new TextView(this);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Enter the Quantity");

            final EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_TEXT);
            builder.setView(input);

            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    String smoothie = ch6.getText().toString();

                    sqnty = input.getText().toString();

                    int sprice = 80;

                    int tot = sprice * Integer.parseInt(sqnty);

                    data1.add(smoothie);
                    data2.add(String.valueOf(sqnty));
                    data3.add(String.valueOf(sprice));
                    data4.add(String.valueOf(tot));
                    TableLayout table = (TableLayout) findViewById(R.id.tb1);

                    String total;

                    for (int i = 0; i < data1.size(); i++) {
                        String pname = data1.get(i);
                        String quantity = data2.get(i);
                        String price = data3.get(i);
                        total = data4.get(i);

                        t1.setText(pname);
                        t2.setText(quantity);
                        t3.setText(price);
                        t4.setText(total);
                    }

                    row.addView(t1);
                    row.addView(t2);
                    row.addView(t3);
                    row.addView(t4);
                    table.addView(row);

                }
            });

            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();

                }
            });

            builder.show();
        }


    }




    // code for navigation bar

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.data, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.it1)
        {
            Intent intent = new Intent(MainActivity.this,Database.class);
            startActivity(intent);
        }

        else if(id == R.id.it2)
        {
            builder.setTitle("Guide")
                    .setMessage("Mark the item and click the ADD button and then give quantity of item. Then details of item will display in database. After adding all item click the Refresh button. Then display total amount. At one time add one item. If you want to add new item then should you remove the mark of existing item. Use Reset button to remove the mark of item. If you want to add new bill then go back and log to application again. So store to you business details there have a database. In that enter name of customer, date and total amount of bill. Then in that database can add, update, delete, view database. delete mean delete by existing bill.")
                    .setCancelable(true)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

            builder.show();
        }

        return super.onOptionsItemSelected(item);
    }



}