package android.bignerdranch.com.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Francisco R. on 10/03/2016.
 */
public class CrimeListFragment extends Fragment{

    private RecyclerView mCrimeRecyclerView;
    private CrimeAdapter mAdapter;
    private int position;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crime_list, container, false);

        mCrimeRecyclerView = (RecyclerView) view
                .findViewById(R.id.crime_recycle_view);

        mCrimeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }//onCreateView()

    private void updateUI() {
        CrimeLab crimeLab = CrimeLab.get(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();

        if (mAdapter ==null){
            mAdapter = new CrimeAdapter(crimes);
            mCrimeRecyclerView.setAdapter(mAdapter);
        }
        else{
            //mAdapter.notifyDataSetChanged();
            mAdapter.notifyItemChanged(position);
        }
    }//updateUI()

    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private Crime mCrime;
        public TextView mTitleTextView;
        public TextView mDateTextView;
        public CheckBox mCrimeSolvedCheckBox;

        public void bindCrime(Crime crime){
            mCrime = crime;
            mTitleTextView.setText(mCrime.getTitle());
            mDateTextView.setText(mCrime.getDate().toString());
            mCrimeSolvedCheckBox.setChecked(mCrime.isSolved());
        }//bindCrime()

        public CrimeHolder (View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView) itemView.
                    findViewById(R.id.list_item_crime_title_text_view);
            mDateTextView = (TextView) itemView.
                    findViewById(R.id.list_item_crime_date_text_view);
            mCrimeSolvedCheckBox = (CheckBox) itemView.
                    findViewById(R.id.list_item_crime_solved_checkbox);
        }//constructor

        @Override
        public void onClick(View v) {
            position = getAdapterPosition();
            Intent intent = CrimePagerActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);

        }
    }//inner class

    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;

        public CrimeAdapter (List<Crime> crimes){
            mCrimes = crimes;
        }//constructor

        /*
        This method is called by the RecyclerView when it needs a new View to display an item
        */
        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater =  LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_crime, parent, false);
            return new CrimeHolder(view);
        }//onCreateViewHolder()

        /*
        This method will bind a ViewHolder's View to your model object
         */
        @Override
        public void onBindViewHolder(CrimeHolder holder, int position) {
            Crime crime = mCrimes.get(position);
            holder.bindCrime(crime);
        }//onBindViewHolder

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }//getItemCount()
    }//inner class

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }
}
