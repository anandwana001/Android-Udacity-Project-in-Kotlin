package xyz.akshay.dscvisitingcard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        video.setOnClickListener{
            openVideo(getString(R.string.video_link))
        }

        article.setOnClickListener{
            openArticle(getString(R.string.article_link))
        }
    }

    fun openVideo(youtubeID: String) {
        val intentBrowser = Intent(Intent.ACTION_VIEW,
                Uri.parse("http://www.youtube.com/watch?v=" + youtubeID))
          this.startActivity(intentBrowser)
    }

    fun openArticle(articleID: String) {
        val intentBrowser = Intent(Intent.ACTION_VIEW, Uri.parse(articleID))
            this.startActivity(intentBrowser)
    }
}
