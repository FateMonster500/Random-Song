/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.sound.midi.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;

/**
 *
 * @author Kevin Strileckis
 */
public class MidiReader {
    //Function will play the song
    public static void playSong(RandomSong song) throws FileNotFoundException
    {
        InputStream noteIS;
        
        //If there are no notes in the song, then return immediately
        if(song.getMelody().size() == 0)
            return;
        
            
        try {
          Sequencer seq = MidiSystem.getSequencer();
            noteIS = new BufferedInputStream(new FileInputStream(new File("song.mid")));
                
            seq.open();
            seq.setSequence(noteIS);
            seq.start();
        } catch (Exception ex) {
            System.out.println("In actionListener: Caught exception "+ex.getMessage());
            //Logger.getLogger(RandomSong.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
