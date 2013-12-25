package by.java7.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * @author Tsimafei_Shchytkavets
 */
public class FileManipulationUtils
{
    public static void manipulateWithFile(String filePath) throws IOException
    {
        final Path path = Paths.get(filePath);
        final Path file = Files.createFile(path);
        Files.copy(file, file, StandardCopyOption.REPLACE_EXISTING);
        Files.delete(path);
    }
}
