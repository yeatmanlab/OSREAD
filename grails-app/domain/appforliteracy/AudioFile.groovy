package appforliteracy

class AudioFile {
    
    String filename
    String extension
    int sampleRate
    Date uploadDate
    double[] audioData
    double[] correctData
    String patientId
    
    static constraints = {
        filename blank: false
        extension blank: false
        sampleRate blank: false
        uploadDate blank: false
        audioData blank: false
    }
}
