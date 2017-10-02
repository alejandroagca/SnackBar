package com.example.snackbar;

import android.graphics.Color;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class SnackbarActivity extends AppCompatActivity implements View.OnClickListener{

    private Button show, change, parent;
    private CoordinatorLayout coordinatorLayout;
    private LinearLayout linearLayout;
    private Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);

        show = (Button) findViewById(R.id.btn1);
        show.setOnClickListener(this);
        change = (Button) findViewById(R.id.btn2);
        change.setOnClickListener(this);
        parent = (Button) findViewById(R.id.btn3);
        parent.setOnClickListener(this);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.cooLayout);
        linearLayout = (LinearLayout) findViewById(R.id.linParent);

    }

    View.OnClickListener snackbarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            snackbar.dismiss();
        }
    };

    @Override
    public void onClick(View view) {
        if(view == show) {
            Snackbar.make(coordinatorLayout, "Mensaje", Snackbar.LENGTH_SHORT).show();
        }
        else if(view == change){
            snackbar = Snackbar.make(coordinatorLayout, "Mensaje con otro color", Snackbar.LENGTH_INDEFINITE).setAction("Dismmiss", snackbarClickListener);
            snackbar.setActionTextColor(Color.CYAN);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(ContextCompat.getColor(SnackbarActivity.this, R.color.colorPrimaryDark));
            snackbar.show();
        }
        else if(view == parent){
            snackbar = Snackbar.make(linearLayout, "Mensaje en el linear layout", Snackbar.LENGTH_INDEFINITE).setAction("Dismmiss", snackbarClickListener);
            snackbar.setActionTextColor(Color.MAGENTA);
            View view1 = snackbar.getView();
            view1.setBackgroundColor(Color.GRAY);
            snackbar.show();
        }
    }
}
