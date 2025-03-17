import com.fasterxml.jackson.databind.ObjectMapper;
import modal.Phone;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

@DisplayName("Json тесты") // Эта аннотация задает удобочитаемое имя для класса тестов, что позволяет делать выводы более понятными при выполнении тестов. Это особенно полезно для отображения результатов в отчетах, так как предоставляет более ясное описание того, что тестируется.
public class JsonTest {

    private final ClassLoader cl = JsonTest.class.getClassLoader(); //Здесь создается ClassLoader, который используется для загрузки ресурсов, находящихся в classpath. Этот конкретный объект cl будет применяться для поиска и загрузки файла Phone.json, который, предположительно, находится в ресурсах проекта. Использование ClassLoader полезно, так как оно позволяет избежать абсолютных путей к файлу.

    @DisplayName("Проверяем файл Phone.json")
    @Test
    void jsonTest() throws Exception{ // Это делается для упрощения обработки ошибок, связанных с вводом/выводом (например, если JSON-файл не найден) и ошибки при десериализации. В реальных тестах желательно использовать более конкретные исключения и обрабатывать их, чтобы сделать тесты более информативными.
        try (InputStream is = cl.getResourceAsStream("Phone.json"); //Этот код загружает файл Phone.json как поток. Если файл не будет найден, is будет равен null, что приведёт к возникновению исключения при попытке чтения.
        InputStreamReader isr = new InputStreamReader(is)) {  //Создается InputStreamReader, который позволяет читать поток is как текстовые данные, а не как байты. Это нужно, чтобы можно было потом использовать его для парсинга JSON.
            Phone phone = new ObjectMapper().readValue(isr, Phone.class); //Здесь используется ObjectMapper — часть библиотеки Jackson, — который преобразует содержимое JSON в объект класса Phone. Этот процесс называется десериализацией. Таким образом, все поля из JSON-файла преобразуются в соответствующие свойства экземпляра класса Phone.
        }
    }
}
