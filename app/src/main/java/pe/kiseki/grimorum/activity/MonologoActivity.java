package pe.kiseki.grimorum.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;

public class MonologoActivity extends Activity {

    ImageView imagenpulsar;
    ImageView imagentexto;
    AnimationDrawable anipulsar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monologo);

        ((App) getApplication()).texto = 1;

        imagenpulsar = (ImageView) findViewById(R.id.imagenpulsar);
        imagentexto = (ImageView) findViewById(R.id.imagentexto);

        anipulsar = new AnimationDrawable();
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p1), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p2), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p3), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p4), 200);
        anipulsar.setOneShot(false);
        ImageView imageAnim2 = (ImageView) findViewById(R.id.imagenpulsar);
        imageAnim2.setBackgroundDrawable(anipulsar);
        imageAnim2.post(new Starter2());

        imagenpulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((App) getApplication()).texto) {
                    case 1:
                        imagentexto.setImageResource(R.drawable.m2);
                        ((App) getApplication()).texto++;
                        break;
                    case 2:
                        imagentexto.setImageResource(R.drawable.m3);
                        ((App) getApplication()).texto++;
                        break;
                    case 3:
                        Intent i = new Intent(getApplicationContext(), PreliminarActivity.class);
                        startActivity(i);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    class Starter2 implements Runnable {
        public void run() {
            anipulsar.start();
        }
    }

}
