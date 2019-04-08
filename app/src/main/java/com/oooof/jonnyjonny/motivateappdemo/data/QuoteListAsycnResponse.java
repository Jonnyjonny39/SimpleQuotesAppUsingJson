package com.oooof.jonnyjonny.motivateappdemo.data;

import com.oooof.jonnyjonny.motivateappdemo.model.Quote;

import java.util.ArrayList;

public interface QuoteListAsycnResponse {
    void processFinished(ArrayList<Quote>quotes);
}
