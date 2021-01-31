package meow.sweetbread.piano;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mPlayer;
    
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("meow", "onCreate: meow!");

        AssetManager myAssetManager = getApplicationContext().getAssets();

        try {
            String[] Files = myAssetManager.list(""); // массив имён файлов
            Log.d("meow", String.join(", ", Files));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onClick(View v) {
        Log.d("meow", "onClick: meow!");
        playSound(v.getId());
    };

    private void playSound(int sound) {
        Log.d("meow", "playSound: " + String.valueOf(sound));
        if (sound == R.id._do) {
            mPlayer = MediaPlayer.create(this, R.raw._do);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.re) {
            mPlayer = MediaPlayer.create(this, R.raw.re);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.mi) {
            mPlayer = MediaPlayer.create(this, R.raw.mi);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.fa) {
            mPlayer = MediaPlayer.create(this, R.raw.fa);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.sol) {
            mPlayer = MediaPlayer.create(this, R.raw.sol);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.la) {
            mPlayer = MediaPlayer.create(this, R.raw.la);
            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });
        } else if (sound == R.id.si) {
            mPlayer = MediaPlayer.create(this, R.raw.si);
            mPlayer.setOnCompletionListener(mp -> stopPlay());
        }

        mPlayer.start();
    }

    private void stopPlay(){
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}