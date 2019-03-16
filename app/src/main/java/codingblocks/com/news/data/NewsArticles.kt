package codingblocks.com.news.data

data class NewsArticles(
	val totalResults: Int? = null,
	val articles: List<ArticlesItem>,
	val status: String? = null
)
