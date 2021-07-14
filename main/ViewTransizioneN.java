public class ViewTransizioneN
{
    private TransizioneN t;

    public ViewTransizioneN(TransizioneN t)
    {
        this.t = t;
    }

    public String toString()
    {
        return "ID: " + this.t.getID();
    }
}
