package inc.genesis.mvvm_roomdb_kotlin.Repository

import androidx.lifecycle.LiveData
import inc.genesis.mvvm_roomdb_kotlin.Room.Quote
import inc.genesis.mvvm_roomdb_kotlin.Room.QuoteDao


class QuoteRepository(private val quoteDao : QuoteDao) {

    fun getQote() : LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }

    suspend fun insertQuote(quote: Quote){
        quoteDao.insertQuote(quote)
    }

}