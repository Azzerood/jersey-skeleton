package fr.univ_lille1.iut_info.brisseta.a133grandir.REST_ACCESS.Gallery_class;

import android.app.Activity;
import android.app.ActionBar.LayoutParams;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

import java.io.File;
import java.util.List;

import fr.univ_lille1.iut_info.brisseta.a133grandir.R;

public class ImageSwitcherActivity extends Activity {
    private ImageSwitcher sw;
    private Button b1, b2;
    public static int INDEX = 0;
    public static List<File> gallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        gallery = PhotoList.listeFichier();   /*  RECUP la lste des images de l 'app dans sdcard */
        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

        sw = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        sw.setFactory(new ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT));
                return myView;
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "previous Image",
                        Toast.LENGTH_LONG).show();
                File head = imageSuivante(INDEX);
                sw.setImageDrawable(Drawable.createFromPath(head.getAbsolutePath()));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Next Image",
                        Toast.LENGTH_LONG).show();
                File head = imageSuivante(INDEX);
                ImageView imageView = (ImageView) findViewById(R.id.icon);
                imageView.setImageDrawable(Drawable.createFromPath(head.getAbsolutePath()));
            }
        });

    }

    public File imageSuivante(int index) {
        if (index < gallery.size())
            INDEX++;
        else
            INDEX = 0;
        return gallery.get(INDEX);
    }

    public File imagePrecedente(int index) {
        if (index > 0)
            INDEX--;
        else
            INDEX = 0;
        return gallery.get(INDEX);
    }
}