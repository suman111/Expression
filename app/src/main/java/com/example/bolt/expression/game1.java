package com.example.bolt.expression;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class game1 extends AppCompatActivity {

    public ImageView iv,home;
    public Button b1,b2,b3;
    public int c,bi,idx,ix;
    public String me,t;
    public int count=0,temp=1,entry;
    public TextView tv,level,right,wrong;
    public CardView cardView;
    private Animation shake;
    private MediaPlayer mediaPlayer,mp,wrongVoice;
    private ArrayList<Integer> sounds;


    //public obj o = new obj(R.drawable.anger1 , "anger1");
    //public obj ob = new obj(R.drawable.joy1, "JOY");
    public int[] bid={R.id.b1, R.id.b2,R.id.b3};
    public int[] rsid = {R.drawable.joy1, R.drawable.anger1, R.drawable.cry1, R.drawable.disgust1, R.drawable.sad1,R.drawable.satisfied1,R.drawable.smiling1,R.drawable.surprise1};
    public String[] name = { "ആനന്ദം" , "ദേഷ്യം" , "കരച്ചിൽ" , "വെറുപ്പ്" , "വിഷമം", "തൃപ്തി","പുഞ്ചിരി","അത്ഭുതം" };

    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> newItem = new ArrayList<String>();
    ArrayList<Button> buttonArray = new ArrayList<Button>();
    ArrayList<Integer> random_array = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);
        iv = (ImageView)findViewById(R.id.im);
        home = (ImageView) findViewById(R.id.home_id);
        level = (TextView) findViewById(R.id.levelNo_id);

        right = (TextView) findViewById(R.id.rightNo_id);
        wrong = (TextView) findViewById(R.id.wrongNo_id);

        cardView = (CardView)findViewById(R.id.card_view_bottom);
        mediaPlayer = MediaPlayer.create(this,R.raw.alternative_correct);
        wrongVoice = MediaPlayer.create(this, R.raw.wrong);
        shake = AnimationUtils.loadAnimation(this, R.anim.shake);
        cardView.setCardBackgroundColor(Color.TRANSPARENT);

        for(int i=0;i<8;i++){
            random_array.add(i);
        }



      /*  if(list.contains(me)){
            newItem=list;
            newItem.remove(me);
        }
        else{
            newItem=list;
        }*/

        createImg();


        iv.setBackgroundResource(c);


        b1=(Button)findViewById(R.id.b1);
        b2=(Button)findViewById(R.id.b2);
        b3=(Button)findViewById(R.id.b3);

        buttonArray.add(b1);
        buttonArray.add(b2);
        buttonArray.add(b3);
       // b1.setText(me);




        list.add("ആനന്ദം");
        list.add("ദേഷ്യം");
        list.add("കരച്ചിൽ");
        list.add("വെറുപ്പ്");
        list.add("വിഷമം");
        list.add("തൃപ്തി");
        list.add("പുഞ്ചിരി");
        list.add("അത്ഭുതം");

        sounds = new ArrayList<>();
        sounds.add(R.raw.correct1);
        sounds.add(R.raw.correct2);
        sounds.add(R.raw.correct3);
        sounds.add(R.raw.correct4);
        sounds.add(R.raw.correct5);
        sounds.add(R.raw.correct6);
        shuffle();


   /* if(newItem.size()!=0) {
    buttonArray.get(2).setText(me);
    buttonArray.get(1).setText(newItem.get(0));
    buttonArray.get(0).setText(newItem.get(1));
    newItem.add(me);
    }*/
        if ((newItem.size() != 0)&&(newItem.get(0)!=newItem.get(1))) {

            if((newItem.get(0)!=me)&&(newItem.get(1)!=me)) {

                buttonArray.get(2).setText(me);
                buttonArray.get(1).setText(newItem.get(0));
                buttonArray.get(0).setText(newItem.get(1));
               // newItem.add(me);

            }
        }



    }

    public void setHome(View view){

        SceneTracker.setCorrectedItem(0);
        SceneTracker.setWrongItem(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
    @Override
    public void onBackPressed() {

        SceneTracker.setCorrectedItem(0);
        SceneTracker.setWrongItem(0);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }



    public void clicked (View v) {


        cardView.setCardBackgroundColor(Color.TRANSPARENT);
        b1 = (Button) v;
        tv = (TextView) findViewById(R.id.t2);
        String buttonText = b1.getText().toString();


        if (entry == 0){

            //buttonText.equals(me)
            if (buttonText.equals(me)) {
                entry=1;

                if (cardView.getCardBackgroundColor() != ColorStateList.valueOf(Color.RED)) {

                    SceneTracker.setCorrectedItem((SceneTracker.getCorrectedItem() + 1));
                    right.setText(String.valueOf(SceneTracker.getCorrectedItem()));

                    if (temp == 10) {

                        v.startAnimation(shake);


                        cardView.setCardBackgroundColor(Color.GREEN);
                        new CountDownTimer(1000, 1000) {

                            @Override
                            public void onTick(long arg0) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFinish() {
                                cardView.setCardBackgroundColor(Color.TRANSPARENT);
                            }
                        }.start();

                      final Intent  intent = new Intent(this, nameGame.class);
                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {
                                int randomInt = (new Random().nextInt(sounds.size()));
                                int sound = sounds.get(randomInt);
                                mp = MediaPlayer.create(getApplicationContext(), sound);
                                mp.start();
                                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {


                                        startActivity(intent);
                                    }
                                });

                            }
                        });



                    } else {


                        newItem = list;

                        v.startAnimation(shake);

                        cardView.setCardBackgroundColor(Color.GREEN);
                        new CountDownTimer(1000, 1000) {

                            @Override
                            public void onTick(long arg0) {
                                // TODO Auto-generated method stub

                            }

                            @Override
                            public void onFinish() {
                                cardView.setCardBackgroundColor(Color.TRANSPARENT);
                            }
                        }.start();


                        mediaPlayer.start();
                        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                            @Override
                            public void onCompletion(MediaPlayer mp) {


                                int randomInt = (new Random().nextInt(sounds.size()));
                                int sound = sounds.get(randomInt);
                                mp = MediaPlayer.create(getApplicationContext(), sound);
                                mp.start();
                                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {


                                        createImg();
                                        entry=0;
                                        count += 10;
                                        String s = String.valueOf(count);
                                        temp++;
                                        level.setText(String.valueOf(temp));

                                        iv.setBackgroundResource(c);
                                        shuffle();

                                        Log.d("neItem", String.valueOf(list));


                                        Collections.shuffle(buttonArray);

                                        //cardView.setCardBackgroundColor(Color.GREEN);
                                        if (newItem.size() != 0) {

                                            buttonArray.get(2).setText(me);
                                            buttonArray.get(1).setText(newItem.get(0));
                                            buttonArray.get(0).setText(newItem.get(1));

                                            // newItem=list;
                                            // newItem.remove(0);


                                        }


                                        // cardView.setCardBackgroundColor(Color.TRANSPARENT);

                                        tv.setText(s);
                                        newItem.add(me);
                                        Log.d("neItem", String.valueOf(buttonArray));


                                    }
                                });


                            }
                        });

                    }
                }
            } else {
                if (cardView.getCardBackgroundColor() != ColorStateList.valueOf(Color.GREEN)) {
                    cardView.setCardBackgroundColor(Color.RED);
                    new CountDownTimer(1000, 500) {

                        @Override
                        public void onTick(long arg0) {
                            // TODO Auto-generated method stub

                        }

                        @Override
                        public void onFinish() {
                            cardView.setCardBackgroundColor(Color.TRANSPARENT);
                        }
                    }.start();


                    SceneTracker.setWrongItem((SceneTracker.getWrongItem() + 1));
                    wrong.setText(String.valueOf(SceneTracker.getWrongItem()));
                    wrongVoice.start();
                }
            }


    }
    }

    public void shuffle(){

        newItem=list;

        if(newItem.contains(me)){
            newItem.remove(me);
        }

      /*  if(newItem.isEmpty()){
            newItem=list;

            if(list.contains(me)){

                newItem.remove(me);
            }

        }*/

       if(list.contains(me)){

           newItem=list;
           newItem.remove(me);


       }
        Collections.shuffle(newItem);

    }


    public void createImg(){
        idx = new Random().nextInt(rsid.length);

        if(random_array.isEmpty()){
            for(int i=0;i<8;i++){
                random_array.add(i);
            }
        }

        Collections.shuffle(random_array);


        Log.d("Rondam",String.valueOf(random_array));

        c = rsid[random_array.get(0)];
        me = name[random_array.get(0)];

        random_array.remove(0);


    }

    private void playRandomSound() {
        int randomInt = (new Random().nextInt(sounds.size()));
        int sound = sounds.get(randomInt);
        mp = MediaPlayer.create(this, sound);
            mp.start();


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
