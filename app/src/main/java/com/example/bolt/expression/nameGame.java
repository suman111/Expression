package com.example.bolt.expression;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class nameGame extends AppCompatActivity {
    TextView right,wrong,accuracy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_game);

        right = (TextView) findViewById(R.id.rightNo_id);
        wrong = (TextView) findViewById(R.id.wrongNo_id);
        accuracy = (TextView)findViewById(R.id.accuracyNo_id) ;

        wrong.setText(String.valueOf(SceneTracker.getWrongItem()));
        right.setText(String.valueOf(SceneTracker.getCorrectedItem()));
        int a = SceneTracker.getWrongItem();
        int b = SceneTracker.getCorrectedItem();
        int c = a+b;
        int x = (int) (((double) b / (double) c) * 100);
        accuracy.setText(String.valueOf(x));

    }





    public void startGame(View v ){

        SceneTracker.setCorrectedItem(0);
        SceneTracker.setWrongItem(0);
        Intent f = new Intent(nameGame.this , game1.class);
        startActivity(f);
    }
    public void setExit(View view){

        this.finishAffinity();
    }
    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
