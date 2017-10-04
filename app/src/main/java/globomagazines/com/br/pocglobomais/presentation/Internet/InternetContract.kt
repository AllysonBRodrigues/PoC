package globomagazines.com.br.pocglobomais.presentation.Internet

/**
 * Created by AllysonRodrigues on 18/08/17.
 */
interface InternetContract{

    interface Presentation{

        fun bind(view: View)

        fun checkConnection()

        fun responseConnection(retorno: Boolean)

    }

    interface View{
        fun exibirStatus(retorno: Boolean)
    }


}