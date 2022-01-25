package com.shia.practice111.fragments2;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.shia.practice111.R;

import java.util.concurrent.TimeUnit;

public class FragmentSeven extends Fragment {

    //mediaPlayer
    TextView textView1;
    Button button1, button2, button3, button4, button5, button6;
    MediaPlayer mediaPlayer;
    private int timeInt;

    //videoView1
    VideoView videoView1;
    private int videoPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seven, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        textView1 = view.findViewById(R.id.textView1);
        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);
        button4 = view.findViewById(R.id.button4);
        button5 = view.findViewById(R.id.button5);
        button6 = view.findViewById(R.id.button6);

        videoView1 = view.findViewById(R.id.videoView1);

        //mediaPlayer

        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getContext(), R.raw.watersound);
        }

        mediaPlayer.setLooping(true);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.start();

                Toast.makeText(getContext(), "The music is playing", Toast.LENGTH_SHORT).show();

                timeInt = mediaPlayer.getDuration();

                audioTime();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                Toast.makeText(getContext(), "The Music Paused", Toast.LENGTH_SHORT).show();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.stop();
                Toast.makeText(getContext(), "The Music Stoped", Toast.LENGTH_SHORT).show();
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.seekTo(20000);
                Toast.makeText(getContext(), "The Music went to The minutes 20", Toast.LENGTH_SHORT).show();
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){
                    textView1.setText("The music is playing");
                } else {
                    textView1.setText("The music is not Playing");
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeInt = mediaPlayer.getCurrentPosition();
                audioTime();
            }
        });

        //videoView1

        final MediaController controller = new MediaController(getContext());
        videoView1.setMediaController(controller);

        Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + R.raw.holakooii);
        videoView1.setVideoURI(videoUri);

        //Uri videoUri = Uri.parse("http://youtube.com");
        //videoView1.setVideoURI(videoUri);

        //videoView1.setVideoPath("http://youtube.com");

        videoView1.start();

        videoView1.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {

                        controller.setAnchorView(videoView1);

                        if (controller.isShowing()) {
                            //Do something
                        } else {
                            controller.show(3000);
                        }
                    }
                });
            }
        });

        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(getContext(), "The video Ended", Toast.LENGTH_SHORT).show();
            }
        });

        videoView1.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mediaPlayer, int i, int i1) {
                Toast.makeText(getContext(), "There is a Problem", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }

    //mediaPlayer

    private void audioTime() {
        String time = String.format("%02d min, %02d sec",
                TimeUnit.MILLISECONDS.toMinutes(timeInt),
                TimeUnit.MILLISECONDS.toSeconds(timeInt) -
                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeInt))
        );
        textView1.setText(time);
    }

    //videoView1

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("MyVideoPosition", videoView1.getCurrentPosition());
        videoView1.pause();
    }

    /*@Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        videoPosition = savedInstanceState.getInt("MyVideoPosition");
        videoView1.seekTo(videoPosition);
    }*/

    /*protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        videoPosition = savedInstanceState.getInt("MyVideoPosition");
        videoView1.seekTo(videoPosition);
    }*/
}