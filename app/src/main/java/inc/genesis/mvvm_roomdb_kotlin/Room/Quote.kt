package inc.genesis.mvvm_roomdb_kotlin.Room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "quote")
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    val ext : String,
    val author : String
)
