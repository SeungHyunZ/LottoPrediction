package com.darkbluesharp.lottoprediction;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.CaptureActivity;


public class MainActivity extends CaptureActivity {
    private static MediaPlayer mp;

    ImageButton lottoprediction, search_qrcode;
    TextView numberA1, numberA2, numberA3, numberA4, numberA5, numberA6, numberA7, numberA8, numberA9, numberA10 ;
    TextView numberA11, numberA12, numberA13, numberA14, numberA15, numberA16, numberA17, numberA18, numberA19, numberA20 ;
    TextView numberA21, numberA22, numberA23, numberA24, numberA25, numberA26, numberA27, numberA28, numberA29, numberA30 ;
    TextView numberA31, numberA32, numberA33, numberA34, numberA35, numberA36, numberA37, numberA38, numberA39, numberA40 ;
    TextView numberA41, numberA42, numberA43, numberA44, numberA45;

    TextView numberB1, numberB2, numberB3, numberB4, numberB5, numberB6, numberB7, numberB8, numberB9, numberB10 ;
    TextView numberB11, numberB12, numberB13, numberB14, numberB15, numberB16, numberB17, numberB18, numberB19, numberB20 ;
    TextView numberB21, numberB22, numberB23, numberB24, numberB25, numberB26, numberB27, numberB28, numberB29, numberB30 ;
    TextView numberB31, numberB32, numberB33, numberB34, numberB35, numberB36, numberB37, numberB38, numberB39, numberB40 ;
    TextView numberB41, numberB42, numberB43, numberB44, numberB45;

    TextView numberC1, numberC2, numberC3, numberC4, numberC5, numberC6, numberC7, numberC8, numberC9, numberC10 ;
    TextView numberC11, numberC12, numberC13, numberC14, numberC15, numberC16, numberC17, numberC18, numberC19, numberC20 ;
    TextView numberC21, numberC22, numberC23, numberC24, numberC25, numberC26, numberC27, numberC28, numberC29, numberC30 ;
    TextView numberC31, numberC32, numberC33, numberC34, numberC35, numberC36, numberC37, numberC38, numberC39, numberC40 ;
    TextView numberC41, numberC42, numberC43, numberC44, numberC45;

    TextView numberD1, numberD2, numberD3, numberD4, numberD5, numberD6, numberD7, numberD8, numberD9, numberD10 ;
    TextView numberD11, numberD12, numberD13, numberD14, numberD15, numberD16, numberD17, numberD18, numberD19, numberD20 ;
    TextView numberD21, numberD22, numberD23, numberD24, numberD25, numberD26, numberD27, numberD28, numberD29, numberD30 ;
    TextView numberD31, numberD32, numberD33, numberD34, numberD35, numberD36, numberD37, numberD38, numberD39, numberD40 ;
    TextView numberD41, numberD42, numberD43, numberD44, numberD45;

    TextView numberE1, numberE2, numberE3, numberE4, numberE5, numberE6, numberE7, numberE8, numberE9, numberE10 ;
    TextView numberE11, numberE12, numberE13, numberE14, numberE15, numberE16, numberE17, numberE18, numberE19, numberE20 ;
    TextView numberE21, numberE22, numberE23, numberE24, numberE25, numberE26, numberE27, numberE28, numberE29, numberE30 ;
    TextView numberE31, numberE32, numberE33, numberE34, numberE35, numberE36, numberE37, numberE38, numberE39, numberE40 ;
    TextView numberE41, numberE42, numberE43, numberE44, numberE45;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

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
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
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
                                    Toast.makeText(MainActivity.this, "기능을 취소했습니다", Toast.LENGTH_SHORT).show();
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
            }
        }
