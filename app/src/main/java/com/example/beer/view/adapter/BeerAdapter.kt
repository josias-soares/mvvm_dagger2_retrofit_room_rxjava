package com.example.beer.view.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.beer.datasource.BeerRepository
import com.example.beer.view.viewholder.BeerViewHolder

class BeerAdapter(private val mPriorityRepository : BeerRepository) : RecyclerView.Adapter<BeerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BeerViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

//    private var mList: List<TaskNetwork> = arrayListOf()
//    private lateinit var mListener: TaskListener
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val item =
//            LayoutInflater.from(parent.context).inflate(R.layout.row_task_list, parent, false)
//
//        return TaskViewHolder(item, mListener, mPriorityRepository)
//    }
//
//    override fun getItemCount(): Int {
//        return mList.count()
//    }
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        holder.bindData(mList[position])
//    }
//
//    fun attachListener(listener: TaskListener) {
//        mListener = listener
//    }
//
//    fun updateList(list: List<TaskNetwork>) {
//        mList = list
//        notifyDataSetChanged()
//    }
}