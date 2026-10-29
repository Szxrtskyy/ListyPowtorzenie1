package com.example.listypowtorzenie1;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String> owoceArrayList;
    ArrayAdapter<String> arrayAdapter;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);

        listView = findViewById(R.id.ListView);
        owoceArrayList = new ArrayList<>();
        owoceArrayList.add("Jabłko");
        owoceArrayList.add("Gruszka");
        owoceArrayList.add("Czereśnia");
        arrayAdapter = new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_list_item_1,
                owoceArrayList
        );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                        view.setBackgroundColor(Color.GRAY);
//                        Toast.makeText(MainActivity.this, owoceArrayList.get(i),
//                                Toast.LENGTH_SHORT).show();
//                        owoceArrayList.remove(i);
//                        arrayAdapter.notifyDataSetChanged();
                        //przekreślenie
                        TextView textView = (TextView) view;
                        if(textView.getPaintFlags() == Paint.STRIKE_THRU_TEXT_FLAG){
                            textView.setPaintFlags(Paint.CURSOR_AFTER);
                        }else {
                            textView.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
                        }

                    }
                }
        );

        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String owoc = editText.getText().toString();
                        owoceArrayList.add(owoc);
                        arrayAdapter.notifyDataSetChanged();
                    }
                }
        );


    }
}