package globomagazines.com.br.pocglobomais.presentation.Notification


import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class GloboMaisFirebaseMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        var data: Map<String,String> = remoteMessage.data


        Log.e("MENSAGEM", data.toString())

        if (remoteMessage.data.size > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData())
            Log.e("CLICK", remoteMessage.notification.clickAction.toString())
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody())
            Log.e("CLICK", remoteMessage.notification.clickAction.toString())
        }
    }

    fun sendNotification(){

    }


}
