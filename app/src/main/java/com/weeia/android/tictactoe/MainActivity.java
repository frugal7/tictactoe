package com.weeia.android.tictactoe;

import android.support.v4.media.session.IMediaControllerCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public void reset(View view)
    {
        TextView overTxt = (TextView)findViewById(R.id.text);
        overTxt.setVisibility(View.GONE);
        for(int i = 0; i < 8; i++)
        {
            gameStatus[i] = 2;
        }
        ImageView x = (ImageView)findViewById(R.id.imageView4);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView6);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView7);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView8);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView9);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView10);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView11);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView12);
        x.setImageResource(0);
        x = (ImageView)findViewById(R.id.imageView13);
        x.setImageResource(0);
    }


    public boolean check()
    {
        for(int i = 0; i < 8; i++)
        {
            if( gameStatus[winningPositions[i][0]] == gameStatus[winningPositions[i][1]] &&
                gameStatus[winningPositions[i][0]] == gameStatus[winningPositions[i][2]] &&
                gameStatus[winningPositions[i][1]] == gameStatus[winningPositions[i][2]] &&
                gameStatus[winningPositions[i][0]] != 2)
            {
                return true;
            }
        }
        return false;
    }


    boolean user = true;
    int[] gameStatus = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };

    public void drop(View view)
    {
        ImageView counter = (ImageView) view;
        int position = Integer.parseInt(counter.getTag().toString());
        if(gameStatus[position] == 2)
        {
            counter.setTranslationY(-1000f);
            if(user)
            {
                counter.setImageResource(R.drawable.red);
                user = !user;
                gameStatus[position] = 1;
            }
            else
            {
                counter.setImageResource(R.drawable.yellow);
                user = !user;
                gameStatus[position] = 0;
            }
            counter.animate().translationYBy(1000f).rotation(360).setDuration(800);
            if(check())
            {
                System.out.println("Koniec gry!");
                for(int i = 0; i < 8; i++)
                {
                    gameStatus[i] = 1;
                }
               // Button reset = (Button)findViewById(R.id.reset);
                TextView overTxt = (TextView)findViewById(R.id.text);
                overTxt.setVisibility(View.VISIBLE);
                //reset.setVisibility(View.VISIBLE);

            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
