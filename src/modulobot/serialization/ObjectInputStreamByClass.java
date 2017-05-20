package modulobot.serialization;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.io.StreamCorruptedException;
import java.util.ArrayList;
import java.util.Arrays;

public class ObjectInputStreamByClass extends ObjectInputStream {

    private ArrayList<Class> classes;

    public ObjectInputStreamByClass(InputStream in, Class... classes) throws IOException, StreamCorruptedException {
        super(in);
        if (classes == null || classes.length == 0) {
            throw new IllegalArgumentException("Class must not be null");
        }
        this.classes = new ArrayList<>(Arrays.asList(classes));
    }

    @SuppressWarnings("rawtypes")
    @Override
    protected Class resolveClass(ObjectStreamClass classDesc) throws IOException, ClassNotFoundException {
        long uid = classDesc.getSerialVersionUID();
        for (Class c : classes) {
            if(ObjectStreamClass.lookup(c).getSerialVersionUID() == uid){
                return c;
            }
        }
        return super.resolveClass(classDesc);
    }
}
