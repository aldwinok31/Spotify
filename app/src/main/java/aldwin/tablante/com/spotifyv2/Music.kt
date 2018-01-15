package aldwin.tablante.com.spotifyv2

import android.net.Uri
import android.os.Environment

/**
 * Created by Bobby on 11/01/2018.
 */
class Music(title:String , description:String ,name:String){
    var dtitle = title
    var ddescription = description
    var dname = name
    var dselectedis = Uri.parse(Environment.getExternalStorageDirectory().getPath() + "/download/"+name)
    var data = dselectedis.toString()
}