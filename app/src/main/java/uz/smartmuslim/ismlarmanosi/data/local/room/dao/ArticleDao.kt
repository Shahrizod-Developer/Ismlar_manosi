package uz.smartmuslim.ismlarmanosi.data.local.room.dao

import androidx.annotation.NonNull
import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ArticleEntity

@Dao
interface ArticleDao : BaseDao<ArticleEntity> {

    @Query("Select * From article_entity")
    fun getAllArticles(): Flow<List<ArticleEntity>>

    @Query("SELECT * FROM article_entity WHERE id = :id")
    fun getArticleById(@NonNull id: String): Flow<ArticleEntity>

}