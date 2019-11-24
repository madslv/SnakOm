package com.example.myapp9.TagSnakken;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp9.Questions.DrommeQActivity;
import com.example.myapp9.Questions.MemoryQActivity;
import com.example.myapp9.Questions.MindesammenQActivity;
import com.example.myapp9.Questions.OrganQActivity;
import com.example.myapp9.Questions.SongQActivity;
import com.example.myapp9.Questions.TankenQActivity;
import com.example.myapp9.R;

import java.util.ArrayList;

public class TagSnakkenActivity extends AppCompatActivity implements SpgAdapter.OnListItemClickListener {

    RecyclerView mSpgList;
    RecyclerView.Adapter mSpgAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_snakken);

        //Create ListView start
        mSpgList = findViewById(R.id.rv);
        mSpgList.hasFixedSize();
        mSpgList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Spg> spgs = new ArrayList<>();
        spgs.add(new Spg("Sange", R.drawable.sange));
        spgs.add(new Spg("Mindesammenkomst", R.drawable.oel));
        spgs.add(new Spg("Organdonation", R.drawable.krop));
        spgs.add(new Spg("Minder", R.drawable.kasse));
        spgs.add(new Spg("Tanker om døden", R.drawable.dame));
        spgs.add(new Spg("Drømme og ønsker", R.drawable.ark));

        mSpgAdapter = new SpgAdapter(spgs, this);
        mSpgList.setAdapter(mSpgAdapter);

    }

    public void onListItemClick(int clickedItemIndex) {
        int SpgNumber = clickedItemIndex + 1;
        Toast.makeText(this, "Spørgsmåls nummer: " + SpgNumber, Toast.LENGTH_SHORT).show();

        int id = clickedItemIndex;
        if (id == 0) {
            Intent intent = new Intent(this, SongQActivity.class);
            startActivity(intent);
        }
        if (id == 1) {
            Intent intent = new Intent(this, MindesammenQActivity.class);
            startActivity(intent);
        }
        if (id == 2) {
            Intent intent = new Intent(this, OrganQActivity.class);
            startActivity(intent);
        }
        if (id == 3) {
            Intent intent = new Intent(this, MemoryQActivity.class);
            startActivity(intent);
        }
        if (id == 4) {
            Intent intent = new Intent(this, TankenQActivity.class);
            startActivity(intent);
        }
        if (id == 5) {
            Intent intent = new Intent(this, DrommeQActivity.class);
            startActivity(intent);
        }
    }
}