package uz.smartmuslim.ismlarmanosi.data.local.room.database

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.ArticleDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.ImageDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.NameDao
import uz.smartmuslim.ismlarmanosi.data.local.room.dao.OfferDao
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ArticleEntity
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.ImageEntity
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.NameEntity
import uz.smartmuslim.ismlarmanosi.data.local.room.entity.OfferEntity

@Database(
    entities = [NameEntity::class, ImageEntity::class, ArticleEntity::class, OfferEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun imageDao(): ImageDao

    abstract fun nameDao(): NameDao

    abstract fun offerDao(): OfferDao

    abstract fun articleDao(): ArticleDao
}