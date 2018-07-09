/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.audioplayer;

/**
 *
 * @author EEB
 */
public class Program2 {

    public static void main(String[] args) {
        String audioFilePath = "1.wav";
        AudioPlayer2 player = new AudioPlayer2();
        player.play(audioFilePath);
        System.out.println("This does not wait until playing the sound is finished.");
    }
}
