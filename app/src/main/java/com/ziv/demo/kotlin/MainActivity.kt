package com.ziv.demo.kotlin

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.widget.MediaController

class MainActivity : AppCompatActivity(), MediaController.MediaPlayerControl {
    private val TAG: String = "MainActivity"

    private var mWidth: Int = 0
    private var mMediaPlayer: MediaPlayer = MediaPlayer()
    private lateinit var mMediaController: MediaController

    private var playUrl: String = "https://phantom-test-oss.oss-cn-shanghai.aliyuncs.com/phantom/cms/video/MR0s9.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val surfaceView = findViewById<SurfaceView>(R.id.video_surface)
        mMediaController = MediaController(this, false)
//        mMediaController = findViewById(R.id.video_controller)

        surfaceView.setOnClickListener { _ ->
            Log.d(TAG, "surfaceView has clicked.")
            if (isPlaying) {
                pause()
                mMediaController.show()
            } else {
                start()
                mMediaController.hide()
            }
        }

        surfaceView?.holder?.addCallback(object: SurfaceHolder.Callback {
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
            mMediaController.isEnabled = true
            mMediaController.show()
            mMediaController.setMediaPlayer(this)
            start()
            Log.d(TAG, "start play.")
        }
        mMediaPlayer.setOnCompletionListener {
            Log.d(TAG, "play finish.")
            mMediaController.hide()
        }
        mMediaPlayer.setOnErrorListener { _, what, extra ->
            Log.e(TAG, "play error $what, $extra")
            mMediaController.hide()
            false
        }

        mMediaPlayer.setDataSource(playUrl)
        mMediaPlayer.prepareAsync()
    }

    override fun isPlaying(): Boolean {
        return mMediaPlayer.isPlaying
    }

    override fun canSeekForward(): Boolean {
        return false
    }

    override fun getDuration(): Int {
        return mMediaPlayer.duration
    }

    override fun pause() {
        mMediaPlayer.pause()
    }

    override fun getBufferPercentage(): Int {
        return 0
    }

    override fun seekTo(pos: Int) {
        mMediaPlayer.seekTo(pos)
    }

    override fun getCurrentPosition(): Int {
        return mMediaPlayer.currentPosition
    }

    override fun canSeekBackward(): Boolean {
        return false
    }

    override fun start() {
        mMediaPlayer.start()
    }

    override fun getAudioSessionId(): Int {
        return mMediaPlayer.audioSessionId
    }

    override fun canPause(): Boolean {
        return isPlaying
    }
}
