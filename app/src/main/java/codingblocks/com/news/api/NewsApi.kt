package codingblocks.com.news.api

import codingblocks.com.news.data.NewsArticles
import retrofit2.Call
import okhttp3.ResponseBody
import retrofit2.http.GET

interface NewsApi {
    @GET("top-headlines?country=in&apiKey=edd7050df22d4a04a85ca742b9ad39e6")
    fun getTopHighlights(): Call<NewsArticles>

    @GET("top-headlines?country=in&category=sports&apiKey=edd7050df22d4a04a85ca742b9ad39e6")
    fun getSportsNews():Call<NewsArticles>

    @GET("top-headlines?country=in&category=business&apiKey=edd7050df22d4a04a85ca742b9ad39e6")
    fun getBusinessNews():Call<NewsArticles>

}