import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AbstractClassesTest {

    @Test
    void abstractReaderDecoratorOpenMethodWithPreProcessOK_Test() throws IOException {
        ReaderDecorator readerDecoratorInstance = Mockito.mock(ReaderDecorator.class);

        Mockito.when(readerDecoratorInstance.preProcess("testFileName")).thenReturn(true);
        Mockito.doCallRealMethod().when(readerDecoratorInstance).open("testFileName");
        boolean result = readerDecoratorInstance.open("testFileName");

        Assert.assertTrue(result);
    }

    @Test
    void abstractReaderDecoratorOpenMethodWithPreProcessFail_Test() throws IOException {
        ReaderDecorator readerDecoratorInstance = Mockito.mock(ReaderDecorator.class);

        Mockito.when(readerDecoratorInstance.preProcess("testFileName")).thenReturn(false);
        Mockito.doCallRealMethod().when(readerDecoratorInstance).open("testFileName");
        boolean result = readerDecoratorInstance.open("testFileName");

        Assert.assertFalse(result);
    }

}
