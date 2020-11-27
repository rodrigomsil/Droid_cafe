package com.example.droidcaf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscaDados();
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.getProduto()?.enqueue(object : Callback<List<Produto>> {
            override fun onResponse(call: Call<List<Produto>?>?, response: Response<List<Produto>?>?) {
                val listaDeProduto = response?.body()

                descricao1.text = listaDeProduto?.get(0)?.descricao
                descricao2.text = listaDeProduto?.get(1)?.descricao
                descricao3.text = listaDeProduto?.get(2)?.descricao

                imagem1.setImageResource(R.drawable.donut_circle)
                imagem2.setImageResource(R.drawable.icecream_circle)
                imagem3.setImageResource(R.drawable.froyo_circle)

                total1.text = listaDeProduto?.get(0)?.valor.toString()
                total2.text = listaDeProduto?.get(1)?.valor.toString()
                total3.text = listaDeProduto?.get(2)?.valor.toString()

            }

            override fun onFailure(call: Call<List<Produto>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })

    }
}