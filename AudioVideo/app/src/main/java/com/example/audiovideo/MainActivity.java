package com.example.audiovideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;
    boolean checkIfAudioIsPlaying = false;

    public void play(View view) {

        if (!checkIfAudioIsPlaying) {

            mediaPlayer.start();
            checkIfAudioIsPlaying = true;
            ((TextView) findViewById(R.id.buttonPlay)).setText("Pause");

        } else {

            mediaPlayer.pause();
            checkIfAudioIsPlaying = false;
            ((TextView) findViewById(R.id.buttonPlay)).setText("Play");

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        int currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.video2);
        MediaController mediaController = new MediaController(this);

        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        mediaPlayer = MediaPlayer.create(this, R.raw.careless);
        SeekBar volumeControl = (SeekBar) findViewById(R.id.seekBarVolumeControl);

        volumeControl.setMax(maxVolume);
        volumeControl.setProgress(currentVolume);

        volumeControl.setOnSeekBarChangeListener((new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i("SeekBar changed", Integer.toString(progress));
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        }));

        final SeekBar seekBarMusicControl = (SeekBar) findViewById(R.id.seekBarMusicControl);
        seekBarMusicControl.setMax(mediaPlayer.getDuration());

        seekBarMusicControl.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress2, boolean fromUser2) {
                mediaPlayer.seekTo(progress2);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                seekBarMusicControl.setProgress(mediaPlayer.getCurrentPosition());
            }
        }, 0, 300);
    }
}