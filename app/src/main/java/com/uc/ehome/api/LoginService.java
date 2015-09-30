package com.uc.ehome.api;

import com.uc.ehome.models.User;
import constants.URI;
import retrofit.http.Body;
import retrofit.http.POST;

import java.util.Hashtable;

/**
 * Created by Wayne on 9/6/2015.
 */
public interface LoginService {

    @POST(URI.LOGIN)
    void basicLogin(@Body Hashtable credentials, retrofit.Callback<User> callback);

}
