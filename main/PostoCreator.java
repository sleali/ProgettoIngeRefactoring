import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class PostoCreator implements InstanceCreator
{
    @Override
    public Posto createInstance(Type type) {
        Posto p = new PostoN(1);
        return p;
    }
}
