package pe.kiseki.grimorum.activity;

import java.io.IOException;
import java.util.ArrayList;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.ProgressBar;
import android.widget.TableRow;
import android.widget.Toast;

public class PruebaActivity extends Activity implements OnGesturePerformedListener {

    GestureLibrary mLibrary;
    AnimationDrawable anipulsar;
    ImageView imagenpulsar;
    ImageView imagentexto;
    ImageView imagenhechizo;
    String[][] sa = {{"1", "2"}, {"1", "3", "4", "3"}, {"1", "5"}, {"1", "6", "4", "6"}};
    String[][] sb = {{"7", "8"}, {"1", "3", "4", "8"}, {"7", "2", "9"}, {"7", "5", "4", "5", "10"}};
    String[][] sc = {{"11", "3"}, {"11", "5"}, {"11", "8", "4", "8"}};
    String[][] sd = {{"1", "3", "12"}, {"7", "3", "10", "13"}, {"1", "2", "4", "2", "14"}, {"11", "6", "14", "15"}, {"7", "3", "4", "3", "10", "12", "13"}};
    String[][] se = {{"16", "8", "17"}, {"16", "3", "18", "9"}, {"1", "3", "4", "3", "12", "15"}, {"16", "8", "18", "10", "12", "13"}};
    int[] sai = {R.drawable.sa1, R.drawable.sa2, R.drawable.sa3, R.drawable.sa4};
    int[] sbi = {R.drawable.sb1, R.drawable.sb2, R.drawable.sb3, R.drawable.sb4};
    int[] sci = {R.drawable.sc1, R.drawable.sc2, R.drawable.sc3};
    int[] sdi = {R.drawable.sd1, R.drawable.sd2, R.drawable.sd3, R.drawable.sd4, R.drawable.sd5};
    int[] sei = {R.drawable.se1, R.drawable.se2, R.drawable.se3, R.drawable.se4};
    ProgressBar mProgressBar;
    CountDownTimer mCountDownTimer;
    int i;
    int j = 0;
    int k = 0;
    int vida = 4;
    boolean activo = false;
    boolean exito = false;