/************권한요청 끝**************/





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        lottoprediction = (ImageButton) findViewById(R.id.lottoprediction) ;
        search_qrcode = (ImageButton) findViewById(R.id.search_qrcode) ;

        numberA1 = (TextView) findViewById(R.id.numberA1) ;
        numberA2 = (TextView) findViewById(R.id.numberA2) ;
        numberA3 = (TextView) findViewById(R.id.numberA3) ;
        numberA4 = (TextView) findViewById(R.id.numberA4) ;
        numberA5 = (TextView) findViewById(R.id.numberA5) ;
        numberA6 = (TextView) findViewById(R.id.numberA6) ;
        numberA7 = (TextView) findViewById(R.id.numberA7) ;
        numberA8 = (TextView) findViewById(R.id.numberA8) ;
        numberA9 = (TextView) findViewById(R.id.numberA9) ;
        numberA10 = (TextView) findViewById(R.id.numberA10) ;
        numberA11 = (TextView) findViewById(R.id.numberA11) ;
        numberA12 = (TextView) findViewById(R.id.numberA12) ;
        numberA13 = (TextView) findViewById(R.id.numberA13) ;
        numberA14 = (TextView) findViewById(R.id.numberA14) ;
        numberA15 = (TextView) findViewById(R.id.numberA15) ;
        numberA16 = (TextView) findViewById(R.id.numberA16) ;
        numberA17 = (TextView) findViewById(R.id.numberA17) ;
        numberA18 = (TextView) findViewById(R.id.numberA18) ;
        numberA19 = (TextView) findViewById(R.id.numberA19) ;
        numberA20 = (TextView) findViewById(R.id.numberA20) ;
        numberA21 = (TextView) findViewById(R.id.numberA21) ;
        numberA22 = (TextView) findViewById(R.id.numberA22) ;
        numberA23 = (TextView) findViewById(R.id.numberA23) ;
        numberA24 = (TextView) findViewById(R.id.numberA24) ;
        numberA25 = (TextView) findViewById(R.id.numberA25) ;
        numberA26 = (TextView) findViewById(R.id.numberA26) ;
        numberA27 = (TextView) findViewById(R.id.numberA27) ;
        numberA28 = (TextView) findViewById(R.id.numberA28) ;
        numberA29 = (TextView) findViewById(R.id.numberA29) ;
        numberA30 = (TextView) findViewById(R.id.numberA30) ;
        numberA31 = (TextView) findViewById(R.id.numberA31) ;
        numberA32 = (TextView) findViewById(R.id.numberA32) ;
        numberA33 = (TextView) findViewById(R.id.numberA33) ;
        numberA34 = (TextView) findViewById(R.id.numberA34) ;
        numberA35 = (TextView) findViewById(R.id.numberA35) ;
        numberA36 = (TextView) findViewById(R.id.numberA36) ;
        numberA37 = (TextView) findViewById(R.id.numberA37) ;
        numberA38 = (TextView) findViewById(R.id.numberA38) ;
        numberA39 = (TextView) findViewById(R.id.numberA39) ;
        numberA40 = (TextView) findViewById(R.id.numberA40) ;
        numberA41 = (TextView) findViewById(R.id.numberA41) ;
        numberA42 = (TextView) findViewById(R.id.numberA42) ;
        numberA43 = (TextView) findViewById(R.id.numberA43) ;
        numberA44 = (TextView) findViewById(R.id.numberA44) ;
        numberA45 = (TextView) findViewById(R.id.numberA45) ;

        numberB1 = (TextView) findViewById(R.id.numberB1) ;
        numberB2 = (TextView) findViewById(R.id.numberB2) ;
        numberB3 = (TextView) findViewById(R.id.numberB3) ;
        numberB4 = (TextView) findViewById(R.id.numberB4) ;
        numberB5 = (TextView) findViewById(R.id.numberB5) ;
        numberB6 = (TextView) findViewById(R.id.numberB6) ;
        numberB7 = (TextView) findViewById(R.id.numberB7) ;
        numberB8 = (TextView) findViewById(R.id.numberB8) ;
        numberB9 = (TextView) findViewById(R.id.numberB9) ;
        numberB10 = (TextView) findViewById(R.id.numberB10) ;
        numberB11 = (TextView) findViewById(R.id.numberB11) ;
        numberB12 = (TextView) findViewById(R.id.numberB12) ;
        numberB13 = (TextView) findViewById(R.id.numberB13) ;
        numberB14 = (TextView) findViewById(R.id.numberB14) ;
        numberB15 = (TextView) findViewById(R.id.numberB15) ;
        numberB16 = (TextView) findViewById(R.id.numberB16) ;
        numberB17 = (TextView) findViewById(R.id.numberB17) ;
        numberB18 = (TextView) findViewById(R.id.numberB18) ;
        numberB19 = (TextView) findViewById(R.id.numberB19) ;
        numberB20 = (TextView) findViewById(R.id.numberB20) ;
        numberB21 = (TextView) findViewById(R.id.numberB21) ;
        numberB22 = (TextView) findViewById(R.id.numberB22) ;
        numberB23 = (TextView) findViewById(R.id.numberB23) ;
        numberB24 = (TextView) findViewById(R.id.numberB24) ;
        numberB25 = (TextView) findViewById(R.id.numberB25) ;
        numberB26 = (TextView) findViewById(R.id.numberB26) ;
        numberB27 = (TextView) findViewById(R.id.numberB27) ;
        numberB28 = (TextView) findViewById(R.id.numberB28) ;
        numberB29 = (TextView) findViewById(R.id.numberB29) ;
        numberB30 = (TextView) findViewById(R.id.numberB30) ;
        numberB31 = (TextView) findViewById(R.id.numberB31) ;
        numberB32 = (TextView) findViewById(R.id.numberB32) ;
        numberB33 = (TextView) findViewById(R.id.numberB33) ;
        numberB34 = (TextView) findViewById(R.id.numberB34) ;
        numberB35 = (TextView) findViewById(R.id.numberB35) ;
        numberB36 = (TextView) findViewById(R.id.numberB36) ;
        numberB37 = (TextView) findViewById(R.id.numberB37) ;
        numberB38 = (TextView) findViewById(R.id.numberB38) ;
        numberB39 = (TextView) findViewById(R.id.numberB39) ;
        numberB40 = (TextView) findViewById(R.id.numberB40) ;
        numberB41 = (TextView) findViewById(R.id.numberB41) ;
        numberB42 = (TextView) findViewById(R.id.numberB42) ;
        numberB43 = (TextView) findViewById(R.id.numberB43) ;
        numberB44 = (TextView) findViewById(R.id.numberB44) ;
        numberB45 = (TextView) findViewById(R.id.numberB45) ;

        numberC1 = (TextView) findViewById(R.id.numberC1) ;
        numberC2 = (TextView) findViewById(R.id.numberC2) ;
        numberC3 = (TextView) findViewById(R.id.numberC3) ;
        numberC4 = (TextView) findViewById(R.id.numberC4) ;
        numberC5 = (TextView) findViewById(R.id.numberC5) ;
        numberC6 = (TextView) findViewById(R.id.numberC6) ;
        numberC7 = (TextView) findViewById(R.id.numberC7) ;
        numberC8 = (TextView) findViewById(R.id.numberC8) ;
        numberC9 = (TextView) findViewById(R.id.numberC9) ;
        numberC10 = (TextView) findViewById(R.id.numberC10) ;
        numberC11 = (TextView) findViewById(R.id.numberC11) ;
        numberC12 = (TextView) findViewById(R.id.numberC12) ;
        numberC13 = (TextView) findViewById(R.id.numberC13) ;
        numberC14 = (TextView) findViewById(R.id.numberC14) ;
        numberC15 = (TextView) findViewById(R.id.numberC15) ;
        numberC16 = (TextView) findViewById(R.id.numberC16) ;
        numberC17 = (TextView) findViewById(R.id.numberC17) ;
        numberC18 = (TextView) findViewById(R.id.numberC18) ;
        numberC19 = (TextView) findViewById(R.id.numberC19) ;
        numberC20 = (TextView) findViewById(R.id.numberC20) ;
        numberC21 = (TextView) findViewById(R.id.numberC21) ;
        numberC22 = (TextView) findViewById(R.id.numberC22) ;
        numberC23 = (TextView) findViewById(R.id.numberC23) ;
        numberC24 = (TextView) findViewById(R.id.numberC24) ;
        numberC25 = (TextView) findViewById(R.id.numberC25) ;
        numberC26 = (TextView) findViewById(R.id.numberC26) ;
        numberC27 = (TextView) findViewById(R.id.numberC27) ;
        numberC28 = (TextView) findViewById(R.id.numberC28) ;
        numberC29 = (TextView) findViewById(R.id.numberC29) ;
        numberC30 = (TextView) findViewById(R.id.numberC30) ;
        numberC31 = (TextView) findViewById(R.id.numberC31) ;
        numberC32 = (TextView) findViewById(R.id.numberC32) ;
        numberC33 = (TextView) findViewById(R.id.numberC33) ;
        numberC34 = (TextView) findViewById(R.id.numberC34) ;
        numberC35 = (TextView) findViewById(R.id.numberC35) ;
        numberC36 = (TextView) findViewById(R.id.numberC36) ;
        numberC37 = (TextView) findViewById(R.id.numberC37) ;
        numberC38 = (TextView) findViewById(R.id.numberC38) ;
        numberC39 = (TextView) findViewById(R.id.numberC39) ;
        numberC40 = (TextView) findViewById(R.id.numberC40) ;
        numberC41 = (TextView) findViewById(R.id.numberC41) ;
        numberC42 = (TextView) findViewById(R.id.numberC42) ;
        numberC43 = (TextView) findViewById(R.id.numberC43) ;
        numberC44 = (TextView) findViewById(R.id.numberC44) ;
        numberC45 = (TextView) findViewById(R.id.numberC45) ;

        numberD1 = (TextView) findViewById(R.id.numberD1) ;
        numberD2 = (TextView) findViewById(R.id.numberD2) ;
        numberD3 = (TextView) findViewById(R.id.numberD3) ;
        numberD4 = (TextView) findViewById(R.id.numberD4) ;
        numberD5 = (TextView) findViewById(R.id.numberD5) ;
        numberD6 = (TextView) findViewById(R.id.numberD6) ;
        numberD7 = (TextView) findViewById(R.id.numberD7) ;
        numberD8 = (TextView) findViewById(R.id.numberD8) ;
        numberD9 = (TextView) findViewById(R.id.numberD9) ;
        numberD10 = (TextView) findViewById(R.id.numberD10) ;
        numberD11 = (TextView) findViewById(R.id.numberD11) ;
        numberD12 = (TextView) findViewById(R.id.numberD12) ;
        numberD13 = (TextView) findViewById(R.id.numberD13) ;
        numberD14 = (TextView) findViewById(R.id.numberD14) ;
        numberD15 = (TextView) findViewById(R.id.numberD15) ;
        numberD16 = (TextView) findViewById(R.id.numberD16) ;
        numberD17 = (TextView) findViewById(R.id.numberD17) ;
        numberD18 = (TextView) findViewById(R.id.numberD18) ;
        numberD19 = (TextView) findViewById(R.id.numberD19) ;
        numberD20 = (TextView) findViewById(R.id.numberD20) ;
        numberD21 = (TextView) findViewById(R.id.numberD21) ;
        numberD22 = (TextView) findViewById(R.id.numberD22) ;
        numberD23 = (TextView) findViewById(R.id.numberD23) ;
        numberD24 = (TextView) findViewById(R.id.numberD24) ;
        numberD25 = (TextView) findViewById(R.id.numberD25) ;
        numberD26 = (TextView) findViewById(R.id.numberD26) ;
        numberD27 = (TextView) findViewById(R.id.numberD27) ;
        numberD28 = (TextView) findViewById(R.id.numberD28) ;
        numberD29 = (TextView) findViewById(R.id.numberD29) ;
        numberD30 = (TextView) findViewById(R.id.numberD30) ;
        numberD31 = (TextView) findViewById(R.id.numberD31) ;
        numberD32 = (TextView) findViewById(R.id.numberD32) ;
        numberD33 = (TextView) findViewById(R.id.numberD33) ;
        numberD34 = (TextView) findViewById(R.id.numberD34) ;
        numberD35 = (TextView) findViewById(R.id.numberD35) ;
        numberD36 = (TextView) findViewById(R.id.numberD36) ;
        numberD37 = (TextView) findViewById(R.id.numberD37) ;
        numberD38 = (TextView) findViewById(R.id.numberD38) ;
        numberD39 = (TextView) findViewById(R.id.numberD39) ;
        numberD40 = (TextView) findViewById(R.id.numberD40) ;
        numberD41 = (TextView) findViewById(R.id.numberD41) ;
        numberD42 = (TextView) findViewById(R.id.numberD42) ;
        numberD43 = (TextView) findViewById(R.id.numberD43) ;
        numberD44 = (TextView) findViewById(R.id.numberD44) ;
        numberD45 = (TextView) findViewById(R.id.numberD45) ;

        numberE1 = (TextView) findViewById(R.id.numberE1) ;
        numberE2 = (TextView) findViewById(R.id.numberE2) ;
        numberE3 = (TextView) findViewById(R.id.numberE3) ;
        numberE4 = (TextView) findViewById(R.id.numberE4) ;
        numberE5 = (TextView) findViewById(R.id.numberE5) ;
        numberE6 = (TextView) findViewById(R.id.numberE6) ;
        numberE7 = (TextView) findViewById(R.id.numberE7) ;
        numberE8 = (TextView) findViewById(R.id.numberE8) ;
        numberE9 = (TextView) findViewById(R.id.numberE9) ;
        numberE10 = (TextView) findViewById(R.id.numberE10) ;
        numberE11 = (TextView) findViewById(R.id.numberE11) ;
        numberE12 = (TextView) findViewById(R.id.numberE12) ;
        numberE13 = (TextView) findViewById(R.id.numberE13) ;
        numberE14 = (TextView) findViewById(R.id.numberE14) ;
        numberE15 = (TextView) findViewById(R.id.numberE15) ;
        numberE16 = (TextView) findViewById(R.id.numberE16) ;
        numberE17 = (TextView) findViewById(R.id.numberE17) ;
        numberE18 = (TextView) findViewById(R.id.numberE18) ;
        numberE19 = (TextView) findViewById(R.id.numberE19) ;
        numberE20 = (TextView) findViewById(R.id.numberE20) ;
        numberE21 = (TextView) findViewById(R.id.numberE21) ;
        numberE22 = (TextView) findViewById(R.id.numberE22) ;
        numberE23 = (TextView) findViewById(R.id.numberE23) ;
        numberE24 = (TextView) findViewById(R.id.numberE24) ;
        numberE25 = (TextView) findViewById(R.id.numberE25) ;
        numberE26 = (TextView) findViewById(R.id.numberE26) ;
        numberE27 = (TextView) findViewById(R.id.numberE27) ;
        numberE28 = (TextView) findViewById(R.id.numberE28) ;
        numberE29 = (TextView) findViewById(R.id.numberE29) ;
        numberE30 = (TextView) findViewById(R.id.numberE30) ;
        numberE31 = (TextView) findViewById(R.id.numberE31) ;
        numberE32 = (TextView) findViewById(R.id.numberE32) ;
        numberE33 = (TextView) findViewById(R.id.numberE33) ;
        numberE34 = (TextView) findViewById(R.id.numberE34) ;
        numberE35 = (TextView) findViewById(R.id.numberE35) ;
        numberE36 = (TextView) findViewById(R.id.numberE36) ;
        numberE37 = (TextView) findViewById(R.id.numberE37) ;
        numberE38 = (TextView) findViewById(R.id.numberE38) ;
        numberE39 = (TextView) findViewById(R.id.numberE39) ;
        numberE40 = (TextView) findViewById(R.id.numberE40) ;
        numberE41 = (TextView) findViewById(R.id.numberE41) ;
        numberE42 = (TextView) findViewById(R.id.numberE42) ;
        numberE43 = (TextView) findViewById(R.id.numberE43) ;
        numberE44 = (TextView) findViewById(R.id.numberE44) ;
        numberE45 = (TextView) findViewById(R.id.numberE45) ;



        mp = MediaPlayer.create(this, R.raw.lottoprediction3);
        mp.setLooping(false);

        setGone();

        lottoStart1();
        lottoStart2();
        lottoStart3();
        lottoStart4();
        lottoStart5();

        lottoprediction.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                musicStart();
                lottoStart1();
                lottoStart2();
                lottoStart3();
                lottoStart4();
                lottoStart5();
            }
        });

        //출처 : https://dwfox.tistory.com/79
        search_qrcode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startQRCode();
            }
        });


    }

    public void startQRCode() {
      //  final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(this);
      //  integrator.setCaptureActivity(MainActivity.class);

        integrator.setOrientationLocked(false); //가로, 세로모드 전환 작동
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES); //qr 타입지정
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

      //  new IntentIntegrator(this).initiateScan();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (result == null||data == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
              //  Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                Toast.makeText(this, "동행복권 당첨결과 페이지로 이동합니다.", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse(result.getContents());
                intent.setData(uri);
                startActivity(intent);

            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void musicStart(){
    //     mp.release();
        mp.start();
        setGone();
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();

        mp.stop();
        if (mp != null){
            mp.release();
            mp=null;
        }
    }

    @Override
    protected void onUserLeaveHint(){
        mp.pause();
        super.onUserLeaveHint();
    }

    @Override
    public void onBackPressed(){
        mp.pause();
        super.onUserLeaveHint();
    }

    public void lottoStart1(){
        int Lotto[] = new int[6];

        for(int i=0; i<Lotto.length; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(Lotto[i] == Lotto[j]){
                    i--;
                    break;
                }
            }

        }

        for(int i=0;i<Lotto.length;i++){
            Log.e("lotto number",Lotto[i] + " ");



            switch (Lotto[i]){

                case 1 :
                    numberA1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    numberA2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    numberA3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    numberA4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    numberA5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    numberA6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    numberA7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    numberA8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    numberA9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    numberA10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    numberA11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    numberA12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    numberA13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    numberA14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    numberA15.setVisibility(View.VISIBLE);
                    break;
                case 16 :
                    numberA16.setVisibility(View.VISIBLE);
                    break;
                case 17 :
                    numberA17.setVisibility(View.VISIBLE);
                    break;
                case 18 :
                    numberA18.setVisibility(View.VISIBLE);
                    break;
                case 19 :
                    numberA19.setVisibility(View.VISIBLE);
                    break;
                case 20 :
                    numberA20.setVisibility(View.VISIBLE);
                    break;
                case 21 :
                    numberA21.setVisibility(View.VISIBLE);
                    break;
                case 22 :
                    numberA22.setVisibility(View.VISIBLE);
                    break;
                case 23 :
                    numberA23.setVisibility(View.VISIBLE);
                    break;
                case 24 :
                    numberA24.setVisibility(View.VISIBLE);
                    break;
                case 25 :
                    numberA25.setVisibility(View.VISIBLE);
                    break;
                case 26 :
                    numberA26.setVisibility(View.VISIBLE);
                    break;
                case 27 :
                    numberA27.setVisibility(View.VISIBLE);
                    break;
                case 28 :
                    numberA28.setVisibility(View.VISIBLE);
                    break;
                case 29 :
                    numberA29.setVisibility(View.VISIBLE);
                    break;
                case 30 :
                    numberA30.setVisibility(View.VISIBLE);
                    break;
                case 31 :
                    numberA31.setVisibility(View.VISIBLE);
                    break;
                case 32 :
                    numberA32.setVisibility(View.VISIBLE);
                    break;
                case 33 :
                    numberA33.setVisibility(View.VISIBLE);
                    break;
                case 34 :
                    numberA34.setVisibility(View.VISIBLE);
                    break;
                case 35 :
                    numberA35.setVisibility(View.VISIBLE);
                    break;
                case 36 :
                    numberA36.setVisibility(View.VISIBLE);
                    break;
                case 37 :
                    numberA37.setVisibility(View.VISIBLE);
                    break;
                case 38 :
                    numberA38.setVisibility(View.VISIBLE);
                    break;
                case 39 :
                    numberA39.setVisibility(View.VISIBLE);
                    break;
                case 40 :
                    numberA40.setVisibility(View.VISIBLE);
                    break;
                case 41 :
                    numberA41.setVisibility(View.VISIBLE);
                    break;
                case 42 :
                    numberA42.setVisibility(View.VISIBLE);
                    break;
                case 43 :
                    numberA43.setVisibility(View.VISIBLE);
                    break;
                case 44 :
                    numberA44.setVisibility(View.VISIBLE);
                    break;
                case 45 :
                    numberA45.setVisibility(View.VISIBLE);
                    break;
                default:
            }



        }
    }

    public void lottoStart2(){
        int Lotto[] = new int[6];

        for(int i=0; i<Lotto.length; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(Lotto[i] == Lotto[j]){
                    i--;
                    break;
                }
            }

        }

        for(int i=0;i<Lotto.length;i++){
            Log.e("lotto number",Lotto[i] + " ");



            switch (Lotto[i]){

                case 1 :
                    numberB1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    numberB2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    numberB3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    numberB4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    numberB5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    numberB6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    numberB7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    numberB8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    numberB9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    numberB10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    numberB11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    numberB12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    numberB13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    numberB14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    numberB15.setVisibility(View.VISIBLE);
                    break;
                case 16 :
                    numberB16.setVisibility(View.VISIBLE);
                    break;
                case 17 :
                    numberB17.setVisibility(View.VISIBLE);
                    break;
                case 18 :
                    numberB18.setVisibility(View.VISIBLE);
                    break;
                case 19 :
                    numberB19.setVisibility(View.VISIBLE);
                    break;
                case 20 :
                    numberB20.setVisibility(View.VISIBLE);
                    break;
                case 21 :
                    numberB21.setVisibility(View.VISIBLE);
                    break;
                case 22 :
                    numberB22.setVisibility(View.VISIBLE);
                    break;
                case 23 :
                    numberB23.setVisibility(View.VISIBLE);
                    break;
                case 24 :
                    numberB24.setVisibility(View.VISIBLE);
                    break;
                case 25 :
                    numberB25.setVisibility(View.VISIBLE);
                    break;
                case 26 :
                    numberB26.setVisibility(View.VISIBLE);
                    break;
                case 27 :
                    numberB27.setVisibility(View.VISIBLE);
                    break;
                case 28 :
                    numberB28.setVisibility(View.VISIBLE);
                    break;
                case 29 :
                    numberB29.setVisibility(View.VISIBLE);
                    break;
                case 30 :
                    numberB30.setVisibility(View.VISIBLE);
                    break;
                case 31 :
                    numberB31.setVisibility(View.VISIBLE);
                    break;
                case 32 :
                    numberB32.setVisibility(View.VISIBLE);
                    break;
                case 33 :
                    numberB33.setVisibility(View.VISIBLE);
                    break;
                case 34 :
                    numberB34.setVisibility(View.VISIBLE);
                    break;
                case 35 :
                    numberB35.setVisibility(View.VISIBLE);
                    break;
                case 36 :
                    numberB36.setVisibility(View.VISIBLE);
                    break;
                case 37 :
                    numberB37.setVisibility(View.VISIBLE);
                    break;
                case 38 :
                    numberB38.setVisibility(View.VISIBLE);
                    break;
                case 39 :
                    numberB39.setVisibility(View.VISIBLE);
                    break;
                case 40 :
                    numberB40.setVisibility(View.VISIBLE);
                    break;
                case 41 :
                    numberB41.setVisibility(View.VISIBLE);
                    break;
                case 42 :
                    numberB42.setVisibility(View.VISIBLE);
                    break;
                case 43 :
                    numberB43.setVisibility(View.VISIBLE);
                    break;
                case 44 :
                    numberB44.setVisibility(View.VISIBLE);
                    break;
                case 45 :
                    numberB45.setVisibility(View.VISIBLE);
                    break;
                default:
            }



        }
    }

    public void lottoStart3(){
        int Lotto[] = new int[6];

        for(int i=0; i<Lotto.length; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(Lotto[i] == Lotto[j]){
                    i--;
                    break;
                }
            }

        }

        for(int i=0;i<Lotto.length;i++){
            Log.e("lotto number",Lotto[i] + " ");



            switch (Lotto[i]){

                case 1 :
                    numberC1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    numberC2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    numberC3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    numberC4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    numberC5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    numberC6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    numberC7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    numberC8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    numberC9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    numberC10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    numberC11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    numberC12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    numberC13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    numberC14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    numberC15.setVisibility(View.VISIBLE);
                    break;
                case 16 :
                    numberC16.setVisibility(View.VISIBLE);
                    break;
                case 17 :
                    numberC17.setVisibility(View.VISIBLE);
                    break;
                case 18 :
                    numberC18.setVisibility(View.VISIBLE);
                    break;
                case 19 :
                    numberC19.setVisibility(View.VISIBLE);
                    break;
                case 20 :
                    numberC20.setVisibility(View.VISIBLE);
                    break;
                case 21 :
                    numberC21.setVisibility(View.VISIBLE);
                    break;
                case 22 :
                    numberC22.setVisibility(View.VISIBLE);
                    break;
                case 23 :
                    numberC23.setVisibility(View.VISIBLE);
                    break;
                case 24 :
                    numberC24.setVisibility(View.VISIBLE);
                    break;
                case 25 :
                    numberC25.setVisibility(View.VISIBLE);
                    break;
                case 26 :
                    numberC26.setVisibility(View.VISIBLE);
                    break;
                case 27 :
                    numberC27.setVisibility(View.VISIBLE);
                    break;
                case 28 :
                    numberC28.setVisibility(View.VISIBLE);
                    break;
                case 29 :
                    numberC29.setVisibility(View.VISIBLE);
                    break;
                case 30 :
                    numberC30.setVisibility(View.VISIBLE);
                    break;
                case 31 :
                    numberC31.setVisibility(View.VISIBLE);
                    break;
                case 32 :
                    numberC32.setVisibility(View.VISIBLE);
                    break;
                case 33 :
                    numberC33.setVisibility(View.VISIBLE);
                    break;
                case 34 :
                    numberC34.setVisibility(View.VISIBLE);
                    break;
                case 35 :
                    numberC35.setVisibility(View.VISIBLE);
                    break;
                case 36 :
                    numberC36.setVisibility(View.VISIBLE);
                    break;
                case 37 :
                    numberC37.setVisibility(View.VISIBLE);
                    break;
                case 38 :
                    numberC38.setVisibility(View.VISIBLE);
                    break;
                case 39 :
                    numberC39.setVisibility(View.VISIBLE);
                    break;
                case 40 :
                    numberC40.setVisibility(View.VISIBLE);
                    break;
                case 41 :
                    numberC41.setVisibility(View.VISIBLE);
                    break;
                case 42 :
                    numberC42.setVisibility(View.VISIBLE);
                    break;
                case 43 :
                    numberC43.setVisibility(View.VISIBLE);
                    break;
                case 44 :
                    numberC44.setVisibility(View.VISIBLE);
                    break;
                case 45 :
                    numberC45.setVisibility(View.VISIBLE);
                    break;
                default:
            }



        }
    }

    public void lottoStart4(){
        int Lotto[] = new int[6];

        for(int i=0; i<Lotto.length; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(Lotto[i] == Lotto[j]){
                    i--;
                    break;
                }
            }

        }

        for(int i=0;i<Lotto.length;i++){
            Log.e("lotto number",Lotto[i] + " ");



            switch (Lotto[i]){

                case 1 :
                    numberD1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    numberD2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    numberD3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    numberD4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    numberD5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    numberD6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    numberD7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    numberD8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    numberD9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    numberD10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    numberD11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    numberD12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    numberD13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    numberD14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    numberD15.setVisibility(View.VISIBLE);
                    break;
                case 16 :
                    numberD16.setVisibility(View.VISIBLE);
                    break;
                case 17 :
                    numberD17.setVisibility(View.VISIBLE);
                    break;
                case 18 :
                    numberD18.setVisibility(View.VISIBLE);
                    break;
                case 19 :
                    numberD19.setVisibility(View.VISIBLE);
                    break;
                case 20 :
                    numberD20.setVisibility(View.VISIBLE);
                    break;
                case 21 :
                    numberD21.setVisibility(View.VISIBLE);
                    break;
                case 22 :
                    numberD22.setVisibility(View.VISIBLE);
                    break;
                case 23 :
                    numberD23.setVisibility(View.VISIBLE);
                    break;
                case 24 :
                    numberD24.setVisibility(View.VISIBLE);
                    break;
                case 25 :
                    numberD25.setVisibility(View.VISIBLE);
                    break;
                case 26 :
                    numberD26.setVisibility(View.VISIBLE);
                    break;
                case 27 :
                    numberD27.setVisibility(View.VISIBLE);
                    break;
                case 28 :
                    numberD28.setVisibility(View.VISIBLE);
                    break;
                case 29 :
                    numberD29.setVisibility(View.VISIBLE);
                    break;
                case 30 :
                    numberD30.setVisibility(View.VISIBLE);
                    break;
                case 31 :
                    numberD31.setVisibility(View.VISIBLE);
                    break;
                case 32 :
                    numberD32.setVisibility(View.VISIBLE);
                    break;
                case 33 :
                    numberD33.setVisibility(View.VISIBLE);
                    break;
                case 34 :
                    numberD34.setVisibility(View.VISIBLE);
                    break;
                case 35 :
                    numberD35.setVisibility(View.VISIBLE);
                    break;
                case 36 :
                    numberD36.setVisibility(View.VISIBLE);
                    break;
                case 37 :
                    numberD37.setVisibility(View.VISIBLE);
                    break;
                case 38 :
                    numberD38.setVisibility(View.VISIBLE);
                    break;
                case 39 :
                    numberD39.setVisibility(View.VISIBLE);
                    break;
                case 40 :
                    numberD40.setVisibility(View.VISIBLE);
                    break;
                case 41 :
                    numberD41.setVisibility(View.VISIBLE);
                    break;
                case 42 :
                    numberD42.setVisibility(View.VISIBLE);
                    break;
                case 43 :
                    numberD43.setVisibility(View.VISIBLE);
                    break;
                case 44 :
                    numberD44.setVisibility(View.VISIBLE);
                    break;
                case 45 :
                    numberD45.setVisibility(View.VISIBLE);
                    break;
                default:
            }



        }
    }

    public void lottoStart5(){
        int Lotto[] = new int[6];

        for(int i=0; i<Lotto.length; i++){
            Lotto[i] = (int)(Math.random()*45)+1;

            for(int j=0; j<i; j++){
                if(Lotto[i] == Lotto[j]){
                    i--;
                    break;
                }
            }

        }

        for(int i=0;i<Lotto.length;i++){
            Log.e("lotto number",Lotto[i] + " ");



            switch (Lotto[i]){

                case 1 :
                    numberE1.setVisibility(View.VISIBLE);
                    break;
                case 2 :
                    numberE2.setVisibility(View.VISIBLE);
                    break;
                case 3 :
                    numberE3.setVisibility(View.VISIBLE);
                    break;
                case 4 :
                    numberE4.setVisibility(View.VISIBLE);
                    break;
                case 5 :
                    numberE5.setVisibility(View.VISIBLE);
                    break;
                case 6 :
                    numberE6.setVisibility(View.VISIBLE);
                    break;
                case 7 :
                    numberE7.setVisibility(View.VISIBLE);
                    break;
                case 8 :
                    numberE8.setVisibility(View.VISIBLE);
                    break;
                case 9 :
                    numberE9.setVisibility(View.VISIBLE);
                    break;
                case 10 :
                    numberE10.setVisibility(View.VISIBLE);
                    break;
                case 11 :
                    numberE11.setVisibility(View.VISIBLE);
                    break;
                case 12 :
                    numberE12.setVisibility(View.VISIBLE);
                    break;
                case 13 :
                    numberE13.setVisibility(View.VISIBLE);
                    break;
                case 14 :
                    numberE14.setVisibility(View.VISIBLE);
                    break;
                case 15 :
                    numberE15.setVisibility(View.VISIBLE);
                    break;
                case 16 :
                    numberE16.setVisibility(View.VISIBLE);
                    break;
                case 17 :
                    numberE17.setVisibility(View.VISIBLE);
                    break;
                case 18 :
                    numberE18.setVisibility(View.VISIBLE);
                    break;
                case 19 :
                    numberE19.setVisibility(View.VISIBLE);
                    break;
                case 20 :
                    numberE20.setVisibility(View.VISIBLE);
                    break;
                case 21 :
                    numberE21.setVisibility(View.VISIBLE);
                    break;
                case 22 :
                    numberE22.setVisibility(View.VISIBLE);
                    break;
                case 23 :
                    numberE23.setVisibility(View.VISIBLE);
                    break;
                case 24 :
                    numberE24.setVisibility(View.VISIBLE);
                    break;
                case 25 :
                    numberE25.setVisibility(View.VISIBLE);
                    break;
                case 26 :
                    numberE26.setVisibility(View.VISIBLE);
                    break;
                case 27 :
                    numberE27.setVisibility(View.VISIBLE);
                    break;
                case 28 :
                    numberE28.setVisibility(View.VISIBLE);
                    break;
                case 29 :
                    numberE29.setVisibility(View.VISIBLE);
                    break;
                case 30 :
                    numberE30.setVisibility(View.VISIBLE);
                    break;
                case 31 :
                    numberE31.setVisibility(View.VISIBLE);
                    break;
                case 32 :
                    numberE32.setVisibility(View.VISIBLE);
                    break;
                case 33 :
                    numberE33.setVisibility(View.VISIBLE);
                    break;
                case 34 :
                    numberE34.setVisibility(View.VISIBLE);
                    break;
                case 35 :
                    numberE35.setVisibility(View.VISIBLE);
                    break;
                case 36 :
                    numberE36.setVisibility(View.VISIBLE);
                    break;
                case 37 :
                    numberE37.setVisibility(View.VISIBLE);
                    break;
                case 38 :
                    numberE38.setVisibility(View.VISIBLE);
                    break;
                case 39 :
                    numberE39.setVisibility(View.VISIBLE);
                    break;
                case 40 :
                    numberE40.setVisibility(View.VISIBLE);
                    break;
                case 41 :
                    numberE41.setVisibility(View.VISIBLE);
                    break;
                case 42 :
                    numberE42.setVisibility(View.VISIBLE);
                    break;
                case 43 :
                    numberE43.setVisibility(View.VISIBLE);
                    break;
                case 44 :
                    numberE44.setVisibility(View.VISIBLE);
                    break;
                case 45 :
                    numberE45.setVisibility(View.VISIBLE);
                    break;
                default:
            }



        }
    }

    public void setGone(){
        numberA1.setVisibility(View.GONE);
        numberA2.setVisibility(View.GONE);
        numberA3.setVisibility(View.GONE);
        numberA4.setVisibility(View.GONE);
        numberA5.setVisibility(View.GONE);
        numberA6.setVisibility(View.GONE);
        numberA7.setVisibility(View.GONE);
        numberA8.setVisibility(View.GONE);
        numberA9.setVisibility(View.GONE);
        numberA10.setVisibility(View.GONE);

        numberA11.setVisibility(View.GONE);
        numberA12.setVisibility(View.GONE);
        numberA13.setVisibility(View.GONE);
        numberA14.setVisibility(View.GONE);
        numberA15.setVisibility(View.GONE);
        numberA16.setVisibility(View.GONE);
        numberA17.setVisibility(View.GONE);
        numberA18.setVisibility(View.GONE);
        numberA19.setVisibility(View.GONE);
        numberA20.setVisibility(View.GONE);

        numberA21.setVisibility(View.GONE);
        numberA22.setVisibility(View.GONE);
        numberA23.setVisibility(View.GONE);
        numberA24.setVisibility(View.GONE);
        numberA25.setVisibility(View.GONE);
        numberA26.setVisibility(View.GONE);
        numberA27.setVisibility(View.GONE);
        numberA28.setVisibility(View.GONE);
        numberA29.setVisibility(View.GONE);
        numberA30.setVisibility(View.GONE);

        numberA31.setVisibility(View.GONE);
        numberA32.setVisibility(View.GONE);
        numberA33.setVisibility(View.GONE);
        numberA34.setVisibility(View.GONE);
        numberA35.setVisibility(View.GONE);
        numberA36.setVisibility(View.GONE);
        numberA37.setVisibility(View.GONE);
        numberA38.setVisibility(View.GONE);
        numberA39.setVisibility(View.GONE);
        numberA40.setVisibility(View.GONE);

        numberA41.setVisibility(View.GONE);
        numberA42.setVisibility(View.GONE);
        numberA43.setVisibility(View.GONE);
        numberA44.setVisibility(View.GONE);
        numberA45.setVisibility(View.GONE);

        numberB1.setVisibility(View.GONE);
        numberB2.setVisibility(View.GONE);
        numberB3.setVisibility(View.GONE);
        numberB4.setVisibility(View.GONE);
        numberB5.setVisibility(View.GONE);
        numberB6.setVisibility(View.GONE);
        numberB7.setVisibility(View.GONE);
        numberB8.setVisibility(View.GONE);
        numberB9.setVisibility(View.GONE);
        numberB10.setVisibility(View.GONE);

        numberB11.setVisibility(View.GONE);
        numberB12.setVisibility(View.GONE);
        numberB13.setVisibility(View.GONE);
        numberB14.setVisibility(View.GONE);
        numberB15.setVisibility(View.GONE);
        numberB16.setVisibility(View.GONE);
        numberB17.setVisibility(View.GONE);
        numberB18.setVisibility(View.GONE);
        numberB19.setVisibility(View.GONE);
        numberB20.setVisibility(View.GONE);

        numberB21.setVisibility(View.GONE);
        numberB22.setVisibility(View.GONE);
        numberB23.setVisibility(View.GONE);
        numberB24.setVisibility(View.GONE);
        numberB25.setVisibility(View.GONE);
        numberB26.setVisibility(View.GONE);
        numberB27.setVisibility(View.GONE);
        numberB28.setVisibility(View.GONE);
        numberB29.setVisibility(View.GONE);
        numberB30.setVisibility(View.GONE);

        numberB31.setVisibility(View.GONE);
        numberB32.setVisibility(View.GONE);
        numberB33.setVisibility(View.GONE);
        numberB34.setVisibility(View.GONE);
        numberB35.setVisibility(View.GONE);
        numberB36.setVisibility(View.GONE);
        numberB37.setVisibility(View.GONE);
        numberB38.setVisibility(View.GONE);
        numberB39.setVisibility(View.GONE);
        numberB40.setVisibility(View.GONE);

        numberB41.setVisibility(View.GONE);
        numberB42.setVisibility(View.GONE);
        numberB43.setVisibility(View.GONE);
        numberB44.setVisibility(View.GONE);
        numberB45.setVisibility(View.GONE);

        numberC1.setVisibility(View.GONE);
        numberC2.setVisibility(View.GONE);
        numberC3.setVisibility(View.GONE);
        numberC4.setVisibility(View.GONE);
        numberC5.setVisibility(View.GONE);
        numberC6.setVisibility(View.GONE);
        numberC7.setVisibility(View.GONE);
        numberC8.setVisibility(View.GONE);
        numberC9.setVisibility(View.GONE);
        numberC10.setVisibility(View.GONE);

        numberC11.setVisibility(View.GONE);
        numberC12.setVisibility(View.GONE);
        numberC13.setVisibility(View.GONE);
        numberC14.setVisibility(View.GONE);
        numberC15.setVisibility(View.GONE);
        numberC16.setVisibility(View.GONE);
        numberC17.setVisibility(View.GONE);
        numberC18.setVisibility(View.GONE);
        numberC19.setVisibility(View.GONE);
        numberC20.setVisibility(View.GONE);

        numberC21.setVisibility(View.GONE);
        numberC22.setVisibility(View.GONE);
        numberC23.setVisibility(View.GONE);
        numberC24.setVisibility(View.GONE);
        numberC25.setVisibility(View.GONE);
        numberC26.setVisibility(View.GONE);
        numberC27.setVisibility(View.GONE);
        numberC28.setVisibility(View.GONE);
        numberC29.setVisibility(View.GONE);
        numberC30.setVisibility(View.GONE);

        numberC31.setVisibility(View.GONE);
        numberC32.setVisibility(View.GONE);
        numberC33.setVisibility(View.GONE);
        numberC34.setVisibility(View.GONE);
        numberC35.setVisibility(View.GONE);
        numberC36.setVisibility(View.GONE);
        numberC37.setVisibility(View.GONE);
        numberC38.setVisibility(View.GONE);
        numberC39.setVisibility(View.GONE);
        numberC40.setVisibility(View.GONE);

        numberC41.setVisibility(View.GONE);
        numberC42.setVisibility(View.GONE);
        numberC43.setVisibility(View.GONE);
        numberC44.setVisibility(View.GONE);
        numberC45.setVisibility(View.GONE);

        numberD1.setVisibility(View.GONE);
        numberD2.setVisibility(View.GONE);
        numberD3.setVisibility(View.GONE);
        numberD4.setVisibility(View.GONE);
        numberD5.setVisibility(View.GONE);
        numberD6.setVisibility(View.GONE);
        numberD7.setVisibility(View.GONE);
        numberD8.setVisibility(View.GONE);
        numberD9.setVisibility(View.GONE);
        numberD10.setVisibility(View.GONE);

        numberD11.setVisibility(View.GONE);
        numberD12.setVisibility(View.GONE);
        numberD13.setVisibility(View.GONE);
        numberD14.setVisibility(View.GONE);
        numberD15.setVisibility(View.GONE);
        numberD16.setVisibility(View.GONE);
        numberD17.setVisibility(View.GONE);
        numberD18.setVisibility(View.GONE);
        numberD19.setVisibility(View.GONE);
        numberD20.setVisibility(View.GONE);

        numberD21.setVisibility(View.GONE);
        numberD22.setVisibility(View.GONE);
        numberD23.setVisibility(View.GONE);
        numberD24.setVisibility(View.GONE);
        numberD25.setVisibility(View.GONE);
        numberD26.setVisibility(View.GONE);
        numberD27.setVisibility(View.GONE);
        numberD28.setVisibility(View.GONE);
        numberD29.setVisibility(View.GONE);
        numberD30.setVisibility(View.GONE);

        numberD31.setVisibility(View.GONE);
        numberD32.setVisibility(View.GONE);
        numberD33.setVisibility(View.GONE);
        numberD34.setVisibility(View.GONE);
        numberD35.setVisibility(View.GONE);
        numberD36.setVisibility(View.GONE);
        numberD37.setVisibility(View.GONE);
        numberD38.setVisibility(View.GONE);
        numberD39.setVisibility(View.GONE);
        numberD40.setVisibility(View.GONE);

        numberD41.setVisibility(View.GONE);
        numberD42.setVisibility(View.GONE);
        numberD43.setVisibility(View.GONE);
        numberD44.setVisibility(View.GONE);
        numberD45.setVisibility(View.GONE);

        numberE1.setVisibility(View.GONE);
        numberE2.setVisibility(View.GONE);
        numberE3.setVisibility(View.GONE);
        numberE4.setVisibility(View.GONE);
        numberE5.setVisibility(View.GONE);
        numberE6.setVisibility(View.GONE);
        numberE7.setVisibility(View.GONE);
        numberE8.setVisibility(View.GONE);
        numberE9.setVisibility(View.GONE);
        numberE10.setVisibility(View.GONE);

        numberE11.setVisibility(View.GONE);
        numberE12.setVisibility(View.GONE);
        numberE13.setVisibility(View.GONE);
        numberE14.setVisibility(View.GONE);
        numberE15.setVisibility(View.GONE);
        numberE16.setVisibility(View.GONE);
        numberE17.setVisibility(View.GONE);
        numberE18.setVisibility(View.GONE);
        numberE19.setVisibility(View.GONE);
        numberE20.setVisibility(View.GONE);

        numberE21.setVisibility(View.GONE);
        numberE22.setVisibility(View.GONE);
        numberE23.setVisibility(View.GONE);
        numberE24.setVisibility(View.GONE);
        numberE25.setVisibility(View.GONE);
        numberE26.setVisibility(View.GONE);
        numberE27.setVisibility(View.GONE);
        numberE28.setVisibility(View.GONE);
        numberE29.setVisibility(View.GONE);
        numberE30.setVisibility(View.GONE);

        numberE31.setVisibility(View.GONE);
        numberE32.setVisibility(View.GONE);
        numberE33.setVisibility(View.GONE);
        numberE34.setVisibility(View.GONE);
        numberE35.setVisibility(View.GONE);
        numberE36.setVisibility(View.GONE);
        numberE37.setVisibility(View.GONE);
        numberE38.setVisibility(View.GONE);
        numberE39.setVisibility(View.GONE);
        numberE40.setVisibility(View.GONE);

        numberE41.setVisibility(View.GONE);
        numberE42.setVisibility(View.GONE);
        numberE43.setVisibility(View.GONE);
        numberE44.setVisibility(View.GONE);
        numberE45.setVisibility(View.GONE);
    }



}
