package com.example.wilder.candhaloween;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wilder.candhaloween.ListFragment.OnListFragmentInteractionListener;
import com.example.wilder.candhaloween.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyitemRecyclerViewAdapter extends RecyclerView.Adapter<MyitemRecyclerViewAdapter.ViewHolder> {

    private ArrayList<BonbonModel> mBonbon = new ArrayList<>();

    public MyitemRecyclerViewAdapter(ArrayList<BonbonModel> bonbon) {

        mBonbon = bonbon;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView ivBonbon;
        TextView tvNomBonbon;

        public ViewHolder(View v) {
            super(v);
            this.ivBonbon = v.findViewById(R.id.iv_bonbon);
            this.tvNomBonbon = v.findViewById(R.id.tv_bonbon);
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
        //holder.ivBonbon.setImageDrawable(mBonbon.);
        holder.tvNomBonbon.setText(bonbonModel.getName());
    }

    @Override
    public int getItemCount() {

        return mBonbon.size();
    }

}
