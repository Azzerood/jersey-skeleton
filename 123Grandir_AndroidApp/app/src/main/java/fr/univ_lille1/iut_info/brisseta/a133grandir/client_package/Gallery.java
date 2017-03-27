package fr.univ_lille1.iut_info.brisseta.a133grandir.client_package;

import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import fr.univ_lille1.iut_info.brisseta.a133grandir.R;

public class Gallery extends AppCompatActivity {

    private ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
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
      /*  this.adapter = new ItemsAdapter(this, R.layout.content_admin, ItemManagers.getLoadedItems());
        setListAdapter(this.adapter);
        */

    }
    private class ItemsAdapter extends ArrayAdapter<ClipData.Item> implements ListAdapter {

        private ClipData.Item[] items;

        public ItemsAdapter(Context context, int textViewResourceId, ClipData.Item[] items) {
            super(context, textViewResourceId, items);
            this.items = items;
        }

       /* @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.content_gallery, null);
            }

            ClipData.Item it = items[position];
            if (it != null) {
                //ImageView iv = (ImageView) v.findViewById(R.id.);
                /*if (iv != null) {
                    //iv.setImageDrawable(it.getImage());
                }
            }
            return v;
        }
        */
    }
}