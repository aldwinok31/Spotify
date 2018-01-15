package aldwin.tablante.com.spotifyv2
import aldwin.tablante.com.spotifyv2.MainActivity
import aldwin.tablante.com.spotifyv2.R.id.*
/**
 * Created by Bobby on 17/12/2017.
 */

import android.app.Fragment
import android.app.FragmentContainer
import android.app.FragmentManager
import android.content.Context
import android.content.Intent

import android.media.MediaPlayer
import android.net.Uri
import android.os.Environment

import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import android.util.SparseBooleanArray
import android.widget.Button
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*


private var trialbool = true
private var trialcount =0
private val selectedItems = SparseBooleanArray()
class RecipeRecycler (dataMusic: ArrayList<Music>, context: Context) : RecyclerView.Adapter<RecipeRecycler.Musicy>(){
var allMusicList:ArrayList<String> = ArrayList()
val mContext = context
    val imageBut:ImageView?=null
    var mp : MediaPlayer?=null
    companion object {
        val MUSICLIST = "musiclist"
        val MUSICTEMPOS = "pos"
    }

    var dataMusic: ArrayList<Music> = dataMusic
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): Musicy {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.listview, parent, false)


        return Musicy(view)
    }

    override fun onBindViewHolder(holder: Musicy?, position: Int) {
        val dish = dataMusic[position]
        val title = dish.dtitle
        val name = dish.dname
        val button:Button?=null
        val description = dish.ddescription
        holder!!.titlev.text = "" + title
        holder.descript.text = "" + description




        holder.setReclicker(object:Musiclick{

            override fun onMusicClick(view: View, pos: Int) {


              /*  var musicDataIntent = Intent(mContext,viewer::class.java)
for (i in 0  until dataMusic.size){
allMusicList.add(dataMusic[i].data)

}

                musicDataIntent.putStringArrayListExtra(MUSICLIST,allMusicList)
                musicDataIntent.putExtra(MUSICTEMPOS,pos)
                mContext.startService(musicDataIntent) */

             /*

                 if(trialbool){
                     holder.titlev.setTextColor(Color.parseColor("green"))
                     trialbool=false
                     dataMusic[pos].dselectedis=true

                 }
                else{

                     while(count<10){

                         if(dataMusic[count].dselectedis){
                             trialbool=true
                             dataMusic[count].dselectedis=false
                             holder.titlev.setTextColor(Color.parseColor("blue"))
                            count++
                         }
                         else{
                             holder.titlev.setTextColor(Color.parseColor("white"))
                             count++

                         }
                     }
                 }*/








                //Frag(mContext).showFragment()

                    play(pos,name,0)




            }
        })




    }


    override fun getItemCount(): Int {
        return dataMusic.size
    }


    class Musicy(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(p0: View?) {
            this.reClicker!!.onMusicClick(p0!!, adapterPosition)
        }



        val titlev: TextView
        val descript: TextView

        var reClicker:Musiclick? = null


        init {


            titlev = itemView.findViewById<TextView>(R.id.titleview)
            descript = itemView.findViewById<TextView>(R.id.description)

            itemView.setOnClickListener(this)
        }

        fun setReclicker(Musiclicker: Musiclick) {
            this.reClicker = Musiclicker

        }





    }


    fun play(pos:Int,title:String,mode:Int){


if(mp!=null){

    mp!!.stop()
    mp!!.release()
    mp = null
}

        if(mode==1){
            mp!!.stop()
            mp!!.release()
            mp = null
        }
        else {
            val title_m = "/download/" + title

            val data = Uri.parse(Environment.getExternalStorageDirectory().getPath() + title_m)
            mp = MediaPlayer.create(mContext, data)

            mp!!.start()
        }


        }

}
