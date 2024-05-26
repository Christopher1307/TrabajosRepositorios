package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ver {

    public static void main(String[] args) {
        // Configurar el marco principal
        JFrame ventana = new JFrame("Ventana Pro");
        ventana.setSize(600, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crear y configurar el panel principal con color de fondo
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBackground(Color.LIGHT_GRAY);
        ventana.add(panelPrincipal);

        // Configurar restricciones para el diseño de los componentes
        GridBagConstraints restricciones = new GridBagConstraints();
        restricciones.insets = new Insets(10, 10, 10, 10);
        restricciones.fill = GridBagConstraints.HORIZONTAL;

        // Añadir etiqueta y campo de texto para el usuario
        JLabel etiquetaUsuario = new JLabel("Usuario:");
        restricciones.gridx = 0;
        restricciones.gridy = 0;
        panelPrincipal.add(etiquetaUsuario, restricciones);

        JTextField campoUsuario = new JTextField(20);
        restricciones.gridx = 1;
        restricciones.gridy = 0;
        restricciones.gridwidth = 2;
        panelPrincipal.add(campoUsuario, restricciones);

        // Añadir etiqueta y campo de texto para la contraseña
        JLabel etiquetaContraseña = new JLabel("Contraseña:");
        restricciones.gridx = 0;
        restricciones.gridy = 1;
        restricciones.gridwidth = 1;
        panelPrincipal.add(etiquetaContraseña, restricciones);

        JPasswordField campoContraseña = new JPasswordField(20);
        restricciones.gridx = 1;
        restricciones.gridy = 1;
        restricciones.gridwidth = 2;
        panelPrincipal.add(campoContraseña, restricciones);

        // Añadir etiqueta y combo box para seleccionar el rol
        JLabel etiquetaRol = new JLabel("Rol:");
        restricciones.gridx = 0;
        restricciones.gridy = 2;
        restricciones.gridwidth = 1;
        panelPrincipal.add(etiquetaRol, restricciones);

        // Crear roles con imágenes redimensionadas
        Rol[] roles = {
            new Rol("Administrador", new ImageIcon("src/vista/imagenes/admin.jpeg")),
            new Rol("Usuario", new ImageIcon("src/vista/imagenes/usuario.jpg")),
            new Rol("Invitado", new ImageIcon("src/vista/imagenes/invitado.jpg")),
            new Rol("Planificador", new ImageIcon("src/vista/imagenes/planificador.png")),
            new Rol("Arquitecto", new ImageIcon("src/vista/imagenes/arquitecto.jpeg"))
        };

        JComboBox<Rol> comboRol = new JComboBox<>(roles);
        comboRol.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value instanceof Rol) {
                    Rol rol = (Rol) value;
                    label.setText(rol.nombre);
                    label.setIcon(rol.icono);
                }
                return label;
            }
        });

        restricciones.gridx = 1;
        restricciones.gridy = 2;
        restricciones.gridwidth = 2;
        panelPrincipal.add(comboRol, restricciones);

        // Añadir botones de login y reset
        JButton botonLogin = new JButton("Login");
        restricciones.gridx = 0;
        restricciones.gridy = 3;
        restricciones.gridwidth = 1;
        botonLogin.setBackground(Color.BLUE);
        botonLogin.setForeground(Color.WHITE);
        panelPrincipal.add(botonLogin, restricciones);

        JButton botonReset = new JButton("Reset");
        restricciones.gridx = 1;
        restricciones.gridy = 3;
        restricciones.gridwidth = 1;
        botonReset.setBackground(Color.RED);
        botonReset.setForeground(Color.WHITE);
        panelPrincipal.add(botonReset, restricciones);

        // Añadir comportamiento al botón de login
        botonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                String usuario = campoUsuario.getText();
                String contraseña = new String(campoContraseña.getPassword());
                Rol rolSeleccionado = (Rol) comboRol.getSelectedItem();

                if (!usuario.isEmpty() && !contraseña.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Login con éxito\nUsuario: " + usuario + "\nRol: " + rolSeleccionado.nombre);
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Añadir comportamiento al botón de reset
        botonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evento) {
                campoUsuario.setText("");
                campoContraseña.setText("");
                comboRol.setSelectedIndex(0);
            }
        });

        // Mostrar el marco principal
        ventana.setVisible(true);
    }
}




