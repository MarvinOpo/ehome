package com.uc.ehome;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.uc.ehome.models.TaskDetails;

import java.util.ArrayList;

import helpers.RVadapter;

/**
 * Created by jadjaluddin on 8/5/2015.
 */
public class AcceptedTaskFragment extends Fragment {
    private FragmentTabHost mTabHost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.tabframe);

        mTabHost.addTab(mTabHost.newTabSpec("accepted").setIndicator("Tasks Accepted"),
                TaskAcceptedFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("done").setIndicator("Tasks Done"),
                TaskDoneFragment.class, null);
        return mTabHost;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }

    public static class TaskAcceptedFragment extends Fragment{
        ArrayList<TaskDetails> mList = new ArrayList<TaskDetails>();

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);

            mList.add(new TaskDetails("Sundo Igsuon", "School", "Undone", "9-22-15", "10:34am", null));
            mList.add(new TaskDetails("Taya lotto", "Not Specified", "Undone", "9-22-15", "10:34am", null));
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.task_recylcer, container, false);

            RecyclerView rv = (RecyclerView) view.findViewById(R.id.task_recycler);
            rv.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);

            RVadapter adapter = new RVadapter(null, mList);
            rv.setAdapter(adapter);

            return view;
        }
    }

    public static class TaskDoneFragment extends Fragment{
        ArrayList<TaskDetails> mList = new ArrayList<TaskDetails>();

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setHasOptionsMenu(true);

            mList.add(new TaskDetails("Hugas plato", "Not Specified", "Done", "9-22-15", "10:34am", null));
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.task_recylcer, container, false);

            RecyclerView rv = (RecyclerView) view.findViewById(R.id.task_recycler);
            rv.setHasFixedSize(true);
            LinearLayoutManager llm = new LinearLayoutManager(getActivity());
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            rv.setLayoutManager(llm);

            RVadapter adapter = new RVadapter(null, mList);
            rv.setAdapter(adapter);

            return view;
        }
    }
}