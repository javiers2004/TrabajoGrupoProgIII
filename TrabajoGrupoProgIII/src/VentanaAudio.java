import javax.sound.sampled.*;
import java.io.IOException;

public class VentanaAudio {
    private Clip audioClip;
    private FloatControl volumeControl;

    public VentanaAudio(String audioFilePath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(VentanaAudio.class.getResource(audioFilePath));
        audioClip = AudioSystem.getClip();
        audioClip.open(audioStream);

        volumeControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
    }

   // public void play() {
  //      audioClip.start();
  //  }
    
    public void play() {
        if (audioClip.isRunning()) {
            audioClip.stop(); // Si ya está reproduciendo, detenlo
        }
        audioClip.setFramePosition(0); // Reinicia el audio al principio
        audioClip.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce el audio en bucle indefinidamente
    }

    public void stop() {
        audioClip.stop();
    }

    public void setVolume(float volume) {
        if (volume < 0f || volume > 1f) {
            throw new IllegalArgumentException("El volumen debe estar entre 0 y 1");
        }
        float min = volumeControl.getMinimum();
        float max = volumeControl.getMaximum();
        volumeControl.setValue((max - min) * volume + min);
    }
}
