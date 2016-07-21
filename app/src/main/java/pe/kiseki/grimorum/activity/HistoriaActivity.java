package pe.kiseki.grimorum.activity;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class HistoriaActivity extends Activity {

    ImageButton btnnueva;
    ImageButton btncontinuar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historia);
        btnnueva = (ImageButton) findViewById(R.id.btnnueva);
        btncontinuar = (ImageButton) findViewById(R.id.btncontinuar);
        btncontinuar.setAlpha(45);

        btnnueva.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnnueva.setImageResource(R.drawable.btnnueva2);
                Intent i = new Intent(getApplicationContext(), MonologoActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnnueva.setImageResource(R.drawable.btnnueva1);
    }

}