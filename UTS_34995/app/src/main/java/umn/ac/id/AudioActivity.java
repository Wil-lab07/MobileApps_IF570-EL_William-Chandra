package umn.ac.id;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AudioActivity extends AppCompatActivity {

    private TextView name;
    private TextView genre;
    private Button playBtn;
    private MediaPlayer player;
    private int Uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        name = (TextView) findViewById(R.id.name);
        genre = (TextView) findViewById(R.id.genre);
        playBtn = (Button) findViewById(R.id.playBtn);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberAudio sumberAudio = (SumberAudio) bundle.getSerializable("AudioActivity");
        name.setText(sumberAudio.getName());
        genre.setText(sumberAudio.getGenre());
        setTitle(sumberAudio.getName());

        Uri = Integer.parseInt(sumberAudio.getAudioURI());
    }
    public void playSFX(View view){
        if (player == null) {
            player = MediaPlayer.create(this, Uri);
        }
        player.start();
    }
}