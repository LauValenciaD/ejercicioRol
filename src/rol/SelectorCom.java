package rol;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.util.List;

public class SelectorCom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private JButton btnVolver;


	public SelectorCom() {
		setTitle("Selector combatientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
        contentPane.setLayout(null);
        btnVolver = new JButton("Volver");
        btnVolver.setBounds(82, 212, 61, 21);
        getContentPane().add(btnVolver);
        
        
        JList<String> listPlayer = new JList<String>();
        listPlayer.setBounds(45, 73, 158, 132);
        DefaultListModel<String> listModel = new DefaultListModel<>(); // Cambiamos el tipo de DefaultListModel a String
        
        for (Personaje item : GUI.personajesCreados) {
            Personaje personaje = (Personaje) item; // Casting a Personaje
            if (personaje.isJugador()) { // Llama a isJugador() en cada instancia de Personaje
                listModel.addElement(personaje.getNombre()); // Agrega el nombre del personaje
            }
        }
        listPlayer.setModel(listModel);
        getContentPane().add(listPlayer);
        
        
        JLabel lblTipo = new JLabel("Personajes jugables:");
        lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblTipo.setBounds(45, 40, 158, 13);
        getContentPane().add(lblTipo);

        
        JLabel lbltexto = new JLabel("Elije a los luchadores");
        lbltexto.setHorizontalAlignment(SwingConstants.CENTER);
        lbltexto.setFont(new Font("Impact", Font.PLAIN, 18));
        lbltexto.setBounds(128, 0, 177, 33);
        getContentPane().add(lbltexto);
        

        
        JList<String> listNPC = new JList<String>();
        listNPC.setBounds(226, 73, 158, 132);
        DefaultListModel<String> listModelNPC = new DefaultListModel<>();
      for (Personaje item : GUI.personajesCreados) {
      Personaje personaje = (Personaje) item; // Casting a Personaje
      if (!personaje.isJugador()) { // Llama a isJugador() en cada instancia de Personaje
    	  listModelNPC.addElement(personaje.getNombre()); // Agrega el nombre del personaje
      		}
      }
      
      listNPC.setModel(listModelNPC);
        contentPane.add(listNPC);
        
        JButton btnLuchar = new JButton("Luchar");
        btnLuchar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Obtiene el nombre seleccionado de la lista de jugadores
                String nombreJugadorSeleccionado = listPlayer.getSelectedValue();
                // Obtiene el nombre seleccionado de la lista de NPC
                String nombreNPCSeleccionado = listNPC.getSelectedValue();

                // Busca el objeto Personaje correspondiente al nombre seleccionado en la lista de jugadores
                Personaje player = buscarPersonajePorNombre(nombreJugadorSeleccionado, GUI.personajesCreados);
                // Busca el objeto Personaje correspondiente al nombre seleccionado en la lista de NPC
                Personaje npc = buscarPersonajePorNombre(nombreNPCSeleccionado, GUI.personajesCreados);

                if (player == null || npc == null) {
                    // Si no se han seleccionado ambos personajes, mostrar un mensaje de advertencia
                    JOptionPane.showMessageDialog(null, "Debes seleccionar un personaje jugable y un NPC para luchar.");
                } else {
                    // Si se han seleccionado ambos personajes, iniciar la lucha
                    Combate combate = new Combate(player, npc);
                    combate.setVisible(true);
                    setVisible(false);
                }
            }
        });

        btnLuchar.setBounds(244, 212, 75, 21);
        contentPane.add(btnLuchar);
        
        JLabel lblEnemigos = new JLabel("Enemigos:");
        lblEnemigos.setHorizontalAlignment(SwingConstants.CENTER);
        lblEnemigos.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblEnemigos.setBounds(226, 41, 158, 13);
        contentPane.add(lblEnemigos);

        // Agregar ActionListener al botón "Volver"
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

	}
	private Personaje buscarPersonajePorNombre(String nombre, List<Personaje> personajes) {
	    for (Personaje personaje : personajes) {
	        if (personaje.getNombre().equals(nombre)) {
	            return personaje;
	        }
	    }
	    return null; // Retorna null si no se encuentra el personaje con el nombre dado
	}
}
