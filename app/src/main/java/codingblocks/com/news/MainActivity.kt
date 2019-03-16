package codingblocks.com.news

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import codingblocks.com.news.api.NewsApiService
import codingblocks.com.news.data.ArticlesItem
import codingblocks.com.news.data.NewsArticles
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),Callback<NewsArticles> {

    val data = ArrayList<ArticlesItem>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var newsData = NewsApiService.create()
        newsData.getTopHighlights().enqueue(this)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = NewsAdapter(data)

    }

    override fun onFailure(call: Call<NewsArticles>, t: Throwable) {


    }

    override fun onResponse(call: Call<NewsArticles>, response: Response<NewsArticles>) {

        val newsArticles = response?.body()

        if (newsArticles != null) {
            data.clear()
            data.addAll(newsArticles.articles)
            recyclerview.adapter.notifyDataSetChanged()


        }

    }
}
