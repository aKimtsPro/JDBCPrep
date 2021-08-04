package bstorm.akimts.java.models;

public class Section {
    private long id;
    private String name;
    private long delegateId;

    public Section() {
    }

    public Section(long id, String name, long delegateId) {
        this.id = id;
        this.name = name;
        this.delegateId = delegateId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(long delegateId) {
        this.delegateId = delegateId;
    }
}
