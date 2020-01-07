package com.example.gjunspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1, sp2;
    AutoCompleteTextView actv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp1 = (Spinner) findViewById(R.id.spinner);
        sp2 = (Spinner) findViewById(R.id.spinner2);
        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, sp1.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String days[] = {"班別選擇", "早上班", "下午班", "晚上班", "假日班"};
        ArrayAdapter<String> AA = new ArrayAdapter<String>(MainActivity.this, R.layout.item, days);
        AA.setDropDownViewResource(R.layout.dropdown);
        sp2.setAdapter(AA);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 1:
                        Toast.makeText(MainActivity.this, "選擇"+days[1], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "選擇"+days[2], Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "選擇"+days[3], Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "選擇"+sp2.getItemAtPosition(4), Toast.LENGTH_SHORT).show();
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            String course[] = getResources().getStringArray(R.array.string_array_name);
            ArrayAdapter<String> aa = new ArrayAdapter<String>(MainActivity.this, R.layout.dropdown, course);
            actv.setAdapter(aa);

        }
}
