package com.example.hellosharedpreferences;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private Button btnSave;
    private TextView textName;

    private ApplicationPreferences appPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initUI();
        appPreferences.init(getApplicationContext());
        this.loadName();



    }

    @Override
    public void onClick(View v) {

        Button button = (Button) v;

        switch (button.getId()) {
            case (R.id.buttonSave):
                appPreferences.saveString(name.getText().toString());
                textName.setText(name.getText());
                break;
        }
    }

    private void initUI() {
        name = findViewById(R.id.editText);
        btnSave = findViewById(R.id.buttonSave);
        textName = findViewById(R.id.textView);
    }

    private void loadName() {
        textName.setText(appPreferences.readString("Hello TÚ"));
    }
}
