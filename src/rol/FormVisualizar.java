package rol;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JList;

public class FormVisualizar extends JInternalFrame {
	private static final long serialVersionUID = 1L; // Agregar serialVersionUID

  
    private JButton btnVolver;

    public FormVisualizar() {
        super("Ver Personajes", false, true, false, false);
        setBounds(50, 50, 391, 328);
        getContentPane().setLayout(null);

        


        // Crear botones "Guardar" y "Volver"

        btnVolver = new JButton("Volver");
        btnVolver.setBounds(200, 258, 100, 30);
        getContentPane().add(btnVolver);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(FormRaza.class.getResource("/images/wizard (1).gif")));
        lblNewLabel.setBounds(20, 109, 120, 120);
        getContentPane().add(lblNewLabel);
        
        
        JList<String> list = new JList<String>();
        list.setBounds(155, 93, 158, 132);
        getContentPane().add(list);
        
        JComboBox<String> comboBoxTipo = new JComboBox<>(new String[]{"", "Jugable", "No Jugable"});
       
        comboBoxTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedTipo = (String) comboBoxTipo.getSelectedItem();
                DefaultListModel<String> listModel = new DefaultListModel<>(); // Cambiamos el tipo de DefaultListModel a String
                if (selectedTipo.equals("Jugable")) {
                    for (Personaje item : GUI.personajesCreados) {
                        Personaje personaje = (Personaje) item; // Casting a Personaje
                        if (personaje.isJugador()) { // Llama a isJugador() en cada instancia de Personaje
                            listModel.addElement(personaje.getNombre()); // Agrega el nombre del personaje
                        }
                    }
                } else {
                    for (Object item : GUI.personajesCreados) {
                        Personaje personaje = (Personaje) item; // Casting a Personaje
                        if (!personaje.isJugador()) { // Llama a isJugador() en cada instancia de Personaje
                            listModel.addElement(personaje.getNombre()); // Agrega el nombre del personaje
                        }
                    }
                }
                list.setModel(listModel);
            }
        });
        comboBoxTipo.setBounds(180, 37, 120, 21);
        getContentPane().add(comboBoxTipo);
        
        JLabel lblTipo = new JLabel("Tipo de personaje");
        lblTipo.setBounds(50, 41, 100, 13);
        getContentPane().add(lblTipo);

        
        JLabel lbltexto = new JLabel("Nombre:");
        lbltexto.setBounds(50, 94, 69, 13);
        getContentPane().add(lbltexto);

        // Agregar ActionListener al botón "Volver"
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                if (evt.getClickCount() == 2) { // Doble clic
                    String nombreSeleccionado = (String) list.getSelectedValue();
                    for (Personaje pers : GUI.personajesCreados) {
                        if (pers.getNombre().equals(nombreSeleccionado)) {
                            DatosPersonaje datosFrame = new DatosPersonaje(pers);
                            datosFrame.setVisible(true);
                            break;
                        }
                    }
                }
            }
        });
    }
}

