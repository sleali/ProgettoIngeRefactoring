import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class PostoPNCreator implements InstanceCreator
{
    @Override
    public Posto createInstance(Type type) {
        Posto p = new PostoPN(1, 1);
        return p;
    }
}
