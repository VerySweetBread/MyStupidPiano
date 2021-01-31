package meow.sweetbread.piano;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mStreamID;
    private int s_do, s_re, s_mi, s_fa, s_sol, s_la, s_si;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSoundPool();
        mAssetManager = getAssets();

        s_do = loadSound("_do.mp3");
        s_re = loadSound("re.mp3");
        s_mi = loadSound("mi.mp3");
        s_fa = loadSound("fa.mp3");
        s_sol = loadSound("sol.mp3");
        s_la = loadSound("la.mp3");
        s_si = loadSound("si.mp3");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id._do:
                playSound(s_do);
                break;
            case R.id.re:
                playSound(s_re);
                break;
            case R.id.mi:
                playSound(s_mi);
                break;
            case R.id.fa:
                playSound(s_fa);
                break;
            case R.id.sol:
                playSound(s_sol);
                break;
            case R.id.la:
                playSound(s_la);
                break;
            case R.id.si:
                playSound(s_si);
                break;
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .setMaxStreams(7)
                .build();
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (Exception e) {
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1, 1, 1, 0, 1);
        }
        return mStreamID;
    }
}