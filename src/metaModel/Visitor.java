package metaModel;


import metaModel.type.Collection;
import metaModel.type.Primitive;
import metaModel.type.Reference;

public class Visitor {

	public void visitModel(Model e) {
	}
	public void visitEntity(Entity e) {}

	public void visitAttribute(Attribute e) {}

    public void visitPrimitiveType(Primitive primitive) {}

	public void visitCollectionType(Collection collection) {

	}

	public void visitReferenceType(Reference reference) {
	}
}
