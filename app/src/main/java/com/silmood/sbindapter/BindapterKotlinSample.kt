package com.silmood.sbindapter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.silmood.bindapter.Bindapter

class BindapterKotlinSample: Fragment() {

    private lateinit var bindapter: Bindapter<Game>
    private var list: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater?.inflate(R.layout.fragment_list, container, false)


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list = view?.findViewById(R.id.list)

        if(list != null)
            setupList(list as RecyclerView)
    }


    private fun setupList(list: RecyclerView) {
        list.layoutManager = LinearLayoutManager(context)

        bindapter = Bindapter(R.layout.item, BR.game)
        bindapter.addItems(GameDataSource.getGames())
        list.adapter = bindapter
    }

}