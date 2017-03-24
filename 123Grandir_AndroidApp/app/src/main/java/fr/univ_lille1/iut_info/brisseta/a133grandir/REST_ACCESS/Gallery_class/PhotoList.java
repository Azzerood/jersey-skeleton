package fr.univ_lille1.iut_info.brisseta.a133grandir.REST_ACCESS.Gallery_class;

import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static android.Manifest.*;
import static android.support.v4.app.ActivityCompat.requestPermissions;
import static android.support.v4.app.ActivityCompat.shouldShowRequestPermissionRationale;
import static android.support.v4.content.ContextCompat.checkSelfPermission;

/**
 * Created by adrie on 24/03/2017.
 */

public abstract class PhotoList {

    public static List<File> listeFichier(){
        String path = Environment.getExternalStorageDirectory().toString();
        File directory = new File(path);
        Log.d("accessible","write"+directory.canWrite()+" read : "+directory.canRead());
        File[] files = directory.listFiles();
        List<File> toRes = new ArrayList<>();
        for (int i = 0; i < files.length; i++)
        {
            if(files[i].isFile() && files[i].getName().contains("123Grandir")){
                toRes.add(files[i]);
            }
        }
        return toRes;
    }
}
