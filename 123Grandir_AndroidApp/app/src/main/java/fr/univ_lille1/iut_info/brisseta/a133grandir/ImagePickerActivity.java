package fr.univ_lille1.iut_info.brisseta.a133grandir;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Date;

public class ImagePickerActivity extends AppCompatActivity {

    private Uri mImageCaptureUri;
    private ImageView mImageView;
    private static final int PICK_FROM_CAMERA = 1;
    private static final int PICK_FROM_FILE = 2;
    ContentValues values = new ContentValues();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final String[] items = new String[]{"From Camera", "From SD Card"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, items);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select Image");
        builder.setAdapter(adapter, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                if (item == 0) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File file = new File(Environment.getExternalStorageDirectory(), "tmp_avatar_" + String.valueOf(System.currentTimeMillis()) + ".jpg");
                    mImageCaptureUri = Uri.fromFile(file);
                    try {
                        intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
                        intent.putExtra("return-data", true);
                        startActivityForResult(intent, PICK_FROM_CAMERA);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    dialog.cancel();
                } else {
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    startActivityForResult(Intent.createChooser(intent, "Complete action using"), PICK_FROM_FILE);
                }
            }
        });
        final AlertDialog dialog = builder.create();
        //mImageView = (ImageView) findViewById(R.id.envoyerImage); si affichage
        ((Button) findViewById(R.id.envoyerImage)).setOnClickListener(new View.OnClickListener() { //pour envoyer video

                                                                          public void onClick(View v) {
                                                                              dialog.show();
                                                                          }

                                                                      }

        );
        ((Button) findViewById(R.id.envoyerVideo)).setOnClickListener(new View.OnClickListener() { //pour envoyer Image

                                                                          public void onClick(View v) {
                                                                              dialog.show();
                                                                          }
                                                                      }

        );

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;
        Bitmap bitmap = null;
        String path = "";
        if (requestCode == PICK_FROM_FILE)
            mImageCaptureUri = data.getData();
        if (path == null)
            path = mImageCaptureUri.getPath(); //from File Manager
        if (path != null)
            bitmap = BitmapFactory.decodeFile(path);
        else {
            path = mImageCaptureUri.getPath();
            bitmap = BitmapFactory.decodeFile(path);
        }
        stockerImage(bitmap); //TODO

    }
    public void stockerImage(Bitmap image) {
        Bitmap bmp = image;

        if(bmp != null) {
            //Conversion de la bitmap en tableau de byte
            int bytes = bmp.getByteCount();
            ByteBuffer buffer = ByteBuffer.allocate(bytes);
            bmp.copyPixelsToBuffer(buffer);
            byte[] datas = buffer.array();
            //Le champs "mon_image" doit être de type BLOB
            File repertoireTmp = new File(Environment.getDataDirectory().toURI()+"tmp");
            if(repertoireTmp.exists()) {
                writeToFile(datas.toString(), getApplicationContext(), repertoireTmp);
            }else{
                repertoireTmp.mkdirs();
                writeToFile(datas.toString(), getApplicationContext(), repertoireTmp);
                setContentView(R.layout.activity_admin);
            }
        }
    }

    public void stockerVideo(MediaStore.Video video) {
        //TODO
    }
    private void writeToFile(String data,Context context,File repertoire) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(repertoire.getAbsolutePath(), Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
}
