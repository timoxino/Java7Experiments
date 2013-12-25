package by.java7.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author Tsimafei_Shchytkavets
 */
public class FolderManipulationUtils
{
    public static String getRelativePath(String pathToSource, String pathToTarget)
    {
        final Path sourcePath = Paths.get(pathToSource);
        final Path targetPath = Paths.get(pathToTarget);
        return sourcePath.relativize(targetPath).toString();
    }

    public static void displayFolderFiles(String folderPath, String pattern) throws IOException
    {
        final Path path = Paths.get(folderPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, pattern))
        {
            for (Path entry : stream)
            {
                System.out.println(entry.getFileName());
            }
        }
    }

    public static void displayFolderFilesRecursively(String folderPath, final String fileExtension) throws IOException
    {
        final Path path = Paths.get(folderPath);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
            {
                if (file.toString().endsWith(fileExtension))
                {
                    System.out.println(file.getFileName());
                }
                return super.visitFile(file, attrs);
            }
        });
    }
}
