package com.example.sepactionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    TextView count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_action_bar, menu);
        MenuItem item=menu.findItem(R.id.app_bar_search);

        SearchView searchView = (SearchView)item.getActionView();
        searchView.setQueryHint("Search People");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this,query,Toast.LENGTH_LONG).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.add:
                count=findViewById(R.id.info);
                count.setText("Add is clicked");
                return(true);
            case R.id.reset:
                count=findViewById(R.id.info);
                count.setText("Nothing is selected");
                return(true);
            
            case R.id.none:       return true;
            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_LONG).show();
                return(true);
            case R.id.exit:
                finish();
                return(true);


        }
        return(super.onOptionsItemSelected(item));
    }
}