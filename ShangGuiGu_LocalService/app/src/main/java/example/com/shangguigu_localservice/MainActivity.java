package example.com.shangguigu_localservice;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button btn_main_play;
    private Button btn_main_stop;
    private Button btn_main_pause;
    private Button btn_main_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_main_play = (Button) findViewById(R.id.btn_main_play);
        btn_main_stop = (Button) findViewById(R.id.btn_main_stop);
        btn_main_pause = (Button) findViewById(R.id.btn_main_pause);
        btn_main_exit = (Button) findViewById(R.id.btn_main_exit);

        btn_main_play.setOnClickListener(this);
        btn_main_stop.setOnClickListener(this);
        btn_main_pause.setOnClickListener(this);
        btn_main_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this,MusicService.class);
        if(v == btn_main_play){
            intent.putExtra("action","play");
            startService(intent);
        }else if(v == btn_main_pause){
            intent.putExtra("action","pause");
            startService(intent);
        }else if(v == btn_main_stop){
            intent.putExtra("action","stop");
            startService(intent);
        }else if(v == btn_main_exit){
            stopService(intent);
            finish();
        }
    }

   /* @Override
    public void onClick(View v) {
        if (btn_main_play == v) {//播放
            playMusic();
        } else if (btn_main_stop == v) {//停止播放
            stopMusic();
        } else if (btn_main_pause == v) {//暂停音乐
            pauseMusic();
        } else if (btn_main_exit == v) {//退出并停止音乐
            exitMusic();
        }
    }

    private MediaPlayer player;
    private void exitMusic() {
        stopMusic();
        finish();
    }

    *//*
     * 暂停音乐
     *//*
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

    *//**
     * 播放音乐
     *//*
    private void playMusic() {
        if(player==null) {
            player = MediaPlayer.create(this,R.raw.jocelin);
        }
        player.start();
    }*/
}
