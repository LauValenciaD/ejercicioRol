package rol;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPersonaje extends JInternalFrame {
	private static final long serialVersionUID = 1L; // Agregar serialVersionUID

    private JTextField txtNombrePJ;
    private JTextField txtRaza;
    private JComboBox<String> comboBoxProfesion;
    private JButton btnGuardar;
    private JButton btnVolver;

    public FormPersonaje() {
        super("Crear Personaje jugable", false, true, false, false);
        setBounds(50, 50, 381, 358);
        getContentPane().setLayout(null);

        // Crear los campos del formulario 1
        JLabel lblNombrePJ = new JLabel("Nombre del Personaje:");
        lblNombrePJ.setBounds(10, 10, 150, 30);
        getContentPane().add(lblNombrePJ);

        txtNombrePJ = new JTextField();
        txtNombrePJ.setBounds(170, 10, 120, 30);
        getContentPane().add(txtNombrePJ);

        JLabel lblProfesion = new JLabel("Profesión:");
        lblProfesion.setBounds(10, 50, 100, 30);
        getContentPane().add(lblProfesion);

        comboBoxProfesion = new JComboBox<>(new String[]{"Mago", "Guerrero"});
        comboBoxProfesion.setBounds(170, 50, 120, 30);
        getContentPane().add(comboBoxProfesion);

        JLabel lblRaza = new JLabel("Raza:");
        lblRaza.setBounds(10, 90, 150, 30);
        getContentPane().add(lblRaza);
        
        txtRaza = new JTextField();
        txtRaza.setBounds(170, 90, 50, 30);
        getContentPane().add(txtRaza);

        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormPersonaje.class.getResource("/images/link-pixel-art (1).gif")));
        lblNewLabel.setBounds(127, 170, 120, 145);
        getContentPane().add(lblNewLabel);

        // Crear botones "Guardar" y "Volver"
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(89, 130, 100, 30);
        getContentPane().add(btnGuardar);

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 130, 100, 30);
        getContentPane().add(btnVolver);
        
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombrePJ.getText();
                String profesion = (String) comboBoxProfesion.getSelectedItem();
                String razaCr = txtRaza.getText();

                boolean coincide = false;
                for (Raza raza : GUI.razasCreadas) {
                    if (raza.getNombre().equals(razaCr)) {
                        coincide = true;
                        // Imprime los datos de caractBonif y bonificador de la Raza encontrada
                        JOptionPane.showMessageDialog(btnGuardar, razaCr + " caracteristica: " + raza.getCaractBonif() + " y bonificador: " + raza.getBonificador());

                        Caracteristicas caract = new Caracteristicas();
                        switch (raza.getCaractBonif()) {
                            case "Fue":
                                caract.setFuerza(caract.getFuerza() + raza.getBonificador());
                                break;
                            case "Des":
                                caract.setDestreza(caract.getDestreza() + raza.getBonificador());
                                break;
                            case "Con":
                                caract.setConstitucion(caract.getConstitucion() + raza.getBonificador());
                                break;
                            case "Sab":
                                caract.setSabiduria(caract.getSabiduria() + raza.getBonificador());
                                break;
                            case "Int":
                                caract.setInteligencia(caract.getInteligencia() + raza.getBonificador());
                                break;
                            case "Car":
                                caract.setCarisma(caract.getCarisma() + raza.getBonificador());
                                break;
                        }

                        Personaje nuevoPersonaje;
                        if (profesion.equals("mago")) {
                            Mago nuevoMago = new Mago();
                            nuevoPersonaje = new Personaje(nombre, caract, nuevoMago, raza, true);
                        } else {
                            Guerrero nuevoGuerrero = new Guerrero();
                            nuevoPersonaje = new Personaje(nombre, caract, nuevoGuerrero, raza, true);
                        }

                        GUI.personajesCreados.add(nuevoPersonaje);
                        JOptionPane.showMessageDialog(btnGuardar, "Personaje " + nombre + " creado correctamente.");
                        break;
                    }
                }

                if (!coincide) {
                    JOptionPane.showMessageDialog(btnGuardar, "El nombre no coincide con el nombre de ninguna raza.");
                }
            }
        });

        // Agregar ActionListener al botón "Volver"
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
    }
}
