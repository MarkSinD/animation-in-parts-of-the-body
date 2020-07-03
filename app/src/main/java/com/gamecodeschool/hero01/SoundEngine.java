package com.gamecodeschool.hero01;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

import java.io.IOException;

public class SoundEngine {

    private static SoundPool mSP;
    private static int mFire_ID = -1;
    private static int mJump_ID = -1;
    private static  int mStep_ID = -1;
    private static  int mVoice_ID = -1;
    private static  int mBullets_ID = -1;
    private static  int mPlayer_Burn_ID = -1;

    private static int streamIDFire;
    private static int streamIDStep;
    private static int streamIDVoice;


    private static SoundEngine ourInstance;

    public static SoundEngine getInstance(Context context){
        ourInstance = new SoundEngine(context);
        return ourInstance;
    }

    public SoundEngine(Context c){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            mSP = new SoundPool.Builder()
                    .setMaxStreams(5)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            mSP = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        }
        try {
            AssetManager assetManager = c.getAssets();
            AssetFileDescriptor descriptor;

            // Prepare the sounds in memory
            descriptor = assetManager.openFd("fire.ogg");
            mFire_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("jump.ogg");
            mJump_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("step.ogg");
            mStep_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("votehaaaa.ogg");
            mVoice_ID = mSP.load(descriptor, 0);

            descriptor = assetManager.openFd("bullets.ogg");
            mBullets_ID = mSP.load(descriptor, 0);

        } catch (IOException e) {
            // Error
        }

    }


    public static void playFire(){
        streamIDFire = mSP.play(mFire_ID, 1,1,0,-1,1);
        mSP.setRate(streamIDFire, 2);
    }
    public static void stopFire(){ mSP.stop(streamIDFire); }


    public static void playJump(){ mSP.play(mJump_ID, 0.5f,0.5f,0,0,1); }


    public static void playStep(){
        streamIDStep = mSP.play(mStep_ID, 0.1f,0.1f,0,-1,1);
    }
    public static void stopStep(){ mSP.stop(streamIDStep); }


    public static void playVoice(){ streamIDVoice = mSP.play(mVoice_ID, 1f,1f,0,0,1);}
    public static void stopVoice(){ mSP.stop(streamIDVoice); }

    public static void playBullets(){ mSP.play(mBullets_ID, 0.1f,0.1f,0,1,1);}


    public static void stopAllSound(){ mSP.autoPause();}



}
