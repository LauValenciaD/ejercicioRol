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
import javax.swing.border.CompoundBorder;

public class FormNPC extends JInternalFrame {
	private static final long serialVersionUID = 1L; // Agregar serialVersionUID

    private JTextField txtNombrePJ;
    private JComboBox<String> comboBoxProfesion;
    private JButton btnGuardar;
    private JButton btnVolver;

    public FormNPC() {
        super("Crear Personaje NO jugable", false, true, false, false);
        setBounds(50, 50, 399, 333);
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
        
        JComboBox<String> comboBoxRazas = new JComboBox<>(GUI.comboBoxModel);
        comboBoxRazas.setBounds(160, 90, 150, 30);
        getContentPane().add(comboBoxRazas);

        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormNPC.class.getResource("/images/bowser (1).gif")));
        lblNewLabel.setBounds(137, 170, 120, 123);
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
                String razaCr = (String) comboBoxRazas.getSelectedItem();

        
                    Personaje nuevoPersonaje = new Personaje(nombre, razaCr, profesion);
                    GUI.personajesCreados.add(nuevoPersonaje);
                    JOptionPane.showMessageDialog(btnGuardar, "Personaje " + nombre + " creado correctamente.");
 
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
