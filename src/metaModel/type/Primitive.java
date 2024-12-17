package metaModel.type;

import metaModel.Visitor;

public class Primitive extends Type {

    public Primitive(String name, String id) {
        super(name, id);
    }


    public void accept(Visitor visitor) {
        visitor.visitPrimitiveType(this);
    }
}
