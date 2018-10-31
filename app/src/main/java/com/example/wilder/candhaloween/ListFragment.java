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

        mBonbon.add(new BonbonModel(getResources().getString(R.string.Crocodile), "@drawable/crocodilebonbno",43.600346, 1.443844));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Tagada), null,43.700998, 1.489429));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Marshmallow), null,42.986370, 1.086368));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Dragibus), null,42.600346, 1.657899));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Ourson), null,42.600346, 1.453197));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Arlequin), null,41.600346, 1.325797));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Oeuf_au_plat), null,41.600346, 1.247864));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Schtroumpfs), null,41.600346, 1.468988));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Carambar), null,41.874795, 1.543278));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Cola), null,41.600346, 1.986432));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Roudoudou), null,41.366438, 1.652399));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Langue_pik), null,42.600346, 1.474789));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Banane), null,41.368976, 1.226799));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Boule_de_mammouth), null,41.576659, 1.653468));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Skittles), null,43.878687, 1.765346));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.M_Ms), null,43.135799, 1.65446));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Papillote), null,42.687674, 1.653457));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Kinder_surprise), null,43.134689, 1.453467));
        mBonbon.add(new BonbonModel(getResources().getString(R.string.Car_en_Sac), null,43.457689, 1.453457));

        RecyclerView listBonbon = getView().findViewById(R.id.list);

        final MyitemRecyclerViewAdapter adapter = new MyitemRecyclerViewAdapter(mBonbon);

        listBonbon.setAdapter(adapter);
    }
}
