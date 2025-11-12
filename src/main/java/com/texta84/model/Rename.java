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

    private String newName;

    public Rename() {
        this.newName = "";
    }

    public void setRenameFile(File file, String searchText, String replaceText) {
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
                setNewName(newFile.getName());
            }
        }
    }

    public void setCopyFile(String pathOrigin, String pathDestination, boolean rename) {
        if (rename) {
            pathDestination = pathDestination + ".fil";
        }
        try {
            Path originPath = Paths.get(pathOrigin);
            Path destinationPath = Paths.get(pathDestination);

            CopyOption[] opciones = new CopyOption[]{
                    StandardCopyOption.REPLACE_EXISTING,
                    StandardCopyOption.COPY_ATTRIBUTES
            };
            Files.copy(originPath, destinationPath, opciones);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setNewName(String nvoNombre) {
        this.newName = nvoNombre;
    }

    public String getNewName() {
        return this.newName;
    }
}
