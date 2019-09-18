package com.hisense.zxn;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.hisense.zxn.entity.SearchNet;
import com.hisense.zxn.entity.SearchNetMu;

import org.jsoup.Jsoup;
import org.jsoup.UncheckedIOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RNSearchManager {

    private static final String BASE_URL = "http://m.baidu.com/s?&ie=urf-8&wd=";
    private static RNSearchManager instance;

    public static RNSearchManager getInstance() {
        if (instance == null) {
            synchronized (RNSearchManager.class) {
                if (instance == null)
                    instance = new RNSearchManager();
            }
        }
        return instance;
    }

    public List<SearchNet> decode(String searchText) {
        if (TextUtils.isEmpty(searchText))
            return null;
        List<SearchNet> searchNets = new ArrayList<>();
        String url = BASE_URL.concat(searchText);
        try {
            Document doc = Jsoup.connect(url).get();
            Elements recommends = doc.select(".results").select(".c-result.result");
            packageResult(searchNets, recommends);
        } catch (UncheckedIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchNets;
    }

    private void packageResult(List<SearchNet> searchNets, Elements elements) {
        for (Element element : elements) {
            Gson gson = new Gson();
            SearchNetMu mu = gson.fromJson(element.attr("data-log"), SearchNetMu.class);
            String title = element.select("div.c-result-content").
                    select(".c-gap-bottom-small").
                    select(".c-touchable-feedback.c-touchable-feedback-no-default").
                    select("[href]").
                    attr("voice-tag");
            title=title.replaceAll("<em>","");
            title=title.replaceAll("</em>","");
            String description = element.select("div.c-result-content").
                   select(".c-abstract.c-row").
                   select(".c-color").
                   select(".c-line-clamp3").
                   text();
            SearchNet searchNet = new SearchNet(title, mu, description);
            if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(description) && mu != null) {
                for (SearchNet search : searchNets) {
                     if (search.getTitle().equals(title))
                         return;
                     }
                searchNets.add(searchNet);
            }
        }
    }
}
