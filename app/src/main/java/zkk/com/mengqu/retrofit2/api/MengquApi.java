package zkk.com.mengqu.retrofit2.api;

import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import zkk.com.mengqu.retrofit2.interfaces.ApimoejuInterface;
import zkk.com.mengqu.retrofit2.interfaces.ApiwwwmoejuInterface;

/**
 * Created by Administrator on 2016/6/27 0027.
 */
public class MengquApi {

    public  static ApimoejuInterface apimoejuInterface;
    public  static ApiwwwmoejuInterface apiwwwmoejuInterface;

    private static OkHttpClient okHttpClient = new OkHttpClient();

    private static Converter.Factory gsonConverterFactory = GsonConverterFactory.create();
    private static CallAdapter.Factory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();


    public  static  ApimoejuInterface getInstance(){


        if(apimoejuInterface==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://api.moeju.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apimoejuInterface = retrofit.create(ApimoejuInterface.class);
        }
        return  apimoejuInterface;
    }



    public  static  ApiwwwmoejuInterface getwwwInstance(){

        if(apiwwwmoejuInterface==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl("http://www.moeju.cn/")
                    .addConverterFactory(gsonConverterFactory)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .build();
            apiwwwmoejuInterface = retrofit.create(ApiwwwmoejuInterface.class);
        }
        return  apiwwwmoejuInterface;
    }
}