    AnimationDrawable aniconjuro;
    int explosionId = -1;
    ImageView imagenconjuro;
    TableRow laybarra;
    MediaPlayer mediaPlayer;
    SoundPool soundPool;
    Toast f5t;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba);

        this.f5t = Toast.makeText(this, "", Toast.LENGTH_SHORT);
        this.f5t.setGravity(51, 150, 100);

        ((App) getApplication()).texto = 1;

        setVolumeControlStream(3);
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor descriptor = getAssets().openFd("Prueba.mp3");
            mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            mediaPlayer.prepare();
            mediaPlayer.setLooping(true);
        } catch (IOException e) {
            mediaPlayer = null;
            Log.e("No hay error", e.getMessage());
        }
        setVolumeControlStream(3);
        soundPool = new SoundPool(20, 3, 0);
        try {
            explosionId = this.soundPool.load(getAssets().openFd("DRAGON01.WAV"), 1);
        } catch (IOException e2) {
            Log.e("No hay error", e2.getMessage());
        }

        imagenpulsar = (ImageView) findViewById(R.id.imagenpulsar);
        imagentexto = (ImageView) findViewById(R.id.imagentexto);
        imagenhechizo = (ImageView) findViewById(R.id.imagenhechizo);
        imagenconjuro = (ImageView) findViewById(R.id.imagenconjuro);
        laybarra = (TableRow) findViewById(R.id.laybarra);

        imagenpulsar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch (((App) getApplication()).texto) {
                    case 1:
                        imagentexto.setVisibility(View.VISIBLE);
                        ((App) getApplication()).texto++;
                        break;
                    case 2:
                        imagentexto.setImageResource(R.drawable.p02);
                        ((App) getApplication()).texto++;
                        break;
                    case 3:
                        imagentexto.setImageResource(R.drawable.p03);
                        ((App) getApplication()).texto++;
                        break;
                    case 4:
                        imagentexto.setImageResource(R.drawable.p04);
                        ((App) getApplication()).texto++;
                        break;
                    case 5:
                        imagentexto.setImageResource(R.drawable.p05);
                        ((App) getApplication()).texto++;
                        break;
                    case 6:
                        imagentexto.setImageResource(R.drawable.p06);
                        ((App) getApplication()).texto++;
                        break;
                    case 7:
                        imagentexto.setImageResource(R.drawable.p07);
                        ((App) getApplication()).texto++;
                        break;
                    case 8:
                        imagentexto.setImageResource(R.drawable.p08);
                        ((App) getApplication()).texto++;
                        break;
                    case 9:
                        imagentexto.setImageResource(R.drawable.p09);
                        ((App) getApplication()).texto++;
                        break;
                    case 10:
                        imagentexto.setImageResource(R.drawable.p10);
                        ((App) getApplication()).texto++;
                        break;
                    case 11:
                        imagentexto.setImageResource(R.drawable.p11);
                        ((App) getApplication()).texto++;
                        break;
                    case 12:
                        imagentexto.setImageResource(R.drawable.p12);
                        laybarra.setVisibility(View.VISIBLE);
                        ((App) getApplication()).hechizo2 = sa;
                        ((App) getApplication()).hechizo3 = sai;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        accion();
                        break;
                    case 13:
                        imagentexto.setImageResource(R.drawable.p13);
                        ((App) getApplication()).texto++;
                        break;
                    case 14:
                        imagentexto.setImageResource(R.drawable.p14);
                        ((App) getApplication()).hechizo2 = sb;
                        ((App) getApplication()).hechizo3 = sbi;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        accion();
                        break;
                    case 15:
                        imagentexto.setImageResource(R.drawable.p15);
                        ((App) getApplication()).hechizo2 = sc;
                        ((App) getApplication()).hechizo3 = sci;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        accion();
                        break;
                    case 16:
                        imagentexto.setImageResource(R.drawable.p16);
                        ((App) getApplication()).texto++;
                        break;
                    case 17:
                        imagentexto.setImageResource(R.drawable.p17);
                        ((App) getApplication()).hechizo2 = sd;
                        ((App) getApplication()).hechizo3 = sdi;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        accion();
                        break;
                    case 18:
                        imagentexto.setImageResource(R.drawable.p18);
                        ((App) getApplication()).texto++;
                        break;
                    case 19:
                        imagentexto.setImageResource(R.drawable.p19);
                        ((App) getApplication()).texto++;
                        break;
                    case 20:
                        imagentexto.setImageResource(R.drawable.p20);
                        ((App) getApplication()).texto++;
                        break;
                    case 21:
                        imagentexto.setImageResource(R.drawable.p21);
                        ((App) getApplication()).texto++;
                        break;
                    case 22:
                        imagentexto.setImageResource(R.drawable.p22);
                        ((App) getApplication()).texto++;
                        break;
                    case 23:
                        imagentexto.setImageResource(R.drawable.p23);
                        ((App) getApplication()).hechizo2 = se;
                        ((App) getApplication()).hechizo3 = sei;
                        imagenpulsar.setVisibility(View.INVISIBLE);
                        accion();
                        break;
                    case 24:
                        imagentexto.setImageResource(R.drawable.p24);
                        ((App) getApplication()).texto++;
                        break;
                    case 25:
                        imagentexto.setImageResource(R.drawable.p25);
                        ((App) getApplication()).texto++;
                        break;
                    case 26:
                        imagentexto.setImageResource(R.drawable.p26);
                        ((App) getApplication()).texto++;
                        break;
                    case 27:
                        imagentexto.setImageResource(R.drawable.p27);
                        ((App) getApplication()).texto++;
                        break;
                    case 28:
                        imagentexto.setImageResource(R.drawable.p28);
                        ((App) getApplication()).texto++;
                        break;
                    case 29:
                        imagentexto.setImageResource(R.drawable.p29);
                        ((App) getApplication()).texto++;
                        break;
                    case 30:
                        imagentexto.setImageResource(R.drawable.p30);
                        ((App) getApplication()).texto++;
                        break;
                    case 31:
                        imagentexto.setImageResource(R.drawable.p31);
                        ((App) getApplication()).texto = 39;
                        break;
                    case 32:
                        imagentexto.setImageResource(R.drawable.p32);
                        ((App) getApplication()).texto++;
                        break;
                    case 33:
                        imagentexto.setImageResource(R.drawable.p33);
                        ((App) getApplication()).texto++;
                        break;
                    case 34:
                        imagentexto.setImageResource(R.drawable.p34);
                        ((App) getApplication()).texto++;
                        break;
                    case 35:
                        imagentexto.setImageResource(R.drawable.p35);
                        ((App) getApplication()).texto++;
                        break;
                    case 36:
                        imagentexto.setImageResource(R.drawable.p36);
                        ((App) getApplication()).texto++;
                        break;
                    case 37:
                        imagentexto.setImageResource(R.drawable.p37);
                        ((App) getApplication()).texto++;
                        break;
                    case 38:
                        Intent i1 = new Intent(getApplicationContext(), FinalActivity.class);
                        i1.putExtra("fondo", 1);
                        startActivity(i1);
                        break;
                    case 39:
                        Intent i2 = new Intent(getApplicationContext(), FinalActivity.class);
                        i2.putExtra("fondo", 2);
                        startActivity(i2);
                        break;
                    default:
                        break;
                }
            }
        });

        mLibrary = GestureLibraries.fromRawResource(this, R.raw.hechizos2);
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



        aniconjuro = new AnimationDrawable();
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w01), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w02), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w03), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w04), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w05), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w06), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w07), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w08), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w09), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w10), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w11), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w12), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w13), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w14), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w15), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w16), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w17), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w18), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w19), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w20), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w21), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w22), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w23), 100);
        aniconjuro.addFrame(getResources().getDrawable(R.drawable.w24), 100);
    }

    class Starter2 implements Runnable {
        public void run() {
            anipulsar.start();
        }
    }

    class Starter3 implements Runnable {
        public void run() {
            if (aniconjuro.isRunning()) {
                aniconjuro.stop();
            }
            aniconjuro.start();
        }
    }

    private void accion() {
        if (k == ((App) getApplication()).hechizo2.length) {
            this.imagenpulsar.setVisibility(View.VISIBLE);
            ((App) getApplication()).texto++;
            this.activo = false;
            this.k = 0;
            return;
        }
        imagenhechizo.setImageResource(((App) getApplication()).hechizo3[this.k]);
        ((App) getApplication()).hechizo = ((App) getApplication()).hechizo2[this.k];
        i = 0;
        activo = true;
        progresa();
    }

    @Override
    public void onGesturePerformed(GestureOverlayView overlay, Gesture gesture) {
        if (activo) {
            ArrayList<Prediction> predictions = mLibrary.recognize(gesture);
            if (predictions.size() > 0) {
                Prediction prediction = predictions.get(0);
                if (prediction.score <= 2.0d) {
                    f5t.setText("Intenta el conjuro otra vez");
                    f5t.show();
                    i = 0;
                } else if (prediction.name.equals(((App) getApplication()).hechizo[i])) {
                    i++;
                    if (i == ((App) getApplication()).hechizo.length) {
                        animacion();
                        if (explosionId != -1) {
                            soundPool.play(explosionId, 1.0f, 1.0f, 0, 0, 1.0f);
                        }
                        f5t.setText("Conjuro completo");
                        f5t.show();
                        activo = false;
                        exito = true;
                        return;
                    }
                    f5t.setText("Muy bien");
                    f5t.show();
                } else {
                    f5t.setText("Intenta el conjuro otra vez");
                    f5t.show();
                    i = 0;
                }
            }
        }
    }

    /*private void anipulsar() {
        if (anipulsar.isRunning()) {
            anipulsar.stop();
            return;
        }
        anipulsar.stop();
        anipulsar.start();
    }*/

    public void progresa() {
        j = 0;
        mProgressBar = (ProgressBar) findViewById(R.id.bar);
        mProgressBar.setProgress(j);
        mCountDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                j++;
                mProgressBar.setProgress(j);
            }

            @Override
            public void onFinish() {
                j++;
                mProgressBar.setProgress(j);

                if (exito) {
                    exito = false;
                    activo = false;
                    k++;
                    accion();
                } else if (vida == 4) {
                    f5t.setText("Perdiste un punto");
                    f5t.show();
                    ((ImageView) findViewById(R.id.vida1)).setImageResource(R.drawable.vida2);
                    vida--;
                    accion();
                } else if (vida == 3) {
                    f5t.setText("Perdiste un punto");
                    f5t.show();
                    ((ImageView) findViewById(R.id.vida2)).setImageResource(R.drawable.vida2);
                    vida--;
                    accion();
                } else if (vida == 2) {
                    f5t.setText("Perdiste un punto");
                    f5t.show();
                    ((ImageView) findViewById(R.id.vida3)).setImageResource(R.drawable.vida2);
                    vida--;
                    accion();
                } else if (vida == 1) {
                    activo = false;
                    f5t.setText("Tu prueba terminó");
                    f5t.show();
                    ((ImageView) findViewById(R.id.vida4)).setImageResource(R.drawable.vida2);
                    imagenpulsar.setVisibility(View.VISIBLE);
                    ((App) getApplication()).texto = 32;
                    vida--;
                }
            }
        };
        mCountDownTimer.start();
    }

    public void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    public void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }

    public void animacion() {
        anipulsar.setOneShot(true);
        ImageView imageAnim3 = (ImageView) findViewById(R.id.imagenconjuro);
        imageAnim3.setBackgroundDrawable(aniconjuro);
        imageAnim3.post(new Starter3());
    }

}