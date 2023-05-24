import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PrivateMethodsTest {

    @Test
    void unArchZipReaderDecoratorTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ZipReaderDecorator zipReaderDecoratorInstance = new ZipReaderDecorator(null);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        Object result = unArchZip().invoke(zipReaderDecoratorInstance, stream);

        Assert.assertTrue(result instanceof ByteArrayOutputStream);
    }

    @Test
    void isPasswordRequiredZipReaderDecoratorTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ZipReaderDecorator zipReaderDecoratorInstance = new ZipReaderDecorator(null);
        String fileName = "testFileName";

        boolean result = (boolean) isPasswordRequiredZip().invoke(zipReaderDecoratorInstance, fileName);

        Assert.assertFalse(result);
    }

    private Method unArchZip() throws NoSuchMethodException {
        Method method = ZipReaderDecorator.class.getDeclaredMethod("unArch", ByteArrayOutputStream.class);
        method.setAccessible(true);
        return method;
    }

    private Method isPasswordRequiredZip() throws NoSuchMethodException {
        Method method = ZipReaderDecorator.class.getDeclaredMethod("isPasswordRequired", String.class);
        method.setAccessible(true);
        return method;
    }
}
