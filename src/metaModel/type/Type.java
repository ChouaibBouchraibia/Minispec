package metaModel.type;

import metaModel.MinispecElement;

public abstract class Type implements MinispecElement {
    public String id;
    public String name;

    public Type(String name, String id) {
        this.name = name;
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


}
