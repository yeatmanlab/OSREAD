package appforliteracy

class AudioFile {
    
    String filename
    String extension
    int sampleRate
    Date uploadDate
    double[] audioData
    String patientId
    
    static constraints = {
        filename blank: false
        extension blank: false
        sampleRate blank: false
        uploadDate blank: false
        audioData blank: false
    }
}
