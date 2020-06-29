package com.ziv.demo.kotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView

class MainActivity : AppCompatActivity() {
    private val TAG: String = "MainActivity";

    private var mMediaPlayer: MediaPlayer = MediaPlayer()
    private var mWidth: Int = 0

    private var playUrl: String = "https://phantom-test-oss.oss-cn-shanghai.aliyuncs.com/phantom/cms/video/MR0s9.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfaceView = findViewById<SurfaceView>(R.id.video_surface)

        surfaceView.holder.addCallback(object: SurfaceHolder.Callback {
            override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
                Log.d(TAG, "surfaceChanged: $width * $height")
                mWidth = width
            }

            override fun surfaceDestroyed(holder: SurfaceHolder?) {
                Log.d(TAG, "surfaceDestroyed")
            }

            override fun surfaceCreated(holder: SurfaceHolder?) {
                Log.d(TAG, "surfaceCreated")
                mMediaPlayer.setDisplay(holder)
            }
        })

        mMediaPlayer.setOnPreparedListener { mp ->
            surfaceView.holder.setFixedSize(mWidth, mp.videoHeight * mWidth / mp.videoWidth)
            mp!!.start()
            Log.d(TAG, "start play.")
        }
        mMediaPlayer.setOnCompletionListener {
            Log.d(TAG, "play finish.")
        }
        mMediaPlayer.setOnErrorListener { _, what, extra ->
            Log.e(TAG, "play error $what, $extra")
            false
        }

        mMediaPlayer.setDataSource(playUrl)
        mMediaPlayer.prepareAsync()

    }
}
