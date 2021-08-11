package com.example.homeworkseven;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().
                beginTransaction().
                replace(R.id.notes_container, com.example.homeworkseven.NotesFragment.newInstance()).
                commit();
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.description_container, FragmentDescription.newInstance(new Notes("text","text"))).
                    commit();
        }
    }
}