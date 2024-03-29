package example.com.shangguigu_localservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MusicService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        // TODO Auto-generated method stub
        return null;
    }


    private MediaPlayer player;


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String action = intent.getStringExtra("action");
        if("play".equals(action)) {
            playMusic();
        } else if("pause".equals(action)) {
            pauseMusic();
        } else if("stop".equals(action)) {
            stopMusic();
        }

        return super.onStartCommand(intent, flags, startId);
    }
    /*
     * 暂停音乐
     */
    private void pauseMusic() {
        if(player!=null && player.isPlaying()) {
            player.pause();
        }
    }

    private void stopMusic() {
        if(player!=null) {
            player.stop();//停止
            player.reset();//重置
            player.release();//释放资源
            player = null;//赋空
        }
    }

    /**
     * 播放音乐
     */
    private void playMusic() {
        if(player==null) {
            player = MediaPlayer.create(this,R.raw.jocelin);
        }
        player.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在死亡之前停止音乐
        stopMusic();
    }
}
