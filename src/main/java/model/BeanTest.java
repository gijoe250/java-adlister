package model;

import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args){
        Album album = new Album("Whitney", "Bodyguard", 1987, 2000, "pop");
        Quote quote = new Quote("The wheel weaves as the wheel wills");
        Author author = new Author("Al", "Bundy");
        quote.setAuthor(author);

        Quote quote2 = new Quote("Dont stop");
        Author author2 = new Author("Believe", "it");
        quote2.setAuthor(author2);

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quote);
        quotes.add(quote2);

        System.out.println(album.getArtist());
        System.out.println(author.getFirst_name());
        for (Quote quoteTemp : quotes){
            System.out.println(quoteTemp.getContent());
            System.out.println(quoteTemp.getAuthor().getFirst_name());
            System.out.println(quoteTemp.getAuthor().getLast_name());
        }
    }
}
