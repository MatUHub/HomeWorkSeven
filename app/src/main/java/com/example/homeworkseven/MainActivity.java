package com.example.homeworkseven;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import static android.widget.Toast.LENGTH_LONG;

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
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            NavigationView navigationView = findViewById(R.id.nav_view);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem item) {
                    switch (item.getItemId()){
                        case R.id.action_setting:
                            Toast toast1 = Toast.makeText(getApplicationContext(),
                                    "Запуск настроек", Toast.LENGTH_SHORT);
                            toast1.show();
                            break;

                        case R.id.action_about_application:
                            Toast toast2 = Toast.makeText(getApplicationContext(),
                                    "Информация о приложении", Toast.LENGTH_SHORT);
                            toast2.show();
                            break;

                    }
                    return false;
                }
            });

        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
switch (item.getItemId()){
    case R.id.action_setting:
        Toast toast1 = Toast.makeText(getApplicationContext(),
                "Запуск настроек", Toast.LENGTH_SHORT);
        toast1.show();
        break;

    case R.id.action_about_application:
        Toast toast2 = Toast.makeText(getApplicationContext(),
                "Информация о приложении", Toast.LENGTH_SHORT);
        toast2.show();
        break;

}
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }
}