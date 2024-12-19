package metaModel;

import java.util.ArrayList;
import java.util.List;

public class Entity implements MinispecElement {
	private String name;
	private String packagePath;
	private Entity parent;
	private List<Attribute> attributes;


	public Entity(String name, List<Attribute> attributes) {
		this.name = name;
		this.attributes = attributes;
		this.packagePath = null;
	}

	public Entity(){
		attributes = new ArrayList<Attribute>();
		this.packagePath = null;
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

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public Entity getParent() {
		return parent;
	}

	public void setParent(Entity parent) {
		this.parent = parent;
	}
}
