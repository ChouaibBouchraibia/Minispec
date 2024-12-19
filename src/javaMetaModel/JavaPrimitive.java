package javaMetaModel;

import metaModel.MinispecElement;
import metaModel.type.Type;

public class JavaPrimitive implements MinispecElement {
    public String name;
    public Type type;
    public String packagePath;

    public JavaPrimitive(String name, Type type, String packagePath) {
        this.name = name;
        this.type = type;
        this.packagePath = packagePath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }
}
