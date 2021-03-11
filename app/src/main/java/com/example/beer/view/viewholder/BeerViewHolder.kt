package com.example.beer.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beer.R
import com.example.beer.domain.models.BeerRecipe
import com.example.beer.shared.listener.BeerListener
import kotlinx.android.synthetic.main.row_beer_list.view.*

class BeerViewHolder(
    itemView: View,
    listener: BeerListener
) :
    RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private var _view: View = itemView
    private var _listener: BeerListener = listener
    private var beerRecipe: BeerRecipe? = null


    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.image_delete -> _listener.onDeleteFavorite(beerRecipe!!.id)
            R.id.image_favorite -> _listener.onFavorite(beerRecipe)
            else -> _listener.onDetails(beerRecipe!!.id)
        }
    }

    fun bindData(beerRecipe: BeerRecipe) {
        Glide.with(_view).load(beerRecipe.imageUrl).into(_view.image_beer);
        _view.text_name_recipe.text = beerRecipe.name
    }

}