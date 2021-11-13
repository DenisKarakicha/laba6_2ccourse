package com.company;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        /*Quotes quotes = new Quotes();
        String quotesStr = quotes.loadUrl("https://www.breakingbadapi.com/api/quotes");
        quotes.restoreObject(quotesStr);

        System.out.println(quotes);*/


        GetJson jsonGetter = new GetJson();
        GetJson.url = "https://www.breakingbadapi.com/api/quotes";
        jsonGetter.run();

        String jsonString = jsonGetter.jsonIn;

        /*Quotes quotes = new Quotes();
        quotes.restoreObject(jsonString);

        System.out.println(quotes);*/

        Object tempObj = null;
        try
        {
            tempObj = new JSONParser().parse(jsonString);
        }
        catch (org.json.simple.parser.ParseException e)
        {
            e.printStackTrace();
        }

        JSONArray jsonArray = (JSONArray) tempObj;
        System.out.println(jsonArray.toJSONString());

        Quotes quotes = new Quotes();

        for (Object jsonObject : jsonArray)
        {
            JSONObject getQuote = (JSONObject) jsonObject;
            String quote = (String) getQuote.get("quote");
            String author = (String) getQuote.get("author");
            String series = (String) getQuote.get("series");
            long quoteID = (long) getQuote.get("quote_id");


            Quote newQuote = new Quote(quote, author, series , quoteID);
            quotes.add(newQuote);
        }

        System.out.println(quotes);

        // Сортировка в алфавитном порядке
        quotes.getQuotes().sort(Quote.byQuoteAsc);
        System.out.println("\n\nSorting by Quotes(A)" + quotes);

        // Сортирока в обраном от алфавита порядке
        quotes.getQuotes().sort(Quote.byQuoteDesc);
        System.out.println("\n\nSorting by Quotes(D)" + quotes);

        // Сортировка сначала по автору , а потом по цитате
        quotes.getQuotes().sort(Quote.byTemp);
        System.out.println("\n\nSorting by (Author + Quote)" + quotes);


        // Фильтрация
        System.out.println("\n\n");
        Quotes filterByWalterWhile = quotes.filterByAuthorQuote("Walter White");
        filterByWalterWhile.getQuotes().sort(Quote.byQuoteAsc);
        System.out.println(filterByWalterWhile);

;
    }
}
