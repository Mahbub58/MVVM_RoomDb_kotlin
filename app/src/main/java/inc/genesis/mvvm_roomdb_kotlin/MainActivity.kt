package inc.genesis.mvvm_roomdb_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import inc.genesis.mvvm_roomdb_kotlin.Repository.QuoteRepository
import inc.genesis.mvvm_roomdb_kotlin.Room.Quote
import inc.genesis.mvvm_roomdb_kotlin.Room.QuoteDatabase
import inc.genesis.mvvm_roomdb_kotlin.ViewModel.MainViewModel
import inc.genesis.mvvm_roomdb_kotlin.ViewModel.MainViewModelFactory
import inc.genesis.mvvm_roomdb_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)



        val dao= QuoteDatabase.getDatabase(applicationContext).quoteDao()
        val repository=QuoteRepository(dao)
        mainViewModel= ViewModelProvider(this,MainViewModelFactory(repository)).get(MainViewModel::class.java)

        mainViewModel.getQuotes().observe(this, Observer{
            binding.quotes=it.toString()
        })
        binding.btnAdQuote.setOnClickListener{
            val quote=Quote(0,"Testing","Insert by User ")
            mainViewModel.insertQuotes(quote)
        }

    }
}