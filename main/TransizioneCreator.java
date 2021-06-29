import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class TransizioneCreator implements InstanceCreator
{
    @Override
    public Transizione createInstance(Type type) {
        Transizione t = new TransizioneN(1);
        return t;
    }
}
