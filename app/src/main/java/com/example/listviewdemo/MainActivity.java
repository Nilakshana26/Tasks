package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listView=(ListView)findViewById( R.id.listView );

        final ArrayList<String>arrayList =new ArrayList<>(  );

        arrayList.add("android");
        arrayList.add("is");
        arrayList.add("great");
        arrayList.add("and I love it");
        arrayList.add("It");
        arrayList.add("is");
        arrayList.add("better");
        arrayList.add("than");
        arrayList.add("many");
        arrayList.add("other");
        arrayList.add("operating system");
        arrayList.add("android");
        arrayList.add("is");
        arrayList.add("great");
        arrayList.add("and I love it");
        arrayList.add("It");
        arrayList.add("is");
        arrayList.add("better");
        arrayList.add("than");
        arrayList.add("many");
        arrayList.add("other");
        arrayList.add("operating system");

        ArrayAdapter arrayAdapter=new ArrayAdapter( this,android.R.layout.simple_list_item_1,arrayList );

        listView.setAdapter( arrayAdapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,"Clicked item :"+i+" " +arrayList.get( i ).toString(),Toast.LENGTH_SHORT).show();
                

            }
        } );

    }
}