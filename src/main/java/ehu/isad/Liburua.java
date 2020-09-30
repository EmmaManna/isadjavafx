package ehu.isad;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;

public class Liburua {
    private String ISBN;
    private int number_of_pages;
    private String[] publishers;
    private String title;
    private String subtitle = "";

    @Override
    public String toString() {
        return "Liburua{" +
                "ISBN='" + ISBN + '\'' +
                ", number_of_pages=" + number_of_pages +
                ", publishers=" + Arrays.toString(publishers) +
                ", title='" + title + '\'' +
                '}';
    }

    public Liburua(){}

    public int getNumber_of_pages() {
        return number_of_pages;
    }

    public String[] getPublishers() {
        return publishers;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Liburua irakurriURLtik(String isbn)  {

        String lerroa = " ";
        URL openLibrary;

        try {
            openLibrary = new URL("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&jscmd=details&format=json");
            URLConnection konexioa = openLibrary.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(konexioa.getInputStream()));
            lerroa = in.readLine();
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        String[] zatiak = lerroa.split("details\":");
        lerroa = zatiak[1].substring(0, zatiak[1].length()-1);
        zatiak = lerroa.split(", \"preview\":");
        lerroa = zatiak[0]; //.substring(0, zatiak[0].length()-1);
        System.out.println(lerroa);


        //Json json = readUrl("https://api.gdax.com/products/" + txanponMota + "-eur/ticker");
        Gson gson = new Gson();
        Liburua l = new Liburua();
        l = gson.fromJson(lerroa,Liburua.class);
        l.ISBN = isbn;
        return l;
    }
}
