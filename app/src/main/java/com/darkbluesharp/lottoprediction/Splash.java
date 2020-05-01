package com.darkbluesharp.lottoprediction;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import static java.lang.Thread.sleep;


public class Splash extends Activity {

    Thread splashTread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            /**
             * 사용자 단말기의 권한 중 "카메라" 권한이 허용되어 있는지 확인한다.
             *  Android는 C언어 기반으로 만들어졌기 때문에 Boolean 타입보다 Int 타입을 사용한다.
             */
            int permissionResult = checkSelfPermission(Manifest.permission.CAMERA);


            /** * 패키지는 안드로이드 어플리케이션의 아이디이다. *
             *  현재 어플리케이션이 카메라에 대해 거부되어있는지 확인한다. */
            if (permissionResult == PackageManager.PERMISSION_DENIED) {


                /** * 사용자가 CALL_PHONE 권한을 거부한 적이 있는지 확인한다. *
                 * 거부한적이 있으면 True를 리턴하고 *
                 * 거부한적이 없으면 False를 리턴한다. */
                if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(Splash.this);
                    dialog.setTitle("권한이 필요합니다.").setMessage("이 기능을 사용하기 위해서는 단말기의 \"카메라\" 권한이 필요합니다. 계속 하시겠습니까?")
                            .setPositiveButton("네", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // 새로운 인스턴스(onClickListener)를 생성했기 때문에 *
                                    //  버전체크를 다시 해준다.
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                        // CALL_PHONE 권한을 Android OS에 요청한다.
                                        requestPermissions(new String[]{Manifest.permission.CAMERA}, 1000);
                                    }
                                }
                            })
                            .setNegativeButton("아니요", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(Splash.this, "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
                                }
                            }).create().show();


                    // return ;
                    // need to retry
                }
                // 최초로 권한을 요청할 때
                else {
                    // CALL_PHONE 권한을 Android OS에 요청한다.
                    requestPermissions(new String[]{Manifest.permission.CAMERA}, 1000);
                }


            }
            // CALL_PHONE의 권한이 있을 때
            else {
             //   Handler hd = new Handler();
               // hd.postDelayed(new splashhandler(), 1000); // 1초 후에 hd handler 실행  3000ms = 3초
                splashhandler();
            }
        }


    }

    private void splashhandler (){


        Animation anim = AnimationUtils.loadAnimation(Splash.this, R.anim.translate);
        anim.reset();
        ImageView l = (ImageView) findViewById(R.id.splash);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout iv = (LinearLayout) findViewById(R.id.lin_lay);
        iv.clearAnimation();
        iv.startAnimation(anim);

        splashTread = new Thread() {
            @Override
            public void run() {
                //  startActivity(new Intent(getApplication(), MainActivity.class)); //로딩이 끝난 후, ChoiceFunction 이동
                //   Splash.this.finish(); // 로딩페이지 Activity stack에서 제거
                //  overridePendingTransition(R.anim.fadein, R.anim.fadeout);
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 400) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(Splash.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
               //     Splash.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    Splash.this.finish();
                }
            }
        };
        splashTread.start();
    }

    @Override
    public void onBackPressed() {
        //초반 플래시 화면에서 넘어갈때 뒤로가기 버튼 못누르게 함
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1000: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    splashhandler();

                } else {
                    Toast.makeText(this,"앱을 종료합니다.",Toast.LENGTH_LONG).show();
                    finish();
                }
                return;
            }

        }
    }

}