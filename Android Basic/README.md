# DSC Visiting Card

This is the first project from Android Basic Developer Nanodegree. Develop UI for single screen which may be look like a card or letter or etc. 

I had tried here making two cardviews with text and make them clickable. The major purpose of this project is to learn Kotlin through Udacity's basic projects. 

We have seen some points in this project:
1. No need of `findViewById()`, we can directly use the id name which we have written in layout file
2. setOnClickListener on this cardView, 
 `video_cardView.setOnClickListener{
            // Do anything on Click
        }`
3. Calling Intent
 `val intentBrowser = Intent(Intent.ACTION_VIEW,uri)
          startActivity(intentBrowser)`
