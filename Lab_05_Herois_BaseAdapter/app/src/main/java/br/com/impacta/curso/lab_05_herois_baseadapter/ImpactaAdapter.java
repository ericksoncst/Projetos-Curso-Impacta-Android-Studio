package br.com.impacta.curso.lab_05_herois_baseadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nalmir on 03/03/2018.
 */

public class ImpactaAdapter extends BaseAdapter {

    // Permiter acesso a recursos centralizados
    // Ler xml (celula) transformar binario
    private Context context;

    // flexibilizar o layout de celula
    private int resource;

    //
    private List<HMAux> data;

    // Ler XML para findViewByID
    private LayoutInflater mInflater;

    private long item_selecionado = -1;

    public void setItem_selecionado(long item_selecionado) {
        this.item_selecionado = item_selecionado;
        //
        notifyDataSetChanged();
    }

    public ImpactaAdapter(Context context, int resource, List<HMAux> data) {
        this.context = context;
        this.resource = resource;
        this.data = data;
        //this.mInflater = (LayoutInflater)
        //        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mInflater = LayoutInflater.from(context);
    }

    // Devolve a quantidade de registos da minha colecao
    @Override
    public int getCount() {
        return data.size();
    }

    // Devolve o registro especifico da posicao referenciada pelo
    // parametro position
    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        // data.get(position) = HMAux
        // data.get(position).get(HMAux.ID) = campos ID do HMAux
        // Long.parseLong(data.get(position).get(HMAux.ID)) = transformar
        // um valor string em um valor long
        return Long.parseLong(data.get(position).get(HMAux.ID));
    }


    // Criar a View com os dados devidamente processados
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Acesso aos dados referenciados pelo parametro position
        HMAux item = data.get(position);

        // Acesso ao LayOut da Celula
        if (convertView == null) {
            convertView = mInflater.inflate(
                    resource,
                    parent,
                    false
            );
        }

        // Acesso aos controles dentro da Celula
        LinearLayout ll = (LinearLayout)
                convertView.findViewById(R.id.celula_ll);

        ImageView iv_foto = (ImageView)
                convertView.findViewById(R.id.celula_iv_foto);

        TextView tv_nome = (TextView)
                convertView.findViewById(R.id.celula_tv_nome);

        // Preparacao Final da Celula
        iv_foto.setImageResource(Integer.parseInt(item.get(HMAux.TEXTO_01)));
        tv_nome.setText(item.get(HMAux.TEXTO_02));
        //
        if (item.get(HMAux.ID).equals(String.valueOf(item_selecionado))) {
            ll.setBackgroundColor(context.getResources().getColor(R.color.celula_selecionada));
        } else {
            ll.setBackgroundColor(context.getResources().getColor(R.color.celula_transparente));
        }
        //
        return convertView;
    }
}
