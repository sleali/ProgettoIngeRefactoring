import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;

public class TransizionePNpCreator implements InstanceCreator
{
    @Override
    public Transizione createInstance(Type type) {
        Transizione t = new TransizionePNp(1, 1);
        return t;
    }
}
