package francosebastian.firebasekotlindemo

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

/**
 * Created by Franco Arraño Silva on 09-03-18.
 * www.github.com/francosebastian
 */

class HeroAdapter(mCtx : Context, layoutResId: Int, heroList: List<Hero>): ArrayAdapter<Hero>(mCtx, layoutResId, heroList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return super.getView(position, convertView, parent)
    }
}