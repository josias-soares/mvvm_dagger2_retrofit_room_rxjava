package com.example.beer.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.beer.datasource.BeerRepository
import com.example.beer.shared.listener.BeerListener

class BeerViewHolder(
    itemView: View,
    val listener: BeerListener,
    private val mPriorityRepository: BeerRepository
) :
    RecyclerView.ViewHolder(itemView) {

//    private val mDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
//
//    //private val mPriorityRepository = PriorityRepositoryImpl(itemView.context, get<PriorityService>())
//
//    private var mTextDescription: TextView = itemView.findViewById(R.id.text_description)
//    private var mTextPriority: TextView = itemView.findViewById(R.id.text_priority)
//    private var mTextDueDate: TextView = itemView.findViewById(R.id.text_due_date)
//    private var mImageTask: ImageView = itemView.findViewById(R.id.image_task)
//
//    /**
//     * Atribui valores aos elementos de interface e também eventos
//     */
//    fun bindData(task: TaskNetwork) {
//
//        this.mTextDescription.text = task.description
//        this.mTextPriority.text = mPriorityRepository.get(task.priorityId).description
//
//        val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(task.dueDate)
//        this.mTextDueDate.text = mDateFormat.format(date)
//
//        if (task.complete) {
//            mTextDescription.setTextColor(Color.GRAY)
//            this.mImageTask.setImageResource(R.drawable.ic_done)
//        } else {
//            mTextDescription.setTextColor(Color.BLACK)
//            this.mImageTask.setImageResource(R.drawable.ic_todo)
//        }
//
//        // Eventos
//        mTextDescription.setOnClickListener { listener.onListClick(task.id) }
//        mImageTask.setOnClickListener {
//            if (task.complete) {
//                listener.onUndoClick(task.id)
//            } else {
//                listener.onCompleteClick(task.id)
//            }
//        }
//
//        mTextDescription.setOnLongClickListener {
//            AlertDialog.Builder(itemView.context)
//                .setTitle(R.string.remocao_de_tarefa)
//                .setMessage(R.string.remover_tarefa)
//                .setPositiveButton(R.string.sim) { _, _ ->
//                    listener.onDeleteClick(task.id)
//                }
//                .setNeutralButton(R.string.cancelar, null)
//                .show()
//            true
//        }
//
//    }

}