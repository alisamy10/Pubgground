package com.ali.pubgground.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ali.pubgground.R;
import com.ali.pubgground.data.model.Response;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    private MissionsViewModel viewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MissionsViewModel.class);
        viewModel.getMissions();
        viewModel.getMissionsList().observe(this, new Observer<Response>() {
            @Override
            public void onChanged(Response response) {
                Log.e("a",response.getData().get(0).getImage());
                Toast.makeText(MainActivity.this,response.getData().get(0).getTitle(),Toast.LENGTH_LONG).show();
            }
        });

    }
}