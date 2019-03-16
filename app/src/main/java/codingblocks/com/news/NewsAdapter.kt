package codingblocks.com.news

import android.media.Image
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codingblocks.com.news.data.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_row.view.*

class NewsAdapter(val newsData:List<ArticlesItem>):RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    class ViewHolder(val view: View):RecyclerView.ViewHolder(view){

        val newsText=view.newsText
        val newsImage=view.newsImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount()= newsData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.newsText.text=newsData[position].description
        Picasso.get()
            .load(newsData[position].urlToImage)
            .into(holder.newsImage)


    }
}