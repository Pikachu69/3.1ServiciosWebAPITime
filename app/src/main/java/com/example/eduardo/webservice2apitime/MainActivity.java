package com.example.eduardo.webservice2apitime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView amsterdam, oslo;
    Button req;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amsterdam = findViewById(R.id.amsterdam);
        oslo = findViewById(R.id.oslo);

        req = findViewById(R.id.req);

        req.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetJson process = new GetJson();
                process.execute();
            }
        });
    }
}
