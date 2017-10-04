package globomagazines.com.br.pocglobomais.presentation.Criptografia

import android.util.Log
import globomagazines.com.br.pocglobomais.util.CryptoHelper
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import javax.crypto.SecretKey

/**
 * Created by AllysonRodrigues on 10/08/17.
 */
class CriptografiaPresentation : CriptografiaContract.Presentation {

    var view: CriptografiaContract.View? = null

    override fun salvarArquivo(file: File, byteArray: ByteArray){

        try {
            val bos = BufferedOutputStream(FileOutputStream(file))
            bos.write(byteArray)
            bos.flush()
            bos.close()
            view?.exibirMensagem("Sucesso")
        } catch (e: Exception) {
            view?.exibirMensagem("Erro")
        }
    }

    override fun bind(view: CriptografiaContract.View) {
        this.view = view
    }

    override fun criptografarArquivo(file: File, key: SecretKey): ByteArray? {

        var filesBytes: ByteArray? = null
        try {
            val byteArray = FileInputStream(file).readBytes()
            filesBytes = CryptoHelper.encodeFile(key, byteArray)
        } catch (e: Exception) {
            Log.e("ERRO CRIPT", "Erro ao criptografar arquivo")
        } finally {
            return filesBytes
        }

    }

    override fun descriptografarArquivo(file: File, key: SecretKey): ByteArray? {

        var filesBytes: ByteArray? = null

        try {
            val byteArray = FileInputStream(file)
                    .readBytes()
            filesBytes = CryptoHelper.decodeFile(key, byteArray)
        } catch (e: Exception) {
            Log.e("ERRO CRIPT", "Erro ao descriptografar arquivo")
        } finally {
            return filesBytes
        }
    }

}