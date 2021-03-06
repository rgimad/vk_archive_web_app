package com.project.server.controller1;

//import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
// import java.sql.SQLException;
// import java.util.ArrayList;
import java.util.HashMap;

public class VKPageParser {
    private static String token;
    private static String versionAPI;
    private static String domain;

    public VKPageParser(String token, String versionAPI) {
        VKPageParser.token = token;
        VKPageParser.versionAPI = versionAPI;
    }

    public static Document connectDataUser(StringBuilder strId) throws IOException {
        String url = "https://api.vk.com/method/users.get";
        HashMap<String, String> map = new HashMap<>();
        map.put("access_token", token);
        map.put("name_case", "Nom");
        map.put("v", versionAPI);
        map.put("user_ids", strId.toString());
        map.put("fields", "city, bdate, country, home_town, " +
                "photo_max_orig, online, domain, has_mobile," +
                "contacts, site, education, connections, " +
                "exports, activities");

        return Jsoup.connect(url)
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .ignoreContentType(true)
                .data(map)
                .post();
    }

}