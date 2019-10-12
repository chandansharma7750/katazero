package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayers=0;

    int [] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
public   void dropin(View view){
    ImageView counter=(ImageView)view;

    int gettag=Integer.parseInt(counter.getTag().toString());
    if(gamestate[gettag]==2){
gamestate[gettag]= activeplayers;
    counter.setTranslationY(-1000f);

    if(activeplayers ==0) {
        counter.setImageResource(R.drawable.red);
        activeplayers = 1;
    } else {
        counter.setImageResource(R.drawable.yellow);
        activeplayers=0;
    }
    counter.animate().translationYBy(1000f).setDuration(300);
    }
    for(int [] winning:winning){

        if((gamestate[winning[0]]==gamestate[winning[1]])&&(gamestate[winning[1]]==gamestate[winning[2]])&&(gamestate[winning[0]]!=2)){
            String x="red";
            if (gamestate[winning[0]]==0){

                TextView tv=(TextView)findViewById(R.id.tv);
                LinearLayout linear=(LinearLayout)findViewById(R.id.linear);
                tv.setText("winner is "+x);
                linear.setVisibility(View.VISIBLE);


            }
            else if (gamestate[winning[0]]==1){
                x="yellow";
                TextView tv=(TextView)findViewById(R.id.tv);
                LinearLayout linear=(LinearLayout)findViewById(R.id.linear);
                tv.setText("winner is "+x);
                linear.setVisibility(View.VISIBLE);
            }


        }
        else{
            boolean game=true;
            for(int i:gamestate) {
                if (i == 2) {
                    game=false;
                }

                }
            if(game){
                TextView tv=(TextView)findViewById(R.id.tv);
                LinearLayout linear=(LinearLayout)findViewById(R.id.linear);
                tv.setText("GAME IS DRAW");
                linear.setVisibility(View.VISIBLE);
                }
            }


    }

}
public void playagain(View view){
    LinearLayout linear =(LinearLayout)findViewById(R.id.linear);
    linear.setVisibility(View.INVISIBLE);
    activeplayers=0;
    for(int i=0;i<gamestate.length;i++){
        gamestate[i]=2;
    }
    GridLayout gridview =(GridLayout)findViewById(R.id.gridview);
    for(int i=0;i<gridview.getChildCount();i++){
        ( (ImageView) gridview.getChildAt(i)).setImageResource(0);
    }

}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
