import org.junit.Test;
import static org.junit.Assert.*;

public class TestEqualsReteWhitebox
{
    @Test
    public void TestCammino1()
    {
        Rete r1 = new Rete();
        Rete r2 = new Rete();
        r1.addElemento(new ElementoN(new PostoN(1), new TransizioneN(1), true));
        assertFalse(r1.equals(r2));
    }

    @Test
    public void TestCammino2()
    {
        Rete r1 = new Rete();
        Rete r2 = new Rete();
        assertTrue(r1.equals(r2));
    }

    @Test
    public void TestCammino3()
    {
        // IMPOSSIBILE
        assert true;
    }

    @Test
    public void TestCammino4()
    {
        // IMPOSSIBILE
        assert true;
    }

    @Test
    public void TestCammino5()
    {
        // IMPOSSIBILE
        assert true;
    }

    @Test
    public void TestCammino6()
    {
        // IMPOSSIBILE
        assert true;
    }

    @Test
    public void TestCammino7()
    {
        Rete r1 = new Rete();
        Rete r2 = new Rete();
        r1.addElemento(new ElementoN(new PostoN(1), new TransizioneN(1), true));
        r2.addElemento(new ElementoN(new PostoN(2), new TransizioneN(1), true));
        assertFalse(r1.equals(r2));
    }

    @Test
    public void TestCammino8()
    {
        // IMPOSSIBILE
        assert true;
    }

    @Test
    public void TestCammino9()
    {
        Rete r1 = new Rete();
        Rete r2 = new Rete();
        r1.addElemento(new ElementoN(new PostoN(1), new TransizioneN(1), true));
        r2.addElemento(new ElementoN(new PostoN(1), new TransizioneN(1), true));
        assertTrue(r1.equals(r2));
    }

    @Test
    public void TestCammino10()
    {
        // IMPOSSIBILE
        assert true;
    }
}
