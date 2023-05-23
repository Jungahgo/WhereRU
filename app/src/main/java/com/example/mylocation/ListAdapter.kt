package com.example.mylocation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mylocation.databinding.ItemListDefaultBinding

class ListAdapter(private var signalList : ArrayList<Listdata>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    //클릭인터페이스 정의
    public interface MyItemClickListner{
        fun onItemClick(signal : Listdata)
    }

    //리스너 객체를 전달받을 함수랑 리스너 객체를 전달받을 변수
    private lateinit var mItemClickListner : MyItemClickListner

    public fun setMyItemClickListener(itemClickListner : MyItemClickListner){
        mItemClickListner = itemClickListner
    }


    //default(추가정보 입력안했을때 siganal) 모드 ViewHolder
    inner class DefaultViewHolder(private val binding : ItemListDefaultBinding) :
        RecyclerView.ViewHolder(binding.root){
        fun bind(signal : Listdata){
            //binding.itemMapSignalListDefaultProfileIv.setImageResource(signal.profileImageUrl!!)
            binding.itemMapSignalListDefaultNicknameTv.text = signal.nickName
        }
    }

    //viewholder를 생성해야 할때 호출
    //아이템 뷰 객체를 만들어서 viewHolder에 전달
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return DefaultViewHolder(
                    ItemListDefaultBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

    //viewHolder에 데이터 바인딩 할때마다 호출
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(signalList[position].checkSigWrite){
            SignalMode.DEFAULT->{
                (holder as DefaultViewHolder).bind(signalList[position])
                holder.itemView.setOnClickListener { mItemClickListner.onItemClick(signalList[position]) }
            }
            else ->{
                (holder as DefaultViewHolder).bind(signalList[position])
                holder.itemView.setOnClickListener { mItemClickListner.onItemClick(signalList[position]) }
            }

        }
    }

    override fun getItemCount(): Int = signalList.size

    //ViewType 설정
    override fun getItemViewType(position: Int): Int {
        return signalList[position].checkSigWrite
    }
}