package com.example.mylocation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mylocation.databinding.ActivityListBinding
import java.util.Collections.list


class ListActivity :AppCompatActivity() {
    lateinit var binding: ActivityListBinding
    var ListDatas = ArrayList<Listdata>()


    private fun setAdapter(mapSignalListDatas: ArrayList<Listdata>){
        //리사이클러뷰 어뎁터 세팅
        val ListAdapter = ListAdapter(ListDatas)
        binding.mapSignalListRecyclerviewGrid.adapter = ListAdapter
        binding.mapSignalListRecyclerviewGrid.layoutManager = GridLayoutManager(this@ListActivity, 2)

        //리사이클러뷰 클릭관련 함수정의
        ListAdapter.setMyItemClickListener(object :
            ListAdapter.MyItemClickListner {
            override fun onItemClick(signal: Listdata) {
                //클릭 시 알림 전송
                val mDialogView = LayoutInflater.from(this@ListActivity).inflate(R.layout.dialog, null)
                val mBuilder = AlertDialog.Builder(this@ListActivity)
                    .setView(mDialogView)
                mBuilder.show()

            }
        })

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mapListBackBtn.setOnClickListener {
            finish()
            overridePendingTransition(0, 0)
        }

        ListDatas.add(Listdata(0,"나","문화관"))
        ListDatas.add(Listdata(0,"박지성","문화관", "1분전"))
        setAdapter(ListDatas)

    }
}
