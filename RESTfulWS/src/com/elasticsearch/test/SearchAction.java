package com.elasticsearch.test;


import com.elasticsearch.test.News;


import java.util.List;



/**
 * Created by root on 16-4-12.
 */
public class SearchAction {

    private static SearchService searchService=new SearchService();
    public static void buildSearchIndex(){
        searchService.builderSearchIndex();
    }
   
   public static void main(String[] args) {
	   buildSearchIndex();
	   String param = "个人";
       List<News> news = searchService.searchsNews(param);
       System.out.println("id   标题                                           内容");
       for (int i = 0; i < news.size(); i++) {
           News article = news.get(i);
           System.out.println(article.getId() + "   " + article.getTitle() + "   " + article.getContent());
       }
}
}
