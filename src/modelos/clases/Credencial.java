package modelos.clases;

import modelos.interfaces.IAdapterCredencial;

public class Credencial {
    private String idCredencial;
    private String fotoCredencial;
    private IAdapterCredencial adapter;
    private Notificador notificador;
    private Boolean habilitado;

    public Credencial(String idCredencial, String fotoCredencial, IAdapterCredencial adapter) {
        this.idCredencial = idCredencial;
        this.fotoCredencial = fotoCredencial;
        this.adapter = adapter;
        this.habilitado = false;
    }

    public void setAdapter(IAdapterCredencial adapter) {
        this.adapter = adapter;
    }

    public void verificarCredencial() {
        if (adapter.verificarCredencial(this)){
            setHabilitado(true);
        }
        else{
            setHabilitado(false);
        }
    }

    public String getIdCredencial() {
        return idCredencial;
    }

    public String getFotoCredencial() {
        return fotoCredencial;
    }

    public void notificar(Guia guia) {
        if (getHabilitado() == true){
            Notificacion notificacion = new Notificacion(
                    "Credencial Validada",
                    "Se ha validado su credencial con satisfacción. Ya puede ofrecer sus servicios!",
                    guia
            );
            notificador = new Notificador();
            notificador.cambiarEstrategia(new Push());
            notificador.enviar(notificacion);
        }
        else{
            Notificacion notificacion = new Notificacion(
                    "Credencial Invalidada",
                    "Se ha invalidado su credencial.",
                    guia
            );
            notificador = new Notificador();
            notificador.cambiarEstrategia(new Push());
            notificador.enviar(notificacion);
        }
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }
}