import java.io.File;
import java.nio.file.Path;

public class BasedPath {

    private Path mainProductPath, tempProductPath, mainQuantityPath, tempQuantityPath;
    private File mainProductFile, tempProductFile, mainQuantityFile, tempQuantityFile;

    //mutators

    public void setMainProductPath(Path mainProductPath) { 

        this.mainProductPath = mainProductPath;

    }

    public void setTempProductPath(Path tempProductPath) {

        this.tempProductPath = tempProductPath;

    }

    public void setMainQuantityPath(Path mainQuantityPath) {

        this.mainQuantityPath = mainQuantityPath;

    }

    public void setTempQuantityPath(Path tempQuantityPath) {

        this.tempQuantityPath = tempQuantityPath;

    }

    public void setMainProductFile(File mainProductFile) { 

        this.mainProductFile = mainProductFile;

    }

    public void setTempProductFile(File tempProductFile) {

        this.tempProductFile = tempProductFile;

    }

    public void setMainQuantityFile(File mainQuantityFile) {

        this.mainQuantityFile = mainQuantityFile;

    }

    public void setTempQuantityFile(File tempQuantityFile) {

        this.tempQuantityFile = tempQuantityFile;

    }

    //accessors

    public Path getMainProductPath() { 

        return mainProductPath;

    }

    public Path getTempProductPath() {

        return tempProductPath;
    }


    public Path getMainQuantityPath() {

        return mainQuantityPath;

    }


    public Path getTempQuantityPath() {

        return tempQuantityPath;

    }

    public File getMainProductFile() { 

        return mainProductFile;

    }

    public File getTempProductFile() {

        return tempProductFile;
    }


    public File getMainQuantityFile() {

        return mainQuantityFile;

    }


    public File getTempQuantityFile() {

        return tempQuantityFile;

    }
}
