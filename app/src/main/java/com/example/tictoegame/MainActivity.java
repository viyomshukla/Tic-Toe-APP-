package com.example.tictoegame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 boolean IsRed=true;
 boolean IsStart=true;
 int[] visited={2,2,2,2,2,2,2,2,2};
 int [][]winning={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};


        public void ClickIn(View img){
            TextView winnerTextView = findViewById(R.id.winnerTextView);
            if(IsStart){

            ImageView counter=(ImageView)img; //counter->img
            int tag=Integer.parseInt(counter.getTag().toString());
            counter.setImageResource(R.drawable.red);
            if(IsRed){
                counter.setImageResource(R.drawable.red);
                IsRed=false;
                visited[tag]=1;
            }
            else {
                counter.setImageResource(R.drawable.yellow);
                IsRed=true;
                visited[tag]=0;
            }
            for (int []WinningPos:winning){
//             WinningPos[0]=0//3//6//....;
//             WinningPos[1]=1//4//7//...;
//             WinningPos[2]=2//5//8//...;
                if(visited[WinningPos[0]]==visited[WinningPos[1]] &&
                        visited[WinningPos[1]]==visited[WinningPos[2]]&& visited[WinningPos[0]]!=2)
                {
                    if(IsRed)   {
                        winnerTextView.setText("Yellow Win!!!");
                        winnerTextView.setVisibility(View.VISIBLE);
                        Toast.makeText(this, "Yellow Win!!!", Toast.LENGTH_SHORT).show();
                    }  else{
                        winnerTextView.setText("Red Win!!!");
                        winnerTextView.setVisibility(View.VISIBLE);
                        Toast.makeText(this, "Red wins", Toast.LENGTH_SHORT).show();
                    }
                    IsStart=false;

                }

            }



        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        TextView winnerTextView = findViewById (R.id.winnerTextView);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}