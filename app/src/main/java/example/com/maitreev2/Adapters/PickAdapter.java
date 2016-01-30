package example.com.maitreev2.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

import example.com.maitreev2.R;
import example.com.maitreev2.Response;

/**
 * Created by Hello on 28-01-2016.
 */
public class PickAdapter extends BaseAdapter {

    Context context;
    List<Response.DatesEntity.PickuppointsEntity> meetpointlist;
    LayoutInflater mLayoutInflater;
    public PickAdapter(Context context, List<Response.DatesEntity.PickuppointsEntity> meetpointlist)
    {
        this.context=context;
        this.meetpointlist=meetpointlist;
        mLayoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return meetpointlist.size();
    }

    @Override
    public Response.DatesEntity.PickuppointsEntity getItem(int position) {
        return meetpointlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder mViewHolder;
        if(convertView==null){
            convertView = mLayoutInflater.inflate(R.layout.listrow,null);
            mViewHolder = new ViewHolder();
            mViewHolder.meetname = (TextView) convertView.findViewById(R.id.meetplace);
            mViewHolder.meettime = (TextView) convertView.findViewById(R.id.meettime);
            mViewHolder.meetlat= (TextView) convertView.findViewById(R.id.meetlat);
            mViewHolder.meetlang= (TextView) convertView.findViewById(R.id.meetlang);
            mViewHolder.meetimage= (ImageView) convertView.findViewById(R.id.navigatebutton);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder) convertView.getTag();
        }
        mViewHolder.meetname.setText(getItem(position).getAddress());
        mViewHolder.meettime.setText(getItem(position).getTime());
        mViewHolder.meetlat.setText(getItem(position).getLat());
        mViewHolder.meetlang.setText(getItem(position).getLang());
        mViewHolder.meetimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,mViewHolder.meetlat.getText().toString()+" "+mViewHolder.meetlang.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
        return convertView;

    }
    static class ViewHolder {


        TextView meetname;
        TextView meetlat;
        TextView meetlang;
        TextView meettime;
        ImageView meetimage;

    }
}
