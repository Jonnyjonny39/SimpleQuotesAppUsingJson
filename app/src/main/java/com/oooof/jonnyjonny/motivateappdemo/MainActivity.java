package com.oooof.jonnyjonny.motivateappdemo;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.oooof.jonnyjonny.motivateappdemo.data.QuoteData;
import com.oooof.jonnyjonny.motivateappdemo.data.QuoteListAsycnResponse;
import com.oooof.jonnyjonny.motivateappdemo.model.Quote;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdapter quoteViewPagerAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdapter=new QuoteViewPagerAdapter(getSupportFragmentManager(),getFragments());
        viewPager=findViewById(R.id.viewPager);
        viewPager.setAdapter(quoteViewPagerAdapter);

    }
    private List<Fragment>getFragments(){
       final List<Fragment>fragmentList=new ArrayList<>();
        new QuoteData().getQuotes(new QuoteListAsycnResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i=0;i<quotes.size();i++){
                    QuoteFragment quoteFragment=QuoteFragment.newInstance(quotes.get(i).getQuote(),quotes.get(i).getAuthor());
                    fragmentList.add(quoteFragment);

            }
            quoteViewPagerAdapter.notifyDataSetChanged();
        }


        });
        return fragmentList;

    }
}
