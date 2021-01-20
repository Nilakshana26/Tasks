package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[] ={"FaceBook","Whatsapp","Twitter","Instagram","YouTube"};
    String description[]={"FaceBook description","Whatsapp description","Twitter description","Instagram description","YouTube description"};
    int images[]={R.drawable.n3,R.drawable.n4,R.drawable.n2,R.drawable.n1,R.drawable.n5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        listView =findViewById(R.id.list_item);

        MyAdapter adapter =new MyAdapter( this,mTitle, description ,images);
        listView.setAdapter( adapter );

        listView.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position == 0 ){
                    Toast.makeText( MainActivity.this,"FaceBook Descroption",Toast.LENGTH_SHORT ).show();
                }
                if(position == 0 ){
                    Toast.makeText( MainActivity.this,"whatsapp Descroption",Toast.LENGTH_SHORT ).show();
                }
                if(position == 0 ){
                    Toast.makeText( MainActivity.this,"Twitter Descroption",Toast.LENGTH_SHORT ).show();
                }
                if(position == 0 ){
                    Toast.makeText( MainActivity.this,"Instagram Descroption",Toast.LENGTH_SHORT ).show();
                }
                if(position == 0 ){
                    Toast.makeText( MainActivity.this,"YouTube Descroption",Toast.LENGTH_SHORT ).show();
                }

            }
        } );
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int range[];

        MyAdapter(Context c, String title[], String description[], int range[]) {
            super( c, R.layout.row, R.id.textView1, title );
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.range = range;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater =(LayoutInflater)getApplicationContext().getSystemService( Context.LAYOUT_INFLATER_SERVICE);
            View row =layoutInflater.inflate( R.layout.row,parent,false );
            ImageView image = row.findViewById(R.id.image);
            TextView myTitle =row.findViewById( R.id.textView1 );
            TextView myDescription =row.findViewById( R.id.textView2 );

            image.setImageResource( range[position] );
            myTitle.setText( rTitle[position] );
            myDescription.setText( rDescription[position] );


            return row;
        }
    }

}