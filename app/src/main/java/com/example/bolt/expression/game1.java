package com.example.bolt.expression;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class game1 extends AppCompatActivity {

    public ImageView iv;
    public Button b1,b2,b3;
    public int c,bi,idx,ix;
    public String me,t;
    public int count=0;
    public TextView tv;

    //public obj o = new obj(R.drawable.anger , "anger");
    //public obj ob = new obj(R.drawable.joy, "JOY");
    public int[] bid={R.id.b1, R.id.b2,R.id.b3};
    public int[] rsid = {R.drawable.joy , R.drawable.anger, R.drawable.fear , R.drawable.disgust , R.drawable.sad};
    public String[] name = { "JOY" , "ANGER" , "FEAR" , "DISGUST" , "SAD" };

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> newItem = new ArrayList<String>();
    ArrayList<Button> buttonArray = new ArrayList<Button>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        iv = (ImageView)findViewById(R.id.im);
        createImg();
        iv.setBackgroundResource(c);


        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        buttonArray.add(b1);
        buttonArray.add(b2);
        buttonArray.add(b3);
        b1.setText(me);

        list.add("JOY");
        list.add("ANGER");
        list.add("FEAR");
        list.add("DISGUST");
        list.add("SAD");



    }

    public void clicked (View v) {

        b1 =(Button)v;
        tv =(TextView)findViewById(R.id.t2);
        String buttonText = b1.getText().toString();


        //buttonText.equals(me)
        if(buttonText.equals(me)) {

            createImg();

            count+=10;
            String s = String.valueOf(count);
            iv.setBackgroundResource(c);
             shuffle();

            Log.d("neItem", String.valueOf(list));


            Collections.shuffle(buttonArray);


            buttonArray.get(2).setText(me);
            buttonArray.get(1).setText(newItem.get(0));
            buttonArray.get(0).setText(newItem.get(1));



            tv.setText(s);
            newItem.add(me);
            Log.d("neItem", String.valueOf(buttonArray));



        }

    }

    public void shuffle(){

       if(list.contains(me)){

           newItem=list;
           newItem.remove(me);


       }
        Collections.shuffle(newItem);

    }


    public void createImg(){
        idx = new Random().nextInt(rsid.length);

        c = rsid[idx];
        me = name[idx];

    }

/*    private int generateRandomNumber() {
        Random rand=new Random();
        int[] randNo = new int[rsid.length];
        ArrayList numbers = new ArrayList();
        for (int k=0 ; k < 8; k++) {
            rnd = rand.nextInt(5) + 1;
            if(k==0) {
                randNo[0] = rnd;
                numbers.add(randNo[0]);
            } else {
                while(numbers.contains(new Integer(rnd))) {
                    rnd = rand.nextInt(5) + 1;
                }
                randNo[k] = rnd;
                numbers.add(randNo[k]);
            }
        }
      return rnd;
    }*/

    public String getName(){
        idx = new Random().nextInt(name.length);

        return name[idx];
    }

    public void buttonSel(){
        ix = new Random().nextInt(bid.length);
      // Collections.shuffle(Arrays.asList(bid));

          bi = bid[ix];

    }

    /*public void buttonset(){
        buttonSel();
        String t="",t1="";
        b1=(Button)findViewById(bi);
        b1.setText(me);
        for(int q= 0;q<3;q++){
            while (bid[q]!=bi){
                t = getName();
                if(!t.equals(me) && !t.equals(t1)){
                    b1=(Button)findViewById(bid[q]);
                    b1.setText(t);
                    t1=t;
                }
            }
        }
    }*/

}
