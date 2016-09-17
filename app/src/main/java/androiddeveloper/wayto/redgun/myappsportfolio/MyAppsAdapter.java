package androiddeveloper.wayto.redgun.myappsportfolio;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ravindra on 25-06-2016.
 */
public class MyAppsAdapter extends BaseAdapter {


    private static LayoutInflater inflater = null;
    ArrayList<MyApp> result;
    Context context;

    public MyAppsAdapter(Context context, ArrayList<MyApp> productsList) {
        // TODO Auto-generated constructor stub
        result = productsList;
        context = context;
        inflater = (LayoutInflater) context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder;
        View rowView = convertView;
        if (rowView == null) {
            rowView = inflater.inflate(R.layout.my_apps_listview_layout, parent, false);
            holder = new Holder();
            holder.app_name_tv = (TextView) rowView.findViewById(R.id.app_name_tv);

            rowView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.app_name_tv.setText(result.get(position).getAppName());
        return rowView;
    }

    public class Holder {
        TextView app_name_tv;
    }

}

