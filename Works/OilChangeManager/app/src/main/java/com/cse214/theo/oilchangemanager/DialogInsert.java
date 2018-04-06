package com.cse214.theo.oilchangemanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.cse214.theo.oilchangemanager.Car.Make.CHEVY;
import static com.cse214.theo.oilchangemanager.Car.Make.CHRYSLER;
import static com.cse214.theo.oilchangemanager.Car.Make.DODGE;
import static com.cse214.theo.oilchangemanager.Car.Make.FORD;
import static com.cse214.theo.oilchangemanager.Car.Make.GMC;
import static com.cse214.theo.oilchangemanager.Car.Make.JEEP;
import static com.cse214.theo.oilchangemanager.Car.Make.LINCOLN;
/**
 *  The activity class that takes Car owner's name and Make to insert before the cursor.
 *
 *  @author
 *    Theo Seo, SBU ID: 111319497
 *
 *    Homework #2 for CSE 214, fall 2017
 */


public class DialogInsert extends AppCompatActivity {

    /**
     * Array adapter for spinner.
     */
    private ArrayAdapter < String > spinnerArrayAdapter;

    /**
     * The options to be displayed on the spinner
     */
    private String[] spinnerArray = {
            "Select List",
            "FORD",
            "GMC",
            "CHEVY",
            "JEEP",
            "DODGE",
            "CHRYSLER",
            "LINCOLN"
    };


    /**
     * Called when the activity is starting. After receiving information of student's name and money, it sends them to the main activity intent.
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down. then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle)
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.dialog_insert);


        final EditText NAMETXT = (EditText) findViewById(R.id.insert_name);

        final Spinner SPINNER = (Spinner) findViewById(R.id.insert_spinner);

        spinnerArrayAdapter = new ArrayAdapter(this, R.layout.spinner_item, spinnerArray);

        SPINNER.setAdapter(spinnerArrayAdapter);

        SPINNER.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView < ? > parentView, View selectedItemView, int position, long id) {

                final int spinnerPosition = position;

                final Button CONFIRM = (Button) findViewById(R.id.inser_confirm);


                CONFIRM.setOnClickListener(
                        new View.OnClickListener() {
                            public void onClick(View view) {

                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                                if (NAMETXT.getText().toString().equals("")) {

                                    Toast.makeText(getBaseContext(), "Please Enter the information.", Toast.LENGTH_LONG).show();

                                    return;
                                }
                                String name = NAMETXT.getText().toString();
                                Car.Make make = null;
                                if (spinnerPosition != 0)
                                    switch (spinnerPosition) {
                                        case 1:
                                            make = FORD;
                                            break;
                                        case 2:
                                            make = GMC;
                                            break;
                                        case 3:
                                            make = CHEVY;
                                            break;
                                        case 4:
                                            make = JEEP;
                                            break;
                                        case 5:
                                            make = DODGE;
                                            break;
                                        case 6:
                                            make = CHRYSLER;
                                            break;
                                        case 7:
                                            make = LINCOLN;
                                            break;
                                    }

                                intent.putExtra("INSERTED_MAKE", make);

                                intent.putExtra("INSERTED_NAME", name);

                                setResult(RESULT_OK, intent);

                                finish();

                            }
                        });


            }

            @Override
            public void onNothingSelected(AdapterView < ? > parent) {

            }

        });

    };
}