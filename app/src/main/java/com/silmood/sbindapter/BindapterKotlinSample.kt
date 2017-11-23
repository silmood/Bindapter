package com.silmood.sbindapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import com.silmood.bindapter.Bindapter
import java.util.*

class BindapterKotlinSample: Fragment() {

    private lateinit var bindapter: Bindapter<Game>
    private var list: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater?.inflate(R.layout.fragment_list, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view?.findViewById(R.id.list)

        if(list != null)
            setupList(list as RecyclerView)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.menu_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            R.id.item_add -> addItem()
            R.id.item_remove -> removeItem()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun setupList(list: RecyclerView) {
        list.layoutManager = LinearLayoutManager(context)

        bindapter = Bindapter(R.layout.item, BR.game)
        bindapter.addItems(GameDataSource.getGames())
        list.adapter = bindapter
    }

    private fun addItem() {
        val games = GameDataSource.getGames()
        val position = Random().nextInt(games.count())
        bindapter.addItem(games[position])
    }

    private fun removeItem() {
        val position = Random().nextInt(bindapter.itemCount)
        bindapter.removeItem(position)
    }


}