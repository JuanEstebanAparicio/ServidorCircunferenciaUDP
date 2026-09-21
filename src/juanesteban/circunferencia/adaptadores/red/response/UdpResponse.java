/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juanesteban.circunferencia.adaptadores.red.response;

import java.nio.charset.StandardCharsets;
/**
 *
 * @author apari
 */
public final class UdpResponse {
    private final String payload;
    private final String ipDestino;
    private final int puertoDestino;
    
    public UdpResponse(final String payload, final String ipDestino, final int puertoDestino) {
        this.payload = payload;
        this.ipDestino = ipDestino;
        this.puertoDestino = puertoDestino;
    }

    public String getPayload() {
        return payload;
    }

    public String getIpDestino() {
        return ipDestino;
    }

    public int getPuertoDestino() {
        return puertoDestino;
    }
    
    public byte[] getByte() {
        return payload.getBytes(StandardCharsets.UTF_8);
    }
    
}
