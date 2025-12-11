// ISP stands for Interface Segregation Principle
// This principle states that a client should not be forced to depend on methods it doesn't use

// Bad example of the Interface Segregation Principle

interface MediaPlayer {
    void playAudio(String audioFile);

    void stopAudio();

    void adjustAudioVolume(int volume);

    void playVideo(String videoFile);

    void stopVideo();

    void adjustVideoBrightness(int brightness);

    void displaySubtitles(String subtitleFile);
}

// Now lets sau i want to create a pure audio player a class that only handles
// sound
class AudioPlayer implements MediaPlayer {
    @Override
    public void playAudio(String audioFile) {
        // Play the audio file
        System.out.println("Playing audio file: " + audioFile);
    }

    @Override
    public void stopAudio() {
        // Stop the audio playback
        System.out.println("Stopping audio playback");
    }

    @Override
    public void adjustAudioVolume(int volume) {
        // Adjust the audio volume
        System.out.println("Adjusting audio volume to " + volume);
    }

    // methods this class shouldnot care about
    @Override
    public void playVideo(String videoFile) {
        // Play the video file
        System.out.println("Playing video file: " + videoFile);
    }

    @Override
    public void stopVideo() {
        // Stop the video playback
        System.out.println("Stopping video playback");
    }

    @Override
    public void adjustVideoBrightness(int brightness) {
        // Adjust the video brightness
        System.out.println("Adjusting video brightness to " + brightness);
    }

    @Override
    public void displaySubtitles(String subtitleFile) {
        // Display subtitles
        System.out.println("Displaying subtitles: " + subtitleFile);
    }
}

// This is a bad example of the Interface Segregation Principle
// Even though AudioOnlyPlayer only needs audio methods,
// it’s forced to implement unrelated video functionality.
// You either throw exceptions or write empty methods. Neither is ideal.

// Good example of the Interface Segregation Principle

interface AudioPlayerControls {
    void playAudio(String audioFile);

    void stopAudio();

    void adjustAudioVolume(int volume);
}

interface VideoPlayerControls {
    void playVideo(String videoFile);

    void stopVideo();

    void adjustVideoBrightness(int brightness);

    void displaySubtitles(String subtitleFile);
}

class AudioOnlyPlayer implements AudioPlayerControls {
    @Override
    public void playAudio(String audioFile) {
        // Play the audio file
        System.out.println("Playing audio file: " + audioFile);
    }

    @Override
    public void stopAudio() {
        // Stop the audio playback
        System.out.println("Stopping audio playback");
    }

    @Override
    public void adjustAudioVolume(int volume) {
        // Adjust the audio volume
        System.out.println("Adjusting audio volume to " + volume);
    }
}

public class ISP {

}
