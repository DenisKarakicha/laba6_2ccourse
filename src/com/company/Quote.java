package com.company;

import java.io.Serializable;
import java.util.Comparator;

class Quote implements Serializable {

    long quoteId;
    String quote;
    String author;
    String series;

    public Quote( String quote, String author, String series ,long quoteId) {
        this.setQuoteId(quoteId);
        this.setQuote(quote);
        this.setAuthor(author);
        this.setSeries(series);
    }

    public Quote() {

    }

    public long getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(long quoteId) {
        this.quoteId = quoteId;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public static Comparator<Quote> byQuoteAsc = Comparator.comparing(Quote::getQuote);
    public static Comparator<Quote> byQuoteDesc = (o1 , o2) -> o2.quote.compareTo(o1.quote);
    public static Comparator<Quote> byTemp = Comparator.comparing(Quote::getAuthor).thenComparing(Quote::getQuote);




    @Override
    public String toString() {
        return "\nQuote{" +
                "quoteId=" + quoteId +
                ", quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", series='" + series + '\'' +
                '}';
    }
}
