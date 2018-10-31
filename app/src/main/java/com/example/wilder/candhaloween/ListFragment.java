package com.example.wilder.candhaloween;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wilder.candhaloween.dummy.DummyContent;
import com.example.wilder.candhaloween.dummy.DummyContent.DummyItem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ListFragment newInstance(int columnCount) {
        ListFragment fragment = new ListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

        //listBonbon.setAdapter(getContext().adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            //recyclerView.setAdapter(new MyitemRecyclerViewAdapter(DummyContent.ITEMS, mListener));

        }
        return view;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayList<BonbonModel> mBonbon = new ArrayList<>();

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), getResources().getDrawable(R.drawable.bonbongris),43.606489, 1.444153, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), getResources().getDrawable(R.drawable.bonbongris),43.592190, 1.441698, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), getResources().getDrawable(R.drawable.bonbongris),43.594278, 1.444409, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), getResources().getDrawable(R.drawable.bonbongris),43.594278, 1.444409, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), getResources().getDrawable(R.drawable.ourson),43.59923812, 1.43892695, "1/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), getResources().getDrawable(R.drawable.arlequin),43.60201328, 1.44465463, "1/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), getResources().getDrawable(R.drawable.bonbongris),43.59388259, 1.4508802, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), getResources().getDrawable(R.drawable.schtrounf),43.60152454, 1.43924955, "1/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), getResources().getDrawable(R.drawable.bonbongris),43.60400284, 1.432515,"0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), getResources().getDrawable(R.drawable.cola),43.59839905, 1.44201096, "1/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), getResources().getDrawable(R.drawable.bonbongris),43.60572688, 1.45061624, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), getResources().getDrawable(R.drawable.languedechat),43.6035295, 1.44562683, "1/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), getResources().getDrawable(R.drawable.bonbongris),43.59147733, 1.440788, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), getResources().getDrawable(R.drawable.bonbongris),43.60083768, 1.44874592, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), getResources().getDrawable(R.drawable.bonbongris),43.60090453, 1.43445538, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), getResources().getDrawable(R.drawable.bonbongris),43.60363231, 1.43805026, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), getResources().getDrawable(R.drawable.bonbongris),43.59882815, 1.4413074, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.bonbongris),43.59431834, 1.43704105, "0/10"));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), getResources().getDrawable(R.drawable.bonbongris),43.6062955, 1.43540997, "0/10"));

        RecyclerView listBonbon = getView().findViewById(R.id.list);

        final MyitemRecyclerViewAdapter adapter = new MyitemRecyclerViewAdapter(mBonbon);

        listBonbon.setAdapter(adapter);

    }
}
