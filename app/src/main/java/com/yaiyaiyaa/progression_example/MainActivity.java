package com.yaiyaiyaa.progression_example;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.yaiyaiyaa.progression.Progression;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Button showLoader1;
    private Button showLoader2;
    private ProgressDialog progression1;
    private ProgressDialog progression2;
    private Button showLoader3;
    private ProgressDialog progression3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        initializeListeners();
    }

    private void initializeComponents() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        showLoader1 = (Button) findViewById(R.id.show_loader1);
        showLoader2 = (Button) findViewById(R.id.show_loader2);
        showLoader3 = (Button) findViewById(R.id.show_loader3);
        progression1 = Progression.initProgression(MainActivity.this, 1);
        progression2 = Progression.initProgression(MainActivity.this, 2);
        progression3 = Progression.initProgression(MainActivity.this, 3);
    }

    private void initializeListeners() {
        showLoader1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLoader1();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader1();
                            }
                        }, 3000);
                    }
                });
            }
        });

        showLoader2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoLoader2();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader2();
                            }
                        }, 3000);
                    }
                });
            }
        });

        showLoader3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoLoader3();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader3();
                            }
                        }, 3000);
                    }
                });
            }
        });
    }

    private void shoLoader3() {
        progression3.show();
    }

    private void hideLoader3() {
        if(progression3.isShowing())
            progression3.dismiss();
    }

    private void shoLoader2() {
        progression2.show();
    }

    private void hideLoader2() {
        if(progression2.isShowing())
            progression2.dismiss();
    }

    private void showLoader1() {
        progression1.show();
    }

    private void hideLoader1() {
        if(progression1.isShowing())
            progression1.dismiss();
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
