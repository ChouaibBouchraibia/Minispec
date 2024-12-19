package metaModel.type;

import metaModel.MinispecElement;

public abstract class Type implements MinispecElement {
    public String id;
    public String name;
    public String packagePath;

    public Type(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Type(String name, String id , String packagePath) {
        this.name = name;
        this.id = id;
        this.packagePath = packagePath;
    }

    public Type (String id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }


}
