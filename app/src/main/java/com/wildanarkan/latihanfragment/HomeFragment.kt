package com.wildanarkan.latihanfragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class HomeFragment : Fragment() {

    private lateinit var adapter: MyAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerView2: RecyclerView
    private lateinit var productArrayList: ArrayList<ProductData>
    private lateinit var mainUpload: Button
    private lateinit var databaseReference: DatabaseReference

    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var news: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        dataInitialize()

        // Layout View
//        val layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
//        recyclerView = view.findViewById(R.id.recycler_view1)
//        recyclerView.layoutManager = layoutManager
//        recyclerView.setHasFixedSize(true)
//        adapter = MyAdapter(newsArrayList)
//        recyclerView.adapter = adapter
//
//        val layoutManager2 = GridLayoutManager(context, 3)
//        recyclerView2 = view.findViewById(R.id.recycler_view2)
//        recyclerView2.layoutManager = layoutManager2
//        recyclerView2.setHasFixedSize(true)
//        recyclerView2.adapter = adapter

        recyclerView = view.findViewById(R.id.rcv_product)
        recyclerView.layoutManager = LinearLayoutManager(context)

        productArrayList = arrayListOf()

        databaseReference = FirebaseDatabase.getInstance().getReference("Product Information")
        databaseReference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for(dataSnapshot in snapshot.children){
                        val productData = dataSnapshot.getValue(ProductData::class.java)
                        if (!productArrayList.contains(productData)){
                            productArrayList.add(productData!!)
                        }
                    }
                    recyclerView.adapter = MyAdapter(productArrayList)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.toString(), Toast.LENGTH_SHORT).show()
            }
        })

        mainUpload = view.findViewById(R.id.mainUpload)
        mainUpload.setOnClickListener{
            val intent = Intent(view.context, UploadActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
        }


    }

//    private fun dataInitialize() {
//        newsArrayList = arrayListOf<News>()
//
//        imageId = arrayOf(
//            R.drawable.wildankecil,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.wildankecil,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.wildankecil,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j,
//            R.drawable.wildankecil,
//            R.drawable.b,
//            R.drawable.c,
//            R.drawable.e,
//            R.drawable.f,
//            R.drawable.g,
//            R.drawable.h,
//            R.drawable.i,
//            R.drawable.j
//        )
//
//        heading = arrayOf(
//            getString(R.string.head_1),
//            getString(R.string.head_2),
//            getString(R.string.head_3),
//            getString(R.string.head_4),
//            getString(R.string.head_5),
//            getString(R.string.head_6),
//            getString(R.string.head_7),
//            getString(R.string.head_8),
//            getString(R.string.head_9),
//            getString(R.string.head_10),
//            getString(R.string.head_1),
//            getString(R.string.head_2),
//            getString(R.string.head_3),
//            getString(R.string.head_4),
//            getString(R.string.head_5),
//            getString(R.string.head_6),
//            getString(R.string.head_7),
//            getString(R.string.head_8),
//            getString(R.string.head_9),
//            getString(R.string.head_10),
//            getString(R.string.head_1),
//            getString(R.string.head_2),
//            getString(R.string.head_3),
//            getString(R.string.head_4),
//            getString(R.string.head_5),
//            getString(R.string.head_6),
//            getString(R.string.head_7),
//            getString(R.string.head_8),
//            getString(R.string.head_9),
//            getString(R.string.head_10),
//            getString(R.string.head_1),
//            getString(R.string.head_2),
//            getString(R.string.head_3),
//            getString(R.string.head_4),
//            getString(R.string.head_5),
//            getString(R.string.head_6),
//            getString(R.string.head_7),
//            getString(R.string.head_8),
//            getString(R.string.head_9),
//            getString(R.string.head_10),
//        )
//
//        news = arrayOf(
//            getString(R.string.news_a),
//            getString(R.string.news_b),
//            getString(R.string.news_c),
//            getString(R.string.news_d),
//            getString(R.string.news_e),
//            getString(R.string.news_f),
//            getString(R.string.news_g),
//            getString(R.string.news_h),
//            getString(R.string.news_i),
//            getString(R.string.news_j),
//            getString(R.string.news_a),
//            getString(R.string.news_b),
//            getString(R.string.news_c),
//            getString(R.string.news_d),
//            getString(R.string.news_e),
//            getString(R.string.news_f),
//            getString(R.string.news_g),
//            getString(R.string.news_h),
//            getString(R.string.news_i),
//            getString(R.string.news_j),
//            getString(R.string.news_a),
//            getString(R.string.news_b),
//            getString(R.string.news_c),
//            getString(R.string.news_d),
//            getString(R.string.news_e),
//            getString(R.string.news_f),
//            getString(R.string.news_g),
//            getString(R.string.news_h),
//            getString(R.string.news_i),
//            getString(R.string.news_j),
//            getString(R.string.news_a),
//            getString(R.string.news_b),
//            getString(R.string.news_c),
//            getString(R.string.news_d),
//            getString(R.string.news_e),
//            getString(R.string.news_f),
//            getString(R.string.news_g),
//            getString(R.string.news_h),
//            getString(R.string.news_i),
//            getString(R.string.news_j),
//        )
//
//        for (i in imageId.indices) {
//            val news = News(imageId[i], heading[i])
//            newsArrayList.add(news)
//        }
//
//    }
}