package metaModel;

import codeGenerator.JavaGenerator;
import metaModel.type.Type;

public class Attribute implements MinispecElement {


        private String name;
        private Type type;

        public Attribute(String name, Type type) {
            this.name = name;
            this.type = type;
        }
        public Attribute(String name) {
            this.name = name;

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public Type getType() {
            return type;
        }


    public void accept(Visitor visitor) {
        visitor.visitAttribute(this);
    }
}
