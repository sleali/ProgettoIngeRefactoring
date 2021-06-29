import com.google.gson.InstanceCreator;

import java.lang.reflect.Type;

public class ElementoNCreator implements InstanceCreator
{
    @Override
    public ElementoN createInstance(Type type) {
        ElementoN e = new ElementoN(null, null, true);
        return e;
    }
}
