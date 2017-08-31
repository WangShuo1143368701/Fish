package com.qijing.fish;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.qijing.fish.api.ApiUtil;
import com.qijing.fish.api.HttpManager;
import com.qijing.fish.model.request.GameFishBody;
import com.qijing.fish.model.request.RequestFactory;
import com.qijing.fish.model.respone.BaseRespone;
import com.qijing.fish.model.respone.GameFishRespone;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayout;
    private GameSurfaceView gameSurfaceView;
    private GameFishBody gameFishBody;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
//        frameLayout=(FrameLayout) findViewById(R.id.activity_main);
//        frameLayout.addView(new FinshGameView(context));
////        findViewById(R.id.test).setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                test();
////            }
////        });

    }


    private void test(){
        gameFishBody = new GameFishBody();
        gameFishBody.getFishBean().value="12";
        gameFishBody.getFish().fishtype=5;
        gameFishBody.getFish().id=102;
        gameFishBody.getFishBean().target_fish.add(gameFishBody.getFish());
        String body = new RequestFactory.Builder()
                .addBase(gameFishBody.CreateFishBaseRequest("104491304"))
                .addModel(gameFishBody.CreateBaseModel())
                .addBean(gameFishBody.CreateBaseBean(gameFishBody.getFishBean()))
                .bulid()
                .MakeRequestBody();
        HttpManager.doHttpTask(ApiUtil.createApiService().buyu(gameFishBody.getUrl(),body), new HttpManager.OnResultListener() {
            @Override
            public void onSuccess(BaseRespone t) {
                GameFishRespone gameFishRespone=(GameFishRespone)t.data;

                Log.e("MainActivity"," gameFishRespone " +gameFishRespone.toString());
            }

            @Override
            public void onError(Throwable error, String msg) {
                Log.e("TAG","失败");
            }
        });
    }
}
