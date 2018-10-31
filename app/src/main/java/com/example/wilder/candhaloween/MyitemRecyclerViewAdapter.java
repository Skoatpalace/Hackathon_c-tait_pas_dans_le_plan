package com.example.wilder.candhaloween;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wilder.candhaloween.ListFragment.OnListFragmentInteractionListener;
import com.example.wilder.candhaloween.dummy.DummyContent.DummyItem;
import com.google.android.gms.flags.Singletons;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyitemRecyclerViewAdapter extends RecyclerView.Adapter<MyitemRecyclerViewAdapter.ViewHolder> {

    private ArrayList<BonbonModel> mBonbon = new ArrayList<>();
    /*BonbonModel bonbonModel=mBonbon.get(0);
    BonbonModel bonbonModel2=mBonbon.get(1);
    BonbonModel bonbonModel3=mBonbon.get(2);
    BonbonModel bonbonModel4=mBonbon.get(3);
    BonbonModel bonbonModel5=mBonbon.get(4);
    BonbonModel bonbonModel6=mBonbon.get(5);
    BonbonModel bonbonModel7=mBonbon.get(6);
    BonbonModel bonbonModel8=mBonbon.get(7);
    BonbonModel bonbonModel9=mBonbon.get(8);
    BonbonModel bonbonModel10=mBonbon.get(9);
    BonbonModel bonbonModel11=mBonbon.get(10);
    BonbonModel bonbonModel12=mBonbon.get(11);
    BonbonModel bonbonModel13=mBonbon.get(12);
    BonbonModel bonbonModel14=mBonbon.get(13);*/


    public MyitemRecyclerViewAdapter(ArrayList<BonbonModel> bonbon) {

        mBonbon = bonbon;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBonbon;
        TextView tvNomBonbon;
        TextView tvCompteur;

        public ViewHolder(View v) {
            super(v);
            this.ivBonbon = v.findViewById(R.id.iv_bonbon);
            this.tvNomBonbon = v.findViewById(R.id.tv_bonbon);
            this.tvCompteur = v.findViewById(R.id.tv_compteur);
        }
    }

    @Override
    public MyitemRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyitemRecyclerViewAdapter.ViewHolder holder, int position) {

        final BonbonModel bonbonModel = mBonbon.get(position);
        //TODO: ajout images
        singleton sg = singleton.getInstance();
        holder.ivBonbon.setImageDrawable(bonbonModel.getPhoto());
        holder.tvNomBonbon.setText(bonbonModel.getName());
        holder.tvCompteur.setText(bonbonModel.getCompteur());
    }

    @Override
    public int getItemCount() {

        return mBonbon.size();
    }

}