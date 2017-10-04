package globomagazines.com.br.pocglobomais.presentation.Notification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.messaging.FirebaseMessaging
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import globomagazines.com.br.pocglobomais.R
import kotlinx.android.synthetic.main.activity_notificacao.*

class NotificacaoActivity : AppCompatActivity() {

    lateinit var inscricoes: ArrayList<String>
    lateinit var desincricoes: ArrayList<String>
    val gson = Gson()
    var preferences: String? = null
    val BRASIL = "Brasil"
    val ECONOMIA = "Economia"
    val ESPORTES = "Esportes"
    val MUNDO = "Mundo"
    val NEGOCIOS = "Negocios"
    val POLITICA = "Politica"
    val COMPORTAMENTO = "Comportamento"
    val CULTURA = "Cultura"
    val FAMOSOS = "Famosos"
    val CARROS = "Carros"
    val DECORACAO = "Decoracao"
    val GASTRONOMIA = "Gastronomia"
    val MODA_BELEZA = "Moda_e_Beleza"
    val SAUDE = "Saude"
    val CIENCIA_TECNOLOGIA = "Ciencia_e_Tecnologia"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notificacao)

        inscricoes = ArrayList()
        recuperarPreferenciasNotificacao()
        updateView()

        checkTodos()


        ck_todos.setOnClickListener({

            if(ck_todos.isChecked){
                marcarTodos()
            }else{
                desmarcarTodos()
            }

        })

    }

    private fun checkTodos() {
        ck_brasil.setOnClickListener({if(!ck_brasil.isChecked){ck_todos.isChecked = false}})
        ck_economia.setOnClickListener({if(!ck_economia.isChecked){ck_todos.isChecked = false}})
        ck_esportes.setOnClickListener({if(!ck_esportes.isChecked){ck_todos.isChecked = false}})
        ck_mundo.setOnClickListener({if(!ck_mundo.isChecked){ck_todos.isChecked = false}})
        ck_negocios.setOnClickListener({if(!ck_negocios.isChecked){ck_todos.isChecked = false}})
        ck_politica.setOnClickListener({if(!ck_politica.isChecked){ck_todos.isChecked = false}})
        ck_comportamento.setOnClickListener({if(!ck_comportamento.isChecked){ck_todos.isChecked = false}})
        ck_cultura.setOnClickListener({if(!ck_cultura.isChecked){ck_todos.isChecked = false}})
        ck_famosos.setOnClickListener({if(!ck_famosos.isChecked){ck_todos.isChecked = false}})
        ck_carros.setOnClickListener({if(!ck_carros.isChecked){ck_todos.isChecked = false}})
        ck_decoracao.setOnClickListener({if(!ck_decoracao.isChecked){ck_todos.isChecked = false}})
        ck_gastronomia.setOnClickListener({if(!ck_gastronomia.isChecked){ck_todos.isChecked = false}})
        ck_moda_beleza.setOnClickListener({if(!ck_moda_beleza.isChecked){ck_todos.isChecked = false}})
        ck_saude.setOnClickListener({if(!ck_saude.isChecked){ck_todos.isChecked = false}})
        ck_ciencia_tecnologia.setOnClickListener({if(!ck_ciencia_tecnologia.isChecked){ck_todos.isChecked = false}})
    }

    private fun desmarcarTodos() {

        ck_brasil.isChecked = false
        ck_economia.isChecked = false
        ck_esportes.isChecked = false
        ck_mundo.isChecked = false
        ck_negocios.isChecked = false
        ck_politica.isChecked = false
        ck_comportamento.isChecked = false
        ck_cultura.isChecked = false
        ck_famosos.isChecked = false
        ck_carros.isChecked = false
        ck_decoracao.isChecked = false
        ck_gastronomia.isChecked = false
        ck_moda_beleza.isChecked = false
        ck_saude.isChecked = false
        ck_ciencia_tecnologia.isChecked = false
    }

    private fun marcarTodos() {
        ck_brasil.isChecked = true
        ck_economia.isChecked = true
        ck_esportes.isChecked = true
        ck_mundo.isChecked = true
        ck_negocios.isChecked = true
        ck_politica.isChecked = true
        ck_comportamento.isChecked = true
        ck_cultura.isChecked = true
        ck_famosos.isChecked = true
        ck_carros.isChecked = true
        ck_decoracao.isChecked = true
        ck_gastronomia.isChecked = true
        ck_moda_beleza.isChecked = true
        ck_saude.isChecked = true
        ck_ciencia_tecnologia.isChecked = true
    }

    fun salvar(view: View) {

        inscricoes = ArrayList()
        desincricoes = ArrayList()

        criarPreferenciasNotificacoes()


    }

    private fun criarPreferenciasNotificacoes() {

        if (ck_brasil.isChecked) {
            inscricoes.add(BRASIL)
            desincricoes.remove(BRASIL)
        } else {
            if(ck_todos.isChecked)
                ck_todos.isChecked = false
            desincricoes.add(BRASIL)
            inscricoes.remove(BRASIL)
        }

        if (ck_economia.isChecked) {
            inscricoes.add(ECONOMIA)
            desincricoes.remove(ECONOMIA)
        } else {

            if(ck_todos.isChecked)
                ck_todos.isChecked = false
            desincricoes.add(ECONOMIA)
            inscricoes.remove(ECONOMIA)
        }

        if (ck_esportes.isChecked) {
            inscricoes.add(ESPORTES)
            desincricoes.remove(ESPORTES)
        } else {

            if(ck_todos.isChecked)
                ck_todos.isChecked = false
            desincricoes.add(ESPORTES)
            inscricoes.remove(ESPORTES)
        }

        if (ck_mundo.isChecked) {
            inscricoes.add(MUNDO)
            desincricoes.remove(MUNDO)
        } else {

            if(ck_todos.isChecked)
                ck_todos.isChecked = false
            desincricoes.add(MUNDO)
            inscricoes.remove(MUNDO)
        }

        if (ck_negocios.isChecked) {
            inscricoes.add(NEGOCIOS)
            desincricoes.remove(NEGOCIOS)
        } else {
            desincricoes.add(NEGOCIOS)
            inscricoes.remove(NEGOCIOS)
        }
        if (ck_politica.isChecked) {
            inscricoes.add(POLITICA)
            desincricoes.remove(POLITICA)
        } else {
            desincricoes.add(POLITICA)
            inscricoes.remove(POLITICA)
        }
        if (ck_comportamento.isChecked) {
            inscricoes.add(COMPORTAMENTO)
            desincricoes.remove(COMPORTAMENTO)
        } else {
            desincricoes.add(COMPORTAMENTO)
            inscricoes.remove(COMPORTAMENTO)
        }
        if (ck_cultura.isChecked) {
            inscricoes.add(CULTURA)
            desincricoes.remove(CULTURA)
        } else {
            desincricoes.add(CULTURA)
            inscricoes.remove(CULTURA)
        }
        if (ck_famosos.isChecked) {
            inscricoes.add(FAMOSOS)
            desincricoes.remove(FAMOSOS)
        } else {
            desincricoes.add(FAMOSOS)
            inscricoes.remove(FAMOSOS)
        }
        if (ck_carros.isChecked) {
            inscricoes.add(CARROS)
            desincricoes.remove(CARROS)
        } else {
            desincricoes.add(CARROS)
            inscricoes.remove(CARROS)
        }
        if (ck_decoracao.isChecked) {
            inscricoes.add(DECORACAO)
            desincricoes.remove(DECORACAO)
        } else {
            desincricoes.add(DECORACAO)
            inscricoes.remove(DECORACAO)
        }
        if (ck_gastronomia.isChecked) {
            inscricoes.add(GASTRONOMIA)
            desincricoes.remove(GASTRONOMIA)
        } else {
            desincricoes.add(GASTRONOMIA)
            inscricoes.remove(GASTRONOMIA)
        }
        if (ck_moda_beleza.isChecked) {
            inscricoes.add(MODA_BELEZA)
            desincricoes.remove(MODA_BELEZA)
        } else {
            desincricoes.add(MODA_BELEZA)
            inscricoes.remove(MODA_BELEZA)
        }
        if (ck_saude.isChecked) {
            inscricoes.add(SAUDE)
            desincricoes.remove(SAUDE)
        } else {
            desincricoes.add(SAUDE)
            inscricoes.remove(SAUDE)
        }
        if (ck_ciencia_tecnologia.isChecked) {
            inscricoes.add(CIENCIA_TECNOLOGIA)
            desincricoes.remove(CIENCIA_TECNOLOGIA)
        } else {
            desincricoes.add(CIENCIA_TECNOLOGIA)
            inscricoes.remove(CIENCIA_TECNOLOGIA)
        }


        preferences = gson.toJson(inscricoes)
        var sp = this.getSharedPreferences(applicationContext.packageName, android.content.Context.MODE_PRIVATE)
        sp.edit().putString("incricoes", preferences).apply()

        fazerInscricoes()
        fazerDesinscricoes()
    }


    fun recuperarPreferenciasNotificacao() {
        var sp = this.getSharedPreferences(applicationContext.packageName, android.content.Context.MODE_PRIVATE)
        if (sp.getString("incricoes", null) != null)
            inscricoes = gson.fromJson(sp.getString("incricoes", null), object : TypeToken<ArrayList<String>>() {}.type)
    }

    fun updateView() {

        for (incricao in inscricoes) {

            when (incricao) {
                BRASIL -> ck_brasil.isChecked = true
                ECONOMIA -> ck_economia.isChecked = true
                ESPORTES -> ck_esportes.isChecked = true
                MUNDO -> ck_mundo.isChecked = true
                NEGOCIOS -> ck_negocios.isChecked = true
                POLITICA -> ck_politica.isChecked = true
                COMPORTAMENTO -> ck_comportamento.isChecked = true
                CULTURA -> ck_cultura.isChecked = true
                FAMOSOS -> ck_famosos.isChecked = true
                CARROS -> ck_carros.isChecked = true
                DECORACAO -> ck_decoracao.isChecked = true
                GASTRONOMIA -> ck_gastronomia.isChecked = true
                MODA_BELEZA -> ck_moda_beleza.isChecked = true
                SAUDE -> ck_saude.isChecked = true
                CIENCIA_TECNOLOGIA -> ck_ciencia_tecnologia.isChecked = true
            }
        }
    }

    fun fazerInscricoes() {
        for (incricao in inscricoes) {
            when (incricao) {
                BRASIL -> FirebaseMessaging.getInstance().subscribeToTopic(BRASIL)
                ECONOMIA -> FirebaseMessaging.getInstance().subscribeToTopic(ECONOMIA)
                ESPORTES -> FirebaseMessaging.getInstance().subscribeToTopic(ESPORTES)
                MUNDO -> FirebaseMessaging.getInstance().subscribeToTopic(MUNDO)
                NEGOCIOS -> FirebaseMessaging.getInstance().subscribeToTopic(NEGOCIOS)
                POLITICA -> FirebaseMessaging.getInstance().subscribeToTopic(POLITICA)
                COMPORTAMENTO -> FirebaseMessaging.getInstance().subscribeToTopic(COMPORTAMENTO)
                CULTURA -> FirebaseMessaging.getInstance().subscribeToTopic(CULTURA)
                FAMOSOS -> FirebaseMessaging.getInstance().subscribeToTopic(FAMOSOS)
                CARROS -> FirebaseMessaging.getInstance().subscribeToTopic(CARROS)
                DECORACAO -> FirebaseMessaging.getInstance().subscribeToTopic(DECORACAO)
                GASTRONOMIA -> FirebaseMessaging.getInstance().subscribeToTopic(GASTRONOMIA)
                MODA_BELEZA -> FirebaseMessaging.getInstance().subscribeToTopic(MODA_BELEZA)
                SAUDE -> FirebaseMessaging.getInstance().subscribeToTopic(SAUDE)
                CIENCIA_TECNOLOGIA -> FirebaseMessaging.getInstance().subscribeToTopic(CIENCIA_TECNOLOGIA)
            }
        }
    }

    fun fazerDesinscricoes() {
        for (desincricao in desincricoes) {
            when (desincricao) {
                BRASIL -> FirebaseMessaging.getInstance().unsubscribeFromTopic(BRASIL)
                ECONOMIA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(ECONOMIA)
                ESPORTES -> FirebaseMessaging.getInstance().unsubscribeFromTopic(ESPORTES)
                MUNDO -> FirebaseMessaging.getInstance().unsubscribeFromTopic(MUNDO)
                NEGOCIOS -> FirebaseMessaging.getInstance().unsubscribeFromTopic(NEGOCIOS)
                POLITICA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(POLITICA)
                COMPORTAMENTO -> FirebaseMessaging.getInstance().unsubscribeFromTopic(COMPORTAMENTO)
                CULTURA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(CULTURA)
                FAMOSOS -> FirebaseMessaging.getInstance().unsubscribeFromTopic(FAMOSOS)
                CARROS -> FirebaseMessaging.getInstance().unsubscribeFromTopic(CARROS)
                DECORACAO -> FirebaseMessaging.getInstance().unsubscribeFromTopic(DECORACAO)
                GASTRONOMIA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(GASTRONOMIA)
                MODA_BELEZA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(MODA_BELEZA)
                SAUDE -> FirebaseMessaging.getInstance().unsubscribeFromTopic(SAUDE)
                CIENCIA_TECNOLOGIA -> FirebaseMessaging.getInstance().unsubscribeFromTopic(CIENCIA_TECNOLOGIA)
            }
        }
    }


}
