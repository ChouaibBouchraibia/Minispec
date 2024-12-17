package metaModel.type;

import metaModel.Entity;
import metaModel.Visitor;

public class Reference extends Type {

    private Entity entity;


    public Reference(String name, String id) {
        super(name, id);
    }
    public Reference( String id, Entity entity) {
        super( id);
        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void accept(Visitor visitor) {
        visitor.visitReferenceType(this);
    }



}
