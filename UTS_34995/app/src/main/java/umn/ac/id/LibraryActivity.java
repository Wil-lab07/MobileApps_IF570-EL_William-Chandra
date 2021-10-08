package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    DaftarAudioAdapter mAdapter;
    LinkedList<SumberAudio> daftarAudio = new LinkedList<>();
    RecyclerView rvDaftarAudio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        rvDaftarAudio = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarAudioAdapter(this, daftarAudio);
        rvDaftarAudio.setAdapter(mAdapter);
        rvDaftarAudio.setLayoutManager(new LinearLayoutManager(this));

        isiDaftarAudio();

        Intent intentLibrary = getIntent();
        String jawaban = intentLibrary.getStringExtra("Message");
        setTitle(jawaban);

        Toast.makeText(getApplicationContext(), "Selamat Datang, " + jawaban, Toast.LENGTH_LONG).show();
    }

    public void isiDaftarAudio(){
        daftarAudio.add(new SumberAudio("Arcade Game Retro", "Game", Integer.toString(R.raw.arcade)));
        daftarAudio.add(new SumberAudio("Small Sweep", "Unknown", Integer.toString(R.raw.smallsweep)));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.listening, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profile:
                Intent profileActivity = new Intent(LibraryActivity.this, ProfileActivity.class);
                startActivity(profileActivity);
                return true;
            case R.id.main:
                Intent mainActivity = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(mainActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}