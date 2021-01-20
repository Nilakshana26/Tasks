package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    String s1[],s2[];
    int image[]={R.drawable.t1,R.drawable.t2,R.drawable.t3,R.drawable.t4,R.drawable.t5,R.drawable.t6,R.drawable.t7,R.drawable.t8,R.drawable.t9,R.drawable.t10};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        recyclerView=findViewById( R.id.recycleView );

        s1=getResources().getStringArray( R.array.programming_languages );
        s2=getResources().getStringArray( R.array.description);

        MyAdapter myAdapter= new MyAdapter(  this,s1,s2, image);
        recyclerView.setAdapter( myAdapter );
        recyclerView.setLayoutManager( new LinearLayoutManager(this) );



    }
}