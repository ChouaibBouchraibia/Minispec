package metaModel.type;

import metaModel.Visitor;

public class Collection extends Type{

    private Integer min;
    private Integer max;
    private Type baseType;

    public Collection(String name, String id, Integer min, Integer max, Type baseType) {
        super(name, id);
        this.min = min;
        this.max = max;
        this.baseType = baseType;
    }

    public Collection(String name, String id, Type baseType) {
        super(name, id);
        this.baseType = baseType;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public Type getBaseType() {
        return baseType;
    }

    public void setBaseType(Type baseType) {
        this.baseType = baseType;
    }


    public void accept(Visitor visitor) {
        visitor.visitCollectionType(this);
    }

}
