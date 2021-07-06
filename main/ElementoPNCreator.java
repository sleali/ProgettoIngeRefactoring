import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class ElementoPNCreator implements InstanceCreator
{
    @Override
    public ElementoPN createInstance(Type type) {
        ElementoPN e = new ElementoPN(null, null, true, 0);
        return e;
    }
}


