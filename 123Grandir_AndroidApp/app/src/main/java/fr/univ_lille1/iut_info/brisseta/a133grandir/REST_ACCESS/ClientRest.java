package fr.univ_lille1.iut_info.brisseta.a133grandir.REST_ACCESS;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by adrie on 24/03/2017.
 */

public class ClientRest {
    private Context context;
    private String login ;
    private String passwd;

    public ClientRest(Context context, String login , String passwd){
        this.context = context;
        this.login = login;
        this.passwd = passwd;
    }
    public String getUrlData(String url){
        RequestQueue queue = Volley.newRequestQueue(context);
        System.setProperty("http.proxyHost","cache.univ-lille1.fr");
        System.setProperty("http.proxyPort","3128");
        String urlServ = "http://172.18.49.73:8080/"+url;
        StringRequest stringRequest;
        final String[] res = new String[1];
        stringRequest = new StringRequest(Request.Method.GET,url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            System.out.print("Response is :"+response.substring(0,500));
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print("ça a merdé");
                error.printStackTrace();
            }
        });
        queue.add(stringRequest);
        return res[0];
    }

}
