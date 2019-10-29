import java.awt.EventQueue;
import javax.swing.JFrame;

public class GUIGame extends JFrame {
    
    
    public GUIGame()
    {
        initUI();
    }

    private void initUI()
    {
        add(new Map());

        setTitle("PacMan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            Pacman ex = new Pacman();
            ex.setVisible(true);
        });
    }
}