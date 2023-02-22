package inc.genesis.mvvm_roomdb_kotlin.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import inc.genesis.mvvm_roomdb_kotlin.Repository.QuoteRepository
import inc.genesis.mvvm_roomdb_kotlin.Room.Quote
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel( private val quoteRepository: QuoteRepository) : ViewModel() {


    fun getQuotes() : LiveData<List<Quote>>{
         return quoteRepository.getQote()
    }

    fun insertQuotes(quote: Quote){
        viewModelScope.launch (Dispatchers.IO){
            quoteRepository.insertQuote(quote)
        }

    }

}