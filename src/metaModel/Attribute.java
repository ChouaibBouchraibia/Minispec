package metaModel;

public class Attribute implements MinispecElement {


        private String name;
        private String type;

        public Attribute(String name, String type) {
            this.name = name;
            this.type = type;
        }
        public Attribute() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }




}
