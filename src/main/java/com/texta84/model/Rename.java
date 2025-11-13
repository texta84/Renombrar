package com.texta84.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author @texta84
 */
public class Rename {

    public static File setRenameFile(File file, String searchText, String replaceText) {
        boolean status = false;
        if (file.getName().contains(searchText)) {
            String path = file.toString().replace(searchText, replaceText).replace(".fil", "");
            File oldFile = new File(file.getPath());
            File newFile = new File(path);
            if (file.isFile()) {
                status = oldFile.renameTo(newFile);
            } else if (file.isDirectory()) {
                status = oldFile.renameTo(newFile);
            }
            if (status) {
                return newFile;
            }
        }
        return null;
    }

    public static File setCopyFile(String pathOrigin, String pathDestination, boolean rename) {
        if (rename) {
            pathDestination = pathDestination + ".fil";
        }
        Path originPath = Paths.get(pathOrigin);
        Path destinationPath = Paths.get(pathDestination);
        try {
            CopyOption[] opciones = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            };
            Path newPath = Files.copy(originPath, destinationPath, opciones);
            if (newPath.toFile().exists()) {
                return newPath.toFile();
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
