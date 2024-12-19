package javaMetaModel;

import metaModel.Entity;
import metaModel.MinispecElement;

public class JavaModel implements MinispecElement {
    public Entity entity;
    public String packagePath;

    public JavaModel(Entity entity, String packagePath) {
        this.entity = entity;
        this.packagePath = packagePath;
    }

    public Entity getEntity() {
        return entity;
    }

    public String getPackagePath() {
        return packagePath;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void setPackagePath(String packagePath) {
        this.packagePath = packagePath;
    }



}
