package pe.kiseki.grimorum.activity;

import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity extends Activity {

    ImageButton btnhistoria;
    ImageButton btnduelo;
    ImageButton btncredito;
    MediaPlayer mediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnhistoria = (ImageButton) findViewById(R.id.btnhistoria);
        btnduelo = (ImageButton) findViewById(R.id.btnduelo);
        btncredito = (ImageButton) findViewById(R.id.btncredito);
        btnduelo.setAlpha(45);

        setVolumeControlStream(3);
        mediaPlayer = new MediaPlayer();
        try {
            AssetFileDescriptor descriptor = getAssets().openFd("Intro.mp3");
            this.mediaPlayer.setDataSource(descriptor.getFileDescriptor(), descriptor.getStartOffset(), descriptor.getLength());
            this.mediaPlayer.prepare();
            this.mediaPlayer.setLooping(true);
        } catch (IOException e) {
            Log.e("No hay error", e.getMessage());
            this.mediaPlayer = null;
        }

        btnhistoria.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btnhistoria.setImageResource(R.drawable.btnhistoria2);
                Intent i = new Intent(getApplicationContext(), HistoriaActivity.class);
                startActivity(i);
            }
        });

        btnduelo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), PruebaActivity.class);
                startActivity(i);
            }
        });

        btncredito.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                btncredito.setImageResource(R.drawable.btncredito2);
                Intent i3 = new Intent(getApplicationContext(), FinalActivity.class);
                i3.putExtra("fondo", 3);
                startActivity(i3);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        btnhistoria.setImageResource(R.drawable.btnhistoria1);
        btncredito.setImageResource(R.drawable.btncredito1);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
            if (isFinishing()) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        }
    }

}
