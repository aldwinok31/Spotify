package aldwin.tablante.com.spotifyv2

import android.content.Intent
import android.database.Cursor
import android.media.MediaPlayer
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.LinearLayoutManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var adapter :RecipeRecycler?=null
    var dataDishes : ArrayList<Music> = ArrayList()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<RelativeLayout>(R.id.button)
        button.bringToFront()
        val tView = findViewById<TextView>(R.id.tView)
        tView.bringToFront()
 val cons = findViewById<RelativeLayout>(R.id.cons)
        cons.bringToFront()




    val btn1 = findViewById<ImageView>(R.id.imageView)
     btn1.setOnClickListener{

     }

        val STAR = arrayOf("*")
        var allaudiosong = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        var audioselection =   MediaStore.Audio.Media.IS_MUSIC + "!=0"

        var cursor:Cursor
        cursor = managedQuery(allaudiosong,STAR,audioselection,null,null)

        if (cursor != null) {

if(cursor.moveToFirst()){
    do{
       var song_artist = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST))
            var song_title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME))
        var song_name = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.TITLE))


        dataDishes.add(Music(song_name,song_artist,song_title))
    }while(cursor.moveToNext())
}


        }


        adapter = RecipeRecycler(dataDishes,applicationContext)
        var layout_manager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layout_manager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        recyclerView.setNestedScrollingEnabled(false);
val play = findViewById<ImageView>(R.id.imageView)





}




}
