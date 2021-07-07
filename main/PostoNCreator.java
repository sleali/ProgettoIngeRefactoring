import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class PostoNCreator implements InstanceCreator
{
    @Override
    public Posto createInstance(Type type) {
        Posto p = new PostoN(1);
        return p;
    }
}
