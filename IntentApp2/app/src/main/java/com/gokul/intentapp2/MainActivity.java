package com.gokul.intentapp2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private final String Tag=getClass().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("View Gokul website");
        menu.add("View map");
        menu.add("Call a number");
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent=null;
        Uri uri;
        switch(item.toString()){
            case "View Gokul website":
                Log.d(Tag,"View Action");
                uri=Uri.parse("https://gokulnair.xyz");
                intent=new Intent(Intent.ACTION_VIEW,uri);
                break;
            case "View map":
                uri=Uri.parse(("geo:40.7113399,-74.0263469"));
                intent=new Intent(Intent.ACTION_VIEW,uri);
                break;
            case "Call a number":
                Log.d(Tag,"Call number");
                uri=Uri.parse(("tel:048729670128"));
                intent=new Intent(Intent.ACTION_CALL,uri);
        }
        startActivity(intent);
        return true;
    }
}