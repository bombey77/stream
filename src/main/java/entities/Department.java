package entities;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Department {

    private int id;
    private int parent;
    private String name;

    private Set<Department> child = new HashSet<Department>();

    public Department(int id, int parent, String name) {
        this.id = id;
        this.parent = parent;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Department> getChild() {
        return child;
    }

    public void setChild(Set<Department> child) {
        this.child = child;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return id == that.id &&
                parent == that.parent &&
                Objects.equals(name, that.name) &&
                Objects.equals(child, that.child);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, parent, name, child);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", child=" + child +
                '}';
    }
}
