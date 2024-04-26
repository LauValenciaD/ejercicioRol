package rol;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class DatosPersonaje extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Personaje personaje;

	public DatosPersonaje(Personaje personaje) {
		this.personaje = personaje;
		Raza raza = personaje.getRaza();
		Caracteristicas caract = personaje.getCaract();
        setTitle("Detalles del Personaje");
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Crear una tabla para mostrar los detalles del personaje
        JTable table = new JTable();
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Atributo");
        model.addColumn("Valor");
        table.setModel(model);

        // Agregar filas para cada atributo del personaje
        model.addRow(new Object[]{"Nombre", personaje.getNombre()});
    
       if (personaje.getProfesion() instanceof Guerrero)
    	    model.addRow(new Object[]{"Profesion", "Guerrero"});
       else	 model.addRow(new Object[]{"Profesion", "Mago"});
       model.addRow(new Object[]{"Raza", raza.getNombre()});	
       model.addRow(new Object[]{"Caracterisica Bono", raza.getCaractBonif()});
       model.addRow(new Object[]{"Bonificador", raza.getBonificador()});
       model.addRow(new Object[]{"Fuerza", caract.getFuerza()});
       model.addRow(new Object[]{"Destreza", caract.getDestreza()});
       model.addRow(new Object[]{"Constitución", caract.getConstitucion()});
       model.addRow(new Object[]{"Inteligencia", caract.getInteligencia()});
       model.addRow(new Object[]{"Sabiduria", caract.getSabiduria()});
       model.addRow(new Object[]{"Carisma", caract.getCarisma()});
       model.addRow(new Object[]{"Vida", "De momento nada"});
       model.addRow(new Object[]{"Defensa", "De momento nada"});
        // Agrega más filas para otros atributos del personaje

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }
}