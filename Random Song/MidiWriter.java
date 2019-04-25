/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import static javax.sound.midi.Sequence.PPQ;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;
import javax.sound.midi.Track;

/**
 *
 * @author Kevin Strileckis
 */
public class MidiWriter {
    //Function will write the midi file
    public static void writeMidiFile(RandomSong song) throws InvalidMidiDataException, IOException
    {
        String stringToneMark;
        int toneMark, dur;
        int placeInTrack = 0;
        try
        {
            //Create a new MIDI sequence
                //Pulses per quarternote and 24 ticks per beat
            //Based on code by Karl Brown
                //http://www.automatic-pilot.com/midifile.html
                //Last updated 2/24/2003
            Sequence midSeq = new Sequence(PPQ, 24);
            //Create a track
            Track t = midSeq.createTrack();
            
            //Turn on General MIDI sound set
            byte[] byteSet = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};
            SysexMessage sysMess = new SysexMessage();
            MidiEvent me;
            sysMess.setMessage(byteSet, 6);
            me = new MidiEvent(sysMess, (long)0);
            t.add(me);
            
            //Set tempo
            MetaMessage metMess = new MetaMessage();
            byte[] byteSetT = {0x02, (byte)0x00, 0x00};
            metMess.setMessage(0x51, byteSetT, 3);
            me = new MidiEvent(metMess, (long) 0);
            t.add(me);
            
            //Set track name
            metMess = new MetaMessage();
            String trackName = "RandomSong";
            metMess.setMessage(0x03, trackName.getBytes(), trackName.length());
            me = new MidiEvent(metMess, (long)0);
            t.add(me);
            
            //Set omni on
            ShortMessage mm = new ShortMessage();
            mm.setMessage(0xB0, 0x7D, 0x00);
            me = new MidiEvent(mm, (long) 0);
            t.add(me);
            
            //Set poly on
            mm = new ShortMessage();
            mm.setMessage(0xB0, 0x7F, 0x00);
            me = new MidiEvent(mm, (long)0);
            t.add(me);
            
            //Set instrument to piano
            mm = new ShortMessage();
            mm.setMessage(0xC0, 0x00, 0x00);
            me = new MidiEvent(mm, (long)0);
            t.add(me);
            
            //Add the notes
            //Add the melody
            for(int i=0; i<song.getMelody().size(); ++i)
            {
                stringToneMark = song.getMelody().get(i).getTone();
                if(stringToneMark.length() == 0){
                  System.out.println("Your note name is not set for note #"+i);
                }
                switch(stringToneMark.charAt(0)-'A')
                {
                    case 0:
                        toneMark = 0x39;
                        break;
                    case 1:
                        toneMark = 0x3B;
                        break;
                    //C on octave 4 (if first octave is -1 and last is 9
                        //This note is often called "Middle C"
                    case 2:
                        toneMark = 0x3C;
                        break;
                    case 3:
                        toneMark = 0x3E;
                        break;
                    case 4:
                        toneMark = 0x40;
                        break;
                    case 5:
                        toneMark = 0x41;
                        break;
                    default:
                        toneMark = 0x43;
                }
                
                dur = song.getMelody().get(i).getDuration();
                switch(dur)
                {
                    case 0:
                        dur = 24;
                        break;
                    case 1:
                        dur = 48;
                        break;
                    case 2:
                        dur = 96;
                        break;
                    case 3:
                        dur = 144;
                        break;
                    default:
                        dur = 192;
                }
                
                //Now add notes of melody and harmony to the track
                
                //Note on
                //Melody
                mm = new ShortMessage();
                mm.setMessage(/*MIDI status message: Ch1 Note on*/0x90,
                        toneMark,
                        /*Velocity ~= volume*/0x70);
                me = new MidiEvent(mm,(long)++placeInTrack);
                t.add(me);
                
                //Note off
                mm = new ShortMessage();
                mm.setMessage(/*MIDI status message: Ch1 Note on*/0x80,
                        toneMark,
                        /*Velocity ~= volume*/0x50);
                //Incrememnt integer placeInTrack
                placeInTrack += dur;
                me = new MidiEvent(mm,(long)placeInTrack);
                t.add(me);
            }
            
            //Reset integer placeInTrack to the delay of the RandomSong
            placeInTrack = 0;//song.getDelay();
            
            
            //End of track - 19 ticks later
            metMess = new MetaMessage();
            byte[] bEmpt = {}; // empty array
            metMess.setMessage(0x2F, bEmpt, 0);
            me = new MidiEvent(metMess, (long)placeInTrack + 140);
            t.add(me);
            
            //Finally, write the MIDI sequence
            File f = new File("song.mid");
            MidiSystem.write(midSeq, 1, f);
            
        } catch(Exception ex){
            System.out.println("In actionListener: Caught exception "+ex.getMessage());
        }
    }
}
