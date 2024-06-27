package controladores;

import modelos.DataBase;
import modelos.clases.Chat;

public class ChatController {

    public void abrirChat(String emailTurista, String emailGuia){
        DataBase db = DataBase.getInstance();
        Chat chat = db.getChat(db.getUsuarioByEmail(emailTurista), db.getGuiaByEmail(emailGuia));
        chat.abrirChat();
    }
    public void enviarMensaje(String emailEmisor, String emailReceptor, String contenido){
        DataBase db = DataBase.getInstance();
        Chat chat = db.getChat(db.getUsuarioByEmail(emailEmisor), db.getGuiaByEmail(emailReceptor));
        chat.enviarMensaje(db.getUsuarioByEmail(emailEmisor), contenido);
    }
}
