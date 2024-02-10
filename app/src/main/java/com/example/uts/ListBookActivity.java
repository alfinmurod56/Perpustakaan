// .:: Veno Setyoaji Wiratama ::.//
// .::        311910363       ::.//
// .::        TI.19.A.2       ::.//

package com.example.uts;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.uts.adapters.CustomCursorAdapter;
import com.example.uts.adapters.DBHelper2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListBookActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView Is;
    DBHelper2 dbHelper2;
    int listData;
    SharedPreferences viewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_book);
        this.setTitle("PERPUSTAKAAN");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ListBookActivity.this, AddActivity.class));
            }
        });

        dbHelper2 = new DBHelper2(this);
        Is = (ListView)findViewById(R.id.list_buku);
        Is.setOnItemClickListener(this);

        viewData = getSharedPreferences("currentListView", 0);
        listData = viewData.getInt("currentListView", 0);

        allData();
    }

    public void allData(){
        Cursor cursor = dbHelper2.allData();
        CustomCursorAdapter customCursorAdapter = new CustomCursorAdapter(this, cursor, 1);
        Is.setAdapter(customCursorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout){
            Toast.makeText(ListBookActivity.this, "Logout Berhasil!", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(ListBookActivity.this, LoginActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long I) {
            TextView getID = (TextView)view.findViewById(R.id.listID);
            final long id = Long.parseLong(getID.getText().toString());
            Cursor cur = dbHelper2.oneData(id);
            cur.moveToFirst();

            Intent idBuku = new Intent(ListBookActivity.this, AddActivity.class);
            idBuku.putExtra(DBHelper2.row_id,id);
            startActivity(idBuku);
    }

    @Override
    protected void onResume() {
        super.onResume();
        allData();
    }
}