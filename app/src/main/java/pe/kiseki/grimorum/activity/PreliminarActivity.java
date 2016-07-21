package pe.kiseki.grimorum.activity;

import java.io.IOException;
import java.util.ArrayList;

import android.media.SoundPool;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.gesture.Gesture;
import android.gesture.GestureLibraries;
import android.gesture.GestureLibrary;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGesturePerformedListener;
import android.gesture.Prediction;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class PreliminarActivity extends Activity implements OnGesturePerformedListener {

    GestureLibrary mLibrary;
    AnimationDrawable anirostro;
    AnimationDrawable anipulsar;
    ImageView imagenpulsar;
    ImageView imagentexto;
    ImageView imagenhechizo;
    ImageView imagenrostro;
    String[] t3s = {"1", "2"};
    String[] t4s = {"1", "3"};
    String[] t5s1 = {"1", "4"};
    String[] t5s2 = {"1", "5"};
    String[] t5s3 = {"1", "6"};
    String[] t7s = {"7"};
    String[] t8s1 = {"1", "3", "7", "5"};
    String[] t8s2 = {"1", "4", "7", "6"};
    String[] t8s3 = {"1", "3", "7", "3"};
    int i;
    boolean activo = false;
    int explosionId = -1;
    SoundPool soundPool;
    Toast f1t;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preliminar);

        f1t = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        f1t.setGravity(53, 150, 100);

        ((App) getApplication()).texto = 1;

        setVolumeControlStream(3);
        soundPool = new SoundPool(20, 3, 0);
        try {
            explosionId = this.soundPool.load(getAssets().openFd("DRAGON01.WAV"), 1);
        } catch (IOException e) {
            Log.e("No hay error", e.getMessage());
        }

        imagenpulsar = (ImageView) findViewById(R.id.imagenpulsar);
        imagentexto = (ImageView) findViewById(R.id.imagentexto);
        imagenhechizo = (ImageView) findViewById(R.id.imagenhechizo);
        imagenrostro = (ImageView) findViewById(R.id.imagenrostro);

        imagenpulsar.setOnClickListener(new View.OnClickListener() {
            int randomNum;

            public void onClick(View v) {
                switch (((App) getApplication()).texto) {
                    case 1:
                        anirostro = new AnimationDrawable();
                        anirostro.addFrame(getResources().getDrawable(R.drawable.rostro1), 300);
                        anirostro.addFrame(getResources().getDrawable(R.drawable.rostro2), 300);
                        anirostro.addFrame(getResources().getDrawable(R.drawable.rostro3), 300);
                        anirostro.addFrame(getResources().getDrawable(R.drawable.rostro4), 300);
                        anirostro.setOneShot(false);
                        imagenrostro.setImageDrawable(anirostro);
                        imagenrostro.post(new Starter1());
                        imagentexto.setImageResource(R.drawable.t1);
                        break;
                    case 2:
                        imagentexto.setImageResource(R.drawable.t2);
                        break;
                    case 3:
                        imagentexto.setImageResource(R.drawable.t3);
                        imagenhechizo.setImageResource(R.drawable.t3s);
                        ((App) getApplication()).hechizo = t3s;
                        i = 0;
                        activo = true;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        break;
                    case 4:
                        imagentexto.setImageResource(R.drawable.t4);
                        imagenhechizo.setImageResource(R.drawable.t4s);
                        ((App) getApplication()).hechizo = t4s;
                        i = 0;
                        activo = true;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        break;
                    case 5:
                        imagentexto.setImageResource(R.drawable.t5);
                        randomNum = 1 + (int) (Math.random() * 3);
                        if (randomNum == 1) {
                            imagenhechizo.setImageResource(R.drawable.t5s1);
                            ((App) getApplication()).hechizo = t5s1;
                        } else if (randomNum == 2) {
                            imagenhechizo.setImageResource(R.drawable.t5s2);
                            ((App) getApplication()).hechizo = t5s2;
                        } else {
                            imagenhechizo.setImageResource(R.drawable.t5s3);
                            ((App) getApplication()).hechizo = t5s3;
                        }
                        i = 0;
                        activo = true;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        break;
                    case 6:
                        imagentexto.setImageResource(R.drawable.t6);
                        break;
                    case 7:
                        imagentexto.setImageResource(R.drawable.t7);
                        imagenhechizo.setImageResource(R.drawable.t7s);
                        ((App) getApplication()).hechizo = t7s;
                        i = 0;
                        activo = true;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        break;
                    case 8:
                        imagentexto.setImageResource(R.drawable.t8);
                        randomNum = 1 + (int) (Math.random() * 3);
                        if (randomNum == 1) {
                            imagenhechizo.setImageResource(R.drawable.t8s1);
                            ((App) getApplication()).hechizo = t8s1;
                        } else if (randomNum == 2) {
                            imagenhechizo.setImageResource(R.drawable.t8s2);
                            ((App) getApplication()).hechizo = t8s2;
                        } else {
                            imagenhechizo.setImageResource(R.drawable.t8s3);
                            ((App) getApplication()).hechizo = t8s3;
                        }
                        i = 0;
                        activo = true;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        break;
                    case 9:
                        imagentexto.setImageResource(R.drawable.t9);
                        break;
                    case 10:
                        imagentexto.setImageResource(R.drawable.t10);
                        break;
                    default:
                        Intent i = new Intent(getBaseContext(), PruebaActivity.class);
                        startActivity(i);
                        break;
                }
                ((App) getApplication()).texto++;
            }
        });

        mLibrary = GestureLibraries.fromRawResource(this, R.raw.hechizos);
        if (!mLibrary.load()) {
            finish();
        }
        GestureOverlayView gestures = (GestureOverlayView) findViewById(R.id.gestures);
        gestures.setGestureColor(Color.rgb(167, 0, 0));
        gestures.addOnGesturePerformedListener(this);

        anipulsar = new AnimationDrawable();
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p1), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p2), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p3), 200);
        anipulsar.addFrame(getResources().getDrawable(R.drawable.p4), 200);
        anipulsar.setOneShot(false);
        ImageView imageAnim2 = (ImageView) findViewById(R.id.imagenpulsar);
        imageAnim2.setBackgroundDrawable(anipulsar);
        imageAnim2.post(new Starter2());
    }

    class Starter1 implements Runnable {
        public void run() {
            anirostro.start();
        }
    }

    class Starter2 implements Runnable {
        public void run() {
            anipulsar.start();
        }
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        if (activo) {
            ArrayList<Prediction> predictions = mLibrary.recognize(gesture);
            if (predictions.size() > 0) {
                Prediction prediction = predictions.get(0);
                if (prediction.score <= 3.0d) {
                    f1t.setText("Intenta el conjuro otra vez");
                    f1t.show();
                    i = 0;
                } else if (prediction.name.equals(((App) getApplication()).hechizo[i])) {
                    i++;
                    if (i == ((App) getApplication()).hechizo.length) {
                        if (explosionId != -1) {
                            soundPool.play(explosionId, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                        f1t.setText("Conjuro completo");
                        f1t.show();
                        imagenpulsar.setVisibility(View.VISIBLE);
                        activo = false;
                        return;
                    }
                    f1t.setText("Muy bien");
                    f1t.show();
                } else {
                    f1t.setText("Intenta el conjuro otra vez");
                    f1t.show();
                    i = 0;
                }
            }
        }
    }

    /*private void anirostro() {
        if (this.anirostro.isRunning()) {
            this.anirostro.stop();
            return;
        }
        this.anirostro.stop();
        this.anirostro.start();
    }

    private void anipulsar() {
        if (this.anipulsar.isRunning()) {
            this.anipulsar.stop();
            return;
        }
        this.anipulsar.stop();
        this.anipulsar.start();
    }*/

}
