package by.pvt.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.pvt.models.NewsRecord;

public class NewsService {

	Map<String, List<NewsRecord>> news = new HashMap<>();
	
	static private NewsService instance = new NewsService();

	public NewsService() {
		news.put("Max", new ArrayList<NewsRecord>());

		news.get("Max").add(new NewsRecord("images/demo/450x250.gif",
				"First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record ",
				"First news record"));

		news.get("Max").add(new NewsRecord("images/demo/450x250-2.gif",
				"Second news record Second news record Second news record Second news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record ",
				"Second news record"));

		news.get("Max").add(new NewsRecord("images/demo/450x250.gif",
				"Third news record Third news record Third news record Third news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record First news record ",
				"Third news record"));

	}

	public List<NewsRecord> getNews(String userName) {
		return news.get(userName);
	};

	public static NewsService getInstance() {
		return instance;
	}

}
