package globomagazines.com.br.pocglobomais.util

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.FirebaseInstanceIdService

/**
 * Created by AllysonRodrigues on 02/10/17.
 */
class FirebaseInstanceIDService : FirebaseInstanceIdService() {

    override fun onTokenRefresh() {
        var refreshedToken = FirebaseInstanceId.getInstance().token

    }



}