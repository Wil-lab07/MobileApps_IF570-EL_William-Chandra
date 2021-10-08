package umn.ac.id;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    DaftarAudioAdapter mAdapter;
    LinkedList<SumberAudio> daftarAudio = new LinkedList<>();
    RecyclerView rvDaftarAudio;
    private Toolbar toolbar;

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

        toolbar = findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_baseline_arrow_back_24));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        toolbar.setTitle(jawaban);
        toolbar.inflateMenu(R.menu.listening);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
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
                        return false;
                }
            }
        });

        Toast.makeText(getApplicationContext(), "Selamat Datang, " + jawaban, Toast.LENGTH_LONG).show();
    }

    public void isiDaftarAudio(){
        daftarAudio.add(new SumberAudio("Arcade Game Retro", "Game", Integer.toString(R.raw.arcade)));
        daftarAudio.add(new SumberAudio("Small Sweep", "Unknown", Integer.toString(R.raw.smallsweep)));
        daftarAudio.add(new SumberAudio("Emergency Alarm", "Game", Integer.toString(R.raw.emergencyalarm)));
        daftarAudio.add(new SumberAudio("Rain", "Lofi", Integer.toString(R.raw.rain)));
        daftarAudio.add(new SumberAudio("Small Sweep", "Unknown", Integer.toString(R.raw.smallsweep)));
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.listening, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.profile:
//                Intent profileActivity = new Intent(LibraryActivity.this, ProfileActivity.class);
//                startActivity(profileActivity);
//                return true;
//            case R.id.main:
//                Intent mainActivity = new Intent(LibraryActivity.this, MainActivity.class);
//                startActivity(mainActivity);
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

}