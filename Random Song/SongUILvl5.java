import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class SongUILvl5 implements ActionListener{
  public static void main(String[] args){
    SongUILvl5 ux = new SongUILvl5();
  }
    public SongUILvl5()
    {
        top = new JFrame("Random Song");
        songHolder = new JPanel();
        ta_song = new JTextArea();
        sp_scroll = new JScrollPane(ta_song);
        b_buildSong_lvl1 = new JButton("Build Song Lvl 1");
        b_buildSong_lvl2 = new JButton("Build Song Lvl 2");
        b_buildSong_lvl3 = new JButton("Build Song Lvl 3");
        b_buildSong_lvl4 = new JButton("Build Song Lvl 4");
        b_buildSong_lvl5 = new JButton("Build Song Lvl 5");
        b_playSong = new JButton("Play Song");
        gridBag = new GridBagLayout();
        gridConstraints = new GridBagConstraints();
        
        initComponents();
    }
   
   ////Students will design/code this function when designing a user inteface
    private void initComponents()
    {
        //Set properties of JTextArea, JScrollPane, and related
        ta_song.setEditable(false);
        ta_song.setFont(new Font(Font.MONOSPACED, Font.LAYOUT_LEFT_TO_RIGHT, 14));
        sp_scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        sp_scroll.setVisible(true);
        songHolder.setBorder(new TitledBorder("Song notes will be displayed here"));
        
        //Set sizes
        top.setBounds(150, 125, 350, 374);
        sp_scroll.setPreferredSize(new Dimension(300, 100));
        
        //Add listeners
        b_buildSong_lvl1.addActionListener(this);
        b_buildSong_lvl2.addActionListener(this);
        b_buildSong_lvl3.addActionListener(this);
        b_buildSong_lvl4.addActionListener(this);
        b_buildSong_lvl5.addActionListener(this);
        b_playSong.addActionListener(this);
        
        //Disable the play song button. Enable it after a song has been built
        b_playSong.setEnabled(false);
        
        
        //Set close
        top.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Set layout
        top.setLayout(gridBag);
        //Set grid
        gridBag.setConstraints(top, gridConstraints);
        
        //Add components
        //Build song button 1 
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 5;
        gridConstraints.weightx = 0.5;
        top.add(b_buildSong_lvl1, gridConstraints);
        //Build song button 2
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 5;
        gridConstraints.weightx = 0.5;
        top.add(b_buildSong_lvl2, gridConstraints);
        //Build song button 3
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 5;
        gridConstraints.weightx = 0.5;
        top.add(b_buildSong_lvl3, gridConstraints);
        //Build song button 4
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 6;
        gridConstraints.weightx = 0.5;
        top.add(b_buildSong_lvl4, gridConstraints);
        //Build song button 5
        gridConstraints.gridx = 1;
        gridConstraints.gridy = 6;
        gridConstraints.weightx = 0.5;
        top.add(b_buildSong_lvl5, gridConstraints);
        //Play song button
        gridConstraints.gridx = 2;
        gridConstraints.gridy = 6;
        gridConstraints.weightx = 0.5;
        top.add(b_playSong, gridConstraints);
        //Song holder, scroll pane, and text area
        gridConstraints.gridx = 0;
        gridConstraints.gridy = 0;
        gridConstraints.weightx = 0.0;
        gridConstraints.gridwidth = 4;
        gridConstraints.ipady = 50;
        gridConstraints.weightx = 0;
        gridConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridConstraints.anchor = GridBagConstraints.NORTH;
        songHolder.add(sp_scroll);
        top.add(songHolder, gridConstraints);
        
        top.setVisible(true);
        
        //Pack in the components on the JFrame (aesthetic)
        top.pack();
        
    }
    
    //Member variables
    //Containers
    private final JFrame top;
    private final JPanel songHolder;
    //Visuals
    private final JButton b_buildSong_lvl1;
    private final JButton b_buildSong_lvl2, b_buildSong_lvl3, b_buildSong_lvl4, b_buildSong_lvl5;
    private final JButton b_playSong;
    private final JTextArea ta_song;
    private final JScrollPane sp_scroll;
    //Layout
    private final GridBagLayout gridBag;
    private final GridBagConstraints gridConstraints;
    //Behind the scenes
    private RandomSong song = null;
    
    
    
    
    
    //Methods overridden from ActionListener
    @Override
    public void actionPerformed(ActionEvent action)
    {
        int general;
        String temp;
        if(action.getActionCommand().equals("Build Song Lvl 1"))
        {
            //Build the RandomSong;
            if(song == null)
                song = new RandomSong("C", 4);
            else
                song = new RandomSong("C", 4);
            
            //Display the notes of the song in JTextArea ta_song
            ta_song.setText(song.toString());
            
            //Enable the play song button
            b_playSong.setEnabled(true);
        }
        //THIS LEVEL DISPLAYS THE NOTES IN THE SONG
        else if(action.getActionCommand().equals("Build Song Lvl 2"))
        {
            //Prompt user for number of notes
            temp = JOptionPane.showInputDialog("How many notes are in this song?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            
            general = Integer.parseInt(temp);
            
            //Build the RandomSong;
            if(song == null)
                song = new RandomSong("C", 4, general);
            else
                song = new RandomSong("C", 4, general);
            
            //Display the notes of the song in JTextArea ta_song
            ta_song.setText(song.toString());
            
            //Enable the play song button
            b_playSong.setEnabled(true);
        }
        //THIS LEVEL MAKES A RANDOM SONG
        else if(action.getActionCommand().equals("Build Song Lvl 3"))
        {
            //Prompt user for number of notes
            temp = JOptionPane.showInputDialog("How many notes are in this song?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            
            general = Integer.parseInt(temp);
            
            //Build the RandomSong;
            if(song == null)
                song = new RandomSong("C", 4, general, true);
            else
                song = new RandomSong("C", 4, general, true);
            
            //Display the notes of the song in JTextArea ta_song
            ta_song.setText(song.toString());
            
            //Enable the play song button
            b_playSong.setEnabled(true);
        }
        //THIS LEVEL MAKES A RANDOM BINARY SONG
        else if(action.getActionCommand().equals("Build Song Lvl 4"))
        {
            //Prompt user for number of notes
            temp = JOptionPane.showInputDialog("How many notes are in each section of song?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            general = Integer.parseInt(temp);
            int repeats;
            temp = JOptionPane.showInputDialog("How many times does this song repeat?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            repeats = Integer.parseInt(temp);
            String tonicNote;
            temp = JOptionPane.showInputDialog("What is the first note of this song (A-G)?", "");
            
            if(temp == null)
                return;
            if(temp.equals("") || temp.charAt(0) > 'G' || temp.charAt(0) < 'A')
            {
                JOptionPane.showMessageDialog(top, "You must enter a valid note to use this function");
                return;
            }
            tonicNote = temp.trim();
            
            //Build the RandomSong;
            if(song == null)
                song = new RandomSong(temp, 4, general, repeats);
            else
                song = new RandomSong(temp, 4, general, repeats);
            
            //Display the notes of the song in JTextArea ta_song
            ta_song.setText(song.toString());
            
            //Enable the play song button
            b_playSong.setEnabled(true);
        }
        //THIS LEVEL MAKES A RANDOM TERNARY SONG
        else if(action.getActionCommand().equals("Build Song Lvl 5"))
        {
            //Prompt user for number of notes
            temp = JOptionPane.showInputDialog("How many notes are in each section of this song?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            general = Integer.parseInt(temp);
            int repeats;
            temp = JOptionPane.showInputDialog("How many times does this song repeat?", "");
            
            if(temp == null)
                return;
            if(temp.equals(""))
            {
                JOptionPane.showMessageDialog(top, "You must enter a number of notes");
                return;
            }
            repeats = Integer.parseInt(temp);
            String tonicNote;
            temp = JOptionPane.showInputDialog("What is the first note of this song (A-G)?", "");
            
            if(temp == null)
                return;
            if(temp.equals("") || temp.charAt(0) > 'G' || temp.charAt(0) < 'A')
            {
                JOptionPane.showMessageDialog(top, "You must enter a valid note to use this function");
                return;
            }
            tonicNote = temp.trim();
            
            //Build the RandomSong;
            if(song == null)
                song = new RandomSong(temp, 4, general, repeats, true);
            else
                song = new RandomSong(temp, 4, general, repeats, true);
            
            //Display the notes of the song in JTextArea ta_song
            ta_song.setText(song.toString());
            
            //Enable the play song button
            b_playSong.setEnabled(true);
        }
        else if(action.getActionCommand().equals("Play Song"))
        {
            try {
                MidiWriter.writeMidiFile(song);
                MidiReader.playSong(song);
            } catch (Exception ex) {
                System.out.println("In actionListener: Caught exception "+ex.getMessage());
            }
        }
    }
}
    