package com.example.videoplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayerController extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, MediaPlayer.OnCompletionListener {

    VideoView mVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player_contoroller);

        mVideoView = findViewById(R.id.my_video_view);
        //URI به داده میرسیم
        //URL یک نو یو ار ای که فقط بیان کننده مکان قرار گیریه
        //URN بازم یک یو ار ای که یک نام منحصر به فرده
        mVideoView.setVideoURI(Uri.parse("https://www.dropbox.com/s/0x2ke57h7wv49ll/Sample_512x288.mp4"));
        mVideoView.setOnPreparedListener(this);
        mVideoView.setOnErrorListener(this);
        mVideoView.setOnCompletionListener(this);
        
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Toast.makeText(this, "there is problem", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        Toast.makeText(this, "complite", Toast.LENGTH_SHORT).show();
    }
}