package com.uc.ehome.api;

import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

/**
 * Created by Wayne on 9/6/2015.
 */
public class ServiceGenerator {

    // No need to instantiate this class.
    private ServiceGenerator() {
    }

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        // call basic auth generator method without user and pass
        return createService(serviceClass, baseUrl, null, null);
    }

    /* for Authentication */
    public static <S> S createService(Class<S> serviceClass, String baseUrl, String email, String password) {
        // set endpoint url and use OkHTTP as HTTP client
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(baseUrl)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(new OkHttpClient()));

//        if (email != null && password != null) {
//            // concatenate email and password with colon for authentication
//            final String credentials = email + ":" + password;
//
//            builder.setRequestInterceptor(new RequestInterceptor() {
//                @Override
//                public void intercept(RequestFacade request) {
//                    // create Base64 encodet string
//                    String string = "Basic " + Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
//                    request.addHeader("Accept", "application/json");
//                    request.addHeader("Authorization", string);
//                }
//            });
//        }

        RestAdapter adapter = builder.build();

        return adapter.create(serviceClass);
    }
}


