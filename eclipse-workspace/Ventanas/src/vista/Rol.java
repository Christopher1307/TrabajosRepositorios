package vista;

import javax.swing.*;
import java.awt.*;

public class Rol {
    String nombre;
    ImageIcon icono;

    Rol(String nombre, ImageIcon icono) {
        this.nombre = nombre;
        // Redimensionar la imagen
        Image imagenOriginal = icono.getImage();
        Image imagenRedimensionada = imagenOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        this.icono = new ImageIcon(imagenRedimensionada);
    }

    @Override
    public String toString() {
        return nombre;
    }
}