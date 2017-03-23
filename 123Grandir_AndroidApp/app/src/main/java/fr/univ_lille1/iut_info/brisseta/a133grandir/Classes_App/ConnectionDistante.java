package fr.univ_lille1.iut_info.brisseta.a133grandir.Classes_App;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by adrie on 22/03/2017.
 */

public class ConnectionDistante {
    private String url;
    private String login;
    private String password;

  public ConnectionDistante(String url , String login , String passwd){
        this.url = url;
        this.login = login;
        this.password = login;
    }

    public JSONObject getJson(String pathToserveur,String name){
        JSONObject obj = null;
        try {

            URL url = new URL(pathToserveur);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            String result = InputStreamOperation.InputStreamToString(inputStream);

            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concernent
            JSONArray array = new JSONArray(jsonObject.getString(name));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                obj = new JSONObject(array.getString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  obj;

    }
    public boolean doLog(String name,String passwd){
        return false;
    }
    public boolean isAdmin(String user){
        try {
            JSONObject tmp = getJson("http://localhost:8080/users", user);
            if (tmp.get("grant").equals("admin")) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
    public boolean isUser(String user){
        try {
            JSONObject tmp = getJson("http://localhost:8080/users", user);
            if (tmp.get("grant").equals("user")) {
                return true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
