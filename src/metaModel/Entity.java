package metaModel;

import java.util.ArrayList;
import java.util.List;

public class Entity implements MinispecElement {
	private String name;
	private List<Attribute> attributes;

	public Entity(String name, List<Attribute> attributes) {
		this.name = name;
		this.attributes = attributes;
	}

	public Entity(){
		attributes = new ArrayList<Attribute>();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	public void addAttribute(Attribute e) {
		this.attributes.add(e);
	}
	public void accept(Visitor visitor) {
		visitor.visitEntity(this);
	}
}
