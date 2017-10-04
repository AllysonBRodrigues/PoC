package globomagazines.com.br.pocglobomais.presentation.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat.startActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging
import globomagazines.com.br.pocglobomais.R
import globomagazines.com.br.pocglobomais.presentation.Criptografia.CriptografiaActivity
import globomagazines.com.br.pocglobomais.presentation.Internet.InternetContract
import globomagazines.com.br.pocglobomais.presentation.Internet.InternetPresentation
import globomagazines.com.br.pocglobomais.presentation.Notification.NotificacaoActivity
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), View.OnClickListener, InternetContract.View {

    val presentationInternet: InternetContract.Presentation = InternetPresentation()
    

    override fun exibirStatus(retorno: Boolean) {
        if(retorno){
            runOnUiThread(Runnable {
                kotlin.run {
                    Toast.makeText(this, "Concetado a internet", Toast.LENGTH_LONG).show()
                }
            })


        } else {
            runOnUiThread(Runnable {
                kotlin.run {
                    Toast.makeText(this, "Sem conexão", Toast.LENGTH_LONG).show()
                }
            })

        }
    }

    override fun onClick(id: View?) {
        when(id){
            bt_criptografia -> {
                val intent = Intent(this, CriptografiaActivity::class.java)
                startActivity(intent)
            }

            bt_login -> {

            }

            bt_teste_net -> {
                presentationInternet.checkConnection()
            }

            bt_notificacao -> {

            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bundle = intent.extras
        if(bundle != null) {
            if (bundle.getString("ID", null) != null) {
                Toast.makeText(applicationContext, bundle.getString("ID", null), Toast.LENGTH_LONG).show()
            }
        }

        bt_criptografia.setOnClickListener(this)
        bt_teste_net.setOnClickListener(this)
        presentationInternet.bind(this)

    }


    fun notificacao (view: View){
        startActivity(Intent(applicationContext, NotificacaoActivity::class.java))
    }


}
