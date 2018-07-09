/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Game.audioplayer;

import java.io.File;

/**
 *
 * @author EEB
 */
public class AudioPlayer2 {
    public void play(String audioFilePath) {
        PlayerThread thread = new PlayerThread(new File(audioFilePath));
        thread.start();
    }
}

class PlayerThread extends Thread {
    private File file;
   
    public PlayerThread(File file) {
        this.file =file;
    }
    
    public void run() {
        AudioPlayer player = new AudioPlayer();
        player.play(file.getAbsolutePath());
    }
}
