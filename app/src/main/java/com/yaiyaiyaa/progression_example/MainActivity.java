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
    private Progression progression1;
    private Progression progression2;
    private Button showLoader3;
    private Progression progression3;
    private Button showLoader4;
    private Progression progression4;
    private Button showLoader5;
    private Progression progression5;
    private Button showLoader6;
    private Progression progression6;

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
        showLoader4 = (Button) findViewById(R.id.show_loader4);
        showLoader5 = (Button) findViewById(R.id.show_loader5);
        showLoader6 = (Button) findViewById(R.id.show_loader6);
        progression1 = Progression.initProgression(MainActivity.this, 1);
        progression2 = Progression.initProgression(MainActivity.this, 2);
        progression3 = Progression.initProgression(MainActivity.this, 3);
        progression4 = Progression.initProgression(MainActivity.this, 4);
        progression5 = Progression.initProgression(MainActivity.this, 4);
        progression6 = Progression.initProgression(MainActivity.this, 4);

        // set color for loader
        progression5.setColor(0xFFFFFFFF);

        // set loader text
        progression6.setColor(0xFFFFFFFF);
        progression6.setBackgroundColor(0xFF8fbe2c);
        progression6.setLoadingText("Loading.. Please Wait..");
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

        showLoader4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoLoader4();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader4();
                            }
                        }, 3000);
                    }
                });
            }
        });

        showLoader5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoLoader5();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader5();
                            }
                        }, 3000);
                    }
                });
            }
        });

        showLoader6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoLoader6();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                hideLoader6();
                            }
                        }, 3000);
                    }
                });
            }
        });
    }

    private void hideLoader6() {
        if(progression6.isShowing())
            progression6.dismiss();
    }

    private void shoLoader6() {
        progression6.show();
    }

    private void hideLoader5() {
        if(progression5.isShowing())
            progression5.dismiss();
    }

    private void shoLoader5() {
        progression5.show();
    }

    private void hideLoader4() {
        if(progression4.isShowing())
            progression4.dismiss();
    }

    private void shoLoader4() {
        progression4.show();
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
