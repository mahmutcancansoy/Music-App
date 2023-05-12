package com.mcc.mymusicapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageButton btn_play, btn_pause, btn_stop, turn_back_btn;



MediaPlayer player=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_player_page);


        btn_play=(ImageButton) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);

        btn_pause=(ImageButton) findViewById(R.id.btn_pause);
        btn_pause.setOnClickListener(this);

        btn_stop=(ImageButton) findViewById(R.id.btn_stop);
        btn_stop.setOnClickListener(this);

        turn_back_btn=(ImageButton)findViewById(R.id.turn_back_btn);
        turn_back_btn.setOnClickListener(this);
        player = MediaPlayer.create(this, R.raw.outoftime);



        back_transection();
        turn_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_trn = new Intent(getApplicationContext(),LoginPage.class);
                startActivity(back_trn);
            }
        });
    }
    public void back_transection(){
        turn_back_btn=findViewById(R.id.turn_back_btn);
    }

    @Override
    public void onClick(View view){
    if (player==null)
    {
        player = MediaPlayer.create(this, R.raw.outoftime);
    }
        if (player != null) {
            if (view.getId()==btn_play.getId())
            {
                if (!player.isPlaying())
                {
                    player.start();
                }
                Toast.makeText(this,"Music started",Toast.LENGTH_SHORT).show();
            }
            else
            if (view.getId()==btn_pause.getId())
            {
                player.pause();
                Toast.makeText(this,"Music paused",Toast.LENGTH_SHORT).show();
            }
            else
            if (view.getId()==btn_stop.getId())
            {
                try {

                    if (player.isPlaying())
                    {
                        player.stop();
                        Toast.makeText(this,"Music stoped",Toast.LENGTH_SHORT).show();
                    }
                        player.reset();
                        player.release();
                        player = null;

                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}