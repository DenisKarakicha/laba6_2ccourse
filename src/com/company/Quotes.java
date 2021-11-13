package com.company;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quotes implements Serializable {
    @JsonProperty("quotes")
    List<Quote> quotes;

    public Quotes() {
        quotes = new ArrayList<>();
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    void add(Quote quote) {
        this.quotes.add(quote);
    }

/*    public void restoreObject(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        Quote[] newQuotes = objectMapper.readValue(json.strip(), Quote[].class);
        this.quotes.addAll(Arrays.stream(newQuotes).toList());

    }*/

    public Quotes filterByAuthorQuote(String str) {
        Quotes tempObject = new Quotes();
        for (Quote quote : this.quotes) {
            if (quote.getAuthor().toLowerCase().contains(str.toLowerCase()))
                tempObject.add(quote);
        }
        return tempObject;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "quotes=" + quotes +
                '}';
    }
}
