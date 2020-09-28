package ehu.isad;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Txanpona {
    int trade_id;
    float price;
    float size;
    String time;
    float bid;
    float ask;
    float volume;

    @Override
    public String toString() {
        return "Txanpona{" +
                "trade_id=" + trade_id +
                ", price=" + price +
                ", size=" + size +
                ", time='" + time + '\'' +
                ", bid=" + bid +
                ", ask=" + ask +
                ", volume=" + volume +
                '}';
    }

    public Txanpona irakurriURLtik(String mota)  {
        String txanponMota = " ";
        String lerroa = " ";
        URL coinmarket;
        Txanpona txanpona = new Txanpona();

        switch(mota){
            case "BTC":
                txanponMota = "btc";
                break;

            case "ETH":
                txanponMota = "eth";
                break;

            case "LTC":
                txanponMota = "ltc";
                break;
        }

        try {
            coinmarket = new URL("https://api.gdax.com/products/" + txanponMota + "-eur/ticker");
            URLConnection konexioa = coinmarket.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(konexioa.getInputStream()));
            lerroa = in.readLine();
            System.out.println(lerroa);
            in.close();
        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //Json json = readUrl("https://api.gdax.com/products/" + txanponMota + "-eur/ticker");
        Gson gson = new Gson();
        txanpona = gson.fromJson(lerroa,Txanpona.class);

        return txanpona;
    }
}
