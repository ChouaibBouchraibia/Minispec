package metaModel;


import metaModel.type.Collection;
import metaModel.type.Primitive;

public class Visitor {

	public void visitModel(Model e) {
	}
	public void visitEntity(Entity e) {}

	public void visitAttribute(Attribute e) {}

    public void visitPrimitiveType(Primitive primitive) {}

	public void visitCollectionType(Collection collection) {
	}
}
