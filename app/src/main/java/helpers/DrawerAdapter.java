package helpers;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.uc.ehome.R;

import com.uc.ehome.models.DrawerItems;

/**
 * Created by Stephanie Lyn on 9/22/2015.
 */
public class DrawerAdapter extends ArrayAdapter<DrawerItems> {
    Context mContext;
    int mLayoutId;
    DrawerItems[] items;

    public DrawerAdapter(Context context, int resource, DrawerItems[] objects) {
        super(context, resource, objects);

        mContext = context;
        mLayoutId = resource;
        items = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        View view = inflater.inflate(mLayoutId, parent, false);

        ImageView icon = (ImageView) view.findViewById(R.id.drawer_icon);
        TextView label = (TextView) view.findViewById(R.id.drawer_title);

        icon.setImageResource(items[position].getIcon());
        label.setText(items[position].getLabel());

        return view;
    }
}
