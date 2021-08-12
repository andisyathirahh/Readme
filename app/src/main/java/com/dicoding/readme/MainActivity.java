package com.dicoding.readme;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] sTitle = {"Bukan Salah Hujan",
            "Southern Eclipse",
            "Nanti Kita Cerita Tentang Hari Ini",
            "Garis Waktu",
            "Laskar Pelangi", "Kata",
            "Here, After", "Hujan", "Dilan 1990", "Seperti Hujan"};
    String[] sDetail = {"Buku Karya Ummu Amalia",
            "Buku Karya Asabelia Audida",
            "Buku Karya Marchella FP",
            "Buku Karya Fiersa Besari", "Buku Karya Andrea Hirata",
            "Buku Karya Rintik Sendu", "Buku Karya Mahir Pradana",
            "Buku Karya Tere Liye", "Buku Karya Pidi Baiq", "Buku Karya Boy Candra"};
    int[] images = {R.drawable.bsh, R.drawable.se, R.drawable.nkcthi, R.drawable.gw, R.drawable.lp, R.drawable.kat,
                    R.drawable.ha, R.drawable.hujan, R.drawable.dilan, R.drawable.sh};



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_item);

        MyAdapter adapter = new MyAdapter(this, sTitle, sDetail, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){

                 if (position == 0) {
                     Intent intent = new Intent(MainActivity.this, BshActivity.class);
                     startActivity(intent);
                }

                if (position == 1) {
                     Intent intent = new Intent(MainActivity.this, SeActivity.class);
                     startActivity(intent);
                }

                else if (position == 2) {
                    Intent intent = new Intent(MainActivity.this, NkcthiActivity.class);
                    startActivity(intent);
                }

                if (position == 3) {
                    Intent intent = new Intent(MainActivity.this, GwActivity.class);
                    startActivity(intent);
                }

                else if (position == 4) {
                    Intent intent = new Intent(MainActivity.this, LpActivity.class);
                    startActivity(intent);
                }

                else if (position == 5) {
                    Intent intent = new Intent(MainActivity.this, KataActivity.class);
                    startActivity(intent);
                }

                else if (position == 6) {
                    Intent intent = new Intent(MainActivity.this, HereActivity.class);
                    startActivity(intent);
                }

                else if (position == 7) {
                    Intent intent = new Intent(MainActivity.this, HujanActivity.class);
                    startActivity(intent);
                }

                else if (position == 8) {
                    Intent intent = new Intent(MainActivity.this, DilanActivity.class);
                    startActivity(intent);
                }

                else if (position == 9) {
                    Intent intent = new Intent(MainActivity.this, HujanActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_about, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.aboutMe:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String[] rTtitle;
        String[] rDetails;
        int[] rImages;

        MyAdapter (Context c, String[] title, String[] details, int[] images){
            super(c, R.layout.row, R.id.mainTitle, title);
            this.context = c;
            this.rTtitle = title;
            this.rDetails = details;
            this.rImages = images;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.action_image);
            TextView myTitle = row.findViewById(R.id.mainTitle);
            TextView myDetails = row.findViewById(R.id.subtitle);

            images.setImageResource(rImages[position]);
            myTitle.setText(rTtitle[position]);
            myDetails.setText(rDetails[position]);


            return row;
        }
    }
}
