package br.com.impacta.curso.prj_007_listview_interface;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nalmir on 03/03/2018.
 */

public class PostAdapter extends BaseAdapter {

    private Context context;
    private int resource;
    private List<HMAux> data;

    private LayoutInflater mInflater;

    public interface IPostAdapter {
        void informarStatusPost(String id, String status);
    }

    private IPostAdapter delegate;

    public void setOnInformarStatusPostListener(IPostAdapter delegate) {
        this.delegate = delegate;
    }

    public PostAdapter(Context context, int resource, List<HMAux> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
        //
        this.mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return Long.parseLong(
                data.get(position).get(HMAux.ID)
        );
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HMAux item = data.get(position);

        if (convertView == null) {
            convertView = mInflater.inflate(
                    resource,
                    parent,
                    false
            );
        }

        TextView tv_post = (TextView)
                convertView.findViewById(R.id.celula_tv_post);
        CheckBox cb_curtir = (CheckBox)
                convertView.findViewById(R.id.celula_cb_curtir);

        cb_curtir.setOnCheckedChangeListener(null);

        tv_post.setText(item.get(HMAux.TEXTO_01));
        if (item.get(HMAux.TEXTO_02).equals("1")) {
            cb_curtir.setChecked(true);
        } else {
            cb_curtir.setChecked(false);
        }
        //
        cb_curtir.setTag(item);
        cb_curtir.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                HMAux item_rec = (HMAux) buttonView.getTag();
                //
                if (delegate != null) {
                    delegate.informarStatusPost(
                            item_rec.get(HMAux.ID),
                            String.valueOf(isChecked ? "1" : "0")
                    );
                }
            }
        });


        return convertView;
    }
}
