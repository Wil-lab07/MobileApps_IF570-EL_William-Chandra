package umn.ac.id;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AudioActivity extends AppCompatActivity {

    private TextView name;
    private TextView genre;
    private Button playBtn;
    private MediaPlayer player;
    private int Uri;
    private Toolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle(sumberAudio.getName());

        Uri = Integer.parseInt(sumberAudio.getAudioURI());
    }
    public void playSFX(View view){
        if (player == null) {
            player = MediaPlayer.create(this, Uri);
        }
        player.start();
    }
}