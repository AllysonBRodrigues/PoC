package globomagazines.com.br.pocglobomais.presentation.Main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import globomagazines.com.br.pocglobomais.R
import globomagazines.com.br.pocglobomais.presentation.Criptografia.CriptografiaActivity
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(id: View?) {
        when(id){
            bt_criptografia -> {
                val intent = Intent(this, CriptografiaActivity::class.java)
                startActivity(intent)
            }

            bt_login -> {

            }


        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_criptografia.setOnClickListener(this)
    }
}
