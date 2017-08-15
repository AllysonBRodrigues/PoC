package globomagazines.com.br.pocglobomais.presentation.Criptografia

import android.Manifest
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.ActivityCompat
import android.content.pm.PackageManager
import java.io.*
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.view.View


import globomagazines.com.br.pocglobomais.R
import globomagazines.com.br.pocglobomais.util.CryptoHelper
import kotlinx.android.synthetic.main.activity_criptografia.*
import javax.crypto.SecretKey

class CriptografiaActivity : AppCompatActivity(), View.OnClickListener, CriptografiaContract.View {


    private val REQUEST_EXTERNAL_STORAGE = 1
    private val RETURN_INTENT_PATH = 2
    private val PERMISSIONS_STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    private val context = this
    val salt = CryptoHelper.generateSalt()
    private var key: SecretKey = CryptoHelper.generateKey(salt, "password")
    var presentation: CriptografiaContract.Presentation = CriptografiaPresentation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_criptografia)

        encrypt.setOnClickListener(this)
        dencrypt.setOnClickListener(this)
        open.setOnClickListener(this)

        presentation.bind(this)

        val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            )
        }

    }

    override fun onClick(id: View?) {
        when (id) {
            encrypt -> {
                val file = File("${Environment.getExternalStorageDirectory().path}/Globo/Teste.pdf")//Arquivo a ser criptografado

                if (file.exists()) {

                    val byte = presentation.criptografarArquivo(file, key)
                    presentation.salvarArquivo(file, byte!!)

                } else {
                    Toast.makeText(context, "O arquivo não existe",
                            Toast.LENGTH_SHORT).show()
                }
            }

            dencrypt -> {

                val file = File("${Environment.getExternalStorageDirectory().path}/Globo/Teste.pdf")
                if (file.exists()) {

                    try {
                        val byte = presentation.descriptografarArquivo(file, key)
                        presentation.salvarArquivo(file, byte!!)

                    } catch (e: Exception) {
                        Toast.makeText(context, "O arquivo já está descriptografado",
                                Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "O arquivo não existe",
                            Toast.LENGTH_SHORT).show()
                }
            }

            open -> {

                val file = File("${Environment.getExternalStorageDirectory().path}/Globo/Teste.pdf")
                if (file.exists()) {
                    val path = Uri.fromFile(file)
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.setDataAndType(path, "*/*")
                    intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

                    try {
                        context.startActivity(intent)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(context, "Não é possivel abrir o arquivo",
                                Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "O arquivo não existe",
                            Toast.LENGTH_SHORT).show()
                }
            }

        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //With when we select the request code we asked in the StartActivityForResult
        when (requestCode) {
        //that will be imageReturned
            RETURN_INTENT_PATH -> {
                val file = File(data!!.data.encodedPath)
                if (file.exists()) {

                }
            }
        }
    }

    override fun exibirMensagem(msg: String) {
        when (msg) {
            "Sucesso" -> {
                Toast.makeText(context, "Sucesso no processamento",
                        Toast.LENGTH_SHORT).show()
            }
            "Erro" -> {
                Toast.makeText(context, "Erro no processamento",
                        Toast.LENGTH_SHORT).show()
            }
        }
    }


}