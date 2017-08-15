package globomagazines.com.br.pocglobomais.presentation.Criptografia

import java.io.File
import javax.crypto.SecretKey

/**
 * Created by AllysonRodrigues on 10/08/17.
 */
interface CriptografiaContract {

    interface Presentation{

        fun bind(view: View)

        fun criptografarArquivo(file: File, key: SecretKey): ByteArray?

        fun descriptografarArquivo(file: File, key: SecretKey): ByteArray?

        fun salvarArquivo(file: File,byteArray: ByteArray)

    }


    interface View{
        fun exibirMensagem(msg: String)
    }

}