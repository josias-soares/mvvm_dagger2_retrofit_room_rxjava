import com.example.beer.datasource.local.models.BeerEntity
import com.example.beer.domain.EntityMapper
import com.example.beer.domain.models.BeerRecipe
import javax.inject.Inject

class BeerEntityMapper
@Inject
constructor() :
    EntityMapper<BeerEntity, BeerRecipe> {

    override fun mapFromEntity(dataSourceModel: BeerEntity): BeerRecipe {
        return BeerRecipe(
            id = dataSourceModel.id,
            name = dataSourceModel.name,
            imageUrl = dataSourceModel.imageUrl,
            abv = null,
            ibu = null,
            ebc = null,
            volume = null,
            boilVolume = null,
            ingredients = null,
            contributedBy = "",
            description = "",
            firstBrewed = "",
            tagline = ""
        )
    }

    override fun mapToEntity(domainModel: BeerRecipe): BeerEntity {

        return BeerEntity(
            id = domainModel.id,
            name = domainModel.name,
            imageUrl = domainModel.imageUrl,
        )
    }
}











