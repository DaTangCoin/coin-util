package com.datang.coin;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class PriceUrl {
	private String url;
	
	public PriceUrl(String url){
		this.url = url;
	}
	
	public String Price() throws IOException{
		System.out.println(url);
		Document doc = Jsoup.connect(url).get();
		
		Elements newsHeadlines = doc.select("b");
		for(int i=0; i< newsHeadlines.size();i++){
			if(newsHeadlines.get(i).text().startsWith("￥"))
				return newsHeadlines.get(i).text().substring(1);
		}
		return null;
	}

}
