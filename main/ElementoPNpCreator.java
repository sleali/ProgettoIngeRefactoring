import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class ElementoPNpCreator implements InstanceCreator
{
    @Override
    public ElementoPNp createInstance(Type type) {
        ElementoPNp e = new ElementoPNp(null, null, true, 0);
        return e;
    }
}
