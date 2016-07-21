package pe.kiseki.grimorum.activity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.LinearLayout;

public class FinalActivity extends Activity {

    LinearLayout line;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        line = (LinearLayout) findViewById(R.id.layfinal);
        int i = this.getIntent().getIntExtra("fondo", 0);
        if (i == 1)
            line.setBackgroundResource(R.drawable.fondomal);
        else if (i == 2)
            line.setBackgroundResource(R.drawable.fondobien);
        else if (i == 3)
            line.setBackgroundResource(R.drawable.fondocredito);
    }

}
