package aldwin.tablante.com.spotifyv2
import aldwin.tablante.com.spotifyv2.Musiclick
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment
import android.os.IBinder
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

/**
 * Created by Bobby on 14/01/2018.
 */
class viewer :Service(){
var currentPos=0
    var musicDataList :ArrayList<String> = ArrayList()
    var mp:MediaPlayer?=null
    override fun onBind(p0: Intent?): IBinder ?{
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        currentPos =intent!!.getIntExtra(RecipeRecycler.MUSICTEMPOS,0)
        musicDataList = intent.getStringArrayListExtra(RecipeRecycler.MUSICLIST)

         mp = MediaPlayer()

        mp!!.setDataSource(musicDataList[currentPos])
        mp!!.setOnPreparedListener {
            mp!!.start()
        }
        return super.onStartCommand(intent, flags, startId)

    }





}