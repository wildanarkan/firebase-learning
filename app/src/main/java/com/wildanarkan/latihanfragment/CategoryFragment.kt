package com.wildanarkan.latihanfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CategoryFragment: Fragment() {
    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var newsArrayList: ArrayList<News>

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var news: Array<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recyclerView = view.findViewById(R.id.r1)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(newsArrayList)
        recyclerView.adapter = adapter

        val layoutManager2 = GridLayoutManager(context, 3)
        recyclerView2 = view.findViewById(R.id.r2)
        recyclerView2.layoutManager = layoutManager2
        recyclerView2.setHasFixedSize(true)
        recyclerView2.adapter = adapter

    }

    private fun dataInitialize() {
        newsArrayList = arrayListOf<News>()

        imageId = arrayOf(
            R.drawable.wildankecil,
            R.drawable.b,
            R.drawable.c,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.wildankecil,
            R.drawable.b,
            R.drawable.c,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.wildankecil,
            R.drawable.b,
            R.drawable.c,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.wildankecil,
            R.drawable.b,
            R.drawable.c,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j
        )

        heading = arrayOf(
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
            getString(R.string.head_8),
            getString(R.string.head_9),
            getString(R.string.head_10),
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
            getString(R.string.head_8),
            getString(R.string.head_9),
            getString(R.string.head_10),
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
            getString(R.string.head_8),
            getString(R.string.head_9),
            getString(R.string.head_10),
            getString(R.string.head_1),
            getString(R.string.head_2),
            getString(R.string.head_3),
            getString(R.string.head_4),
            getString(R.string.head_5),
            getString(R.string.head_6),
            getString(R.string.head_7),
            getString(R.string.head_8),
            getString(R.string.head_9),
            getString(R.string.head_10),
        )

        news = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j),
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j),
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j),
            getString(R.string.news_a),
            getString(R.string.news_b),
            getString(R.string.news_c),
            getString(R.string.news_d),
            getString(R.string.news_e),
            getString(R.string.news_f),
            getString(R.string.news_g),
            getString(R.string.news_h),
            getString(R.string.news_i),
            getString(R.string.news_j),
        )

        for (i in imageId.indices) {
            val news = News(imageId[i], heading[i])
            newsArrayList.add(news)
        }
    }

}